package TicketTypes;

import Address.Address;

public class GiftTicket extends Ticket {
    private static final String GIFT = "bilet prezentowy";

    public GiftTicket(Address address, String eventName, double price, double discount) {
        super(address, eventName, GIFT, price, discount);
    }

    public static String getGIFT() {
        return GIFT;
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
