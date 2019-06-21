package mx.edev.springbatch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;

/**
 * 
 * Properties specific to Patient Batch Loader.
 * <p>
 * Properties are configured in the application.yml file.
 */
@Getter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Batch batch = new Batch();

    @Data
    public static class Batch {

        /**
         * Default value if not assigned
         */
        private String inputPath = "/tmp";
        private String inputName = "fileName.txt";
    }
}