import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\bob\\OneDrive\\Selenium\\chromedriver_win32\\chromedriver.exe"); //selenium 
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize(); 
	}

}
