package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwc.saleforce.faculty.entities.Person;
import pwc.saleforce.faculty.services.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons/{person_id}/changestatus/{status_id}")
    public ResponseEntity<Person> changeCivilStatus(@PathVariable long person_id, @PathVariable long status_id ) throws Exception {
        try {
            return new ResponseEntity<>(personService.changeCivilStatus(person_id, status_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
