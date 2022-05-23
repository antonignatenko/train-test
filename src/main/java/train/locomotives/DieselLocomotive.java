package train.locomotives;

public class DieselLocomotive extends Locomotive {
    private final int DEFAULT_LENGTH_IN_METERS = 30;
    private final int EMPTY_WEIGHT_IN_TONS = 90;
    private final int MAX_PULL_WEIGHT_IN_TONS = 45_000;

    public DieselLocomotive(int orderNumber, int yearOfProduction, String manufacturer,
                            Engine engineType, Designation designationType) {
        super(orderNumber, yearOfProduction, manufacturer, engineType, designationType);
    }

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

    public int getMaxPassengerCapacity() {
        if (getDesignationType().equals(Designation.PASSENGER)) {
            return 450;
        }
        throw new RuntimeException("Only passenger locomotives can carry passengers:");
    }


    public int getMaxLoadCapacity() {
        if (getDesignationType().equals(Designation.FREIGHT)) {
            return 450;
        }
        throw new RuntimeException("Only passenger locomotives can carry passengers:");
    }
}
