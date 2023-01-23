import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {

        Car car = new Car("road", 620,120, "14:00");
        Car train = new Car("35B", 620,350, "14:00");
        Car airPlane = new Car("60B", 620,700, "14:00");

        System.out.println("=================== Car ===================");
        System.out.println("Start time: " + car.getStartTime());
        System.out.println("Speed : " + car.getSpeed());
        System.out.println("duration in minutes: " + car.calculateDuration());
        System.out.print("Duration time: ");
        System.out.printf("%.2f",  airPlane.convertMinToHour(car.calculateDuration()));
        System.out.println(" hour");
        System.out.println("Arrive time: " + car.calculateArrivalTime());

        System.out.println("=================== Train ===================");
        System.out.println("Start time: " + train.getStartTime());
        System.out.println("Speed : " + train.getSpeed());
        System.out.println("duration in minutes: " + train.calculateDuration());
        System.out.print("Duration time: ");
        System.out.printf("%.2f",  airPlane.convertMinToHour(train.calculateDuration()));
        System.out.println(" hour");
        System.out.println("Arrive time: " + train.calculateArrivalTime());

        System.out.println("=================== Airplane ===================");
        System.out.println("Start time: " + airPlane.getStartTime());
        System.out.println("Speed : " + airPlane.getSpeed());
        System.out.println("duration in minutes: " + airPlane.calculateDuration());
        System.out.print("Duration time: ");
        System.out.printf("%.2f",  airPlane.convertMinToHour(airPlane.calculateDuration()));
        System.out.println(" hour");
        System.out.println("Arrive time: " + airPlane.calculateArrivalTime());



        // =======================  convert String of time to double - TESTING ======================= //
        String arriveTime;
        arriveTime = "12:15";
        double hour = Integer.parseInt((arriveTime.substring(0,2)));
        double minute = Integer.parseInt((arriveTime.substring(3,5)));
        double hourToMinutes = hour * 60;
        double totalTime = minute + hourToMinutes;
        double time = 24.167;
        String timeInString = String.valueOf(time);
        String hours = timeInString.substring(0,2);
        String minutes = timeInString.substring(3,5);
        double mintToDouble = Double.parseDouble(minutes);
        double newTine = time * 60;
        int h = (int) newTine / 60;
        int m = (int) newTine % 60;

    }
}