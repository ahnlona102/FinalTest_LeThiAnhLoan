package org.railway.enums;

public enum ResetPassword {
    NEWPASS("password"),
    IDNEWPASS("newPassword"),
    CONFIRMNEWPASS("password"),
    IDCONFIRMNEWPASS("confirmPassword"),
    RESETBUTTON("Reset password");


    private String value;

    ResetPassword(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
