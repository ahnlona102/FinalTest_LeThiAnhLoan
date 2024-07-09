package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.models.User;
import org.railway.utils.Action;

public class TimetablePage extends BasePage{

    private String checkPricePageLocator = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[contains(@href, 'TicketPricePage')]";
    private String bookTicketPageLocator = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[contains(@href, 'BookTicketPage')]";

    public void checkPrice(User user) {
        By check = By.xpath(String.format(checkPricePageLocator, user.getDepart(), user.getArrive()));
        Action.click(check);
    }

    public void bookTicket(User user) {
        By book = By.xpath(String.format(bookTicketPageLocator, user.getDepart(), user.getArrive()));
        Action.click(book);
    }
}
