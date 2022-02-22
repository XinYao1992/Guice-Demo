package implementation;

import annotation.AssertProvider;
import annotation.Provider;
import com.apple.eawt.AppEvent;
import com.google.inject.Inject;
import contract.DatabaseAccess;

public class DatabaseAccessImpl implements DatabaseAccess {

    private String dbUrl = "[Empty]";

    public DatabaseAccessImpl() {

    }

    public DatabaseAccessImpl(@AssertProvider(Provider.JDBC) String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Override
    public void someAction() {
       System.out.println("DatabaseAccessImpl: " + dbUrl);
    }
}
