package com.metasoft.em.test;

import java.io.File;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "file:src/test/resources/test-springContext.xml" })
public abstract class AbstractUnitTestSetup {

    @Autowired
    private DataSource dataSourceOracle;

    protected IDatabaseConnection getOracleConnection() throws Exception {
        return new DatabaseDataSourceConnection(dataSourceOracle);
    }

    @Before
    public void init() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(getOracleConnection(), getPnetDataSet());
    }

    @After
    public void after() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(getOracleConnection(), getPnetDataSet());
    }

    private IDataSet getPnetDataSet() throws Exception {
        return new CsvDataSet(new File("src/test/resources/test_dataset"));
    }

}
