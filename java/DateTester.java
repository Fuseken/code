import java.util.*;
import java.util.Arrays;
import java.util.List;

public class DateTester {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,1999);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        String[] m = {"Jan","Feb","Mar","Apr"};
        String currm = "Mar";
        int currmon = Array.asList(m).indexOf(currm);
        c.set(Calendar.MONTH, currmon);
        System.out.println(c.get(Calendar.MONTH));
    }
}
