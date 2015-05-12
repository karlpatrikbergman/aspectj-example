package se.patrikbergman.java.aspectj.advice;

import org.junit.Test;

public class BookingServiceAspectTest {

    @Test
    public void test() {
        BookingService bookingService = new BookingService("Luger");
        Band band = new Band("The Knife");
        bookingService.book(band);
    }
}
