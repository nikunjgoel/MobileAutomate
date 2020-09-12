package helper;

import java.time.Duration;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestBase {

	protected AndroidDriver<WebElement> driver;
	protected ExtentTest test;

	public TestBase(AndroidDriver<WebElement> driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void sendKeys(WebElement ele, int waitInSec, String text, boolean isWaitReq) {
		if (isWaitReq)
			webdriverWaitVisibilityOf(ele, waitInSec);
		enterText(ele, text);

	}

	private void webdriverWaitUntilText(WebElement ele, int waitInSec) {
		try {
			new WebDriverWait(driver, waitInSec).until(
					(ExpectedCondition<Boolean>) driver -> (ele.getText().length() != 0) && (ele.getText() != null));
		} catch (Throwable e) {
		}
	}

	private void webdriverWaitClickable(WebElement ele, int waitInSec) {
		new WebDriverWait(driver, waitInSec).until(ExpectedConditions.elementToBeClickable(ele));
	}

	private void webdriverWaitTextToBePresent(WebElement ele, int waitInSec, String text) {
		new WebDriverWait(driver, waitInSec).until(ExpectedConditions.textToBePresentInElementValue(ele, text));
	}

	public void sendKeys(WebElement ele, String text) {
		webdriverWaitVisibilityOf(ele, Config.webdriverWait);
		enterText(ele, text);

	}

	public String getText(WebElement ele) {
		webdriverWaitVisibilityOf(ele, Config.webdriverWait);
		return getText(ele);
	}

	private void enterText(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	protected boolean isElementDisplayed(WebElement ele) {

		return ele.isDisplayed();
	}

	public void clickElement(WebElement ele) {
		ele.click();
	}

	public void ClickAction(AndroidElement ele) {
		ele.submit();
	}

	public void webDriverWaitAndClick(WebElement ele) {

		webdriverWaitClickable(ele, Config.webdriverWait);
		clickElement(ele);
	}

	private void webdriverWaitVisibilityOf(WebElement ele, int waitInSec) {
		new WebDriverWait(driver, waitInSec).until(ExpectedConditions.visibilityOf(ele));
	}

	public void webDriverWaitAndClick(WebElement ele, int waitInSec) {

		webdriverWaitClickable(ele, waitInSec);
		clickElement(ele);
	}

	public void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

	public void scrollVisibleText(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}

	public void swipe(int fromX, int fromY, int toX, int toY) {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(fromX, fromY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))) 
				.moveTo(PointOption.point(toX, toY)).release().perform();
	}

	public void swipeUp(int pixelsToSwipe, WebElement el) {

		try {
			Point value = null;
			value = el.getLocation();
			int x = value.x;
			int y = value.y;
			int y1 = value.y + pixelsToSwipe;
			swipe(x, y, x, y1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void swipeDown(int pixelsToSwipe, WebElement el) {

		try {
			Point value = null;
			value = el.getLocation();
			int x = value.x;
			int y = value.y;
			int y1 = value.y + pixelsToSwipe;
			swipe(x, y1, x, y);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void rotateDeviceScreenToLandscape() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}

	public void rotateDeviceScreenToPotrait() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
}
