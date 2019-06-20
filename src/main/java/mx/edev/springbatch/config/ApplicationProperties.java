package mx.edev.springbatch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * Properties specific to Patient Batch Loader.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Batch batch = new Batch();

    public Batch getBatch() {
        return batch;
    }

    public static class Batch {

        /**
         * Default value if not assigned
         */
        private String inputPath = "c:/input";

        public String getInputPath() {
            return this.inputPath;
        }

        public void setInputPath(String inputPath) {
            this.inputPath = inputPath;
        }
    }
}