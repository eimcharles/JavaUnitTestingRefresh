package org.eimc.shippingCostCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *      Unit testing example 4: ShippingCostCalculatorTest
 *
 *      Test methods follow the Arrange-Act-Assert (AAA) pattern,
 *      commonly labeled as Given-When-Then:
 *
 *      1. GIVEN (Arrange): Set up the required inputs, mocks, and expected outcomes.
 *      2. WHEN (Act): Execute the method under test.
 *      3. THEN (Assert): Verify the result using assertions (AssertJ).
 * */

public class ShippingCostCalculatorTest {

    private ShippingCostCalculator actualTestShippingCostCalculator;

    @BeforeEach
    void setUp(){

        // GIVEN
        actualTestShippingCostCalculator = new ShippingCostCalculator();

    }

    @Test
    void shouldChargeFiveDollarsForSmallPackage() {

        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(0.5, "Local", false))
                .isEqualTo(5.00);

    }

    @Test
    void shouldChargeTenDollarsForLocalStandardShipping() {

        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(2.0, "Local", false))
                .isEqualTo(10.00);

    }

    @Test
    void shouldChargeTwentyDollarsForInternationalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(2.0, "International", false))
                .isEqualTo(20.00);

    }

    @Test
    void shouldAddExpressFee() {


    }
}
