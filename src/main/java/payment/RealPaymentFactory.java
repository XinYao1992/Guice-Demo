package payment;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Date;

public class RealPaymentFactory implements PaymentFactory {
    private final Provider<CreditService> creditServiceProvider;
    private final Provider<AuthService> authServiceProvider;

    @Inject
    public RealPaymentFactory(
            Provider<CreditService> creditServiceProvider,
            Provider<AuthService> authServiceProvider
    ) {
        this.creditServiceProvider = creditServiceProvider;
        this.authServiceProvider = authServiceProvider;
    }

    @Override
    public Payment create(Date startDate, Money amount) {
        System.out.println("Xyao create in RealPaymentFactory");
        return new RealPayment(
                creditServiceProvider.get(),
                authServiceProvider.get(),
                startDate,
                amount);
    }
}
