package ticketTypes;

import address.Address;

public class StandardTicket extends Ticket {
    public static final String STANDARD = "bilet standardowy";

    public StandardTicket(Address address, String eventName, double price, double discount) {
        super(address, eventName, STANDARD, price, discount);
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
