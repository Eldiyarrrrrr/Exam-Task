package peaksoft.ekzamtask3etap.ekzam_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveCustomerRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveCustomerResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<SimpleResponse> saveCustomer(@RequestBody SaveCustomerRequestRd customer) {
        SimpleResponse response = customerService.saveCustomer(customer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaveCustomerResponseRd> getCustomer(@PathVariable Long id) {
        Optional<SaveCustomerResponseRd> response = customerService.getCustomer(id);
        return response
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<SaveCustomerResponseRd>> getAllCustomers() {
        List<SaveCustomerResponseRd> response = customerService.getAllCustomers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleResponse> deleteCustomer(@PathVariable Long id) {
        SimpleResponse response = customerService.deleteCustomer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleResponse> updateCustomer(@PathVariable Long id, @RequestBody SaveCustomerRequestRd customerDetails) {
        SimpleResponse response = customerService.updateCustomer(id, customerDetails);
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
//import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveAgencyRequestRd;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveCustomerRequestRd;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveCustomerResponseRd;
//import peaksoft.ekzamtask3etap.ekzam_task.service.CustomerService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/customers")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping
//    public List<SaveCustomerResponseRd> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<SaveCustomerResponseRd> getCustomerById(@PathVariable Long id) {
//        SaveCustomerResponseRd customer = customerService.getCustomer(id);
//        return ResponseEntity.ok(customer);
//    }
//
//    @PostMapping
//    public ResponseEntity<SimpleResponse> createCustomer(@RequestBody SaveCustomerRequestRd customer) {
//        SimpleResponse savedCustomer = customerService.saveCustomer(customer);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateCustomer(@PathVariable Long id, @RequestBody SaveCustomerRequestRd customerDetails) {
//        SimpleResponse updatedCustomer = customerService.updateCustomer(id, customerDetails);
//        return ResponseEntity.ok(updatedCustomer);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
//        customerService.deleteCustomer(id);
//        return ResponseEntity.noContent().build();
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateCustomer(@PathVariable Long id, @RequestBody SaveCustomerRequestRd bookingDetails) {
//        SimpleResponse updatedCustomer = customerService.updateCustomer(id, bookingDetails);
//        return ResponseEntity.ok(updatedCustomer);
////         public ResponseEntity<SimpleResponse> updateBooking(@PathVariable Long id, @RequestBody SaveBookingRequestRd bookingDetails) {
////        SimpleResponse updatedBooking = bookingService.updateBooking(id, bookingDetails);
////        return ResponseEntity.ok(updatedBooking);
//    }
//}
