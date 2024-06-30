package peaksoft.ekzamtask3etap.ekzam_task.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveCustomerRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveCustomerResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Customer;
import peaksoft.ekzamtask3etap.ekzam_task.service.CustomerService;
import peaksoft.ekzamtask3etap.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public SimpleResponse saveCustomer(SaveCustomerRequestRd customer) {
        if (customerRepository.existsByEmail(customer.email())) {
            throw new RuntimeException("Customer with the same name already exists");
        }
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.name());
        newCustomer.setSurname(customer.surname());
        newCustomer.setEmail(customer.email());
        newCustomer.setGender(customer.gender());
        newCustomer.setPhoneNumber(customer.phoneNumber());
        newCustomer.setDateOfBirth(customer.dateOfBirth());
        customerRepository.save(newCustomer);
        return new SimpleResponse("Customer saved successfully");
    }

    @Override
    public Optional<SaveCustomerResponseRd> getCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return Optional.ofNullable(SaveCustomerResponseRd.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .gender(customer.getGender())
                .build());
    }
    @Override
    public List<SaveCustomerResponseRd> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<SaveCustomerResponseRd> response = new ArrayList<>();

        for (Customer customer : customers) {
            response.add(new SaveCustomerResponseRd(
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getEmail(),
                    customer.getGender(),
                    customer.getPhoneNumber(),
                    customer.getDateOfBirth()
            ));
        }
        return response;
    }
    @Override
    public SimpleResponse deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            return new SimpleResponse("Customer not found");
        }

        customerRepository.deleteById(id);
        return new SimpleResponse("Customer deleted successfully");
    }

    @Override
    public SimpleResponse updateCustomer(Long id, SaveCustomerRequestRd customerRequestRd) {
        Optional<Customer> customerOpt = customerRepository.findById(id);

        if (customerOpt.isEmpty()) {
            return new SimpleResponse("Customer not found");
        }

        Customer customer = customerOpt.get();
        customer.setName(customerRequestRd.name());
        customer.setSurname(customerRequestRd.surname());
        customer.setEmail(customerRequestRd.email());
        customer.setGender(customerRequestRd.gender());
        customer.setPhoneNumber(customerRequestRd.phoneNumber());
        customer.setDateOfBirth(customerRequestRd.dateOfBirth());
        customerRepository.save(customer);
        return new SimpleResponse("Customer updated successfully");
    }
}
