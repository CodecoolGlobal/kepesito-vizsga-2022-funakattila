import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CardsPage extends BasePage{

    private final String URL = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    private final By nameFileds = By.xpath("//*[@class=\"searchable-container\"]//h4");


    public CardsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public String[] names() {
        List<WebElement> names = driver.findElements(nameFileds);
        int lengthOfList = names.size();
        String[] result = new String[lengthOfList];

        for (int i = 0; i < lengthOfList; i++) {
            String cleanName = names.get(i).getText().replace("Name: ", "");
            result[i] = cleanName;
        }

        return result;
    }


}
