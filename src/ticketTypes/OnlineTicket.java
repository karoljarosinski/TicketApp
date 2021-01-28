package ticketTypes;

import address.Address;

public class OnlineTicket extends Ticket {
    public static final String ONLINE = "bilet internetowy";

    public OnlineTicket(Address address, String eventName, double price, double discount) {
        super(address, eventName, ONLINE, price, discount);
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}
