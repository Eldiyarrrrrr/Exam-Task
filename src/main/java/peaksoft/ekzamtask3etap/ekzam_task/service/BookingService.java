package peaksoft.ekzamtask3etap.ekzam_task.service;

import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveBookingRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveBookingResponseRd;

import java.util.List;


public interface BookingService {
    SimpleResponse saveBooking(Long customerId, Long houseId);
    List<SaveBookingResponseRd> getAllBookings();
    SimpleResponse deleteBooking(Long id);
    SimpleResponse updateBooking(Long id, SaveBookingRequestRd bookingDetails);

}
