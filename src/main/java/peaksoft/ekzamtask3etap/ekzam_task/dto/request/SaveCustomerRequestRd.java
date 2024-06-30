package peaksoft.ekzamtask3etap.ekzam_task.dto.request;

import lombok.Builder;
import peaksoft.ekzamtask3etap.ekzam_task.enams.Gender;

import java.time.LocalDate;

@Builder
public record SaveCustomerRequestRd(
        String name,
        String surname,
        String email,
        Gender gender,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
