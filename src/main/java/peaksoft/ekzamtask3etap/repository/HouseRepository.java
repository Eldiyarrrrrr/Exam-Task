package peaksoft.ekzamtask3etap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.ekzamtask3etap.ekzam_task.dto.response.SaveHouseResponseRd;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;
import peaksoft.ekzamtask3etap.ekzam_task.entity.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    List<SaveHouseResponseRd> getHouseByHouseType(HouseType houseType);
}