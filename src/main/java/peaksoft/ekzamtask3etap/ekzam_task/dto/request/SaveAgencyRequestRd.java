package peaksoft.ekzamtask3etap.ekzam_task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record SaveAgencyRequestRd(
        String name,
        String country,
        String phoneNumber,
        String email
) {


}
