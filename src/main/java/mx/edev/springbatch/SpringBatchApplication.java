package mx.edev.springbatch;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import mx.edev.springbatch.config.ApplicationProperties;
import mx.edev.springbatch.config.DefaultProfileUtil;

@SpringBootApplication
@EnableConfigurationProperties({ LiquibaseProperties.class, ApplicationProperties.class })
public class SpringBatchApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        // SpringApplication.run(SpringBatchApplication.class, args);
        SpringApplication app = new SpringApplication(SpringBatchApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        LOGGER.info(
                "\n----------------------------------------------------------\n\t"
                        + "Spring Batch Application '{}' is running!"
                        + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), env.getActiveProfiles());
    }

}