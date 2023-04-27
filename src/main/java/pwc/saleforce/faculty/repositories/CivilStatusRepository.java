package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.CivilStatus;

@Repository
public interface CivilStatusRepository extends JpaRepository<CivilStatus, Long> {
}
