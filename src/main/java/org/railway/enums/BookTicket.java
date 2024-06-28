package org.railway.enums;

public enum BookTicket {
    DEPARTDATE("Date"),
    DEPARTSTATION("DepartStation"),
    ARRIVESTATION("ArriveStation"),
    SEATTYPE("SeatType"),
    AMOUNTTICKET("TicketAmount");

    private String value;

    BookTicket(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
