package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwc.saleforce.faculty.entities.Section;
import pwc.saleforce.faculty.services.SectionService;

@RestController
@RequestMapping("/api")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @PostMapping("/sections")
    public ResponseEntity<Section> addSection(@RequestBody Section section) {
        try {
            return new ResponseEntity<>(sectionService.addSection(section), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
