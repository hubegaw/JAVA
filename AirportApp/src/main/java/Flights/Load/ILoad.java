package Flights.Load;

public interface ILoad {
    void updateLoadInfo(long fid, long weight, String weightUnit, long pieces);
    long getFlightId();
    long getId();
    long getWeight();
    String getUnit();
    long getPieces();
}
