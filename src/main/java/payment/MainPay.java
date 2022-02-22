package payment;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import domain.TextEditor;

import java.util.Date;

public class MainPay {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PaymentModule());//注入模块

        // Solution 1:
//        PaymentFactory realPaymentFactory = injector.getInstance(PaymentFactory.class);
////        RealPayment payment1 = (RealPayment) realPaymentFactory.create(new Date(), new Money("1.5"));
//        Payment payment1 = realPaymentFactory.create(new Date(), new Money("1.5")); // 同上
//        payment1.pay();

        System.out.println("<< ===================================== >>");


        // Solution 2 by AssistedInjector:
        PaymentFactory paymentFactory = injector.getInstance(PaymentFactory.class);
        Payment payment2 = paymentFactory.create(new Date(), new Money("2.5"));
        payment2.pay();
    }
}
