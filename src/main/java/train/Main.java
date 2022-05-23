package train;

import java.util.ArrayList;
import java.util.List;
import train.locomotives.ElectricLocomotive;
import train.locomotives.Locomotive;
import train.wagon.FreightWagon;
import train.wagon.PassengerWagon;
import train.wagon.Wagon;

public class Main {
    public static void main(String[] args) {
        Locomotive electric = new ElectricLocomotive(1, 1996, "Skoda",
                Locomotive.Engine.ELECTRIC, Locomotive.Designation.PASSENGER);
        ElectricLocomotive locomotive = new ElectricLocomotive(2, 1998, "Skoda",
                Locomotive.Engine.ELECTRIC, Locomotive.Designation.PASSENGER);

        Wagon freightWagon = new FreightWagon(2001, "AEROTRAM12", "SIEMENS"
                , 1);
        Wagon freightWagon2 = new FreightWagon(2002, "AEROTRAM13",
                "SIEMENS", 2);
        Wagon passengerWagon = new PassengerWagon(2010, "MAGLEV2010",
                "China Railway", 3);
        List<Wagon> wagonList = new ArrayList<>();
        wagonList.add(freightWagon);
        wagonList.add(freightWagon2);
        wagonList.add(passengerWagon);

        Train train = new Train();
        train.addLocomotive(electric);
        train.addWagon(freightWagon);
        train.addWagon(passengerWagon);
        System.out.println("Added conductors to train " + train.addConductors(wagonList));
        System.out.println("Max loading of entire train : " + train.findMaxLoadingWeight());
        System.out.println("Max number of passengers on the train is : " + train.findMaxNumberOfPassenger());
        System.out.println("Total weight of the train is : " + train.findTotalWeightOfTheTrain());
        System.out.println("Total length of the train is : " + train.findTotalLengthOfTheTrain());
        System.out.println("Empty weight of the train is : " + train.findEmptyWeightOfTheEntireTrain());
        System.out.println("Train is capable to drive " + train.isCapableToDrive());
    }
}
