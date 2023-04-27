package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.CivilStatus;
import pwc.saleforce.faculty.repositories.CivilStatusRepository;
import pwc.saleforce.faculty.services.CivilStatusService;

@Service
public class CivilStatusServiceImpl implements CivilStatusService {

    @Autowired
    CivilStatusRepository civilStatusRepository;
    @Override
    public CivilStatus getCivilStatus(long civilStatus_id) throws Exception {
        return civilStatusRepository.findById(civilStatus_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso"));
    }

    @Override
    public CivilStatus addCivilStatus(CivilStatus civilStatus) throws Exception {
        try {
            return civilStatusRepository.save(civilStatus);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }


}
