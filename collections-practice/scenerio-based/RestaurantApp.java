package scenerio_based;

import java.util.*;

class TableAlreadyReservedException extends Exception {
 public TableAlreadyReservedException(String message) {
     super(message);
 }
}

class Table {
 int tableNumber;
 int capacity;

 public Table(int tableNumber, int capacity) {
     this.tableNumber = tableNumber;
     this.capacity = capacity;
 }
}

class Reservation {
 int tableNumber;
 String timeSlot;

 public Reservation(int tableNumber, String timeSlot) {
     this.tableNumber = tableNumber;
     this.timeSlot = timeSlot;
 }
}

class Restaurant {

 Map<Integer, Table> tables = new HashMap<>();
 List<Reservation> reservations = new ArrayList<>();

 public void addTable(int tableNumber, int capacity) {
     tables.put(tableNumber, new Table(tableNumber, capacity));
 }
 public void reserveTable(int tableNumber, String timeSlot)
         throws TableAlreadyReservedException {

     for (Reservation r : reservations) {
         if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
             throw new TableAlreadyReservedException(
                     "Table " + tableNumber + " already reserved for " + timeSlot);
         }
     }

     reservations.add(new Reservation(tableNumber, timeSlot));
     System.out.println("Table " + tableNumber + " reserved for " + timeSlot);
 }

 public void cancelReservation(int tableNumber, String timeSlot) {
     reservations.removeIf(r ->
             r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot));
     System.out.println("Reservation cancelled");
 }

 public void showAvailableTables(String timeSlot) {
     System.out.println("Available tables for " + timeSlot + ":");

     for (Table table : tables.values()) {
         boolean reserved = false;

         for (Reservation r : reservations) {
             if (r.tableNumber == table.tableNumber &&
                 r.timeSlot.equals(timeSlot)) {
                 reserved = true;
                 break;
             }
         }

         if (!reserved) {
             System.out.println("Table " + table.tableNumber);
         }
     }
 }
}

public class RestaurantApp {
 public static void main(String[] args) {
     Restaurant restaurant = new Restaurant();

     restaurant.addTable(1, 4);
     restaurant.addTable(2, 6);

     try {
         restaurant.reserveTable(1, "7PM-9PM");
         restaurant.reserveTable(1, "7PM-9PM"); 
     } catch (TableAlreadyReservedException e) {
         System.out.println(e.getMessage());
     }

     restaurant.showAvailableTables("7PM-9PM");
 }
}

