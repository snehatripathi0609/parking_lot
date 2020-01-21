package models;

import utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class Parking {

    Map<String,String> status = new HashMap<>();
    Map<Integer,String> parkingSlots;

    public Map<String, String> getStatus() {
        return status;
    }

    public void setStatus(Map<String, String> status) {
        this.status = status;
    }

    public Map<Integer, String> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(Map<Integer, String> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public Map<Integer, String> initParkingSlots(int total_slots) {
        parkingSlots = new HashMap<>();
        for(int i=0;i<total_slots;i++){
            parkingSlots.put(i, Constants.free);
        }
        return parkingSlots;
    }

    public void parkCar(Integer freeSlot,String car){
            this.parkingSlots.put(freeSlot,car);
    }

    public void leaveSlot(String val){
        Integer park_key=   parkingSlots.entrySet().stream()
                .filter(e -> e.getValue().equals( Constants.free))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
         this.parkingSlots.put(park_key,Constants.free);
    }

    public Integer getFirstFreeSlot(){
        return parkingSlots.entrySet().stream()
                .filter(e -> e.getValue().equals( Constants.free))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }


}
