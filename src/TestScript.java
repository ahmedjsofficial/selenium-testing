import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class TestScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jsdev\\Downloads\\Programs\\chromedriver.exe");
        ChromeOptions handlingSSL = new ChromeOptions();
        //Using accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(handlingSSL);
        driver.get("https://instagram-jsstack.vercel.app/"); // the link will redirected to the browser
        driver.manage().window().maximize(); // the browser windows will be maximized

        driver.findElement(By.name("email")).sendKeys("jsstack@gmail.com"); // entering the email
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // waiting 30 seconds
        driver.findElement(By.name("password")).sendKeys("123456789"); // entering the passwords
        driver.findElement(By.linkText("LOG IN")).click(); // This will Click button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // waiting after login 30 seconds
        driver.findElement(By.id("add_a_post")).click(); // this action will click on plus button to add posts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // waiting after login 30 seconds
        driver.findElement(By.id("logout")).click(); // this action will click on log out button

        String at = driver.getTitle();
        String et = "Instagram || JSSTACK";
        driver.quit();
        if(at.equalsIgnoreCase(et)) {
            System.out.println("Test Successful");
        } else {
            System.out.println("Test Failure");
        }
    }
}