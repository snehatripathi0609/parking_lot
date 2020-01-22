package com.parking.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String create_parking_lot = "create_parking_lot";
    public static final String park = "park";
    public static final String leave = "leave";
    public static final String status = "status";
    public static final List<String> parkInstructions = new ArrayList<>(Arrays.asList(
            create_parking_lot,
            park,
            leave,
            status));
    public static final int base_parking_charge = 10;
    public static final String free = "free";
    public static final String parking_full ="parking_full";
}
