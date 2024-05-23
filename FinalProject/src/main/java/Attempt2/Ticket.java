package Attempt2;

public abstract class Ticket implements Entity{
    public static final int ECONOMY_TICKET_PRICE = 300;
    public static final int BUSINESS_TICKET_PRICE = 600;
    public static final int FIRST_CLASS_TICKET_PRICE = 1000;

    private int price;
    private String origin;
    private String destination;
    private String seatSize;
    private String ticketNumber;
    private String userName;
    private String password;
    private String ticketFlightNumber;

    public String getTicketFlightNumber() {
        return ticketFlightNumber;
    }

    public void setTicketFlightNumber(String ticketFlightNumber) {
        this.ticketFlightNumber = ticketFlightNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSeatSize() {
        return seatSize;
    }

    public void setSeatSize(String seatSize) {
        this.seatSize = seatSize;
    }

    public Ticket(int price, String origin, String destination, String ticketNumber, String userName, String password, String ticketFlightNumber) {
        this.price = price;
        this.origin = origin;
        this.destination = destination;
        this.seatSize = "Default";
        this.ticketNumber = ticketNumber;
        this.userName = userName;
        this.password = password;
        this.ticketFlightNumber = ticketFlightNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    @Override
    public String returnInfo() {
        return ticketNumber;
    }
}

class economyTicket extends Ticket {

    public economyTicket( String origin, String destination, String ticketNumber,String userName, String password, String ticketFlightNumber) {
        super(ECONOMY_TICKET_PRICE, origin, destination, ticketNumber, userName, password, ticketFlightNumber);
        super.setSeatSize("small");
    }

    public String returnInfo(String ticketNumber) {
        return ticketNumber;
    }
}

class expensiveTicket extends Ticket {
    public expensiveTicket(int price, String origin, String destination, String ticketNumber, String userName, String password, String ticketFlightNumber) {
        super(price, origin, destination, ticketNumber, userName, password, ticketFlightNumber);
    }
}

class businessTicket extends expensiveTicket implements Cancellable{
    public businessTicket( String origin, String destination, String ticketNumber, String userName, String password, String ticketFlightNumber) {
        super(BUSINESS_TICKET_PRICE, origin, destination, ticketNumber,userName, password, ticketFlightNumber);
        super.setSeatSize("medium");
    }

    public String returnInfo(String ticketNumber) {
        return ticketNumber;
    }

    @Override
    public boolean toCancel() {
        return true;
    }
}

class firstClassTicket extends expensiveTicket implements Cancellable{
    public firstClassTicket( String origin, String destination, String ticketNumber, String userName, String password, String ticketFlightNumber) {
        super(FIRST_CLASS_TICKET_PRICE, origin, destination, ticketNumber, userName, password, ticketFlightNumber);
        super.setSeatSize("large");
    }

    public String returnInfo(String ticketNumber) {
        return ticketNumber;
    }

    @Override
    public boolean toCancel() {
        return true;
    }
}
