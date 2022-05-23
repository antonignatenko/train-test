package train.locomotives;

public class ElectricLocomotive extends Locomotive {
    private final int DEFAULT_LENGTH_IN_METERS = 25;
    private final int EMPTY_WEIGHT_IN_TONS = 80;
    private final int MAX_PULL_WEIGHT_IN_TONS = 50_000;

    public ElectricLocomotive(int orderNumber, int yearOfProduction, String manufacturer,
                              Engine engineType, Designation designationType) {
        super(orderNumber, yearOfProduction, manufacturer, engineType, designationType);
    }

    @Override
    public int getTractiveForce() {
        return EMPTY_WEIGHT_IN_TONS + MAX_PULL_WEIGHT_IN_TONS;
    }

    @Override
    public int getDefaultWeight() {
        return EMPTY_WEIGHT_IN_TONS;
    }

    @Override
    public int getDefaultLength() {
        return DEFAULT_LENGTH_IN_METERS;
    }

    @Override
    public int getMaxPassengerCapacity() {
        if (getDesignationType().equals(Designation.PASSENGER)) {
            return 900;
        }
        throw new RuntimeException("This type of locomotive can't carry freight");
    }


    @Override
    public int getMaxLoadCapacity() {
        if (getDesignationType().equals(Designation.FREIGHT)) {
            return 450;
        }
        throw new RuntimeException("This type of locomotive don't carry passengers:");
    }

    @Override
    public String toString() {
        return "ElectricLocomotive{" +
                "DEFAULT_LENGTH_IN_METERS=" + DEFAULT_LENGTH_IN_METERS +
                ", EMPTY_WEIGHT_IN_TONS=" + EMPTY_WEIGHT_IN_TONS +
                ", MAX_PULL_WEIGHT_IN_TONS=" + MAX_PULL_WEIGHT_IN_TONS +
                '}';
    }
}

