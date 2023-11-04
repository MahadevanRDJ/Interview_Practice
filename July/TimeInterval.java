package July;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class TimeInterval {
    private LocalDateTime  userDateTime;
    private LocalDateTime currentTime = LocalDateTime.now();
    private static ZoneId zoneId = ZoneId.systemDefault();
    public static void main(String[] args) {
        TimeInterval timeInterval = new TimeInterval();
        
        System.out.println("Current Date and Time: " + timeInterval.currentTime.atZone(zoneId).toEpochSecond());
        timeInterval.getUserTime();
        long timeDifferEnce = timeInterval.userDateTime.atZone(zoneId).toEpochSecond() - (timeInterval.currentTime.atZone(zoneId).toEpochSecond());
        userFriendlyDate(timeDifferEnce);
        System.out.println();
    }

    private static void userFriendlyDate(long timeDifferEnce) {
        int differnce = (int)timeDifferEnce;
        if(differnce < 0) {
            System.out.println("Time must be greater than current time");
            return;
        }
        System.out.println("Time Interval is : ");
        if(differnce < 60 ) System.out.println(differnce + " seconds ago");
        if(differnce > 60 && differnce < 3600 ) System.out.println(differnce/60 + " minutes ago");
        if(differnce > 3600 && differnce < 86400 ) System.out.println(differnce/3600 + " hours ago");
        if(differnce > 86400 && differnce < 604800 ) System.out.println(differnce/86400 + " days ago");
        if(differnce > 604800 && differnce < 2628288 ) System.out.println(differnce/604800 + " weeks ago");
        else System.out.println(differnce/2628288 + " months ago");
    }



    private void getUserTime() {
        int date, month, year, hour, minute;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Date"); date = scanner.nextInt();
        System.out.println("Month"); month = scanner.nextInt();
        System.out.println("Year"); year = scanner.nextInt();
        System.out.println("Hour"); hour = scanner.nextInt();
        System.out.println("Minute"); minute = scanner.nextInt();

        userDateTime = LocalDateTime.of(year, month, date, hour, minute, 0);

        scanner.close();
    }

}
