package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.Section;
import pwc.saleforce.faculty.entities.ServiceStaff;
import pwc.saleforce.faculty.repositories.ServiceStaffRepository;
import pwc.saleforce.faculty.services.SectionService;
import pwc.saleforce.faculty.services.ServiceStaffService;

@Service
public class ServiceStaffServiceImpl implements ServiceStaffService {

    @Autowired
    ServiceStaffRepository serviceStaffRepository;

    @Autowired
    SectionService sectionService;

    @Override
    public ServiceStaff getServiceStaff(long service_id) throws Exception {
        return serviceStaffRepository.findById(service_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso"));
    }

    @Override
    public ServiceStaff changeServiceStaffOfSection(long section_id, long serviceStaff_id) throws Exception {
        ServiceStaff serviceStaff = null;
        Section section = null;
        try {
            serviceStaff = getServiceStaff(serviceStaff_id);
            section = sectionService.getSection(section_id);
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener recurso" + e);
        }
        try {
            serviceStaff.setSection(section);
            return serviceStaffRepository.save(serviceStaff);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar recurso" + e);
        }
    }

    @Override
    public ServiceStaff addServiceStaff(ServiceStaff serviceStaff) throws Exception {
        try {
            return serviceStaffRepository.save(serviceStaff);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }


}
