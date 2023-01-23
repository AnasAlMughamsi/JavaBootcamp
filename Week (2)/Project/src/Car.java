public class Car extends Trip {

    public Car(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    @Override
    public double calculateDuration() {
        double arrivalTime = (getDistance() / getSpeed());
        return arrivalTime * 60; // in minutes
    }
}
