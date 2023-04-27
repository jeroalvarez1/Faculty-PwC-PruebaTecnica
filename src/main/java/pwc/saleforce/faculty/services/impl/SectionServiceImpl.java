package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.Section;
import pwc.saleforce.faculty.repositories.SectionRepository;
import pwc.saleforce.faculty.services.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Override
    public Section getSection(long section_id) throws Exception {
        return sectionRepository.findById(section_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso"));
    }

    @Override
    public Section addSection(Section section) throws Exception {
        try {
            return sectionRepository.save(section);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

}
