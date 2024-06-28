package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.models.User;
import org.railway.utils.Action;

public class ForgotPasswordPage extends BasePage{
    private By emailtxtboxLocator = By.xpath("//input[@id='email']");
    private By sendInstructionbtn = By.xpath("//input[@type='submit']");

    public void submitResetPasswordForm(User user) {
        enterEmail(user);
        clickSendInstructionButton();
    }

    public void enterEmail(User user) {
        Action.enter(emailtxtboxLocator, user.getEmail());
    }

    public void clickSendInstructionButton() {
        Action.scroll(sendInstructionbtn);
        Action.click(sendInstructionbtn);
    }

}
