package pwc.saleforce.faculty.services;


import pwc.saleforce.faculty.entities.ServiceStaff;

public interface ServiceStaffService {

    ServiceStaff getServiceStaff(long service_id) throws Exception;

    ServiceStaff changeServiceStaffOfSection(long section_id, long serviceStaff_id) throws Exception;

    ServiceStaff addServiceStaff(ServiceStaff serviceStaff) throws Exception;


}
