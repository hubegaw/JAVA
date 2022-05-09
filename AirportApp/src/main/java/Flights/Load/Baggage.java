package Flights.Load;

public class Baggage implements ILoad {
    private long flightId;
    private final long baggageId;
    private long baggageWeight;
    private String baggageWeightUnit;
    private long baggagePieces;

    public Baggage(long id) {
        baggageId = id;
    }

    @Override
    public void updateLoadInfo(long fid, long weight, String weightUnit, long pieces) {
        flightId = fid;
        baggageWeight = weight;
        baggageWeightUnit = weightUnit;
        baggagePieces = pieces;
    }

    @Override
    public long getFlightId() { return flightId; }

    @Override
    public long getId() {
        return baggageId;
    }

    @Override
    public long getWeight() {
        return baggageWeight;
    }

    @Override
    public String getUnit() {
        return baggageWeightUnit;
    }

    @Override
    public long getPieces() { return baggagePieces; }
}
