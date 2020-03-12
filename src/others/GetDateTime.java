package others;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class GetDateTime
{
    public static String main( String[] args )
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        
        return dateFormat.format(date);
    }
}
