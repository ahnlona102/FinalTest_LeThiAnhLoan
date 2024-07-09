package org.railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.railway.enums.ConfirmEmail;
import org.railway.models.User;
import org.railway.utils.Action;

public class EmailPage {

    private By usernametxtboxLocator = By.xpath("//span[@id='inbox-id']");
    //private String userInput = "//input[@value='%s']";
    private String usertxtboxLocator = "//span[@id='inbox-id']//input[@type='text']";
    private By domainselectLocator = By.id("gm-host-select");
    private By setbtn = By.xpath("//span[@id='inbox-id']//button[1]");
    private By checkboxLocator = By.xpath("(//input[@type='checkbox'])[1]");
    private By emailFieldLocator = By.id("email-widget");
    private By confirmLinkLocator = By.xpath("//a[contains(@href, 'saferailway')]");
    private String confirmMess = "//td[contains(text(), '%s')]";
    private By mailContent = By.xpath("//div[@class='email_body']");

    public String getEmail(User user) {
        Action.getWait(10);
        Action.clickIfClickable(usernametxtboxLocator);
        enterUsername(user);
        selectDomain(user);
        Action.click(setbtn);
        Action.click(checkboxLocator);
        String getemail = Action.getText(emailFieldLocator);
        System.out.println("Get Email: " + getemail);
        return getemail;
    }

    public void enterUsername(User user) {
        String xpath = String.format(usertxtboxLocator, user.getUsername());
        WebElement mailPath = Action.find(By.xpath(xpath));
        mailPath.sendKeys(user.getUsername());
    }

    public void selectDomain(User user) {
        Action.selectByValue(domainselectLocator, user.getDomain());
    }

    public void clickSetBtn() {
        Action.click(setbtn);
        Action.getWait(20);
    }

    public void setMail(User user) {
        Action.getWait(10);
        Action.clickIfClickable(usernametxtboxLocator);
        enterUsername(user);
        selectDomain(user);
        clickSetBtn();

    }

    public void checkConfirmMess(ConfirmEmail text) {
        Action.getWait(20);
        By mess = By.xpath(String.format(confirmMess, text.getValue()));
        Action.click(mess);
    }


    public void clickConfirmLink() {
        Action.getWait(50);
        Action.clickIfClickable(confirmLinkLocator);
    }

    public void confirmEmail(ConfirmEmail text) {
        checkConfirmMess(text);
        clickConfirmLink();
    }

    public String getResetPasswordToken() {
        String[] parts = Action.getText(mailContent).split("The token is: ");
        if (parts.length > 1) {
            String tokenPart = parts[1].trim();
            String[] tokenParts = tokenPart.split("\\s+");
            return tokenParts[0];
        }
        return "";
    }

}
