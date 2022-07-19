import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalPage extends BasePage{

    private final String URL = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";

    private final By launcModalButton = By.xpath("//*[@href=\"#myModal0\"]");

    private final By modal = By.id("myModal0");
    private final By modalMessage = By.xpath("//*[@id=\"myModal0\"]//div[@class=\"modal-body\"]");

    private final By closeModalButton = By.xpath("//*[@id=\"myModal0\"]//div[@class=\"modal-footer\"]/a[1]");

    public ModalPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public void clickLaunchButton() {
        driver.findElement(launcModalButton).click();
    }

    public String getMessage() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(modalMessage).getText();
    }

    public void closeModal() {
        driver.findElement(closeModalButton).click();
    }



}
