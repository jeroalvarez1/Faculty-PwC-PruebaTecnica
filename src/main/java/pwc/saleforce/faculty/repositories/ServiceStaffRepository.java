package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.ServiceStaff;

@Repository
public interface ServiceStaffRepository extends JpaRepository<ServiceStaff, Long> {
}
