package exception;

public class ParkingLotException extends Exception {

    public ParkingLotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingLotException(String message) {
        super(message);
    }
}
