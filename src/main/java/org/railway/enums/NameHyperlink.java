package org.railway.enums;

public enum NameHyperlink {

    FORGOTPASSWORD("Forgot Password page"),
    REGISTRATION("registration page"),;

    private String value;

    NameHyperlink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
