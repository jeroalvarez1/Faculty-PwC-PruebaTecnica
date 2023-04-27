package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}