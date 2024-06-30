package peaksoft.ekzamtask3etap.ekzam_task.dto.request;

import lombok.Builder;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Customer;
import peaksoft.ekzamtask3etap.ekzam_task.entity.House;

@Builder
public record SaveBookingRequestRd (
        Customer customer,
        House house
){
}
