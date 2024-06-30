package peaksoft.ekzamtask3etap.ekzam_task.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveHouseRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveHouseResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Agency;
import peaksoft.ekzamtask3etap.ekzam_task.entity.House;
import peaksoft.ekzamtask3etap.ekzam_task.service.HouseService;
import peaksoft.ekzamtask3etap.repository.AgencyRepository;
import peaksoft.ekzamtask3etap.repository.HouseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final AgencyRepository agencyRepository;

    public SimpleResponse saveHouse(Long agencyId, SaveHouseRequestRd house) {
        Optional<Agency> agencyOpt = agencyRepository.findById(agencyId);

        if (agencyOpt.isEmpty()) {
            return new SimpleResponse("Agency not found");
        }

        House newHouse = new House();
        newHouse.setAddress(house.address());
        newHouse.setRoom(house.room());
        newHouse.setPrice(house.price());
        newHouse.setHouseType(house.houseType());
        newHouse.setCountry(house.country());
        newHouse.setDescription(house.description());
        newHouse.setIsBooked(house.isBooked());

        houseRepository.save(newHouse);
        return new SimpleResponse("House saved successfully");
    }

    public Optional<SaveHouseResponseRd> getHouse(Long id) {
        House houseOpt = houseRepository.findById(id).orElseThrow(()
                -> new RuntimeException("House not found"));

        return Optional.ofNullable(SaveHouseResponseRd.builder()
                .id(houseOpt.getId())
                .houseType(houseOpt.getHouseType())
                .address(houseOpt.getAddress())
                .price(houseOpt.getPrice())
                .room(houseOpt.getRoom())
                .country(houseOpt.getCountry())
                .description(houseOpt.getDescription())
                .isBooked(houseOpt.getIsBooked())
                .build());
    }

    public List<SaveHouseResponseRd> getAllHouses() {
        List<House> houses = houseRepository.findAll();
        List<SaveHouseResponseRd> response = new ArrayList<>();

        for (House house : houses) {
            response.add(new SaveHouseResponseRd(
                    house.getId(),
                    house.getHouseType(),
                    house.getAddress(),
                    house.getPrice(),
                    house.getRoom(),
                    house.getCountry(),
                    house.getDescription(),
                    house.getIsBooked()
            ));
        }
        return response;
    }

    public SimpleResponse deleteHouse(Long id) {
        if (!houseRepository.existsById(id)) {
            return new SimpleResponse("House not found");
        }

        houseRepository.deleteById(id);
        return new SimpleResponse("House deleted successfully");
    }

    public List<SaveHouseResponseRd> getHousesByType(HouseType houseType) {
        List<SaveHouseResponseRd> houses = houseRepository.getHouseByHouseType(houseType);
        List<SaveHouseResponseRd> response = new ArrayList<>();

        for (SaveHouseResponseRd house : houses) {
            SaveHouseResponseRd responseRd = new SaveHouseResponseRd(
                    house.id(),
                    house.houseType(),
                    house.address(),
                    house.price(),
                    house.room(),
                    house.country(),
                    house.description(),
                    house.isBooked()
            );
            response.add(responseRd);
        }

        return response;
    }

    public SimpleResponse updateHouse(Long id, SaveHouseRequestRd houseDetails) {
        House houseOpt = houseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found"));

        houseOpt.setAddress(houseDetails.address());
        houseOpt.setRoom(houseDetails.room());
        houseOpt.setPrice(houseDetails.price());
        houseOpt.setHouseType(houseDetails.houseType());

        houseRepository.save(houseOpt);
        return new SimpleResponse("House updated successfully");
    }
}
