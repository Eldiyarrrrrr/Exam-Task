package peaksoft.ekzamtask3etap.ekzam_task.dto.response;

import lombok.Builder;
import peaksoft.ekzamtask3etap.ekzam_task.enams.Gender;

import java.time.LocalDate;

@Builder
public record SaveCustomerResponseRd(
        Long id,
        String name,
        String surname,
        String email,
        Gender gender,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
