package train.wagon;

public class PassengerWagon extends Wagon {
    private final int DEFAULT_WEIGHT_IN_TONS = 60;
    private final int DEFAULT_LENGTH_IN_METERS = 30;
    private final int MAX_PASSENGER_CAPACITY = 150;

    @Override
    public WagonTypes getWagonTypes() {
        return WagonTypes.PASSENGER;
    }

    private final WagonTypes PASSENGER_TYPE_WAGON = WagonTypes.SLEEPING;

    public PassengerWagon(int yearOfProduction, String serialNumber,
                          String manufacturer, int wagonId) {
        super(yearOfProduction, serialNumber, manufacturer, wagonId);
    }

    @Override
    public int getMaxPassengerCapacity() {
        return MAX_PASSENGER_CAPACITY;
    }

    @Override
    public int getMaxLoadCapacity() {
       return 0;
    }

    @Override
    public int getDefaultWagonWeight() {
        return DEFAULT_WEIGHT_IN_TONS;
    }

    @Override
    public int getDefaultLength() {
        return DEFAULT_LENGTH_IN_METERS;
    }
}
