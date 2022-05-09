package Airports;

import Flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class Airport implements IAirport {
    private final String airportCode;
    private int arrivalFlightsAmount = 0;
    private int departureFlightsAmount = 0;
    private int totalPiecesOfBaggageArriving = 0;
    private int totalPiecesOfBaggageDeparting = 0;

    List<Flight> flights = new ArrayList<>();

    public Airport(String code) {
        airportCode = code;
    }

    @Override
    public void updateAirportData(Flight f) {
        flights.add(f);
        countArrivalFlightsAmount();
        countDepartureFlightsAmount();
        countArrivalFlightsAmount();
        countTotalNumberOfBaggageArriving();
        countTotalNumberOfBaggageDeparting();
    }

    private void countArrivalFlightsAmount() {
        for (Flight f : flights) {
            if (f.getArrivalAirportIATACode().equals(airportCode)) {
                arrivalFlightsAmount++;
            }
        }
    }

    private void countDepartureFlightsAmount() {
        for(Flight f : flights) {
            if(!checkIfArrival(f)) {
                departureFlightsAmount++;
            }
        }
    }

    private void countTotalNumberOfBaggageArriving() {
        for(Flight f : flights) {
            if(checkIfArrival(f)) {
                totalPiecesOfBaggageArriving += f.getPiecesOfBaggage();
            }
        }
    }

    private void countTotalNumberOfBaggageDeparting() {
        for(Flight f : flights) {
            if(!checkIfArrival(f)) {
                totalPiecesOfBaggageDeparting += f.getPiecesOfBaggage();
            }
        }
    }

    private boolean checkIfArrival(Flight f) {
        return f.getArrivalAirportIATACode().equals(airportCode);
    }

    public void getFlightsDates() {
        for(Flight f : flights) {
            System.out.println(f.getDepartureDate().substring(0,10));
        }
    }

    @Override
    public String getAirportCode() { return airportCode; }

    @Override
    public int getArrivalFlightsAmount() { return arrivalFlightsAmount; }

    @Override
    public int getDepartureFlightsAmount() { return departureFlightsAmount; }

    @Override
    public int getTotalNumberOfBaggageArriving() { return totalPiecesOfBaggageArriving; }

    @Override
    public int getTotalNumberOfBaggageDeparting() { return totalPiecesOfBaggageDeparting; }

    @Override
    public String toString() {
        String flightsArr = "Number of flights arriving: " + arrivalFlightsAmount;
        String flightsDep = "\nNumber of flights departing: " + departureFlightsAmount;
        String totalBaggageArr = "\nTotal number of baggage arriving: " + totalPiecesOfBaggageArriving;
        String totalBaggageDep = "\nTotal number of baggage departing: " + totalPiecesOfBaggageDeparting;

        return flightsArr + flightsDep + totalBaggageArr + totalBaggageDep;
    }
}
