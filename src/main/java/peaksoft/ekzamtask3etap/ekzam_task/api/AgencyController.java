package peaksoft.ekzamtask3etap.ekzam_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveAgencyRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.service.AgencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agencies")
@RequiredArgsConstructor
public class AgencyController {
    private final AgencyService agencyService;


    @PostMapping
    public ResponseEntity<SimpleResponse> saveAgency(@RequestBody SaveAgencyRequestRd agency) {
        SimpleResponse response = agencyService.saveAgency(agency);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaveAgencyResponseRd> getAgency(@PathVariable Long id) {
        Optional<SaveAgencyResponseRd> response = agencyService.getAgencyById(id);
        return response
                .map(agency -> new ResponseEntity<>(agency, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<SaveAgencyResponseRd>> getAllAgencies() {
        List<SaveAgencyResponseRd> response = agencyService.getAllAgencies();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleResponse> deleteAgency(@PathVariable Long id) {
        SimpleResponse response = agencyService.deleteAgency(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaveAgencyResponseRd>> searchAgencies(@RequestParam String name, @RequestParam String country) {
        List<SaveAgencyResponseRd> response = agencyService.searchAgencies(name, country);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleResponse> updateAgency(@PathVariable Long id, @RequestBody SaveAgencyRequestRd agencyDetails) {
        SimpleResponse response = agencyService.updateAgency(id, agencyDetails);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


//package peaksoft.ekzamtask3etap.ekzam_task.api;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveAgencyRequestRd;
//import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd;
//import peaksoft.ekzamtask3etap.ekzam_task.service.AgencyService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/agencies")
//public class AgencyController {
//    private AgencyService agencyService;
//
//
//    @GetMapping
//    public List<SaveAgencyResponseRd> getAllAgencies() {
//        return agencyService.getAllAgencies();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<SaveAgencyResponseRd> getAgencyById(@PathVariable Long id) {
//        SaveAgencyResponseRd agency = agencyService.getAgency(id);
//        return ResponseEntity.ok(agency);
//    }
//
//    @PostMapping
//    public ResponseEntity<SimpleResponse> createAgency(@RequestBody SaveAgencyRequestRd agency) {
//        SimpleResponse savedAgency = agencyService.saveAgency(agency);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedAgency);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateAgency(@PathVariable Long id, @RequestBody SaveAgencyRequestRd agencyDetails) {
//        SimpleResponse updatedAgency = agencyService.updateAgency(id, agencyDetails);
//        return ResponseEntity.ok(updatedAgency);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<SimpleResponse> deleteAgency(@PathVariable Long id) {
//        agencyService.deleteAgency(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/search")
//    public List<SaveAgencyResponseRd> searchAgencies(@RequestParam(required = false) String name, @RequestParam(required = false) String country) {
//        return agencyService.searchAgencies(name, country);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<SimpleResponse> updateAgency(@PathVariable Long id, @RequestBody SaveAgencyRequestRd agencyDetails) {
//        SimpleResponse updatedAgency = agencyService.updateAgency(id, agencyDetails);
//        return ResponseEntity.ok(updatedAgency);
//    }
//}
