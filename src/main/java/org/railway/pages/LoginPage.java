package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.models.User;
import org.railway.utils.Action;

public class LoginPage extends BasePage {

    private final By emailtxtboxLocator = By.id("username");
    private final By passwordtxtboxLocator = By.id("password");
    private final By loginbtn = By.xpath("//input[@value='login']");
    private final By loginErr = By.xpath("//p[contains(@class,'message error')]");
    private String titleForm = "//legend[contains(text(),'%s')]";

    public void login(User user) {
        enterEmail(user);
        enterPassword(user);
        clickLoginButton();
    }

    public void loginManyTimes(User user, int number) {
        for (int i = 0; i < number - 1; i++) {
            login(user);
        }
    }


    public void enterEmail(User user) {
        Action.enter(emailtxtboxLocator, user.getEmail());
    }

    public void enterPassword(User user) {
        Action.enter(passwordtxtboxLocator, user.getPassword());
    }

    public void clickLoginButton() {
        Action.scroll(loginbtn);
        Action.click(loginbtn);
    }

//    public void checkTitleForm(String title) {
//        By form = By.xpath(String.format(titleForm, title));
//        Action.isDisplayed(form);
//    }

    public boolean isLoginErrorMessageDisplayed(String expectedMessage) {
        String actualMessage = Action.getText(loginErr);
        return actualMessage.equals(expectedMessage);
    }
}
