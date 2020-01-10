package pageObjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;

import java.util.HashMap;

public class TablePage extends PageFactoryInitializer {
    final static Logger logger = Logger.getLogger(TablePage.class);
    protected WebElement languageSelector;
    protected WebElement floatingMenu;
    protected WebElement tableRow;
    protected WebElement tableRowElement;
    protected static HashMap<String, String> columnNameToIndexMap;
    public TablePage(){
        getWebDriver().navigate().to("http://www.w3schools.com/html/html_tables.asp");
        columnNameToIndexMap=new HashMap<String, String>();
        columnNameToIndexMap.put("Company","1");
        columnNameToIndexMap.put("Contact","2");
        columnNameToIndexMap.put("Country","3");
        //tableRow = getWebDriver().findElement(By.id("//table/tbody/tr[2]"));
        //tableRowElement = getWebDriver().findElement(By.id("//table/tbody/tr[text()=]"));
    }
    //xpath("//tbody/tr[text()='"+columnNameToIndexMap.get(searchColumn)+"']"));
    public boolean verifyTableCellText(WebElement table,
                                       String searchColumn,
                                       String searchText,
                                       String returnColumnText,
                                       String expectedText) throws Exception {
        table=getWebDriver().findElement(By.id("customers"));
        WebElement tableRowElement = ((RemoteWebElement) table).findElement(By.
                xpath("//tbody/tr["+columnNameToIndexMap.get(searchColumn)+"]"));
        WebElement TableCell=tableRowElement.findElement(By.xpath("//td[text()='" + searchText+"']"));
        boolean actualCellText=getTableCellText(table,searchColumn,searchText,returnColumnText);
        Assert.assertEquals(returnColumnText,expectedText,"The expected cell value "+searchText+"\n is not as expected");
        return true;
    }


    public boolean getTableCellText(WebElement table,
                                   String searchColumn,
                                    String searchText,
                                    String returnColumnText) throws Exception {

        try {
            String cellText=getTableCellTextByXpath(table,searchColumn, searchText, returnColumnText);
            return cellText==returnColumnText;
        } catch (Exception e) {
            logger.debug("getTableCellTextByXpath(table,searchColumn, searchText, returnColumnText) throwed exception!!");
            e.printStackTrace();
        }
        return true;
    }


    public String getTableCellTextByXpath(
            WebElement table,
            String searchColumn,
            String searchText,
            String returnColumnText) throws Exception {
        if((table==null)|| searchColumn=="" || searchText=="")
            return "ERROR";
        //xpath("//tbody/tr[contains(text(),'Maria Andres')]"))
        WebElement tableRowElement = ((RemoteWebElement) table).findElement(By.
                xpath("//tbody/tr[contains(.,'"+searchText+"')]"));
        WebElement TableCell=tableRowElement.findElement(By.xpath("//td[text()='" + returnColumnText+"']"));

        return TableCell.getText();
    }
}