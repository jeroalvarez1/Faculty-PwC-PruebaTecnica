package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.CivilStatus;
import pwc.saleforce.faculty.entities.Person;
import pwc.saleforce.faculty.repositories.CivilStatusRepository;
import pwc.saleforce.faculty.repositories.PersonRepository;
import pwc.saleforce.faculty.services.CivilStatusService;
import pwc.saleforce.faculty.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CivilStatusService civilStatusService;

    @Override
    public Person changeCivilStatus(long person_id, long civilStatus_id) throws Exception {
        Person person = null;
        CivilStatus civilStatus = null;
        try {
            person = getPerson(person_id);
            civilStatus = civilStatusService.getCivilStatus(civilStatus_id);
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener el recurso -> " + e);
        }
        try {
            person.setCivilStatus(civilStatus);
            return personRepository.save(person);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }

    }

    @Override
    public Person getPerson(long person_id) throws Exception {
        return personRepository.findById(person_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso"));
    }
}
