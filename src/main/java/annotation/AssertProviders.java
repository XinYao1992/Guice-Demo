package annotation;

public class AssertProviders {
    // Factory
    // Return an annotation
    public static AssertProvider assertProvider(Provider value) {
        return new AssertProviderImpl(value);
    }
}
