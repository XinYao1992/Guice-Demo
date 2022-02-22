package implementation;

import annotation.AssertProvider;
import annotation.Provider;
import contract.DatabaseAccess;

public class DatabaseAccessOtherImpl implements DatabaseAccess {

    private String dbUrl = "[Other-Empty]";

    public DatabaseAccessOtherImpl() {

    }

    public DatabaseAccessOtherImpl(@AssertProvider(Provider.JDBC) String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Override
    public void someAction() {
       System.out.println("DatabaseAccessImpl: " + dbUrl);
    }
}
