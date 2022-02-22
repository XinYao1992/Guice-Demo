package payment;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import javax.xml.stream.FactoryConfigurationError;

public class PaymentModule extends AbstractModule {
    @Override
    protected void configure() {
        // Solution 1:
//        bind(PaymentFactory.class).to(RealPaymentFactory.class);

        // Solution 2: no "RealPaymentFactory" needed
        install(
                new FactoryModuleBuilder()
                        .implement(Payment.class, RealPayment.class)
                        .build(PaymentFactory.class)
        );
    }
}
