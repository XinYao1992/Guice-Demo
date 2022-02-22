package implementation;

import contract.Assertor;

public class TestNgAssertor implements Assertor {
    public void equal(int expectValue, int factValue) {
        System.out.println("TestNg Assertor equal...");
    }
}
