package org.eimc.shippingCostCalculator;

/**
 *      Example 4: ShippingCostCalculator
 * */

public class ShippingCostCalculator {

    private static final double EXPRESS_FEE = 15.00;

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

            // Weight <= 5kg
            // Check the region to be local and adjust basePrice -> 10$
            // Check if region is not local (International) adjust basePrice -> 20$
            basePrice = region.equalsIgnoreCase("Local") ? 10.00 : 20.00;

        } else {

            // Weight > 5kg
            // Check the region to be local and adjust basePrice -> 15$
            // Check if region is not local (International) adjust basePrice -> 25$
            basePrice = region.equalsIgnoreCase("Local") ? 15.00 : 25.00;

        }

        // Add express fee
        if (express) {
            basePrice += EXPRESS_FEE;
        }

        return basePrice;
    }
}
