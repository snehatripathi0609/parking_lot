package inputProcessor;

import com.flextrade.jfixture.JFixture;
import exception.ParkingLotException;
import models.Parking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.EvaluateStatusForParkingLot;

class InputFileProcessorTest {

    private InputFileProcessor inputfileProcessor;

    private EvaluateStatusForParkingLot evaluateStatusForParkingLot= Mockito.mock(EvaluateStatusForParkingLot.class);

    @BeforeEach
    void setUp() throws ParkingLotException {
        JFixture fixture = new JFixture();
        inputfileProcessor= new InputFileProcessor(evaluateStatusForParkingLot);
        Mockito.when(evaluateStatusForParkingLot.evaluateStatus(Mockito.anyMap())).thenReturn(fixture.create(Parking.class));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void processInputFile() throws ParkingLotException {
        String path="/home/coditas/IdeaProjects/parking_lot/bin/parking_lot file_inputs.txt";
        inputfileProcessor.processInputFile(path);
    }
}