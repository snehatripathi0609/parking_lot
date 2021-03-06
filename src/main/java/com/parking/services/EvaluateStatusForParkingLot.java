package com.parking.services;

import com.parking.exception.ParkingLotException;
import com.parking.models.Parking;
import com.parking.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class EvaluateStatusForParkingLot {


    public Parking evaluateStatus(Map<String, String> parkingQuery) throws ParkingLotException {
        Parking parkingSlotDetail = new Parking();
        int total_slots = Integer.valueOf(parkingQuery.get(Constants.create_parking_lot));
        if (total_slots < 1) {
            throw new ParkingLotException("Invalid number of parking slots!");
        }
        parkingSlotDetail.initParkingSlots(total_slots);
        Map<String, String> status = new HashMap<>();

        for (Map.Entry<String, String> entry : parkingQuery.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            if (Constants.park.equals(key)) {
                System.out.println("Key:"+key);
                System.out.println("val:"+val);
                Integer freeSlot = parkingSlotDetail.getFirstFreeSlot();
                if (freeSlot != null) {
                    parkingSlotDetail.parkCar(freeSlot, val);
                    status.put(String.valueOf(freeSlot), val);
                } else {
                    status.put(Constants.parking_full, val);
                }

            }
            if (Constants.leave.equals(key)) {
              //TODO
            }

        }

        return parkingSlotDetail;
    }


}
