package scenerio_based;

import java.util.ArrayList;
import java.util.List;

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}
interface FareCalculator {
    double calculateFare(double distance);
}

class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
class User {
    int userId;
    String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Driver {
    int driverId;
    String name;
    boolean available;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }
}

class Ride {
    User user;
    Driver driver;
    double distance;
    double fare;
    String status;

    public Ride(User user, double distance) {
        this.user = user;
        this.distance = distance;
        this.status = "BOOKED";
    }
}
class RideService {

    List<Driver> drivers = new ArrayList<>();
    List<Ride> rideHistory = new ArrayList<>();

    public RideService() {
        drivers.add(new Driver(1, "Ramesh"));
        drivers.add(new Driver(2, "Suresh"));
    }

    public Driver assignDriver() throws NoDriverAvailableException {
        for (Driver driver : drivers) {
            if (driver.available) {
                driver.available = false;
                return driver;
            }
        }
        throw new NoDriverAvailableException("No driver available at the moment!");
    }

    public Ride bookRide(User user, double distance, FareCalculator calculator)
            throws NoDriverAvailableException {

        Ride ride = new Ride(user, distance);
        Driver driver = assignDriver();

        ride.driver = driver;
        ride.fare = calculator.calculateFare(distance);
        ride.status = "COMPLETED";

        rideHistory.add(ride);
        driver.available = true;

        return ride;
    }

    public void showRideHistory() {
        System.out.println("Ride History");
        for (Ride ride : rideHistory) {
            System.out.println(
                "User: " + ride.user.name +
                ", Driver: " + ride.driver.name +
                ", Distance: " + ride.distance + " km" +
                ", Fare: ₹" + ride.fare +
                ", Status: " + ride.status
            );
        }
    }
}
public class CarBooking {

    public static void main(String[] args) {

        RideService rideService = new RideService();

        User user1 = new User(101, "Amit");
        User user2 = new User(102, "Rahul");

        try {
            FareCalculator normalFare = new NormalFareCalculator();
            FareCalculator peakFare = new PeakFareCalculator();

            Ride ride1 = rideService.bookRide(user1, 12, normalFare);
            System.out.println("Ride booked! Fare " + ride1.fare);

            Ride ride2 = rideService.bookRide(user2, 8, peakFare);
            System.out.println("Ride booked! Fare " + ride2.fare);

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        rideService.showRideHistory();
    }
}

