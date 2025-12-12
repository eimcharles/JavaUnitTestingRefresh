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
    void shouldChargeFiveDollarsForWeightLessThanOrEqualToOneKg() {

        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(0.5, "Local", false))
                .isEqualTo(5.00);

    }

    @Test
    void shouldChargeTenDollarsForWeightLessThanOrEqualToFiveKgForLocalShipping() {

        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(2.0, "Local", false))
                .isEqualTo(10.00);

    }

    @Test
    void shouldChargeTwentyDollarsForWeightLessThanOrEqualToFiveKgForInternationalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(2.0, "International", false))
                .isEqualTo(20.00);

    }

    @Test
    void shouldChargeTwentyFiveDollarsForWeightGreaterThanOrEqualToFiveKgForInternationalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(6.0, "International", false))
                .isEqualTo(25.00);

    }

    @Test
    void shouldChargeFifteenDollarsForWeightGreaterThanFiveKgForLocalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(6.0, "Local", false))
                .isEqualTo(15.00);

    }

    @Test
    void shouldAddExpressFeeForExpressWhenWeightLessThanOneKgForLocalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(0.5, "Local", true))
                .isEqualTo(20.00);

    }

    @Test
    void shouldAddExpressFeeForExpressWhenWeightLessThanFiveKgForLocalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(4.0, "Local", true))
                .isEqualTo(25.00);

    }

    @Test
    void shouldAddExpressFeeForExpressWhenWeightLessThanFiveKgForInternationalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(4.0, "International", true))
                .isEqualTo(35.00);

    }

    @Test
    void shouldAddExpressFeeForExpressWhenWeightGreaterThanFiveKgForLocalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(6.0, "Local", true))
                .isEqualTo(30.00);

    }

    @Test
    void shouldAddExpressFeeForExpressWhenWeightGreaterThanFiveKgForInternationalShipping() {
        // WHEN actualTestShippingCostCalculator object created in setUp();

        // THEN
        assertThat(actualTestShippingCostCalculator.calculate(6.0, "International", true))
                .isEqualTo(40.00);

    }
}
