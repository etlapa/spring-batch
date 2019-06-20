package mx.edev.springbatch.config;

import java.sql.Types;

import org.hibernate.dialect.H2Dialect;

/**
 * TODO: check this config... probably not needed
 * 
 * Resolves an issue with column types in H2, especially around new time apis.
 */
public class FixedH2Dialect extends H2Dialect {

    public FixedH2Dialect() {
        registerColumnType(Types.FLOAT, "real");
        registerColumnType(Types.BINARY, "varbinary");
    }
}