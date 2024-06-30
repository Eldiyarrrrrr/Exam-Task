package peaksoft.ekzamtask3etap.ekzam_task.service;

import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveAgencyRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd;

import java.util.List;
import java.util.Optional;

public interface AgencyService {
    SimpleResponse saveAgency(SaveAgencyRequestRd agency);
    Optional<SaveAgencyResponseRd> getAgencyById(Long agencyId);
    List<SaveAgencyResponseRd> getAllAgencies();
    SimpleResponse deleteAgency(Long id);
    List<SaveAgencyResponseRd> searchAgencies(String name, String country);
    SimpleResponse updateAgency(Long id, SaveAgencyRequestRd agencyDetails);
}
