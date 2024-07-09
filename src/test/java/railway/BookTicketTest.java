package railway;

import data.TestDataProvider;
import org.railway.enums.BookTicket;
import org.railway.enums.RailwayTab;
import org.railway.enums.SeatType;
import org.railway.models.User;
import org.railway.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest{
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(dataProvider = "FTTC703", dataProviderClass = TestDataProvider.class, description = "User can book tickets with known price")
    public void Testcase_FTTC703(User user, String section, int totalPrice) {
        basePage.navigateToRailway();
        basePage.clickTab(RailwayTab.LOGIN);
        loginPage.login(user);
        loginPage.clickTab(RailwayTab.TICKETPRICE);
        ticketPricePage.checkPriceWithSection(section);
        ticketPricePage.selectSeatType(user);
        bookTicketPage.select(BookTicket.AMOUNTTICKET, user.getAmountTicket());
        Assert.assertTrue(bookTicketSuccessPage.isInformationDisplayed(user),"Information is incorrect");
        Assert.assertEquals( ticketPricePage.getTotalPriceForTickets(SeatType.HARDSEAT, user),totalPrice);
    }
}
