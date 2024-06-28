package org.railway.pages;

import org.openqa.selenium.By;
import org.railway.enums.BookTicket;
import org.railway.utils.Action;
import org.railway.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookTicketPage extends BasePage{

    private String dateDate = "//select[@name='Date']//option[text()='%s']";
    private By bookTicketbutton = By.xpath("//legend[text()='Book ticket form']/following-sibling::input");
    //private By bookTicketTable = By.xpath("//table[@class='MyTable WideTable']");
    private String selectOption = "//select[@name='%s']";


    public void selectDepartdate(int date){
        String formattedDate = DateUtils.getFormattedDate(date);
        By selectDate = By.xpath(String.format(dateDate, formattedDate));
        Action.find(selectDate).click();
    }

    public void select(BookTicket optionName, String value) {
        By option = By.xpath(String.format(selectOption, optionName.getValue()));
        Action.scroll(option);
        Action.click(option);
        try {
            int intValue = Integer.parseInt(value);
            if (intValue >= 1 && intValue <= 10) {
                Action.selectByValue(option, value);
            } else {
                Action.selectByVisibleText(option, value);
            }
        } catch (NumberFormatException e) {
            Action.selectByVisibleText(option, value);
        }
    }

    public void bookTicketButton() {
        Action.scroll(bookTicketbutton);
        Action.click(bookTicketbutton);
    }
}
