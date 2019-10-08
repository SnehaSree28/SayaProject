package methods;

import common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CPCreation;

public class CPCreationMethod extends CPCreation {
    WebDriverWait webDriverWait = new WebDriverWait(driver,10);


    CPCreation cpCreation = new CPCreation();

    public void createCP(String firstName, String lastName){
        cpCreation.addButtonOfCP.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(cpCreation.getFirstName()));
        cpCreation.getFirstName().sendKeys(firstName);

        cpCreation.getLastName().sendKeys(lastName + CommonMethods.randomChar());
    }


}

