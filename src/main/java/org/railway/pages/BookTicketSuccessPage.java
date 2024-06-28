package org.railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.railway.constant.SuccessBookedTicket;
import org.railway.models.User;
import org.railway.utils.Action;

import java.util.List;

public class BookTicketSuccessPage extends BasePage {

    private final By message = By.xpath("//h1[@align='center']");
    private final By tableInfo = By.xpath("//table[@class='MyTable WideTable']");

    public boolean isSuccessMessageDisplayed(String expectedMessage) {
        String successMess = Action.getText(message);
        return successMess.equals(expectedMessage);
    }

    public boolean isInformationDisplayed(User user) {
        WebElement table = Action.find(tableInfo);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() >= 7) {
                String actualDepartStation = cells.get(SuccessBookedTicket.DEPART_STATION).getText();
                String actualArriveStation = cells.get(SuccessBookedTicket.ARRIVE_STATION).getText();
                String actualSeatType = cells.get(SuccessBookedTicket.SEAT_TYPE).getText();
                String actualDeparteDate = cells.get(SuccessBookedTicket.DEPART_DATE).getText();
                String actualAmount = cells.get(SuccessBookedTicket.AMOUNT_TICKET).getText();
                return actualDepartStation.equals(user.getDepart()) && actualArriveStation.equals(user.getArrive()) && actualSeatType.equals(user.getSeatType()) && actualDeparteDate.equals(user.getDepartDate()) && actualAmount.equals(user.getAmountTicket());
            }
        }
        return false;
    }
}
