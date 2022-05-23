package train.locomotives;

public abstract class Locomotive {
    private int locomotiveId;
    private int yearOfProduction;
    private String manufacturer;
    private Engine engineType;
    private Designation designationType;

    public Locomotive(int orderNumber, int yearOfProduction, String manufacturer, Engine engineType,
                      Designation designationType) {
        this.locomotiveId = orderNumber;
        this.yearOfProduction = yearOfProduction;
        this.manufacturer = manufacturer;
        this.engineType = engineType;
        this.designationType = designationType;
    }

    public enum Designation {
        PASSENGER, FREIGHT
    }

    public enum Engine {
        DIESEL, STEAM, ELECTRIC
    }

    public Designation getDesignationType() {
        return designationType;
    }

    public Engine getEngineType() {
        return engineType;
    }

    public int getLocomotiveId() {
        return locomotiveId;
    }

    abstract public int getMaxLoadCapacity();

    abstract public int getMaxPassengerCapacity();

    abstract public int getTractiveForce();

    abstract public int getDefaultWeight();

    abstract public int getDefaultLength();
}