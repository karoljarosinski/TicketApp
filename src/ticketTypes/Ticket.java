package ticketTypes;

import address.Address;

public class Ticket {
    private Address address;
    private String eventName;
    private String ticketType;
    private double basePrice;
    private double discount;
    private static int ticketId = 0;

    public Ticket(Address address, String eventName, String ticketType, double basePrice, double discount) {
        this.address = address;
        this.eventName = eventName;
        this.basePrice = basePrice;
        this.discount = discount;
        this.ticketType = ticketType;
        ticketId++;
    }

    public double getDiscount() {
        return discount;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void printInfo() {
        System.out.println("Nazwa wydarzenia: " + eventName);
        System.out.println(address.getInfo());
        System.out.println("Typ biletu: " + ticketType);
        System.out.println("Podstawowa cena: " + basePrice);
        System.out.println("Zniżka: " + (discount * 100) + " procent");
        System.out.println("Indywidualny numer biletu: " + ticketId);
    }

    public String getTicketType() {
        return ticketType;
    }
}
