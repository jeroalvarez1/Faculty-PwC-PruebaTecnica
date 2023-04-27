package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwc.saleforce.faculty.entities.ServiceStaff;
import pwc.saleforce.faculty.services.ServiceStaffService;

@RestController
@RequestMapping("/api")
public class ServiceStaffController {

    @Autowired
    ServiceStaffService serviceStaffService;

    @GetMapping("/services/{serviceStaff_id}/changesection/{section_id}")
    public ResponseEntity<ServiceStaff> changeServiceStaffOfSection(@PathVariable long serviceStaff_id, @PathVariable long section_id) throws Exception {
        try {
            return new ResponseEntity<>(serviceStaffService.changeServiceStaffOfSection(section_id, serviceStaff_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/services")
    public ResponseEntity<ServiceStaff> addServiceStaff(@RequestBody ServiceStaff serviceStaff) {
        try {
            return new ResponseEntity<>(serviceStaffService.addServiceStaff(serviceStaff), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
