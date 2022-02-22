package implementation;

import contract.Assertor;

public class JUnitAssertor implements Assertor {
    public void equal(int expectValue, int factValue) {
        System.out.println("JUnit Assertor equal...");
    }
}
