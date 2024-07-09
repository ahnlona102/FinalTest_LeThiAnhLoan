package org.railway.enums;

public enum MyTicket {
    FILTER_DEPARTSTATION("FilterDpStation"),
    FILTER_ARRIVALSTATION("FilterArStation"),
    FILTER_DEPARTDATE("FilterDpDate");

    private String value;

    MyTicket(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
