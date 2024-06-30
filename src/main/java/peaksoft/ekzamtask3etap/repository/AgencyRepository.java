package peaksoft.ekzamtask3etap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.entity.Agency;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    boolean existsByName(String name);


    @Query("select new peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd(" +
            "a.id," +
            "a.name," +
            "a.country," +
            "a.phoneNumber," +
            "a.email) from Agency a where a.name = ?1 and a.country = ?2")
    List<SaveAgencyResponseRd> searchAgencies(String name, String country);

    @Query("select new peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveAgencyResponseRd(" +
            "a.id," +
            "a.name," +
            "a.country," +
            "a.phoneNumber," +
            "a.email) from Agency a where a.id =?1")
    Optional<SaveAgencyResponseRd> getAgencyById(Long agencyId);
}