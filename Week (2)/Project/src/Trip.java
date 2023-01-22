import java.text.SimpleDateFormat;

public abstract class Trip {
    private String tripNumber;
    private double distance;
    private double speed;
    private String startTime;

    public Trip(String tripNumber, double distance, double speed, String startTime) {
        this.tripNumber = tripNumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
    }

    public abstract double calculateDuration();
    public double convertMinToHour(double min) {
        return min/60;
    }

    public String calculateArrivalTime() {

        /*
            take startTime & speed from user input.
            convert it to int/double
            use speed triangle ==> speed = distance / time
            I have the speed and start time
            so... [arriveTime = distance / speed]
        */

        // you only need here is the distance and the speed
//        ==============================================================================
        double hour = Integer.parseInt((startTime.substring(0,2)));
        double minute = Integer.parseInt((startTime.substring(3,5)));
        // after converting to double for calculation.
        double hourToMinutes = hour * 60;
        double startTimeMinutes = minute + hourToMinutes;
//        ==============================================================================
        // convert hour to minutes and add it to double minutes.
        // convert it back to String to display as normal hour;
        double arrivalTime = (distance / speed);
        double timeDifferance = startTimeMinutes + calculateDuration();

//        double newTine = arrivalTime * 60;
        int h = (int) timeDifferance / 60;
        int m = (int) timeDifferance % 60;
//      arrive time = startTime - arrivalTime
//        double
//        take double of startTime and double of arrivalTime
//        then take the differance.

        return h + ":" + m;
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
