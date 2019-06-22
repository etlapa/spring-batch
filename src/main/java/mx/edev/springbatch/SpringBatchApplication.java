package mx.edev.springbatch;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import mx.edev.springbatch.config.ApplicationProperties;
import mx.edev.springbatch.config.Constants;
import mx.edev.springbatch.config.DefaultProfileUtil;

@SpringBootApplication
@EnableConfigurationProperties({ LiquibaseProperties.class, ApplicationProperties.class })
public class SpringBatchApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final Environment env;

    public static void main(String[] args) {
        // TODO: review this way to load the Spring context
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

    /**
     * TODO: review this case
     * 
     * @param env
     */
    public SpringBatchApplication(Environment env) {
        this.env = env;
    }

    /**
     * TODO: review this case
     * 
     * Initializes SpringBatchApplication.
     * <p>
     * Spring profiles can be configured with a program arguments
     * --spring.profiles.active=your-active-profile
     * <p>
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT)
                && activeProfiles.contains(Constants.SPRING_PROFILE_PRODUCTION)) {
            LOGGER.error("You have misconfigured your application! It should not run "
                    + "with both the 'dev' and 'prod' profiles at the same time.");
        }
    }

}