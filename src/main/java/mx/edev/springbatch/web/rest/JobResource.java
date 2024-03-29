package mx.edev.springbatch.web.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edev.springbatch.config.ApplicationProperties;

@RestController
@RequestMapping("/job")
public class JobResource {
    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    private ApplicationProperties applicationProperties;

    public JobResource(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    /**
     * POST /job/:fileName : post to execute a job using the file name given
     *
     * @param fileName
     *            the fileName of the job file to run
     * @return the ResponseEntity with status 200 (OK) or status 500 (Job
     *         Failure)
     */
    @GetMapping("/{fileName:.+}")
    public ResponseEntity<String> runJob(@PathVariable String fileName) {
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put(applicationProperties.getBatch().getInputName(), new JobParameter(fileName));
        try {
            jobLauncher.run(job, new JobParameters(parameterMap));
        } catch (Exception e) {
            return new ResponseEntity<String>("Failure: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}