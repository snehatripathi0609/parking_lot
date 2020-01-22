package com.parking.services;

import com.parking.utils.Constants;

public class ParkingCalculator {

    public int calculateParkingCharges(double hours){
        int parkingCharges = Constants.base_parking_charge;
        if(hours <= 2 ){
            return parkingCharges;
        }
        hours= (int) Math.ceil(hours);
        parkingCharges= (int) (parkingCharges+((hours-2)*10));
        return parkingCharges;
    }
}
