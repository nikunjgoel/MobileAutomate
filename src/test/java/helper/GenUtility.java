package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.AndroidDriver;

public class GenUtility {

	public static int totalRows;

	public static String getDayWithSeconds() {

		DateFormat dateformat = new SimpleDateFormat("MMM_dd_yyyy_hh_mm_ss");

		Calendar cal = Calendar.getInstance();
		String curdate = dateformat.format(cal.getTime());
		return curdate;
	}

	public String currentdate() {

		DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

		Date today = new Date();

		System.out.println(formatter.format(today));
		String date = formatter.format(today);
		return date;
	}

	public static String takeScreenshot(AndroidDriver<WebElement> driver) {

		String Path = System.getProperty("user.dir") + "\\screenshots\\" + "_" + getDayWithSeconds() + ".jpeg";
		
		File srcFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(Path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Path;
	}

	public static String getRandomAlphaNumString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 11) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static String getRandomStringSixAlphaSixNum() {
		String newStr = "ED";
		String str = "" + System.currentTimeMillis() / 1000L;
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] ch = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			ch[i] = str.charAt(i);

		for (int i = 0; i < ch.length; i++) {
			int z = Integer.parseInt(String.valueOf(ch[i]));
			if (i < 4) {
				char s = SALTCHARS.charAt(z);
				newStr += s;
			} else
				newStr += ch[i];
		}
		return newStr;

	}

	public static String convertStringintoDecimaluptoTwoChars(String s) {

		double d = Double.parseDouble(s);
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(d);

	}

	public static double convertStringintoDecimal(String s) {
		return Double.parseDouble(s);

	}
}
