public class Airplane extends Trip {
    public Airplane(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    @Override
    public double calculateDuration() {
        double arrivalTime = (getDistance() / getSpeed());
        return arrivalTime * 60;
    }
}
