package railway;

import data.TestDataProvider;
import org.railway.enums.ConfirmEmail;
import org.railway.enums.MyTicket;
import org.railway.enums.RailwayTab;
import org.railway.models.User;
import org.railway.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTicketTest extends BaseTest{
    BasePage basePage = new BasePage();
    EmailPage emailPage = new EmailPage();
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    BookTicketSuccessPage bookTicketSuccessPage = new BookTicketSuccessPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(dataProvider = "FTTC702", dataProviderClass = TestDataProvider.class, description = "User can filter Manage ticket table with different Depart Dates")
    public void Testcase_FTTC702(User user, int numberOfTicket){
        basePage.navigateToMailPage();
        emailPage.getEmail(user);
        basePage.switchToNewTab();
        basePage.navigateToRailway();
        homePage.clickTab(RailwayTab.REGISTER);
        registerPage.registerAccount(user);
        basePage.switchToEmail();
        basePage.refreshPage();
        emailPage.checkConfirmMess(ConfirmEmail.CONFIRM);
        emailPage.clickConfirmLink();
        basePage.switchToNewTab();
        basePage.navigateToRailway();
        registerPage.clickTab(RailwayTab.LOGIN);
        loginPage.login(user);
        homePage.clickTab(RailwayTab.BOOKTICKET);
        bookTicketPage.bookMultipleTickets(numberOfTicket, user.getDate(), user);
        bookTicketSuccessPage.clickTab(RailwayTab.MYTICKET);
        myTicketPage.selectFieldFilter(MyTicket.FILTER_DEPARTSTATION, user.getDepart());
        myTicketPage.selectFieldFilter(MyTicket.FILTER_ARRIVALSTATION, user.getArrive());
        myTicketPage.inputDepartDateFilter(user.getDepartDate());
        myTicketPage.clickFilterbutton();
        Assert.assertTrue(myTicketPage.isManageTableShowsCorrectTicket(user), "Information is incorrect");
    }

}

