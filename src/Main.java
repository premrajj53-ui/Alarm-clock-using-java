import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:MM:SS");
        LocalTime alarmTime = null;
        while (alarmTime==null){
            try {
                System.out.print("Enter an alarm time (HH:MM:SS) :");
                String imputTime =  sc.nextLine();

                alarmTime = LocalTime.parse(imputTime,format);
                System.out.println("Alarm set for " + alarmTime);
            }
            catch (DateTimeException e){
                System.out.println("Invalid format! USE HH:MM:SS");

            }
        }

    }
}
