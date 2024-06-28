package org.railway.enums;

public enum RailwayTab {
    HOME("Home"),
    FAQ("FAQ"),
    CONTACT("Contact"),
    TIMETABLE("Timetable"),
    TICKETPRICE("Ticket price"),
    REGISTER("Register"),
    LOGIN("Login"),
    MYTICKET("My ticket"),
    BOOKTICKET("Book ticket"),
    CHANGEPASSWORD("Change password"),
    LOGOUT("Log out");

    private String value;

    RailwayTab(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
