package io;

import Address.Address;
import Calculation.CalcPrice;
import TicketTypes.GiftTicket;
import TicketTypes.OnlineTicket;
import TicketTypes.StandardTicket;
import TicketTypes.Ticket;

import java.util.Locale;
import java.util.Scanner;

public class TicketOrder {
    private Address address;
    private Ticket ticket;
    private Scanner scanner = new Scanner(System.in);
    private static final int ONLINE_OPTION = 1;
    private static final int STANDARD_OPTION = 2;
    private static final int GIFT_OPTION = 3;
    private static final int EXIT = 0;

    public void orderTicket() {
        scanner.useLocale(Locale.US);
        int option;
        do {
            welcomeMessage();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case ONLINE_OPTION:
                    createTicket();
                    OnlineTicket onlineTicket = new OnlineTicket(address, ticket.getEventName(), ticket.getBasePrice(),
                            ticket.getDiscount());
                    onlineTicket.printInfo();
                    CalcPrice.calculatePrice(onlineTicket);
                    System.out.println("Ostateczna cena za " + OnlineTicket.getONLINE() + " " +
                            CalcPrice.getFinalPrice());
                    break;
                case STANDARD_OPTION:
                    createTicket();
                    StandardTicket standardTicket = new StandardTicket(address, ticket.getEventName(),
                            ticket.getBasePrice(), ticket.getDiscount());
                    standardTicket.printInfo();
                    CalcPrice.calculatePrice(standardTicket);
                    System.out.println("Ostateczna cena za " + StandardTicket.getSTANDARD() + " " +
                            CalcPrice.getFinalPrice());
                    break;
                case GIFT_OPTION:
                    createTicket();
                    GiftTicket giftTicket = new GiftTicket(address, ticket.getEventName(), ticket.getBasePrice(),
                            ticket.getDiscount());
                    giftTicket.printInfo();
                    CalcPrice.calculatePrice(giftTicket);
                    System.out.println("Ostateczna cena za " + GiftTicket.getGIFT() + " " + CalcPrice.getFinalPrice());
                    break;
                case EXIT:
                    System.out.println("Zrezygnowałes z zakupu biletu");
                    break;
                default:
                    System.out.println("Wybrałeś nieprawidłową opcje, spróbój jeszcze raz");
            }
        } while (option != EXIT);
    }

    private void welcomeMessage() {
        System.out.println("Wybierz jaki rodzaj biletu chcesz zakupic: ");
        System.out.println(ONLINE_OPTION + " jeśli chcesz zakupic " + OnlineTicket.getONLINE());
        System.out.println(STANDARD_OPTION + " jeśli chcesz zakupic " + StandardTicket.getSTANDARD());
        System.out.println(GIFT_OPTION + " jeśli chcesz zakupic " + GiftTicket.getGIFT());
        System.out.println(EXIT + " jeśli chcesz zrezygnować ");
    }

    private void createTicket() {
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
        address = new Address(city, street);
        ticket = new Ticket(address, eventName, price, discount);
    }
}
