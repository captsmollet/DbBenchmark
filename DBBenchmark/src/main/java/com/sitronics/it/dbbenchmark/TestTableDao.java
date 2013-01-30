package com.sitronics.it.dbbenchmark;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO for performance test
 */
public class TestTableDao extends NamedParameterJdbcDaoSupport {

    private String idColumnName;
    private String dateColumnName;
    private String strColumnName;

    private String queryText;                    // "SELECT * FROM yo";

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    List<TestObject> findTestObject(TestObject obj) {

        // construct query parameter map from bean's properties
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);

        // send query and get result mapped to a bean
        List<TestObject> list = getNamedParameterJdbcTemplate().query(queryText, parameterSource, new TestObjectMapper());

        return list;
    }

    public String getIdColumnName() {
        return idColumnName;
    }

    public void setIdColumnName(String idColumnName) {
        this.idColumnName = idColumnName;
    }

    public String getDateColumnName() {
        return dateColumnName;
    }

    public void setDateColumnName(String dateColumnName) {
        this.dateColumnName = dateColumnName;
    }

    public String getStrColumnName() {
        return strColumnName;
    }

    public void setStrColumnName(String strColumnName) {
        this.strColumnName = strColumnName;
    }

    /**
     * Class for mapping ResultSet row to TestObject bean
     */
    public final class TestObjectMapper implements RowMapper<TestObject> {

        @Override
        public TestObject mapRow(ResultSet resultSet, int i) throws SQLException {
            TestObject testObject = new TestObject();
            testObject.setId(resultSet.getInt(getIdColumnName()));
            testObject.setSome_date(resultSet.getDate(getDateColumnName()));
            testObject.setSome_str(resultSet.getString(getStrColumnName()));
            return testObject;
        }
    }

}


