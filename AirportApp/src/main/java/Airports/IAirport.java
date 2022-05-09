package Airports;

import Flights.Flight;

import java.util.List;

public interface IAirport {
    void updateAirportData(Flight f);
    String getAirportCode();
    int getArrivalFlightsAmount();
    int getDepartureFlightsAmount();
    int getTotalNumberOfBaggageArriving();
    int getTotalNumberOfBaggageDeparting();
    String toString();
}
