package se.patrikbergman.java.aspectj.advice;

class BookingService {
    public final String name;

    public BookingService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void book(Band band) {
        System.out.printf("BookingService %s successfully booked band %s\n", this.name, band.getName());
    }
}
