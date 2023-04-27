package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.CivilStatus;
import pwc.saleforce.faculty.entities.Person;

public interface PersonService {

    Person changeCivilStatus(long person_id, long civilStatus_id) throws Exception;
    Person getPerson(long person_id) throws Exception;


}
