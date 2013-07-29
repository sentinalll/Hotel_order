/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Roman
 */
public class Summary {
     public static String getSummary(String price, String datefrom, String dateto) {
        String result = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = df.parse(datefrom);
            date2 = df.parse(dateto);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        Calendar cal1 = null;
        Calendar cal2 = null;
        cal1 = Calendar.getInstance();
        cal2 = Calendar.getInstance();
        // different date might have different offset
        cal1.setTime(date1);
        long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET);
        cal2.setTime(date2);
        long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET);

        // Use integer calculation, truncate the decimals
        int hr1 = (int) (ldate1 / 3600000); //60*60*1000
        int hr2 = (int) (ldate2 / 3600000);

        int days1 = (int) hr1 / 24;
        int days2 = (int) hr2 / 24;
        int dateDiff = days2 - days1;
        int pr = Integer.parseInt(price);
        result = String.valueOf(pr * dateDiff);
        return result;
    }
}
