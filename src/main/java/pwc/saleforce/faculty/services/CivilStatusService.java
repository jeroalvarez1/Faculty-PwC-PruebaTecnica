package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.CivilStatus;

public interface CivilStatusService {

    CivilStatus getCivilStatus(long civilStatus_id) throws Exception;

    CivilStatus addCivilStatus(CivilStatus civilStatus) throws Exception;

}
