package pageObjects.pages;

import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExplicitWaiting;

import java.util.HashMap;

public class tablePage extends PageFactoryInitializer {
    final static Logger logger = Logger.getLogger(tablePage.class);
    protected WebElement languageSelector;
    protected WebElement floatingMenu;
    protected WebElement tableRow;
    protected WebElement tableRowElement;
    protected static HashMap<String, Integer> columnNameToIndexMap;
    public tablePage(){
        getWebDriver().navigate().to("http://www.w3schools.com/html/html_tables.asp");
        columnNameToIndexMap.put("Company",1);
        columnNameToIndexMap.put("Contact",2);
        columnNameToIndexMap.put("Country",3);
        //tableRow = getWebDriver().findElement(By.id("//table/tbody/tr[2]"));
        //tableRowElement = getWebDriver().findElement(By.id("//table/tbody/tr[text()=]"));
    }

    public boolean getTableCellText(WebElement table,
                                   String searchColumn, String searchText, int returnColumnText) {
        tableRowElement = getWebDriver().findElement(By.xpath("//table/tbody/tr["+columnNameToIndexMap.get(searchColumn)+"]"));

        return true;
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText,
                                       int returnColumnText, String expectedText) {
        return true;
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText,
                                          int returnColumnText) throws Exception {

          return "";
    }
}