package Flights;

import Flights.Load.Baggage;
import Flights.Load.Cargo;

import java.util.List;

public class Flight implements IFlight {
    private final long flightId;
    private final long flightNumber;
    private String arrivalAirportIATACode;
    private String departureAirportIATACode;
    private String departureDate;
    private long cargoWeight = 0;
    private long baggageWeight = 0;
    private long totalWeight = 0;
    private long piecesOfBaggageOnBoard = 0;

    List<Baggage> baggages;
    List<Cargo> cargos;

    public Flight(long id, long number) {
        flightId = id;
        flightNumber = number;
    }

    @Override
    public void updateFlightInfo(String arrAirportCode, String depAirportCode, String date) {
        arrivalAirportIATACode = arrAirportCode;
        departureAirportIATACode = depAirportCode;
        departureDate = date;
        countTotalWeight();
        countPiecesOfBaggage();
    }

    private void countTotalWeight() {
        for(Baggage b : baggages) {
            baggageWeight += b.getWeight();
            totalWeight += b.getWeight();
        }

        for(Cargo c : cargos) {
            cargoWeight += c.getWeight();
            totalWeight += c.getWeight();
        }
    }

    private void countPiecesOfBaggage() {
        for(Baggage b : baggages) {
            piecesOfBaggageOnBoard += b.getPieces();
        }
    }

    @Override
    public void setBaggageList(List<Baggage> bgs) {
        baggages = bgs;
    }

    @Override
    public void setCargoList(List<Cargo> cgs) {
        cargos = cgs;
    }

    @Override
    public long getFlightId() {
        return flightId;
    }

    @Override
    public long getFlightNumber() {
        return flightNumber;
    }

    @Override
    public long getTotalWeight() { return totalWeight; }

    @Override
    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    @Override
    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public long getPiecesOfBaggage() { return piecesOfBaggageOnBoard; }

    @Override
    public String toString() {
        String cw = "Cargo Weight: " + cargoWeight;
        String bw = "\nBaggage Weight: " + baggageWeight;
        String tw = "\nTotal Weight: " + totalWeight;

        return cw + bw + tw;
    }
}
