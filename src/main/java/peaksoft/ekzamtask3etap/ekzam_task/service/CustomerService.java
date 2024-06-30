package peaksoft.ekzamtask3etap.ekzam_task.service;

import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveCustomerRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveCustomerResponseRd;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    SimpleResponse saveCustomer(SaveCustomerRequestRd customer);
    Optional<SaveCustomerResponseRd> getCustomer(Long id);
    List<SaveCustomerResponseRd> getAllCustomers();
    SimpleResponse deleteCustomer(Long id);
    SimpleResponse updateCustomer(Long id, SaveCustomerRequestRd customerDetails);
}
