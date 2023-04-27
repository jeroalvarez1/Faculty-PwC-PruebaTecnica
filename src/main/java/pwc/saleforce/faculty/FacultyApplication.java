package pwc.saleforce.faculty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pwc.saleforce.faculty.entities.Course;
import pwc.saleforce.faculty.services.CourseService;
import pwc.saleforce.faculty.services.impl.CourseServiceImpl;

@SpringBootApplication
public class FacultyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacultyApplication.class, args);
	}

}
