package implementation;

import contract.SampleProvider;

public class SampleProviderImpl implements SampleProvider {

    private String dbUrl;
    private String user;

    public SampleProviderImpl(String dbUrl, String user) {
        this.dbUrl = dbUrl;
        this.user = user;
    }

    @Override
    public void someAction() {
        System.out.println("SampleProviderImpl - some action..." + dbUrl + ", " +user);
    }
}
