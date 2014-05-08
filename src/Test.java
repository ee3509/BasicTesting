import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Panos on 24/03/14.
 */
public class Test {


    public static void main(String[] args) {
        System.out.println("Test");
        System.getProperties();

        if (System.getProperty("sun.java.command").contains("-d")) {
            System.out.println("Debug mode");
        }

      java.util.Date date= new java.util.Date();
      System.out.println(new Timestamp(date.getTime()).getTime());
      System.out.println(new SimpleDateFormat("d_M_kk.mm").format(new Date()));
    }

}
