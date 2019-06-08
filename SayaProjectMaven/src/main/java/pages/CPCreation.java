package pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CPCreation extends HomePage {
    @FindBy(id="ctl00_ContentPlaceHolder1_txtFirstName")
    private WebElement firstName;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtLastName")
    private WebElement lastName;
    @FindBy(id="id='ctl00_ContentPlaceHolder1_txtMiddleName")
    private WebElement middleName;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtNotfEmail")
    private WebElement notficationEmail;
    @FindBy(id="@id='ctl00_ContentPlaceHolder1_txtAddress1")
    private WebElement address1;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtAddress2")
    private WebElement address2;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtZip")
    private WebElement postalCode;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlCountries")
    private WebElement selectCountries;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlStates")
    private WebElement selectStates;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlDistricts")
    private WebElement selectDistricts;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlMandals")
    private WebElement selectMandals;
    @FindBy(id="id='ctl00_ContentPlaceHolder1_ddlLocations")
    private WebElement selectLocation;
    @FindBy(xpath="//*[text()='Male']")
    public WebElement male;
    @FindBy(xpath = "//*[text()='Female']")
    public WebElement female;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtOrganisation")
    public WebElement organization;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtContactPerson")
    public WebElement contactPerson;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtPhoneNumber")
    public WebElement phoneNumber;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtEmail")
    public WebElement email;
    @FindBy(id="ctl00_ContentPlaceHolder1_FileUpURLImage")
    public WebElement uploadImage;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtUserName")
    public WebElement userName;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtPassword")
    public WebElement password;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlServiceTypes")
    public WebElement serviceTypes;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtCallsign")
    public WebElement callSign;
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlCurrencyType")
    public WebElement currencyType;
    @FindBy(xpath="//*[text()='Online']")
    public WebElement online;
    @FindBy(xpath="//*[text()='Offline']")
    public WebElement offline;
    @FindBy(xpath = "//*[@id=ctl00_ContentPlaceHolder1_txtFtpAddress")
    public WebElement ftpAddress;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtTMSPort")
    public WebElement port;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtFtpUsername")
    public WebElement ftpUserName;
    @FindBy(id="ctl00_ContentPlaceHolder1_txtFtpPassword")
    public WebElement ftpPassword;
    @FindBy(id="ctl00_ContentPlaceHolder1_rblAdwizeUser_0")
    public WebElement adwizeUserYes;
    @FindBy(id="ctl00_ContentPlaceHolder1_rblAdwizeUser_1")
    public WebElement adwizeUserNo;
    @FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
    public WebElement save;

    public CPCreation(){
        PageFactory.initElements(driver,this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getMiddleName() {
        return middleName;
    }

    public WebElement getNotficationEmail() {
        return notficationEmail;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getAddress2() {
        return address2;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getSelectCountries() {
        return selectCountries;
    }

    public WebElement getSelectStates() {
        return selectStates;
    }

    public WebElement getSelectDistricts() {
        return selectDistricts;
    }

    public WebElement getSelectMandals() {
        return selectMandals;
    }

    public WebElement getSelectLocation() {
        return selectLocation;
    }

    public WebElement getMale() {
        return male;
    }

    public WebElement getFemale() {
        return female;
    }

    public WebElement getOrganization() {
        return organization;
    }

    public WebElement getContactPerson() {
        return contactPerson;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getUploadImage() {
        return uploadImage;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getServiceTypes() {
        return serviceTypes;
    }

    public WebElement getCallSign() {
        return callSign;
    }

    public WebElement getCurrencyType() {
        return currencyType;
    }

    public WebElement getOnline() {
        return online;
    }

    public WebElement getOffline() {
        return offline;
    }

    public WebElement getFtpAddress() {
        return ftpAddress;
    }

    public WebElement getPort() {
        return port;
    }

    public WebElement getFtpUserName() {
        return ftpUserName;
    }

    public WebElement getFtpPassword() {
        return ftpPassword;
    }

    public WebElement getAdwizeUserYes() {
        return adwizeUserYes;
    }

    public WebElement getAdwizeUserNo() {
        return adwizeUserNo;
    }

    public WebElement getSave() {
        return save;
    }





}
