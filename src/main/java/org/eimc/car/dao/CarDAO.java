package org.eimc.car.dao;

import org.eimc.car.Car;

/**
 *      CarDAO defines the contract for all data
 *      access operations related to Car entities
 * */

public interface CarDAO {

    Car[] getCars();

    void addCar(Car Car);

    void updateCar(Car carToUpdate);

}
