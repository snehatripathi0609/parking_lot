package com.parking.inputProcessor;

import com.flextrade.jfixture.JFixture;
import com.parking.exception.ParkingLotException;
import com.parking.models.Parking;
import com.parking.services.EvaluateStatusForParkingLot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InputFileProcessorTest {

    private InputFileProcessor inputfileProcessor;

    private EvaluateStatusForParkingLot evaluateStatusForParkingLot= Mockito.mock(EvaluateStatusForParkingLot.class);

    @BeforeEach
    void setUp() throws ParkingLotException {
        JFixture fixture = new JFixture();
        inputfileProcessor= new InputFileProcessor(evaluateStatusForParkingLot);
        Parking parking =fixture.create(Parking.class);
        Mockito.when(evaluateStatusForParkingLot.evaluateStatus(Mockito.anyMap())).thenReturn(parking);
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