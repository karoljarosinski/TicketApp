package Calculation;

import TicketTypes.GiftTicket;
import TicketTypes.OnlineTicket;
import TicketTypes.StandardTicket;
import TicketTypes.Ticket;

public class CalcPrice {
    private static double finalPrice = 0;

    public static double calculatePrice(Ticket ticket) {
        if (ticket instanceof OnlineTicket) {
            finalPrice = onlineTicketPrice(ticket);
        } else if (ticket instanceof StandardTicket) {
            finalPrice = standardTicketPrice(ticket);
        } else if (ticket instanceof GiftTicket) {
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

    public static double getFinalPrice() {
        return finalPrice;
    }
}
