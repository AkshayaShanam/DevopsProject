import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StudentFormTest {
    public static void main(String[] args) throws InterruptedException {
        // Set path to your chromedriver
        System.setProperty("webdriver.chrome.driver","C:/Users/aksha/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open frontend (update port if needed, e.g., 3000 or file://)
        driver.get("http://localhost:5001");

        // 2. Fill form fields
        driver.findElement(By.id("studentId")).sendKeys("S12345");
        driver.findElement(By.id("name")).sendKeys("Test Student");
        driver.findElement(By.id("email")).sendKeys("test@example.com");

        Select courseDropdown = new Select(driver.findElement(By.id("course")));
        courseDropdown.selectByVisibleText("CSE");

        driver.findElement(By.id("mobile")).sendKeys("9876543210");

        Select genderDropdown = new Select(driver.findElement(By.id("gender")));
        genderDropdown.selectByVisibleText("Male");

        driver.findElement(By.id("dob")).sendKeys("2002-05-10");

        Select yearDropdown = new Select(driver.findElement(By.id("passoutYear")));
        yearDropdown.selectByVisibleText("2026");

        driver.findElement(By.id("address")).sendKeys("123 Main Street, City");

        // 3. Submit the form
        driver.findElement(By.tagName("button")).click();

        // 4. Handle alert message using WebDriverWait
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("✅ Alert Message: " + alertMsg);
        driver.switchTo().alert().accept(); // close alert


        // Close browser
        driver.quit();
    }

}
