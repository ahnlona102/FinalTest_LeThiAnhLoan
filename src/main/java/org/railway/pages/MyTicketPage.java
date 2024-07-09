package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.enums.MyTicket;
import org.railway.models.User;
import org.railway.utils.Action;

public class MyTicketPage extends BasePage {
    private String tableFilterLocator = "//table[@letxpath='letxpathtable']//td//select[@name='%s']";
    private By departDateFilterLocator = By.xpath("//input[@title='Empty = Ignore']");
    private By filterBtnLocator = By.xpath("//input[@value='Apply filter']");
    private final String ticketInforRowLocator = "//table[@class='MyTable']//tr[td[text()='%s' and following-sibling::td[text()='%s'" + " and following-sibling::td[text()='%s' and following-sibling::td[text()='%s' " + "and following-sibling::td[text()='%s']]]]]]";

    public void selectFieldFilter(MyTicket field, String text){
        By filter = By.xpath(String.format(tableFilterLocator, field.getValue()));
        Action.selectByVisibleText(filter, text );
    }

    public void inputDepartDateFilter(String date){
        Action.enter(departDateFilterLocator, date);
    }

    public void clickFilterbutton(){
        Action.click(filterBtnLocator);
    }

    public boolean isManageTableShowsCorrectTicket(User user) {
        String amount = String.valueOf(user.getAmountTicket());
        By rows = By.xpath(String.format(ticketInforRowLocator, user.getDepart(), user.getArrive(), user.getSeatType(), user.getDepartDate(), amount));
        return Action.isDisplayed(rows);
    }
}
