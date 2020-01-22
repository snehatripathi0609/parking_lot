package com.parking;

import com.parking.exception.ParkingLotException;
import com.parking.inputProcessor.InputFileProcessor;
import com.parking.services.EvaluateStatusForParkingLot;

public class ParkingLotApp {

    public static void main(String [] args) throws ParkingLotException {
        if(args.length <1){
            System.out.println("=======================================================================");
            System.out.println("Hey, You didn't enter the filename with instructions. How am I suppose to work?");
            System.out.println("=======================================================================");
            System.exit(0);
        }
        String file_name = args[0];
        System.out.println("=======================================================================");
        System.out.println("Hello There Vishal Singh! Your Girlfirend Loves you :* :* ");
        System.out.println("=======================================================================");
        System.out.println("file_name is "+file_name);
        System.out.println("=======================================================================");
        EvaluateStatusForParkingLot evaluateStatusForParkingLot = new EvaluateStatusForParkingLot();
        InputFileProcessor inputFileProcessor =new InputFileProcessor(evaluateStatusForParkingLot);
        inputFileProcessor.processInputFile(file_name);

    }

}
