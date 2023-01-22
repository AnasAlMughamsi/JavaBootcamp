public class Car extends Trip {

    public Car(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    @Override
    public double calculateDuration() {
        double arrivalTime = (getDistance() / getSpeed());
        double newTime = arrivalTime * 60;
        int h = (int) newTime / 60;
        int m = (int) newTime % 60;
        return newTime;
    }
}
