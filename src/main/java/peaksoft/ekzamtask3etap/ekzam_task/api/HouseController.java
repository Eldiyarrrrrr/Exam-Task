package peaksoft.ekzamtask3etap.ekzam_task.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveHouseRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveHouseResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;
import peaksoft.ekzamtask3etap.ekzam_task.service.HouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/{agencyId}")
    public ResponseEntity<SimpleResponse> saveHouse(@PathVariable Long agencyId, @RequestBody SaveHouseRequestRd house) {
        SimpleResponse response = houseService.saveHouse(agencyId, house);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaveHouseResponseRd> getHouse(@PathVariable Long id) {
        Optional<SaveHouseResponseRd> response = houseService.getHouse(id);
        return response
                .map(house -> new ResponseEntity<>(house, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public ResponseEntity<List<SaveHouseResponseRd>> getAllHouses() {
        List<SaveHouseResponseRd> response = houseService.getAllHouses();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleResponse> deleteHouse(@PathVariable Long id) {
        SimpleResponse response = houseService.deleteHouse(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/type/{houseType}")
    public ResponseEntity<List<SaveHouseResponseRd>> getHousesByType(@PathVariable HouseType houseType) {
        List<SaveHouseResponseRd> response = houseService.getHousesByType(houseType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleResponse> updateHouse(@PathVariable Long id, @RequestBody SaveHouseRequestRd houseDetails) {
        SimpleResponse response = houseService.updateHouse(id, houseDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


//package peaksoft.ekzamtask3etap.ekzam_task.api;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveHouseRequestRd;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveHouseResponseRd;
//import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;
//import peaksoft.ekzamtask3etap.ekzam_task.entity.House;
//import peaksoft.ekzamtask3etap.ekzam_task.service.HouseService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/houses")
//public class HouseController {
//    private HouseService houseService;
//
//    @GetMapping
//    public List<SaveHouseResponseRd> getAllHouses() {
//        return houseService.getAllHouses();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<SaveHouseResponseRd> getHouseById(@PathVariable Long id) {
//        SaveHouseResponseRd house = houseService.getHouse(id);
//        return ResponseEntity.ok(house);
//    }
//
//    @PostMapping("/agency/{agencyId}")
//    public ResponseEntity<SimpleResponse> createHouse(@PathVariable Long agencyId, @RequestBody SaveHouseRequestRd house) {
//        SimpleResponse savedHouse = houseService.saveHouse(agencyId, house);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedHouse);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateHouse(@PathVariable Long id, @RequestBody SaveHouseRequestRd houseDetails) {
//        SimpleResponse updatedHouse = houseService.updateHouse(id, houseDetails);
//        return ResponseEntity.ok(updatedHouse);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
//        houseService.deleteHouse(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/type")
//    public List<SaveHouseResponseRd> getHousesByType(@RequestParam HouseType houseType) {
//        return houseService.getHousesByType(houseType);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateHouse(
//            @PathVariable Long id,
//            @RequestBody SaveHouseRequestRd houseDetails) {
//        try {
//            SimpleResponse updatedHouse = houseService.updateHouse(id, houseDetails);
//            return ResponseEntity.ok(updatedHouse);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new SimpleResponse("House not found"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new SimpleResponse("An error occurred while updating the house"));
//        }
//    }
//}
