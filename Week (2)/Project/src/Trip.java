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

    public abstract int calculateDuration();
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
//        String arriveTime;
//        startTime = "12:15";
//        double hour = Integer.parseInt((startTime.substring(0,2)));
//        double minute = Integer.parseInt((startTime.substring(3,5)));
//        // after converting to double for calculation.
//        double hourToMinutes = hour * 60;
//        double totalTime = minute + hourToMinutes;
//        ==============================================================================

        // convert hour to minutes and add it to double minutes.
        // convert it back to String to display as normal hour;

        double arrivalTime = (distance / speed);
        String arrive = String.valueOf(arrivalTime);
        String timeInString = String.valueOf(arrive);
        String hours = timeInString.substring(0,1);
        String minutes = timeInString.substring(3,5);
//        return String.valueOf(arrivalTime);
        int mintToDouble = Integer.parseInt(minutes);
        mintToDouble%=60;
        String newMins = String.valueOf(mintToDouble);
        return hours + ":" + newMins;
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
