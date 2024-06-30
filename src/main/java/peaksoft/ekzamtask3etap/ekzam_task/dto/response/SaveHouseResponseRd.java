package peaksoft.ekzamtask3etap.ekzam_task.dto.response;

import lombok.Builder;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;

@Builder
public record SaveHouseResponseRd(
        Long id,
        HouseType houseType,
        String address,
        int price,
        int room,
        String country,
        String description,
        String isBooked
) {
}
