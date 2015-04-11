package flight.hibernate;

import java.util.List;
import java.util.Scanner;
import flight.hibernate.Flight;
import flight.hibernate.FlightService;

public class Application {
    
    public static void main(String[] args) {
        
        FlightService flightService = new FlightService();
        Scanner input = new Scanner(System.in);
        int choice=0;
        while(choice!=5) {
        System.out.println("Enter the operation to be performed ");
        System.out.println("1. Input new Flight record ");
        System.out.println("2. Update existing Flight record ");
        System.out.println("3. Delete a flight record ");
        System.out.println("4. View all records ");
        System.out.println("5. Exit ");
        
        choice=input.nextInt();
        
        if(choice==1) {
        	Flight flight = new Flight("KT101", "DEL", "KOL","30-12-2013","0930","4",5000,"Y","E"); // can be taken as user input
        	System.out.println("Before Saving Flight Info : "+ flight);
        
        	// CREATE
        	long flightId = flightService.addFlight(flight);
        
        	// READ - Single Record
        	flight = flightService.getFlight(flightId);
        	System.out.println("After Saving Flight Info : "+flight);
        }
        
        // UPDATE the fare on the basis of dep loc, arr loc and date
        if(choice==2) {
        	System.out.println("Enter Departure Location ");
        	String dep=input.nextLine();
        	System.out.println("Enter Arrival Location ");
        	String arr=input.nextLine();
        	System.out.println("Enter travel date dd-mm-yyyy ");
        	String dot=input.nextLine();
        	
        	List<Flight> flights = flightService.listFlight();
        	for (Flight flight2 : flights) {
            if((flight2.getDepLoc()==dep)&&(flight2.getArrLoc()==arr)&&(flight2.getValidTill()==dot)) {
            	  
            	flight2.setFare(2800);  //Can be taken as user input
            	
            	flight2 = flightService.updateFlight(flight2);
            	System.out.println("After Updation Flight Info : "+flight2);
            }
        	}
        	}
        
        if(choice==3) {
        // DELETE record on the basis of arr loc.
           	System.out.println("Enter arrival location");
           	String arr=input.nextLine();
        	List<Flight> flights = flightService.listFlight();
        	for (Flight flight2 : flights) {
            if(flight2.getArrLoc()==arr) {
            	  
            	long flightId = flightService.addFlight(flight2);	
                flightService.deleteFlight(flightId);    	            
            }
        	}
        
        System.out.println("Deletion successful");
        }
        
        if(choice==4) {
            // READ - Multiple Records
            System.out.println("Displaying all Flight Info : ");
            List<Flight> flights = flightService.listFlight();
            for (Flight flight2 : flights) {
                System.out.println(flight2);
            }
            }
        else
        {
        	System.out.println("");
        }
        }
        input.close();
    }
}