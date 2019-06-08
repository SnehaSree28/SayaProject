package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AffliateManagementPage extends WebDriverTest {
   // public WebDriver driver;
    @FindBy(xpath ="//*[text()='Affiliate Management ']")
    public WebElement mname;
    @FindBy(xpath = "//*[@ng-click='createNewAffiliate();']")
    public WebElement createaffiliate;
    @FindBy(id="txtCreateFirstName")
    public WebElement fname;
    @FindBy(id="txtCreateLastName")
    public WebElement lname;
    @FindBy(id="ddlCreateCountries")
    public WebElement country;
    @FindBy(id="ddlCreateStates")
    public WebElement states;
    @FindBy(id="ddlCreateDistricts")
    public WebElement districts;
    @FindBy(id="ddlCreateMandals")
    public WebElement mandal;
    @FindBy(id="ddlCreateLocations")
    public WebElement location;
    @FindBy(name = "txtCreateAddress")
    public WebElement address;
    @FindBy(name = "txtCreateZipCode")
    public WebElement postalcode;
    @FindBy(name = "txtCreateEmail")
    public WebElement email;
    @FindBy(name = "txtCreatePhoneNumber")
    public WebElement mobilenumber;
    @FindBy(name="txtCreateOrganization")
    public WebElement organization;
    @FindBy(name = "txtCreateUserName")
    public WebElement uname;
    @FindBy(name="txtCreatePassword")
    public WebElement upwd;
    @FindBy(xpath = "//*[@ng-click='saveAffiliateDetails();']")
    public WebElement savebtn;


    public AffliateManagementPage()
    {

        PageFactory.initElements(driver,this);
    }

    public void clickAffiliateManagement()
    {
        mname.click();
    }
    public void clickCreateAfiiliate()
    {
        createaffiliate.click();
    }
    public void firstName(String firstname)
    {
        fname.sendKeys(firstname);
    }
    public void lastName(String lastname)
    {
        lname.sendKeys(lastname);
    }
    public void countryName(String countryname)
    {
        Select selectCountry=new Select(country);
        selectCountry.selectByVisibleText(countryname);
    }
    public void stateName(String statename)
    {
        Select selectState=new Select(states);
        selectState.selectByVisibleText(statename);
    }
    public void districtName(String districtname)
    {
        Select selectDistrict=new Select(districts);
        selectDistrict.selectByVisibleText(districtname);
    }
    public void mandalName(String mandalname)
    {
        Select selectMandal=new Select(mandal);
        selectMandal.selectByVisibleText(mandalname);
    }
    public void locationName(String locationname)
    {
        Select selectLocation=new Select(location);
        selectLocation.selectByVisibleText(locationname);
    }
    public void addressDetails(String addressdetails)
    {
        address.sendKeys(addressdetails);
    }
    public void postalCode(String zipcode)
    {
        postalcode.sendKeys(zipcode);
    }
    public void emailAddress(String emailaddress)
    {
        email.sendKeys(emailaddress);
    }
    public void mobileNumber(String phoneNumber)
    {
        mobilenumber.sendKeys(phoneNumber);
    }
    public void organizationName(String organizationname)
    {
        organization.sendKeys(organizationname);
    }
    public void userName(String username)
    {
        uname.sendKeys(username);
    }
    public void password(String userPassword)
    {
        upwd.sendKeys(userPassword);
    }
    public void saveButton()
    {
        savebtn.click();
    }


    public void affiliateTable()
    {
        WebElement htmltable=driver.findElement(By.xpath("//*[@id=\"divAffiliatesList\"]/table"));
        List<WebElement> rows=htmltable.findElements(By.xpath("//*[@id=\"divAffiliatesList\"]/table/tbody[2]/tr"));
        for(int rnum=0;rnum<rows.size();rnum++)
        {
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
            System.out.println("Number of columns:"+columns.size());

            for(int cnum=0;cnum<columns.size();cnum++)
            {
                System.out.println(columns.get(cnum).getText());
            }
        }
    }
}
