package Flights.Load;

public class Cargo implements ILoad {
    private long flightId;
    private final long cargoId;
    private long cargoWeight;
    private String cargoWeightUnit;
    private long cargoPieces;

    public Cargo(long id) {
        cargoId = id;
    }

    @Override
    public void updateLoadInfo(long fid, long weight, String weightUnit, long pieces) {
        flightId = fid;
        cargoWeight = weight;
        cargoWeightUnit = weightUnit;
        cargoPieces = pieces;
    }

    @Override
    public long getFlightId() { return flightId; }

    @Override
    public long getId() { return cargoId; }

    @Override
    public long getWeight() { return cargoWeight; }

    @Override
    public String getUnit() { return cargoWeightUnit; }

    @Override
    public long getPieces() { return cargoPieces; }
}
