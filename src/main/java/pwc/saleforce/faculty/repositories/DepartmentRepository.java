package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
