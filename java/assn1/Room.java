/*
   CS2911 Assn1, Room Booking Scenario
   3423267, Chad Luo
   */

import java.util.*;

public class Room {

    /**
     * Constructs a room object of capacity and name.
     * @param aCapacity capacity of the rooom.
     * @param aName name of the room.
     */
    public Room(int aCapacity, String aName) {
        capacity = aCapacity;
        name = aName;
        reserveList = new ArrayList<Reservation>();
    }

    /**
     * check if room has available slots for the reservation.
     * @param newReserve to be checked
     */
    public boolean hasSlots(Reservation newReserve) {
        boolean result = true;
        if(newReserve.getWeekList() != null){
            for(WeekReservation unBooked : newReserve.getWeekList()){
                for(Reservation reserves : reserveList ){
                    for(WeekReservation existed : reserves.getWeekList()){
                        if(!(unBooked.getEnd().before(existed.getStart())
                        		&& unBooked.getStart().after(existed.getEnd())) ) {
                            result = false;
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * check if room meeets capacity requirement.
     * @param require the required capacity
     */
    public boolean hasCapacity(int require) {
        return require <= capacity;
    }

    /**
     * put reservation into records.
     * @param reserve inserted after passing checks
     */
    public void append(Reservation reserve) {
        reserveList.add(reserve);
    }

    /**
     * delete reservation from records.
     * @param reserve deleted from records
     */
    public void delete(Reservation reserve) {
        reserveList.remove(reserve);
    }

    /**
     * print reservation information.
     */
    public void print() {
        System.out.println(name);
        for(Reservation reserve : reserveList ) {
        	for( WeekReservation wkrsrv : reserve.getWeekList() ) {
				System.out.print(reserve.getUser());
				System.out.print(" " + wkrsrv.getStart().MONTH);
				System.out.print(" " + wkrsrv.getStart().DAY_OF_MONTH);
				System.out.print(" " + reserve.getCapacity());
				System.out.print(" " + reserve.getDuration());
				System.out.println(" " + reserve.getTitle());
			}
        }
        
    }
    
    public int getCapacity(){
    	return capacity;
    }
    public String getName(){
    	return name;
    }
    public ArrayList<Reservation> getReserveList(){
    	return reserveList;
    }

    private int capacity;
    private String name;
    private ArrayList<Reservation> reserveList;

}
