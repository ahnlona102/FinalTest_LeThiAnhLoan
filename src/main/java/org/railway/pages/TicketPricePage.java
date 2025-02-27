package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.enums.SeatType;
import org.railway.models.User;
import org.railway.utils.Action;

public class TicketPricePage extends BasePage{
    private String seatTypeLocator = "//tr[td[text()='%s']]//a[text()='Book ticket']";
    private String priceOfSeatType = "//table[@class='MyTable MedTable']//th[normalize-space()='Price (VND)']//following-sibling::td[count(//td[text()='%s']/preceding-sibling::td)+1]";
    private By ticketPriceTableHeader = By.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th[contains(text(),'Ticket price from')]");
    private String sectionLocator = "//tr[td/li[text()='%s']]//a[contains(@href, 'TicketPricePage')]";

    public void checkPriceWithSection(String section){
        By sectionLink = By.xpath(String.format(sectionLocator, section));
        Action.click(sectionLink);
    }
    public void selectSeatType(User user) {
        By seattype = By.xpath(String.format(seatTypeLocator, user.getSeatType()));
        Action.scroll(seattype);
        Action.click(seattype);
    }

    public String getHeaderOfSeatPriceTable() {
        return Action.getText(ticketPriceTableHeader);
    }

    public Integer getPriceOfSeatType(SeatType type) {
        By priceOfSeatLocator = By.xpath(String.format(priceOfSeatType, type.getValue()));
        String price = Action.getText(priceOfSeatLocator);
        return Integer.parseInt(price);
    }
    public int getTotalPriceForTickets(SeatType type, User user) {
        int priceOfOneTicket = getPriceOfSeatType(type);
        int amountTicket = Integer.parseInt(user.getAmountTicket());
        return priceOfOneTicket * amountTicket;
    }
}
