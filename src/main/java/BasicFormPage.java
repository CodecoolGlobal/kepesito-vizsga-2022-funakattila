import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicFormPage extends BasePage{

    private final String URL = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
    private final By closePopupButton = By.id("at-cv-lightbox-close");

    private final By numberA = By.id("sum1");

    private final By numberB = By.id("sum2");

    private final By getTotalButton = By.xpath("//*[@id=\"gettotal\"]/button");

    private final By result = By.id("displayvalue");



    public BasicFormPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public void closePopup() {
        driver.findElement(closePopupButton).click();
    }

    public void addNumbers(String a, String b) {
        driver.findElement(numberA).sendKeys(a);
        driver.findElement(numberB).sendKeys(b);
    }

    public void clickGetTotalButton() {
        driver.findElement(getTotalButton).click();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }


}
