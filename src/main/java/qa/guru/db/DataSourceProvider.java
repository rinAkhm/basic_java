package qa.guru.db;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public enum DataSourceProvider {
    INSTANCE;

    private PGSimpleDataSource ds;
    public DataSource getInstance() {
        if (ds == null) {
            ds = new PGSimpleDataSource();
            ds.setServerNames(new String[]{"localhost"});
            ds.setPortNumbers(new int[]{5432});
            ds.setDatabaseName("postgres");
            ds.setUser("postgres");
            ds.setPassword("secret");
        }
        return ds;
    }
}
