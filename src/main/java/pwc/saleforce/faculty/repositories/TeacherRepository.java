package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
