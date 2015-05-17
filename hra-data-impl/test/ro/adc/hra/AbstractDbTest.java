package ro.adc.hra;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-context.xml")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader=ReplacementDataSetLoader.class)
public abstract class AbstractDbTest {

    @Inject
    private DataSource dataSource;

    protected void setSqNextval(final String sequence, final Long value) throws Exception {
        final Connection conn = dataSource.getConnection();
        conn.createStatement().execute(String.format("drop sequence %s", sequence));
        conn.createStatement().execute(String.format("create SEQUENCE %s MINVALUE 1 START WITH %s", sequence,  value));

    }
}
