package calculation;

import ticketTypes.GiftTicket;
import ticketTypes.OnlineTicket;
import ticketTypes.StandardTicket;
import ticketTypes.Ticket;

public class CalcPrice {

    public static double calculatePrice(Ticket ticket) {
        double finalPrice = 0;
        if (ticket.getTicketType().equals(OnlineTicket.ONLINE)) {
            finalPrice = onlineTicketPrice(ticket);
        } else if (ticket.getTicketType().equals(StandardTicket.STANDARD)) {
            finalPrice = standardTicketPrice(ticket);
        } else if (ticket.getTicketType().equals(GiftTicket.GIFT)) {
            finalPrice = giftTicketPrice(ticket);
        }
        return finalPrice;
    }

    private static double onlineTicketPrice(Ticket ticket) {
        return ticket.getBasePrice() * (1 - ticket.getDiscount());
    }

    private static double standardTicketPrice(Ticket ticket) {
        return onlineTicketPrice(ticket) + 5;
    }

    private static double giftTicketPrice(Ticket ticket) {
        return standardTicketPrice(ticket) + (1.05 * ticket.getBasePrice());
    }

}
