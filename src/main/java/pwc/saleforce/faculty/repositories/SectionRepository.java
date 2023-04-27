package pwc.saleforce.faculty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwc.saleforce.faculty.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
