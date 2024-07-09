package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.utils.Action;

public class HomePage extends BasePage{
    private By welcomeMessageLocator = By.xpath("//div[@id='banner']//strong");;

    public boolean isWelcomeMessageDisplayed(String expectedMessage) {
        String actualMessage = Action.getText(welcomeMessageLocator);
        return actualMessage.equals(expectedMessage);
    }

}


