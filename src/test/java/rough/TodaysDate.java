package rough;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodaysDate {
	
	public static void main(String[] args) throws ParseException {
		
		String str= "$236.31   $279.99 ";
		String[] currencies = str.split(" ");
		String pr=currencies[0].replace("$", " ").toString();
        System.out.println(pr);
	}

}
