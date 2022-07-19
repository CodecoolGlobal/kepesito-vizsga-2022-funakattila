import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownListPage extends BasePage{

    private final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    private final By lastElement = By.xpath("//*[@id=\"select-demo\"]/option[last()]");

    private final By selectedValue = By.className("selected-value");

    public DropDownListPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public void selectLastValue() {
        driver.findElement(lastElement).click();
    }

    public String getResult() {
        return driver.findElement(selectedValue).getText();
    }



}
