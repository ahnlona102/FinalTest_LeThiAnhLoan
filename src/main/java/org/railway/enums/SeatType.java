package org.railway.enums;

public enum SeatType {
    SOFTSEAT("SS"),
    HARDSEAT("HS"),
    SOFTSEATWITHAIRCONDITIONER("SSC"),
    HARDBED("HB"),
    SOFTBED("SB"),
    SOFTBEDWITHAIRCONDITIONER("SBC");

    private String value;

    SeatType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
