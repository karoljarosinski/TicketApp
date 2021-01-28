package ticketTypes;

import address.Address;

public class GiftTicket extends Ticket {
    public static final String GIFT = "bilet prezentowy";

    public GiftTicket(Address address, String eventName, double price, double discount) {
        super(address, eventName, GIFT, price, discount);
    }


    @Override
    public void printInfo() {
        super.printInfo();
    }
}
