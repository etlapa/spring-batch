package mx.edev.springbatch.config;

/**
 * TODO: double check this constants
 * 
 * Application constants.
 */
public final class Constants {

    /**
     * Default system account used for all database interaction by the batch
     * processor
     */
    public static final String SYSTEM_ACCOUNT = "system";

    /**
     * Assure locale-specific instances leverage the same default
     */
    public static final String DEFAULT_LANG_KEY = "en";

    /**
     * Spring profile for running in "development mode"
     */
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

    /**
     * Spring profile for running in "production mode"
     */
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    /**
     * Spring profile for not including liquibase database schema management at
     * run-time.
     */
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";

    /**
     * Name of the job
     */
    public static final String JOB_NAME = "spring-batch-loader";

    /**
     * Name of the step
     */
    public static final String STEP_NAME = "process-patients-step";

    /**
     * Item reader name for the job
     */
    public static final String ITEM_READER_NAME = "patient-item-reader";

    private Constants() {
    }
}
