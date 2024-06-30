package peaksoft.ekzamtask3etap.ekzam_task.dto.response;

import lombok.Builder;

@Builder
public record SaveAgencyResponseRd(
        Long id,
        String name,
        String country,
        String phoneNumber,
        String email
) {
}
