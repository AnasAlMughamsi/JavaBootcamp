import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {

        Car car = new Car("road", 620,120, "14:00");
//        car.calculateDuration();
//        car.convertMinToHour();
//        car.calculateArrivalTime(); // here should return hour with string "03:15"
        System.out.println("=================== Car ===================");
        // show start time
        double duration = car.calculateDuration();
        System.out.println("Start time: " + car.getStartTime());
        System.out.println("Arrive time: " + car.calculateDuration());
        System.out.println("Duration: " + car.convertMinToHour(duration));
        System.out.println("Arrive time: " + car.calculateArrivalTime());
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

        double newTine = time * 60;
        int h = (int) newTine / 60;
        int m = (int) newTine % 60;
        System.out.println("time :: >> " + h + ":" + m);
        System.out.println(hours + ":" + minutes);

    }
}