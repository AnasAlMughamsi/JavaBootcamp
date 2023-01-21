import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("B39", 620,120, "14:00");
//        car.calculateDuration();
//        car.convertMinToHour();
//        car.calculateArrivalTime(); // here should return hour with string "03:15"
        System.out.println(car.calculateArrivalTime());
        System.out.println("=================== Car ===================");
        String arrive = car.calculateArrivalTime();
        System.out.println(arrive);
        System.out.println(car.convertMinToHour(120));
        // show start time
        System.out.println("Start time: " + car.getStartTime());
        System.out.println("Arrive time: " + arrive);
        // show arrive time
        System.out.println("=================== End ===================");


        // convert String of time to double
        String arriveTime;
        arriveTime = "12:15";
        double hour = Integer.parseInt((arriveTime.substring(0,2)));
        double minute = Integer.parseInt((arriveTime.substring(3,5)));
        double hourToMinutes = hour * 60;
        double totalTime = minute + hourToMinutes;

        double time = 24.167;
        System.out.println(Math.round(time));
        String timeInString = String.valueOf(time);
        String hours = timeInString.substring(0,2);
        String minutes = timeInString.substring(3,5);
        double mintToDouble = Double.parseDouble(minutes);
        System.out.println(mintToDouble);
        System.out.println("Hour > " + hours);
        System.out.println("Minutes > " + minutes);

        System.out.println(hours + ":" + minutes);

    }
}