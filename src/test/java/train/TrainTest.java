package train;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import train.locomotives.ElectricLocomotive;
import train.locomotives.Locomotive;
import train.wagon.FreightWagon;
import train.wagon.PassengerWagon;
import train.wagon.Wagon;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {
    private Train train;
    private Wagon passengerWagon;
    private FreightWagon freightWagon;
    private FreightWagon goodsCarriage;
    private Locomotive locomotive;

    @BeforeEach
    void setUp() {
        train = new Train();
        passengerWagon = new PassengerWagon(2001, "AEROTRAM", "SKODA", 1);
        freightWagon = new FreightWagon(2001, "FREIGHTWAGON", "SIEMENS", 2);
        locomotive = new ElectricLocomotive(1, 1996, "Skoda",
                Locomotive.Engine.ELECTRIC, Locomotive.Designation.PASSENGER);
        goodsCarriage = new FreightWagon(2003, "GOODS CARRIAGE", "CD CARGO", 3);

        train.addWagon(passengerWagon);
        train.addWagon(freightWagon);
        train.addLocomotive(locomotive);
    }

    @Test
    void getTrainEmptyWeight_Ok() {
        int actual = train.findEmptyWeightOfTheEntireTrain();
        int expected = 163;
        assertEquals(expected, actual);
        assertFalse(actual == 0);
        assertFalse(actual < 0);
    }

    @Test
    void findMaxPassengers_InGoodsTypeOfWagons_Ok() {
        Train goodsTrain = new Train();
        train.addWagon(goodsCarriage);
        int actual = goodsTrain.findMaxNumberOfPassenger();
        assertTrue(actual == 0);
    }

    @Test
    void findMaxPassengers_InPassengerTypeOfWagons_Ok() {
        int actual = train.findMaxNumberOfPassenger();
        int expected = 150;
        assertTrue(actual != 0);
        assertEquals(expected, actual);
    }

    @Test
    void findMaxLoadingWeight_InPassengerTypeOfWagon_notOk() {
        Train passengerTrain = new Train();
        passengerTrain.addWagon(passengerWagon);
        int actual = passengerTrain.findMaxLoadingWeight();
        assertTrue(actual == 0);
    }

    @Test
    void findMaxLoadingWeight_InFreightTypeOfWagon_notOk() {
        int actual = train.findMaxLoadingWeight();
        assertTrue(actual != 0);
    }

    @Test
    void findMaxLoadingOfTheTrain_Ok() {
        int actual = train.findMaxLoadingOfTheTrain();
        int expected = 41250;
        assertEquals(expected, actual);
        assertTrue(actual > 0);
    }

    @Test
    void findTotalLengthOfTheTrain_Ok() {
        int actual = train.findTotalLengthOfTheTrain();
        int expected = 85;
        assertTrue(actual > 0);
        assertEquals(expected, actual);
    }

    @Test
    void isCapableToDrive_Ok() {
        boolean actual = train.isCapableToDrive();
        assertTrue(actual);
    }

    @Test
    void addConductors_Ok() {
        List<Wagon> wagonList = new ArrayList<>();
        wagonList.add(passengerWagon);
        int actual = train.addConductors(wagonList);
        int expected = 3;
        assertTrue(actual > 0);
        assertEquals(expected, actual);
    }
}