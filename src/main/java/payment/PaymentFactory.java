package payment;

import java.util.Date;

public interface PaymentFactory {
    public Payment create(Date startDate, Money amount);
}
