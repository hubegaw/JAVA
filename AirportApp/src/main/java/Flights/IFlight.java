package Flights;

import Flights.Load.Baggage;
import Flights.Load.Cargo;

import java.util.List;

public interface IFlight {
    void updateFlightInfo(String arrAirportCode, String depAirportCode, String date);
    void setBaggageList(List<Baggage> bgs);
    void setCargoList(List<Cargo> cgs);
    long getFlightId();
    long getFlightNumber();
    long getTotalWeight();
    String getArrivalAirportIATACode();
    String getDepartureAirportIATACode();
    String getDepartureDate();
    long getPiecesOfBaggage();
    String toString();
}
