package payment;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import java.util.Date;

public class RealPayment implements Payment {
    private final CreditService creditService;
    private final AuthService authService;
    private final Date startDate;
    private final Money amount;

    @Inject
    public RealPayment(CreditService creditService,
                       AuthService authService,
//                       Date startDate,
//                       Money amount
                       @Assisted Date startDate,
                       @Assisted Money amount
    ) {
        this.creditService = creditService;
        this.authService = authService;
        this.startDate = startDate;
        this.amount = amount;
    }

    @Override
    public void pay() {
        creditService.pay();
        authService.login();
        System.out.println(startDate.getTime() + ", " + amount.value());
    }
}
