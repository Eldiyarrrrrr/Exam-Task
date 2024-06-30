package peaksoft.ekzamtask3etap.ekzam_task.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveBookingRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveBookingResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Booking;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Customer;
import peaksoft.ekzamtask3etap.ekzam_task.entity.House;
import peaksoft.ekzamtask3etap.ekzam_task.service.BookingService;
import peaksoft.ekzamtask3etap.repository.BookingRepository;
import peaksoft.ekzamtask3etap.repository.CustomerRepository;
import peaksoft.ekzamtask3etap.repository.HouseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final CustomerRepository customerRepository;

    private final HouseRepository houseRepository;

    @Override
    public SimpleResponse saveBooking(Long customerId, Long houseId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        Optional<House> houseOpt = houseRepository.findById(houseId);

        if (customerOpt.isEmpty() || houseOpt.isEmpty()) {
            return new SimpleResponse("Customer or House not found");
        }

        Booking booking = new Booking();
        booking.setCustomer(customerOpt.get());
        booking.setHouse(houseOpt.get());
        bookingRepository.save(booking);
        return new SimpleResponse("Booking saved successfully");
    }

    @Override
    public List<SaveBookingResponseRd> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<SaveBookingResponseRd> response = new ArrayList<>();

        for (Booking booking : bookings) {
            response.add(new SaveBookingResponseRd(
                    booking.getId(),
                    booking.getCustomer(),
                    booking.getHouse()
            ));
        }

        return response;
    }
    @Override
    public SimpleResponse deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            return new SimpleResponse("Booking not found");
        }

        bookingRepository.deleteById(id);
        return new SimpleResponse("Booking deleted successfully");
    }
    @Override
    public SimpleResponse updateBooking(Long id, SaveBookingRequestRd bookingDetails) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        Optional<Customer> customerOpt = customerRepository.findById(bookingDetails.customer().getId());
        Optional<House> houseOpt = houseRepository.findById(bookingDetails.house().getId());

        if (bookingOpt.isEmpty() || customerOpt.isEmpty() || houseOpt.isEmpty()) {
            return new SimpleResponse("Booking, Customer or House not found");
        }

        Booking booking = bookingOpt.get();
        booking.setCustomer(customerOpt.get());
        booking.setHouse(houseOpt.get());

        bookingRepository.save(booking);
        return new SimpleResponse("Booking updated successfully");
    }
}
