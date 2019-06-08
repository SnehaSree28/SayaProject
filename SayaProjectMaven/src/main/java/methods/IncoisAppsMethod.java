package methods;

import enums.Districts;
import enums.States;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IncoisAppsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lovel on 08-Oct-18.
 */
public class IncoisAppsMethod extends IncoisAppsPage {
    WebDriverWait wait = new WebDriverWait(driver, 10);


    public List<WebElement> selectGroupIncois() {
        wait.until(ExpectedConditions.visibilityOf(selectGroup));
        Select select = new Select(selectGroup);
        //Get all options
        List<WebElement> elements = select.getOptions();
        //Get the length
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
        }
        return elements;
    }

    public void searchGroup() {
        wait.until(ExpectedConditions.visibilityOf(searchGroup));
        searchGroup.click();
        wait.until(ExpectedConditions.visibilityOf(potentialFishingZone));

    }

    public void sliderPfz(int pfzSliderValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"pfzrange\").innerText=" + pfzSliderValue);
    }

    public void pfzSelectAOI(List<String> languageSelection) {
        showInPFz.click();
        if (checkAOI.isSelected()) {

            for (String se : languageSelection) {
                WebElement selectLanguages = driver.findElement(By.xpath("//*[text()='" + se + "']/../input"));
                System.out.println("Languages are" +selectLanguages.getText());
                selectLanguages.click();
            }
        }
        else {
            System.out.println("Elements are already selected");
        }

    }
    public void countCheckedAndUncheckedTextBoxes(){
        showInPFz.click();
        List<WebElement> elements= driver.findElements(By.xpath("//*[@type='checkbox']"));
        int checkedCount=0;
        int unCheckedCount=0;
        for(int i=0; i< elements.size();i++){
            if(elements.get(i).isSelected()==true){
                checkedCount++;
            }else {
                unCheckedCount++;
            }
        }
        System.out.println("Number of checked checkboxes are " +checkedCount);
        System.out.println("Number of unchecked checkboxes are" +unCheckedCount);
    }

    public void uncheckCheckBoxes(List<String> languageSelection) {
        showInPFz.click();
        for (String se : languageSelection) {
            boolean x = driver.findElement(By.xpath("//*[text()='" + se + "']/../input")).isSelected();
            System.out.println("x value:" + x);
            if (x == false) {
                driver.findElement(By.xpath("//*[text()='" + se + "']/../input")).click();
            } else
                driver.findElement(By.xpath("//*[text()='" + se + "']/../input")).click();
        }
    }

    public void checkAOI(){
        if(checkAOI.isSelected()) {
            checkAOI.click();
        }
    }

    public void pfzMultipleStatesMethod(List<States> states1, List<Districts> districts) throws InterruptedException {
       checkAOI();
        wait.until(ExpectedConditions.visibilityOf(pfzMultipleStates));
        pfzMultipleStates.click();
        for(States states: states1)
        {
            System.out.println("States are " +states1);
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,35)", "");

            boolean x= driver.findElement(By.xpath("//*[text()='" +states+ "']/../input")).isSelected();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if(x==false)
            {
                driver.findElement(By.xpath("//*[text()='"+states+"']/../input")).click();
            }else
                driver.findElement(By.xpath("//*[text()='"+states+"']/../input")).click();
             }
        Thread.sleep(2000);
        pfzMultipleDistricts.click();
        for(Districts dist:districts){
            boolean x=driver.findElement(By.xpath("//*[text()='"+dist+"']/../input")).isSelected();
            if(x==false){
                driver.findElement(By.xpath("//*[text()='"+dist+"']/../input")).click();
            }else
                driver.findElement(By.xpath("//*[text()='"+dist+"']/../input")).click();
        }

    }




}

