package org.eimc.shippingCostCalculator;

/**
 *      Example 4: ShippingCostCalculator
 * */

public class ShippingCostCalculator {

    /**
     *      ShippingCostCalculator determines shipping
     *      costs based on weight, destination region,
     *      and delivery speed.
     */

    public double calculate(double weightKg, String region, boolean express) {

        // TODO: implement using TDD
        double basePrice = 0;

        // For <= 1kg, any region, standard
        if (weightKg <= 1){

            basePrice = 5.00;

        } else if (weightKg <= 5) {

            // Check the region to be local and adjust basePrice -> 10$
            basePrice = region.equalsIgnoreCase("Local") ? 10.00 : 20.00;

        }

        return basePrice;
    }
}
