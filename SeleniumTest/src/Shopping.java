import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Shopping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
		Thread.sleep(5000L); 
		a.moveToElement(driver.findElement(By.xpath("//a[.='Summer Dresses']"))).click().build().perform();
		//driver.findElement(By.xpath("//li[@class='sfHoverForce sfHover']//a[.='Summer Dresses']")).click();
		
		// 6. The Items would be in 'Grid view'. Change it to 'List View'.

		
		
		
		
		
		
		


		
		
		
		
		
		
		

		

		

	}

}
