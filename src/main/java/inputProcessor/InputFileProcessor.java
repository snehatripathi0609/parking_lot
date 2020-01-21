package inputProcessor;

import exception.ParkingLotException;
import services.EvaluateStatusForParkingLot;
import utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputFileProcessor {

    private EvaluateStatusForParkingLot evaluateStatusForParkingLot;

    public InputFileProcessor(EvaluateStatusForParkingLot evaluateStatusForParkingLot) {
         this.evaluateStatusForParkingLot = evaluateStatusForParkingLot;
    }

    public void processInputFile(String path) throws ParkingLotException {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            Map<String, String> parkingQuery = new HashMap<>();
            for (String line : allLines) {
                String[] parkingInstruction = line.split(" ");
                if (parkingInstruction.length < 1 && (Constants.status).equals(parkingInstruction[0])) {
                    throw new ParkingLotException("Invalid Instruction Found!");
                }
                if (parkingInstruction.length < 2 && !(Constants.status).equals(parkingInstruction[0])) {
                    throw new ParkingLotException("Invalid Instruction Found!");
                }
                if (!Constants.parkInstructions.contains(parkingInstruction[0])) {
                    throw new ParkingLotException("Invalid Instruction Found!");
                }
                if(!(Constants.status).equals(parkingInstruction[0])){
                    parkingQuery.put(parkingInstruction[0], parkingInstruction[1]);
                }else{
                    parkingQuery.put(parkingInstruction[0], parkingInstruction[0]);
                }
            }

            evaluateStatusForParkingLot.evaluateStatus(parkingQuery);

        } catch (IOException e) {
            System.out.println("Exception occurred while reading input file");
            throw new ParkingLotException("Exception occurred while reading input file:{}", e);
        }
    }
}
