package train.wagon;

public class SleepingWagon extends Wagon {
    private final int DEFAULT_WEIGHT_IN_TONS = 60;
    private final int DEFAULT_LENGTH = 30;
    private final int MAX_PASSENGER_CAPACITY = 200;

    @Override
    public WagonTypes getWagonTypes() {
        return WagonTypes.SLEEPING;
    }

    private final WagonTypes SLEEPING_TYPE_WAGON = WagonTypes.SLEEPING;

    public SleepingWagon(int yearOfProduction, String serialNumber, String manufacturer, int wagonId) {
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
        return DEFAULT_LENGTH;
    }
}
