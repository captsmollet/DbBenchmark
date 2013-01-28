package com.sitronics.it.dbbenchmark;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Serves as a source of JdbcTemplate connection
 * Date: 28.01.13
 * Time: 2:51
 */
public class DbConnectionFactory {
    static final String JNDI_DATASOUCE = "jdbc/mysql";
    static Logger logger = Logger.getLogger(DbConnectionFactory.class.toString());

    static JdbcTemplate getDbConnection() {
        JdbcTemplate jdbcTemplate = null;
        try {
            jdbcTemplate = new JdbcTemplate(new JndiDataSourceLookup().getDataSource(JNDI_DATASOUCE));
        } catch (DataSourceLookupFailureException e) {
            logger.log(Level.SEVERE, "Can't find datasource in JNDI: " + JNDI_DATASOUCE);
            throw new DataSourceLookupFailureException(JNDI_DATASOUCE);
        }

        return jdbcTemplate;
    }

}
