package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwc.saleforce.faculty.entities.CivilStatus;
import pwc.saleforce.faculty.services.CivilStatusService;

@RestController
@RequestMapping("/api")
public class CivilStatusController {

    @Autowired
    CivilStatusService civilStatusService;

    @PostMapping("/civilstatus")
    public ResponseEntity<CivilStatus> addCivilStatus(@RequestBody CivilStatus civilStatus) {
        try {
            return new ResponseEntity<>(civilStatusService.addCivilStatus(civilStatus), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
