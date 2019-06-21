package mx.edev.spring.batch.springbatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.springbatch.SpringBatchApplication;
import mx.edev.springbatch.config.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBatchApplication.class)
@ActiveProfiles("dev")
public class SpringBatchApplicationTests {

    @Autowired
    private Job job;

    @Test
    public void jobCreation() {
        assertNotNull("Job is null!!!", job);
        assertEquals("Something went wrong with the Job name", Constants.JOB_NAME, job.getName());
    }

}