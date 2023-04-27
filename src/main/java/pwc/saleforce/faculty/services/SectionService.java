package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.Section;

public interface SectionService {

    Section getSection(long section_id) throws Exception;

    Section addSection(Section section) throws Exception;

}
