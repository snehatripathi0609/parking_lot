package services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Constants;

import static org.junit.jupiter.api.Assertions.*;

class ParkingCalculatorTest {

    private ParkingCalculator parkingCalculator;

    @BeforeEach
    void setUp() {
        parkingCalculator = new ParkingCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateParkingChargesWhenLessThanOrTwoHoursParking() {
        int charges = parkingCalculator.calculateParkingCharges(1);
        assertEquals(Constants.base_parking_charge, charges);
        charges = parkingCalculator.calculateParkingCharges(1.5);
        assertEquals(Constants.base_parking_charge, charges);
        charges = parkingCalculator.calculateParkingCharges(2.0);
        assertEquals(Constants.base_parking_charge, charges);
    }

    @Test
    void calculateParkingChargesWhenLGreaterThanTwoHoursParking() {
        int charges = parkingCalculator.calculateParkingCharges(2.5);
        assertEquals(20,charges);
        charges = parkingCalculator.calculateParkingCharges(4);
        assertEquals(30,charges);
        charges = parkingCalculator.calculateParkingCharges(5.5);
        assertEquals(50,charges);
    }
}