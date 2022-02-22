package implementation;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import contract.SampleProvider;

public class SampleClassProvider implements Provider<SampleProvider> {
    private String url;

    @Inject
    public SampleClassProvider (@Named("JDBC URL2") String dbUrl) {
        this.url = dbUrl;
    }

    @Override
    public SampleProvider get() {
        String user = "user";
        SampleProvider sp = new SampleProviderImpl(this.url, user);
        return sp;
    }
}


