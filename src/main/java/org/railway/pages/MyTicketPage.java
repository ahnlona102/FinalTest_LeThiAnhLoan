package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.models.User;
import org.railway.utils.Action;

public class MyTicketPage extends BasePage {
    private final String cancelTicketbtn = "//table[@class='MyTable']//tr[td[text()='%s' and following-sibling::td[text()='%s'" + " and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' " + "and following-sibling::td[text()='%s']]]]]]//input[contains(@onclick, 'Delete')]";

    private final String ticketInforRowLocator = "//table[@class='MyTable']//tr[td[text()='%s' and following-sibling::td[text()='%s'" + " and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' " + "and following-sibling::td[text()='%s']]]]]]";

    public void cancelTicket(User user) {
        String amount = String.valueOf(user.getAmountTicket());
        By cancelbtn = By.xpath(String.format(cancelTicketbtn, user.getDepart(), user.getArrive(), user.getSeatType(), user.getDepartDate(), amount));
        Action.scroll(cancelbtn);
        Action.click(cancelbtn);
    }

    public void acceptCancelTicket() {
        Action.acceptAlert();
    }

    public boolean isCancelledTicketDisplayed(User user) {
        String amount = String.valueOf(user.getAmountTicket());
        By rows = By.xpath(String.format(ticketInforRowLocator, user.getDepart(), user.getArrive(), user.getSeatType(), user.getDepartDate(), amount));
        return Action.isDisappear(rows);
    }
}
