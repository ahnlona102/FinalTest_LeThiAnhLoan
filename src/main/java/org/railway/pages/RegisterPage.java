package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.models.User;
import org.railway.utils.Action;

public class RegisterPage extends BasePage{

    private By emailtxtboxLocator = By.name("email");
    private By passwordtxtboxLocator = By.name("password");
    private By confirmPassLocator = By.id("confirmPassword");
    private By passporttxtboxLocator = By.name("pid");
    private By registerbtn = By.xpath("//input[@title='Register']");
    private By registerErrLocator = By.xpath("//p[@class='message error']");
    private String invalidErrorLocator = "//label[contains(text(),'%s')]";
    private String messageLocator = "//p[contains(text(),'%s')]";

    public void registerAccount(User user) {
        Action.enter(emailtxtboxLocator, user.getEmail());
        Action.enter(passwordtxtboxLocator, user.getPassword());
        Action.enter(confirmPassLocator, user.getConfirmPassword());
        Action.enter(passporttxtboxLocator, user.getPassport());
        clickRegisterButton();
    }

    public void clickRegisterButton() {
        Action.scroll(registerbtn);
        Action.click(registerbtn);
    }

    public boolean isRegisterErrorDisplayed(String expectedMessage) {
        Action.getWait(10);
        String actualMessage = Action.getText(registerErrLocator);
        return actualMessage.equals(expectedMessage);
    }

    public boolean isPasswordFieldError(String message) {
        By fieldErr = By.xpath(String.format(invalidErrorLocator, message));
        return Action.isDisplayed(fieldErr);
    }

    public boolean isPassportFieldError(String message) {
        By fieldErr = By.xpath(String.format(invalidErrorLocator, message));
        return Action.isDisplayed(fieldErr);
    }

    public boolean isMessageDisplayed(String message) {
        By checkText = By.xpath(String.format(messageLocator, message));
        return Action.isDisplayed(checkText);
    }

}

