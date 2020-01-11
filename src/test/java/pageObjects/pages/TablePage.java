package pageObjects.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    protected static HashMap<String, String> searchedColumnNameToIndexMap;

    public TablePage(){
        getWebDriver().navigate().to("http://www.w3schools.com/html/html_tables.asp");
        searchedColumnNameToIndexMap =new HashMap<String, String>();
        searchedColumnNameToIndexMap.put("Company","1");
        searchedColumnNameToIndexMap.put("Contact","2");
        searchedColumnNameToIndexMap.put("Country","3");
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
                xpath("//tbody/tr["+ searchedColumnNameToIndexMap.get(searchColumn)+"]"));
        WebElement TableCell=tableRowElement.findElement(By.xpath("//td[text()='" + searchText+"']"));
        boolean actualCellText=getTableCellText(table,searchColumn,searchText,returnColumnText);
        Assert.assertEquals(returnColumnText,expectedText,"The expected cell value "+searchText+"\n is not as expected");
        return true;
    }


    protected boolean getTableCellText(WebElement table,
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

    @Step("using value at the row get value searched")
    public String getTableCellTextByXpath(
            WebElement table,
            String searchColumn,
            String searchText,
            String returnColumnText) throws Exception {
        String tableCellText;
        try{
            if ((table == null) || searchColumn == "" || searchText == "")
                return "ERROR";
            WebElement tableRowElement = ((RemoteWebElement) table).findElement(By.
                    xpath("//tbody/tr[contains(.,'" + searchText + "')]"));

            WebElement TableCell = table.findElement(By.xpath("//tbody/tr[contains(.,'" + searchText + "')]/td[" + searchedColumnNameToIndexMap.get(searchColumn) + "]"));

            tableCellText = TableCell.getText();
            //Allure.addAttachment("My Cell Value", tableCellText);

            Allure.step("My Cell Value="+tableCellText);
            Allure.step("Expected searched value="+returnColumnText);
            Allure.step("searched column="+searchColumn);
            Allure.step("searched text to find correct row="+searchText);
            if (false == tableCellText.equals("")) {
                return TableCell.getText();
            } else
                return "ERROR";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ERROR";
    }

    protected boolean isSearchedTextIsFromTheDesiredColumn(
            String searchColumn,
            String searchText,
            String  returnColumnText){
        WebElement tableRowElement = getWebDriver().findElement(By.
                xpath("//table/tbody/tr[contains(.,'"+searchText+"')]"));
        return false;
    }
}