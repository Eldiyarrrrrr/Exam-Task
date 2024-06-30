package peaksoft.ekzamtask3etap.ekzam_task.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveBookingRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveBookingResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<SimpleResponse> saveBooking(@RequestParam Long customerId, @RequestParam Long houseId) {
        SimpleResponse response = bookingService.saveBooking(customerId, houseId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SaveBookingResponseRd>> getAllBookings() {
        List<SaveBookingResponseRd> response = bookingService.getAllBookings();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleResponse> deleteBooking(@PathVariable Long id) {
        SimpleResponse response = bookingService.deleteBooking(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleResponse> updateBooking(@PathVariable Long id, @RequestBody SaveBookingRequestRd bookingDetails) {
        SimpleResponse response = bookingService.updateBooking(id, bookingDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


//package peaksoft.ekzamtask3etap.ekzam_task.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveBookingRequestRd;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveBookingResponseRd;
//import peaksoft.ekzamtask3etap.ekzam_task.service.BookingService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @GetMapping
//    public List<SaveBookingResponseRd> getAllBookings() {
//        return bookingService.getAllBookings();
//    }
//
//    @PostMapping
//    public ResponseEntity<SimpleResponse> createBooking(@RequestParam Long customerId, @RequestParam Long houseId) {
//        SimpleResponse savedBooking = bookingService.saveBooking(customerId, houseId);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
//        bookingService.deleteBooking(id);
//        return ResponseEntity.noContent().build();
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateBooking(@PathVariable Long id, @RequestBody SaveBookingRequestRd bookingDetails) {
//        SimpleResponse updatedBooking = bookingService.updateBooking(id, bookingDetails);
//        return ResponseEntity.ok(updatedBooking);
//    }
//}
