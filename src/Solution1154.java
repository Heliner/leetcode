import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution1154 {
    static class Solution {
        public int ordinalOfDate(String date){
            DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date dat = null;
            try {
                dat = fm.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //Date date2 = new Date(System.currentTimeMillis());
            String str = String.format("%tj", dat);//得到time日期是在这年的第几天
            System.out.println(Integer.valueOf(str));
            return Integer.valueOf(str);
        }
    }

    public static void main(String[] args) {
        try {
            String time = "2004-03-01";
            DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fm.parse(time);
            //Date date2 = new Date(System.currentTimeMillis());
            String str = String.format("%tj", date);//得到time日期是在这年的第几天
            System.out.println(Integer.valueOf(str));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}