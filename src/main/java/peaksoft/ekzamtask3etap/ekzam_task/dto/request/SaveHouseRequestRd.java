package peaksoft.ekzamtask3etap.ekzam_task.dto.request;

import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;

@Builder
public record SaveHouseRequestRd(
        HouseType houseType,
        String address,
        int price,
        int room,
        String country,
        String description,
        String isBooked

) {
}
