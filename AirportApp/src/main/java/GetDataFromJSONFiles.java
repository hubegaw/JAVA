import Airports.Airport;
import Flights.Flight;
import Flights.Load.Baggage;
import Flights.Load.Cargo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromJSONFiles {
    JSONObject object;
    JSONArray bg;
    JSONArray cg;

    Baggage baggage;
    Cargo cargo;
    Flight flight;
    Airport airport;

    List<Flight> flights = new ArrayList<Flight>();
    List<Baggage> baggages = new ArrayList<Baggage>();
    List<Cargo> cargos = new ArrayList<Cargo>();
    List<Airport> airports = new ArrayList<Airport>();

    public void getDataFromFiles() throws IOException, ParseException {
        long fid, id, weight, pieces, number;
        String weightUnit, arrAirportCode, depAirportCode, date;

        JSONParser jsonparser = new JSONParser();
        FileReader flightData = new FileReader("src/main/resources/flightEntity.json");
        FileReader cargoData = new FileReader("src/main/resources/cargoEntity.json");

        Object fdobj = jsonparser.parse(flightData);
        Object cdobj = jsonparser.parse(cargoData);

        JSONObject fdjson = (JSONObject) fdobj;
        JSONObject cdjson = (JSONObject) cdobj;

        JSONArray flightsArr = (JSONArray) fdjson.get("flights");
        JSONArray cargosjArr = (JSONArray) cdjson.get("cargos");

        for(Object o : cargosjArr) {
            object = (JSONObject) o;
            bg = (JSONArray) object.get("baggage");
            cg = (JSONArray) object.get("cargo");
            fid = (long) object.get("flightId");
            for(Object o2 : bg) {
                object = (JSONObject) o2;
                id = (long) object.get("id");
                weight = (long) object.get("weight");
                weightUnit = (String) object.get("weightunit");
                pieces = (long) object.get("pieces");
                baggage = new Baggage(id);
                baggage.updateLoadInfo(fid, weight, weightUnit, pieces);
                baggages.add(baggage);
            }

            for(Object o3 : cg) {
                object = (JSONObject) o3;
                id = (long) object.get("id");
                weight = (long) object.get("weight");
                weightUnit = (String) object.get("weightunit");
                pieces = (long) object.get("pieces");
                cargo = new Cargo(id);
                cargo.updateLoadInfo(fid, weight, weightUnit, pieces);
                cargos.add(cargo);
            }
        }

        for (Object o : flightsArr) {
            object = (JSONObject) o;
            id = (long) object.get("flightId");
            number = (long) object.get("flightNumber");
            arrAirportCode = (String) object.get("arrivalAirportIATACode");
            depAirportCode = (String) object.get("departureAirportIATACode");
            date = (String) object.get("departureDate");

            flight = new Flight(id, number);
            flight.setBaggageList(baggages);
            flight.setCargoList(cargos);
            flight.updateFlightInfo(arrAirportCode, depAirportCode, date);
            flights.add(flight);

            airport = new Airport(arrAirportCode);
            airports.add(airport);
            airport = new Airport(depAirportCode);
            airports.add(airport);
        }
        for(Airport a : airports) {
            for(Flight f : flights)
                if(a.getAirportCode().equals(f.getDepartureAirportIATACode()))
                    a.updateAirportData(f);
        }
    }

    public List<Airport> getAirports() { return airports; }
    public List<Flight> getFlights() { return flights; }
}