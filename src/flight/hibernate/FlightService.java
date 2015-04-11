package flight.hibernate;

import java.util.List;
import flight.hibernate.FlightDAO;
import flight.hibernate.Flight;

public class FlightService {
    private FlightDAO flightDAO;
    
    public FlightService() {
        this.flightDAO = new FlightDAO();
    }
    
    public Flight getFlight(long flightId) {
        return this.flightDAO.getFlight(flightId);
    }

    public long addFlight(Flight flight) {
        return this.flightDAO.addFlight(flight);
    }

    public void deleteFlight(long flightId) {
        this.flightDAO.deleteFlight(flightId);
    }

    public Flight updateFlight(Flight flight) {
        return this.flightDAO.updateFlight(flight);
    }

    public List<Flight> listFlight() {
        return this.flightDAO.listFlight();
    }
}