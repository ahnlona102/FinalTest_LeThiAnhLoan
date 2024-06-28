package org.railway.pages;

import org.openqa.selenium.*;
import org.railway.enums.NameHyperlink;
import org.railway.utils.Action;
import org.railway.utils.ConfigLoader;
import org.railway.utils.Driver;
import org.railway.enums.RailwayTab;

public class BasePage {

    private static String railway;
    private static String mail;
    private final String tabLocator = "//a[.='%s']";
    private final String hyperlinkLocator = "//a[contains(text(),'%s')]";
    private By titleLocator = By.xpath("//h1[@align='center']");

    public static void navigateToRailway() {
        String railwayUrl = ConfigLoader.getProperty("railway.url");
        Driver.driver.get(railwayUrl);
        railway = Driver.driver.getWindowHandle();
    }

    public static void switchToRailway() {
        Driver.driver.switchTo().window(railway);
    }

    public static void navigateToMailPage() {
        String mailUrl = ConfigLoader.getProperty("mail.url");
        Driver.driver.get(mailUrl);
        mail = Driver.driver.getWindowHandle();
    }

    public static void switchToEmail() {
        Driver.driver.switchTo().window(mail);
    }

    public static void refreshPage() {
        Driver.driver.navigate().refresh();
    }

    public static void switchToNewTab() {
        Driver.driver.switchTo().newWindow(WindowType.TAB);
    }

    public void clickTab(RailwayTab tabname) {
        By tabName = By.xpath(String.format(tabLocator, tabname.getValue()));
        Action.click(tabName);
    }

    public boolean isTitleDisplay(String message) {
        String actual = Action.getText(titleLocator);
        return actual.equals(message);
    }

    public void clickHyperlinkByName(NameHyperlink linkName) {
        By hyperlinkName = By.xpath(String.format(hyperlinkLocator, linkName.getValue()));
        Action.click(hyperlinkName);
    }

    public boolean isTabDisplayed(RailwayTab nametab) {
        return Action.find(By.linkText(nametab.getValue())).isDisplayed();
    }

    public boolean doesTabExist(RailwayTab tabName) {
        Action.getWait(20);
        boolean disappear = Action.isDisappear(By.linkText(tabName.getValue()));
        return disappear;
    }
}
