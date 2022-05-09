import Airports.Airport;
import Flights.Flight;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AirportsSimulator {

    static GetDataFromJSONFiles gdfjsonf = new GetDataFromJSONFiles();
    static List<Airport> airports;
    static List<Flight> flights;

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\r\\n]+");
        int choice;
        String date, code;
        long flightNumber;
        gdfjsonf.getDataFromFiles();
        airports = gdfjsonf.getAirports();
        flights = gdfjsonf.getFlights();

        System.out.println("Welcome to Airports Simulator!\nWhat would you like to do?\n");
        displayFirstRequest();
        displaySecondRequest();
        while(true) {
            System.out.println("\nPress '1' and type Flight Number and date(YYYY-MM-dd format) to see details.\n");
            System.out.println("Press '2' and type IATA Airport Code and date(YYYY-MM-dd format) to see details.\n");
            System.out.println("Press '3' to end the simulator.");

            choice = sc.nextInt();

            switch(choice) {
                case 1 -> {
                    System.out.println("Input flight number");
                    flightNumber = sc.nextLong();
                    System.out.println("Input date");
                    sc.nextLine();
                    date = sc.nextLine();
                    for(Flight f : flights) {
                        if (f.getFlightNumber() == flightNumber && f.getDepartureDate().substring(0,10).equals(date)) {
                            System.out.println(f + "\n");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Input IATA Airport Code");
                    sc.nextLine();
                    code = sc.nextLine();
                    System.out.println("Input date");
                    date = sc.nextLine();
                    for(Airport a : airports) {
                        for(Flight f : flights) {
                            if (a.getAirportCode().equals(code) && f.getDepartureDate().substring(0,10).equals(date)) {
                                System.out.println("\nIATA Airport Code" + a.getAirportCode() + ",\ttime: " + f.getDepartureDate());
                                System.out.println(a);
                            }
                        }
                    }
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Wrong input!\n");
            }
        }
    }

    private static void displayFirstRequest() {
        for(Flight f : flights) {
            System.out.println("Flight number " + f.getFlightNumber() + ",\tdate " + f.getDepartureDate().substring(0,10));
        }
    }

    private static void displaySecondRequest() {
        for(Airport a : airports) {
            System.out.println("\nIATA Airport Code: " + a.getAirportCode());
            System.out.println("Dates:");
            a.getFlightsDates();
        }
    }

}
