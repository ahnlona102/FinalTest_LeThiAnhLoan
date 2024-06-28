package org.railway.enums;

public enum ConfirmEmail {
    CONFIRM("Please confirm"),
    RESET("Please reset");

    private String value;

    ConfirmEmail(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
