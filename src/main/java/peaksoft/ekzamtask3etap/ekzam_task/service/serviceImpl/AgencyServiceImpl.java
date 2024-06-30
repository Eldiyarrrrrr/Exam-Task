package peaksoft.ekzamtask3etap.ekzam_task.service.serviceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import peaksoft.ekzamtask3etap.ekzam_task.dto.SimpleResponse;
import peaksoft.ekzamtask3etap.ekzam_task.dto.request.SaveAgencyRequestRd;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd;

import peaksoft.ekzamtask3etap.ekzam_task.entity.Agency;
import peaksoft.ekzamtask3etap.ekzam_task.service.AgencyService;
import peaksoft.ekzamtask3etap.repository.AgencyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    @Override
    public SimpleResponse saveAgency(SaveAgencyRequestRd agency) {
        if (agencyRepository.existsByName(agency.name())) {
            throw new RuntimeException("Agency with the same name already exists");
        }
        Agency agency1 = new Agency();
        agency1.setName(agency.name());
        agency1.setCountry(agency.country());
        agency1.setPhoneNumber(agency.phoneNumber());
        agency1.setEmail(agency.email());
        agencyRepository.save(agency1);
        return new SimpleResponse("Agency saved successfully");
    }


    @Override
    public Optional<SaveAgencyResponseRd> getAgencyById(Long agencyId) {
        return Optional.ofNullable(agencyRepository.getAgencyById(agencyId).orElseThrow(()
                -> new RuntimeException("Not found")));

    }

    @Override
    public List<SaveAgencyResponseRd> getAllAgencies() {
        List<Agency> agencies = agencyRepository.findAll();
        List<SaveAgencyResponseRd> agencyResponseRds = new ArrayList<>();
        for (Agency agency : agencies) {
            agencyResponseRds.add(new SaveAgencyResponseRd(
                    agency.getId(),
                    agency.getName(),
                    agency.getCountry(),
                    agency.getPhoneNumber(),
                    agency.getEmail()
            ));
        }
        return agencyResponseRds;
    }

    @Override
    public SimpleResponse deleteAgency(Long id) {
        if (!agencyRepository.existsById(id)) {
            throw new RuntimeException("Agency not found");
        }
        agencyRepository.deleteById(id);
        return new SimpleResponse("Agency deleted successfully");
    }

    @Override
    public List<SaveAgencyResponseRd> searchAgencies(String name, String country) {
        return agencyRepository.searchAgencies(name,country);
    }

    @Override
    public SimpleResponse updateAgency(Long id, SaveAgencyRequestRd agencyDetails) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found"));

        if (!agency.getName().equals(agencyDetails.name()) && agencyRepository.existsByName(agencyDetails.name())) {
            throw new RuntimeException("Agency with the same name already exists");
        }

        agency.setName(agencyDetails.name());
        agency.setCountry(agencyDetails.country());
        agency.setPhoneNumber(agencyDetails.phoneNumber());
        agency.setEmail(agencyDetails.email());

        agencyRepository.save(agency);
        return new SimpleResponse("Agency updated successfully");
    }
}