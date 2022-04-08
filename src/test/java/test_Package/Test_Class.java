package test_Package;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Class {

	public static void main(String[] args) {
		
		String actual_str="Order has been confirmed-ORD1234";
		//1-Two Frame
		//2-Two Diffe Window
		//3-Popup (Alert)
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver dr=new ChromeDriver();
		
		dr.navigate().to("https://.....");
		//Getting How may Frame in this Application.
		
		WebElement frame=dr.findElement(By.tagName("iframe"));
		dr.switchTo().frame(frame);
		dr.findElement(By.xpath("//*[@name='submit']")).click();
		
		dr.switchTo().defaultContent();
		WebElement another_frame_ele=dr.findElement(By.xpath("//*[@id='childeFrame']"));
		String expected = "Order has been confirmed-ORD1234";
		dr.switchTo().frame(another_frame_ele);
		
		if(expected.equalsIgnoreCase(actual_str)) {
			System.out.println("OIrder created successfully");
		}else {
			System.out.println("Order not created.");
		}
		
		dr.switchTo().defaultContent();
		dr.findElement(By.id("First_win")).click();
		
		
		Set<String> allWin= dr.getWindowHandles();
		
		Iterator<String> it=allWin.iterator();
		String PWind=it.next();
		String CWind=it.next();
		
		dr.switchTo().window(CWind);
		dr.findElement(By.xpath("//*[@id='PopupWindw']")).click();
		String popupMsg=dr.switchTo().alert().getText();
		String[] orderNumber=popupMsg.split("ORD");
		
		
		
		
		
		
		
		

	}

}
