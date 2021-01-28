package io;

import address.Address;
import calculation.CalcPrice;
import ticketTypes.GiftTicket;
import ticketTypes.OnlineTicket;
import ticketTypes.StandardTicket;
import ticketTypes.Ticket;

import java.util.Locale;
import java.util.Scanner;

public class TicketOrder {
    private Scanner scanner = new Scanner(System.in);
    private static final int ONLINE_OPTION = 1;
    private static final int STANDARD_OPTION = 2;
    private static final int GIFT_OPTION = 3;
    private static final int EXIT = 0;
    private int option;

    public void orderTicket() {
        scanner.useLocale(Locale.US);
        do {
            welcomeMessage();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case ONLINE_OPTION:
                    Ticket online = createTicket();
                    online.printInfo();
                    System.out.println("Ostateczna cena za " + OnlineTicket.ONLINE + " " + CalcPrice.calculatePrice(online));
                    break;
                case STANDARD_OPTION:
                    Ticket standard = createTicket();
                    standard.printInfo();
                    System.out.println("Ostateczna cena za " + StandardTicket.STANDARD + " " + CalcPrice.calculatePrice(standard));
                    break;
                case GIFT_OPTION:
                    Ticket gift = createTicket();
                    gift.printInfo();
                    System.out.println("Ostateczna cena za " + GiftTicket.GIFT + " " + CalcPrice.calculatePrice(gift));
                    break;
                case EXIT:
                    System.out.println("Zrezygnowales z zakupu");
                    break;
                default:
                    System.out.println("Wybrales nieprawidłową opcję");
            }
        } while (option != EXIT);
    }

    private void welcomeMessage() {
        System.out.println("Wybierz jaki rodzaj biletu chcesz zakupic: ");
        System.out.println(ONLINE_OPTION + " jeśli chcesz zakupic " + OnlineTicket.ONLINE);
        System.out.println(STANDARD_OPTION + " jeśli chcesz zakupic " + StandardTicket.STANDARD);
        System.out.println(GIFT_OPTION + " jeśli chcesz zakupic " + GiftTicket.GIFT);
        System.out.println(EXIT + " jeśli chcesz zrezygnować ");
    }

    private Ticket createTicket() {
        System.out.println("Wprowadz dane wydarzenia");
        System.out.println("Podaj miasto: ");
        String city = scanner.nextLine();
        System.out.println("Podaj ulice: ");
        String street = scanner.nextLine();
        System.out.println("Podaj nazwe wydarzenia: ");
        String eventName = scanner.nextLine();
        System.out.println("Podaj cene biletu: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj zniżke w przedziale 0-1: ");
        double discount = scanner.nextDouble();
        scanner.nextLine();
        String ticketType = "";
        switch (option) {
            case ONLINE_OPTION:
                ticketType = OnlineTicket.ONLINE;
                break;
            case STANDARD_OPTION:
                ticketType = StandardTicket.STANDARD;
                break;
            case GIFT_OPTION:
                ticketType = GiftTicket.GIFT;
                break;
        }
        return new Ticket(new Address(city, street), eventName, ticketType, price, discount);
    }
}
