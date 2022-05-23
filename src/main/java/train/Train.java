package train;

import java.util.ArrayList;
import java.util.List;
import train.locomotives.Locomotive;
import train.wagon.Wagon;

public class Train {
    private List<Wagon> wagons = new ArrayList<>();
    private List<Locomotive> locomotives = new ArrayList<>();
    private int conductors;

    public List<Wagon> getWagons() {
        return wagons;
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void addWagon(Wagon wagon) {
        if (wagons.size() != 0) {
            boolean existedId = wagons.stream()
                    .anyMatch(e -> e.getWagonId() == wagon.getWagonId());
            if (existedId) {
                throw new RuntimeException("Sorry such wagon id is already present in the train");
            }
        }
        wagons.add(wagon);
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() != 0) {
            boolean existedId = locomotives.stream()
                    .anyMatch(e -> e.getLocomotiveId() == locomotive.getLocomotiveId());
            if (existedId) {
                throw new RuntimeException("Sorry such locomotive id is already present in the train");
            }
        }
        locomotives.add(locomotive);
    }

    public int findEmptyWeightOfTheEntireTrain() {
        return locomotives.stream()
                .mapToInt(Locomotive::getDefaultWeight)
                .sum()
                +
                wagons.stream()
                        .mapToInt(Wagon::getDefaultWagonWeight)
                        .sum();
    }

    public int findMaxNumberOfPassenger() {
        return wagons.stream()
                .filter(e -> !e.getWagonTypes().equals(Wagon.WagonTypes.GOODS))
                .mapToInt(Wagon::getMaxPassengerCapacity)
                .sum();
    }

    public int findMaxLoadingWeight() {
        return wagons.stream()
                .filter(e -> e.getWagonTypes().equals(Wagon.WagonTypes.GOODS))
                .mapToInt(Wagon::getMaxLoadCapacity)
                .sum();
    }

    public int findMaxLoadingOfTheTrain() {
        return (findMaxNumberOfPassenger() * 75) + findMaxLoadingWeight();
    }

    public int findTotalWeightOfTheTrain() {
        return findEmptyWeightOfTheEntireTrain() + findMaxLoadingOfTheTrain();
    }

    public int findTotalLengthOfTheTrain() {
        return locomotives.stream()
                .mapToInt(Locomotive::getDefaultLength)
                .sum()
                +
                wagons.stream()
                        .mapToInt(Wagon::getDefaultLength)
                        .sum();
    }

    public boolean isCapableToDrive() {
        return locomotives
                .stream()
                .map(Locomotive::getTractiveForce)
                .mapToInt(e -> e).sum() > findMaxLoadingOfTheTrain();
    }

    public int addConductors(List<Wagon> wagons) {
        return conductors = findMaxNumberOfPassenger() / 50;
    }
}
