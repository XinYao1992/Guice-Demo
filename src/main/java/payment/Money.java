package payment;

public class Money {
    private String price;

    public Money(String p) {
        this.price = p;
    }

    public String value(){
        return "This is money: " + price;
    };
}
