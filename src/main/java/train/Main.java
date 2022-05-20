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
        Locomotive electric = new ElectricLocomotive(1,1996,"Skoda",
                Locomotive.Engine.ELECTRIC, Locomotive.Designation.PASSENGER);
        ElectricLocomotive locomotive = new ElectricLocomotive(2,1998,"Skoda",
                Locomotive.Engine.ELECTRIC, Locomotive.Designation.PASSENGER);

        Wagon freightWagon = new FreightWagon(2001,"AEROTRAM12","SIEMENS"
             ,1 );
        Wagon freightWagon2 = new FreightWagon(2002,"AEROTRAM13",
                "SIEMENS",2);
        Wagon passengerWagon = new PassengerWagon(2010,"MAGLEV2010",
                "China Railway",3);


        Train train = new Train();
        train.addLocomotive(electric);
        train.addLocomotive(locomotive);
        train.addWagon(freightWagon);
        train.addWagon(freightWagon2);
        train.addWagon(passengerWagon);

    }
}
