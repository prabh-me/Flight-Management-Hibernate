package flight.hibernate;
import java.io.Serializable;
public class Flight implements Serializable {
    private static final long serialVersionUID = -9001198124094210159L;
    
    // properties
    private long id;  // identifier
    private String flightNo;
    private String depLoc;
    private String arrLoc;
    private String validTill;
    private String flightTime;
    private String flightDur;
    private int fare;
    private String seatAvailability;
    private String travelClass;
    
    public Flight() {
        super();
    }
    
    public Flight(String flightNo, String depLoc, String arrLoc, String validTill, String flightTime, String flightDur, int fare, String seatAvailability, String travelClass) {
        super();
        this.flightNo = flightNo;
        this.depLoc = depLoc;
        this.arrLoc = arrLoc;
        this.validTill = validTill;
        this.flightTime = flightTime;
        this.flightDur = flightDur;
        this.fare = fare;
        this.seatAvailability = seatAvailability;
        this.travelClass = travelClass;
    }

    
    @Override
    public String toString() {
        return "Flight [id=" + id + ", Flight No=" + flightNo + ", Dep Loc=" + depLoc + ", Arr Loc=" + arrLoc + ", Valid Till=" + validTill + ", Flight Time=" + flightTime + ", Flight Duration=" + flightDur + ", Fare=" + fare + ", Seat Availability=" + seatAvailability
                + ", class=" + travelClass + "]";
    }

 // setters and getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(String flightDur) {
		this.flightDur = flightDur;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
}
