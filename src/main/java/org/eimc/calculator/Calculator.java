package org.eimc.calculator;

/**
 *      Example 1: Calculator
 * */

public class Calculator {

    public <T extends Number> double add(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }
}
