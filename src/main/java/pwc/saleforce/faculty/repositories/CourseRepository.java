package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
