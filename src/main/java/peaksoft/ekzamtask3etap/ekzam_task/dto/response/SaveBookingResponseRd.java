package peaksoft.ekzamtask3etap.ekzam_task.dto.response;

import lombok.Builder;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Customer;
import peaksoft.ekzamtask3etap.ekzam_task.entity.House;

@Builder
public record SaveBookingResponseRd(
        Long id,
        Customer customer,
        House house
) {
}
