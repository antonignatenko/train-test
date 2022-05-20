package train.wagon;

public class FreightWagon extends Wagon {
    private final int DEFAULT_WEIGHT_IN_TONS = 23;
    private final int DEFAULT_LENGTH_IN_METERS = 30;
    private final int MAX_LOAD_CAPACITY = 30_000;

    @Override
    public WagonTypes getWagonTypes() {
        return WagonTypes.GOODS;
    }

    private final WagonTypes FREIGHT_TYPE_WAGON = WagonTypes.GOODS;

    public FreightWagon(int yearOfProduction, String serialNumber, String manufacturer, int wagonId) {
        super(yearOfProduction, serialNumber, manufacturer, wagonId);
    }

    @Override
    public int getMaxPassengerCapacity() {
       return 0;
    }

    @Override
    public int getMaxLoadCapacity() {
        return MAX_LOAD_CAPACITY;
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
