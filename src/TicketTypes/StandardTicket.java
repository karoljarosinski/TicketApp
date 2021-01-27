package TicketTypes;

import Address.Address;

public class StandardTicket extends Ticket {
    private static final String STANDARD = "bilet standardowy";

    public StandardTicket(Address address, String eventName, double price, double discount) {
        super(address, eventName, STANDARD, price, discount);
    }

    public static String getSTANDARD() {
        return STANDARD;
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
