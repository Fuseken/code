/**
 * CS2911 Assn1, Room Booking Scenario
 * 3423267, Chad Luo
 */

import java.util.*;
import java.io.*;

public class RoomBookingSystem {
    public static void main(String[] args) {
    	
    	 Scanner input = null;
    	 String cmd;
        ArrayList<Room> roomList = new ArrayList<Room>();
        try {
			input = new Scanner(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        // main loop
        while( input.hasNext() ) {
            cmd = input.next();
            if( cmd.equals("#") ) cmd = input.nextLine(); // skip comment
            if( cmd.equals("Room") ) {

                int capacity = input.nextInt();
                String name = input.next();
                Room newRoom = new Room(capacity,name);
                roomList.add(newRoom);
                System.out.println("Room " + name + " assigned");

            } else if ( cmd.equals("Book") )  {

                String  user = input.next();
                int capacity = input.nextInt();
                int numweeks = input.nextInt();
                String month = input.next();
                int     date = input.nextInt();
                int     time = input.nextInt();
                int duration = input.nextInt();
                String title = input.next();

                Reservation newReservation = new Reservation(user,title,capacity,
                    numweeks,month,date,time,duration);

                for(Room room : roomList){
                    if(room.hasCapacity(capacity) && room.hasSlots(newReservation)){
                        room.append(newReservation);
                        break;
                    }
                }

            } else if ( cmd.equals("Change") ) {

                String   user = input.next();
                String   room = input.next();
                int  numweeks = input.nextInt();
                String month1 = input.next();
                int     date1 = input.nextInt();
                int     time1 = input.nextInt();
                int  capacity = input.nextInt();
                String month2 = input.next();
                int     date2 = input.nextInt();
                int     time2 = input.nextInt();
                int duration2 = input.nextInt();
                String  title = input.next();

                Reservation newBook = new Reservation(user,title,capacity,
                    numweeks,month2,date2,time2,duration2);

                for(Room currRoom : roomList){
                    for(Reservation existedReserve : currRoom.getReserveList()){
                        if(user.equals(existedReserve.getUser())
                        		&& month1.equals(existedReserve.getMonth())
                        		&& date1 == existedReserve.getDate()
                        		&& time1 == existedReserve.getHour()){
                            currRoom.delete(existedReserve);
                            break;
                        }
                    }
                }

                for(Room room1 : roomList){
                    if(room1.hasCapacity(capacity) && room1.hasSlots(newBook)){
                        room1.append(newBook);
                        break;
                    }
                }
                
            } else if ( cmd.equals("Delete") ) {

                String  user = input.next();
                String roomname = input.next();
                int numweeks = input.nextInt();
                String month = input.next();
                int     date = input.nextInt();
                int     time = input.nextInt();
                String title = "";
                int capacity = 0;
                int duration = 0;

                Reservation newReserv = new Reservation(user,title,capacity,
                    numweeks,month,date,time,duration);

                for(Room existed : roomList){
                    for(Reservation existedReserv : existed.getReserveList()){
                        if(newReserv.getUser().equals(existedReserv.getUser())
                        		&& newReserv.getMonth().equals(existedReserv.getMonth())
                        		&& newReserv.getDate() == existedReserv.getDate()){
                            existed.delete(existedReserv);
                            System.out.println("Reservations deleted");
                            break;
                        }
                    }
                }

            } else if ( cmd.equals("Print") ) {

                String roomName = input.next();
                for(Room room : roomList) {
                    if(room.getName().equals(roomName)){
                        room.print();
                    }
                }

            }
        }
    }
}
