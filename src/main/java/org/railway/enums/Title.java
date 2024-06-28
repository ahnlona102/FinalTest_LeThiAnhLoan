package org.railway.enums;

public enum Title {
    PASSWORD_CHANGE_FORM("Password Change Form");

    private String value;

    Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
