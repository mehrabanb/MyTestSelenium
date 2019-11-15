import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils; 


public class ShoppingAddressRegister {

	public static void main(String[] args) throws InterruptedException, IOException {
		/*
		 * Question:Target Application URL : http://automationpractice.com/index.php
		 * Pre- requiste : Sign up into the application
		 */
		
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\bob\\OneDrive\\Selenium\\chromedriver_win32\\chromedriver.exe"); //selenium 
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize(); 
		
		//1.Login to application:
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("mehraban_b@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("Smile123");
		driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
	
	
		//2. Navigate to 'My Addresses' and add a new address
		driver.findElement(By.xpath("//span[.='My addresses']")).click();
		driver.findElement(By.xpath("//span[.='Add a new address']")).click();
		
		//3. Fill all the information(not only the mandatory)
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Mehraban");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Barimani");
		driver.findElement(By.id("company")).clear();
		driver.findElement(By.id("company")).sendKeys("Tarion");
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys("South Park rd.");
		driver.findElement(By.id("address2")).clear();
		driver.findElement(By.id("address2")).sendKeys("Commerce Valley dr.");
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("New York");
		
		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByValue("32"); 
		//s.deselectByVisibleText("New York");
		driver.findElement(By.id("postcode")).clear();
		driver.findElement(By.id("postcode")).sendKeys("10022");
		
		s = new Select(driver.findElement(By.id("id_country"))); 
		s.selectByValue("21");
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("4168755066");
		driver.findElement(By.id("phone_mobile")).clear();
		driver.findElement(By.id("phone_mobile")).sendKeys("4168755067");
		driver.findElement(By.id("other")).clear();
		driver.findElement(By.id("other")).sendKeys("NA");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("My Address1");
		
		//4. Click 'Save'
		driver.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		
		//5. Navigate to 'Women' --> Summer dresses
		Actions a = new Actions(driver); 
		a.moveToElement(driver.findElement(By.xpath("//a[.='Women']"))).perform();
		Thread.sleep(3000L); 
		a.moveToElement(driver.findElement(By.xpath("//a[.='Summer Dresses']"))).click().build().perform();
		//driver.findElement(By.xpath("//li[@class='sfHoverForce sfHover']//a[.='Summer Dresses']")).click();
		
		// 6. The Items would be in 'Grid view'. Change it to 'List View'.
		driver.findElement(By.className("icon-th-list")).click();
		
		//7. Click on the first item to view.
		driver.findElement(By.xpath("//li[contains(@class, 'first-in-line')]//span[.='More']")).click();
		
		//8. Increase the quantity to 5
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("5");
		
		//9. Change the size to 'L'
		Select sel = new Select(driver.findElement(By.className("attribute_select")));
		sel.selectByValue("3");
		
		//10.Select any colour. 
		driver.findElement(By.className("color_pick")).click();
		
		//11.Add to cart
		driver.findElement(By.xpath("//span[.='Add to cart']")).click();
		Thread.sleep(3000L); 
		
		//12.Click 'Continue shopping' and repeat the same for the other 2 items as well under the summer dresses.
		driver.findElement(By.xpath("//span[contains(.,'Continue shopping')]")).click();
		
		//going back to list of Summer dresses:
		a.moveToElement(driver.findElement(By.xpath("//a[.='Women']"))).perform();
		Thread.sleep(3000L); 
		a.moveToElement(driver.findElement(By.xpath("//a[.='Summer Dresses']"))).click().build().perform();
		
		//adding 2nd item to cart:
		driver.findElement(By.xpath("//li[contains(@class, 'last-in-line')]//span[.='More']")).click();
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("5");
		sel = new Select(driver.findElement(By.className("attribute_select")));
		sel.selectByValue("3");
		driver.findElement(By.className("color_pick")).click();
		driver.findElement(By.xpath("//span[.='Add to cart']")).click();
		Thread.sleep(3000L); 
		driver.findElement(By.xpath("//span[contains(.,'Continue shopping')]")).click();
		
		//going back to list of Summer dresses:
		a.moveToElement(driver.findElement(By.xpath("//a[.='Women']"))).perform();
		Thread.sleep(3000L); 
		a.moveToElement(driver.findElement(By.xpath("//a[.='Summer Dresses']"))).click().build().perform();
		
		
		//adding last item to cart:
		driver.findElement(By.xpath("//li[contains(@class, 'last-line')]//span[.='More']")).click();
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("5");
		sel = new Select(driver.findElement(By.className("attribute_select")));
		sel.selectByValue("3");
		driver.findElement(By.className("color_pick")).click();
		driver.findElement(By.xpath("//span[.='Add to cart']")).click();
		Thread.sleep(3000L); 
		driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]")).click();
				
		
		//13. Proceed to checkout and complete the payment
		a.moveToElement(driver.findElement(By.xpath("//b[.='Cart']"))).perform();
		Thread.sleep(1000L); 
		a.moveToElement(driver.findElement(By.xpath("//b[.='Cart']"))).click().build().perform();
		
		//procedd to checkout button: 
		driver.findElement(By.xpath("//span[.='Proceed to checkout']")).click();
		driver.findElement(By.xpath("//span[.='Proceed to checkout']")).click();
		
		//agree to terms:
		driver.findElement(By.xpath("//*[@type='checkbox']")).click();
		Thread.sleep(2000L); 
		a.moveToElement(driver.findElement(By.xpath("//*[@id='form']/p/button/span"))).perform();
		driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();
		
		//payment by bank wire: 
		driver.findElement(By.className("bankwire")).click();
		driver.findElement(By.xpath("//span[.='I confirm my order']")).click();
		
		//14. Move to your profile and check 'order history and details'
		driver.findElement(By.className("account")).click();
		
		driver.findElement(By.xpath("//span[.='Order history and details']")).click();
		
		//15. Capture a screenshot of the order history
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");    
		Thread.sleep(3000L); 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(src,new File("C://users//Bob//Pictures//Screenshot.png"));
		
		
		//16. Sign out from the application
		driver.findElement(By.className("logout")).click();
		
		//close Browser: 
		driver.quit();
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		
		
		
		
		
		
		

		

		

	}

}
