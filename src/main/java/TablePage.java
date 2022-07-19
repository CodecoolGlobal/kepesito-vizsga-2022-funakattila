import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TablePage extends BasePage{

    private final String URL = "https://demo.seleniumeasy.com/table-data-download-demo.html";

    private final By names = By.xpath("//*[@id=\"example\"]//tr/td[1]");

    public TablePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    public void createFile() {
        try {
            File myObj = new File("names.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("names.txt");

            List<WebElement> listOfNames = driver.findElements(names);

            for (WebElement item:listOfNames) {
                String name = item.getText();
                myWriter.write(name + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int countNames() {
        return driver.findElements(names).size();
    }

    public String[] readFromFile() {
        String[] stringArray = new String[countNames()];
        ArrayList<String> names = new ArrayList<>();

        try {
            File myObj = new File("names.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                names.add(data);
                stringArray = names.toArray(new String[0]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return stringArray;

    }

}
