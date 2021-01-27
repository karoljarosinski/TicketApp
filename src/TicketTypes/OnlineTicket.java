package TicketTypes;

import Address.Address;

public class OnlineTicket extends Ticket {
    private static final String ONLINE = "bilet internetowy";

    public OnlineTicket(Address address, String eventName, double price, double discount) {
        super(address, eventName, ONLINE, price, discount);
    }

    public static String getONLINE() {
        return ONLINE;
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
