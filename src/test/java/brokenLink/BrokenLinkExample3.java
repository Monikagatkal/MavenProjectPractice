package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkExample3 {
	WebDriver driver;
	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\drivers_New\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        driver.get("http://www.deadlinkcity.com/");
        
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        System.out.println(links.size());
        
        for(int i=0;i<links.size();i++)
        {
        	WebElement ele = links.get(i);
        	String url = ele.getAttribute("href");
        	
        	URL link = new URL(url);
        	
        	HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
        	
        	httpConn.connect();
        	int resCode = httpConn.getResponseCode();
        	
        	if(resCode >= 400)
        	{
        		System.out.println(url + " --is Broken Link");
        	}
        	else
        	{
        		System.out.println(url + " --is Valid Link");
        	}
        }
        
	}
}
