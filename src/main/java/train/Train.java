package train;

import java.util.List;
import train.locomotives.Locomotive;
import train.wagon.Wagon;

public class Train {
    private List<Wagon> wagons;
    private List<Locomotive> locomotives;
    private int conductors;


    public void addWagon(Wagon wagon) {
        for (Wagon w : wagons) {
            if (w.getWagonId() == wagon.getWagonId()) {
                throw new RuntimeException("Wagon with such id " + wagon.getWagonId()
                        + "is already present in train");
            }
        }
        wagons.add(wagon);
    }

    public void addLocomotive(Locomotive locomotive) {
        for (Locomotive l : locomotives) {
            if (l.getOrderNumber() == locomotive.getOrderNumber()) {
                throw new RuntimeException("Locomotive with such id " + locomotive.getOrderNumber()
                        + "is already present in train");
            }
        }
        locomotives.add(locomotive);
    }

    public int findEmptyWeightOfTheEntireTrain(List<Wagon> wagonsList, List<Locomotive> locomotives) {
        return locomotives.stream()
                .map(Locomotive::getDefaultWeight)
                .mapToInt(e -> e)
                .sum()
                +
                wagonsList.stream()
                        .map(Wagon::getDefaultWagonWeight)
                        .mapToInt(e -> e)
                        .sum();
    }

    public int findMaxNumberOfPassenger(List<Wagon> wagonsList) {
        return wagonsList.stream()
                .filter(e -> !e.getWagonTypes().equals(Wagon.WagonTypes.GOODS))
                .map(Wagon::getMaxPassengerCapacity)
                .mapToInt(e -> e)
                .sum();
    }

    public int findMaxLoadingWeight(List<Wagon> wagonList) {
        return wagonList.stream()
                .filter(e -> e.getWagonTypes().equals(Wagon.WagonTypes.GOODS))
                .map(Wagon::getMaxLoadCapacity)
                .mapToInt(e -> e)
                .sum();
    }

    public int findMaxLoadingOfTheTrain(List<Wagon> wagonList) {
        return (findMaxNumberOfPassenger(wagonList) * 75) + findMaxLoadingWeight(wagonList);
    }

    public int findTotalWeightOfTheTrain(List<Wagon> wagons, List<Locomotive> locomotives) {
        return findEmptyWeightOfTheEntireTrain(wagons, locomotives) + findMaxLoadingOfTheTrain(wagons);
    }

    public static int findTotalLengthOfTheTrain(List<Wagon> wagons, List<Locomotive> locomotives) {
        return locomotives.stream()
                .map(Locomotive::getDefaultLength)
                .mapToInt(e -> e)
                .sum()
                +
                wagons.stream()
                        .map(Wagon::getDefaultLength)
                        .mapToInt(e -> e)
                        .sum();
    }

    public boolean isCapableToDrive(List<Locomotive> locomotives, List<Wagon> wagons) {
        return locomotives
                .stream()
                .map(Locomotive::getTractiveForce)
                .mapToInt(e -> e).sum() > findMaxLoadingOfTheTrain(wagons);
    }


    public int addConductors(List<Wagon> wagons) {
        return conductors = findMaxNumberOfPassenger(wagons) / 50;
    }





   /*
        cоздать инстанцы вагонов
        добавить  их в  лист вагонов
        тоже самое с локомотивами
         */
}
