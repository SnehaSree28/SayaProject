package common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import static java.time.LocalDate.*;

public class CommonMethods
{
    public static char randomChar(){
        Random random = new Random();
        char c= (char )random.nextInt(10 +'a');
        System.out.println("Randomchar:" +c);
        return c ;
    }
    public static  String getCurrentTimeStamp(){
        SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyHHmmss");
        Date now = new Date();
       String strDate= sdf.format(now.getTime());
        System.out.println(strDate);
        return  strDate;
    }
    public  static String getTodaysDate(){
        String date ="" +LocalDate.now();
       return date;

    }
    public static String getFutureDates(long days){
        String futureDate= ""+LocalDate.now().plusDays(days);
        return futureDate;
    }

}
