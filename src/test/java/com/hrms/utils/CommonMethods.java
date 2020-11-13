package com.hrms.utils;
	
	import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	import com.hrms.testbase.PageInitializer;

	public class CommonMethods extends PageInitializer {
		
		/**
		 * Method that sends text to any given element
		 * @param element
		 * @param text
		 */
		public static void sendText(WebElement element, String text) {
			element.clear();
			element.sendKeys(text);
		}
		
		/**
		 * Method return object of JavaScript Executor type
		 * @return
		 */
		public static JavascriptExecutor getJSExecutor() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			return js;
		}
		
		/**
		 * Method performs clicking using JavaScript executor
		 * @param element
		 */
		
		public static void jsClick(WebElement element) {
			getJSExecutor().executeScript("arguments[0].click();", element);
		}
		
		/**
		 * Methods scrolls up using JavaScript Executor
		 * @param pixel
		 */
		public static void scrollUp(int pixel) {
			getJSExecutor().executeScript("window.scrollBy(0,-" + pixel + ")");
		}
		/**
		 * Methods scrolls down using JavaScript excutor
		 * @param pixel
		 */
		
		public static void scrollDown(int pixel) {
			getJSExecutor().executeScript("window.scrollBy(0." + pixel + ")");
		}
		
		public static WebDriverWait getWaitObject() {
			return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
			
		}
		
		public static void waitForClickability(WebElement element) {
			getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
		}
		public static void click(WebElement element) {
			waitForClickability(element);
			element.click();
		}
		
		/**
		 * Method that will take a screenshot and store with name in specified location with .png extension
		 * @param fileName
		 */
		public static byte[] takeScreenShot(String fileName) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src,new File(Constants.SCREENSHOT_FILEPATH + fileName+ getTimeStamp()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return bytes;
		}
		/**
		 * This method will generate timeStamp
		 * @return
		 */
		public static String getTimeStamp() {
			
			Date date=new Date();
	
			//	This is the structure of Java	---> ("yyyy-MM-dd-HH:mm:ss")
			//										 ("yyyy-MM-dd-HH_mm_ss")
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss-MM-dd-yyyy");
			return sdf.format(date);
		}
		/**
		 * This method will click on checkbox or radio button by the given list of webelements and the value
		 * @param radioOrCheckBoxs
		 * @param value
		 */
		public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxs, String value) {
			String acualValue;
			for (WebElement radioOrCheckBox : radioOrCheckBoxs) {
				acualValue = radioOrCheckBox.getAttribute("value").trim();
				if(radioOrCheckBox.isEnabled() && acualValue.equals(value)) {
					jsClick(radioOrCheckBox);
					break;
				}
			}
		}
		/**
		 * This method will select an option from the dropdown by the given webelements or visible text value
		 * @param dd
		 * @param visibleTextOrValue
		 */
		public static void selectDDValue(WebElement dd, String visibleTextOrValue) {
			Select select = new Select(dd);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if(option.getText().equals(visibleTextOrValue)) {
					select.selectByVisibleText(visibleTextOrValue);
					break;
					
				}
			}
		}
		
		
		/**
		 * This method will select an option from the dropdown by the given webelements or visible text value
		 * @param dd
		 * @param index
		 */
		public static void selectDDValue(WebElement dd, int index) {
			Select select = new Select(dd);
			List<WebElement> options = select.getOptions();
			
			int size = options.size();
		
			if(size > index) {
				select.selectByIndex(index);
			
			}
		}
		
		/**
		 * This method will switch to a frame by the given frame webelement
		 * @param iFrame
		 */
		public static void switchToFrame(WebElement iFrame) {
			try {
				
			driver.switchTo().frame(iFrame);
		}	catch(NoSuchFrameException e) {
			e.printStackTrace();
			
		}
	}
		
		
		
		/**
		 * This method will switch to a frame by the given frame frameIndex
		 * @param frameIndex
		 */
		public static void switchToFrame(int frameIndex) {
			try {
				
			driver.switchTo().frame(frameIndex);
		}	catch(NoSuchFrameException e) {
			e.printStackTrace();
			
		}
	}
		
		
		/**
		 * This method will switch to a frame by the given frame nameOrId
		 * @param nameOrId
		 */
		public static void switchToFrame(String nameOrId) {
			try {
				
			driver.switchTo().frame(nameOrId);
		}	catch(NoSuchFrameException e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * This method switch to child window
	 */
		
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
			
		}
	}
	
	
	/** reading json files and converted to string */
	static String jsonFile;
	public static String readJson(String fileName) {
		try {
			jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	