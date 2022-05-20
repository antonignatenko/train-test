package train.wagon;

public abstract class Wagon {
    private int wagonId;
    private int yearOfProduction;
    private String serialNumber;
    private String manufacturer;
    private WagonTypes wagonTypes;

    public Wagon(int yearOfProduction, String serialNumber,
                 String manufacturer, int wagonId) {
        this.yearOfProduction = yearOfProduction;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.wagonId = wagonId;
    }

    public enum WagonTypes {
        PASSENGER, SLEEPING, DINING, GOODS
    }

    public int getWagonId() {
        return wagonId;
    }

    public WagonTypes getWagonTypes() {
        return wagonTypes;
    }

    abstract public int getMaxPassengerCapacity();

    abstract public int getMaxLoadCapacity();

    abstract public int getDefaultWagonWeight();

    abstract public int getDefaultLength();
}
