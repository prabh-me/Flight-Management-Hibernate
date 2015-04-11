package flight.hibernate;

import java.util.List;

import flight.hibernate.HibernateTemplate;
import flight.hibernate.Flight;

public class FlightDAO {
    private HibernateTemplate hibernateTemplate;
    
    public FlightDAO() {
        this.hibernateTemplate = new HibernateTemplate();
    }

    public Flight getFlight(long FlightId) {
        return (Flight) this.hibernateTemplate.findById(FlightId, Flight.class);
    }

    public long addFlight(Flight Flight) {
        return (Long) ( this.hibernateTemplate.save(Flight));
    }

    public void deleteFlight(long FlightId) {
        this.hibernateTemplate.delete(FlightId, Flight.class);
    }

    public Flight updateFlight(Flight Flight) {
        return (Flight) this.hibernateTemplate.update(Flight);
    }

    @SuppressWarnings("unchecked")
    public List<Flight> listFlight() {
        return (List<Flight>) this.hibernateTemplate.findAll(Flight.class);
    }
}