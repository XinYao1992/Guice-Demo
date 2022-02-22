package contract;

import com.google.inject.ProvidedBy;
import implementation.SampleClassProvider;

//@ProvidedBy(SampleClassProvider.class) // Just-in-time binding, 这样就不用写 bind(SampleProvider.class).toProvider(SampleClassProvider.class);
public interface SampleProvider {
    void someAction();
}
