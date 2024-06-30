package peaksoft.ekzamtask3etap.ekzam_task.service;

import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveHouseRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveHouseResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    SimpleResponse saveHouse(Long agencyId, SaveHouseRequestRd house);
    Optional<SaveHouseResponseRd> getHouse(Long id);
    List<SaveHouseResponseRd> getAllHouses();
    SimpleResponse deleteHouse(Long id);
    List<SaveHouseResponseRd> getHousesByType(HouseType houseType);
    SimpleResponse updateHouse(Long id, SaveHouseRequestRd houseDetails);
}
