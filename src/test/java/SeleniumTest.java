import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class SeleniumTest extends BaseTest{


    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    @Order(1)
    @Story("Beviteli mezők tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void TestInput() {
        BasicFormPage basicFormPage = new BasicFormPage(driver, wait);

        basicFormPage.navigate();
        basicFormPage.closePopup();
        basicFormPage.addNumbers(TestData.sum1, TestData.sum2);
        basicFormPage.clickGetTotalButton();

        Allure.addAttachment("Get total",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        String expected = TestData.expectedTotal;
        String actual = basicFormPage.getResult();

        Assertions.assertEquals(expected, actual);

    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: zhttps://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    @Order(2)
    @Story("Lenyíló lista tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void SelectDayTest() {
        DropDownListPage dropDownListPage = new DropDownListPage(driver, wait);

        dropDownListPage.navigate();
        dropDownListPage.selectLastValue();

        Allure.addAttachment("Selected day",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        String expected =TestData.selectedDayMessage;
        String actual = dropDownListPage.getResult();

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    @Order(3)
    @Story("Felugró ablak tesztelése")
    @Severity(SeverityLevel.NORMAL)
    public void AlertTest() throws InterruptedException {
        ModalPage modalPage = new ModalPage(driver, wait);

        modalPage.navigate();
        modalPage.clickLaunchButton();

        Allure.addAttachment("Check text",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        String expected = TestData.modalMessage;
        String actual = modalPage.getMessage();

        Assertions.assertEquals(expected, actual);

        modalPage.closeModal();
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    @Order(4)
    @Story("Névjegykártyák ellenőrzése")
    @Severity(SeverityLevel.CRITICAL)
    public void NamecardTest() {
        CardsPage cardsPage = new CardsPage(driver, wait);

        cardsPage.navigate();
        Allure.addAttachment("Name cards",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        String[] expected = TestData.names;
        String[] actual = cardsPage.names();

        Assertions.assertArrayEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    @Order(5)
    @Story("Táblázat neveinek ellenőrzése")
    @Severity(SeverityLevel.CRITICAL)
    public void TableTest() {
        TablePage tablePage = new TablePage(driver, wait);

        tablePage.navigate();

        Allure.addAttachment("Table",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        tablePage.createFile();
        tablePage.writeToFile();

        String[] expected = TestData.namesFromFile;
        String[] actual = tablePage.readFromFile();

        Assertions.assertArrayEquals(expected, actual);

    }

}
