// package com.school.details.Controller;
// import java.util.List;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.school.details.Model.SchoolDetails;
// import com.school.details.Service.SchoolDetailService;
// @RestController
// @RequestMapping("/schools")
// @CrossOrigin(origins = "http://localhost:5173/")
// public class SchoolDetailsController {
//     private final SchoolDetailService schoolDetailService;
//     public SchoolDetailsController(SchoolDetailService schoolDetailService) {
//         super();
//         this.schoolDetailService = schoolDetailService;
//     }
//     @GetMapping("/getAllSchools")
//     public ResponseEntity<List<SchoolDetails>> getAllSchools() {
//         return schoolDetailService.getAllSchools();
//     }
//     @PostMapping("/saveSchoolDetails")
//     public ResponseEntity<String> saveSchoolDetails(@RequestBody SchoolDetails s) {
//         return schoolDetailService.saveSchoolDetails(s);
//     }
// }
package com.school.details.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.details.Model.SchoolDetails;
import com.school.details.Service.SchoolDetailService;

@RestController
@RequestMapping("/schools")
@CrossOrigin(origins = "http://localhost:5173/")
public class SchoolDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolDetailsController.class);
    private final SchoolDetailService schoolDetailService;

    public SchoolDetailsController(SchoolDetailService schoolDetailService) {
        this.schoolDetailService = schoolDetailService;
    }

    @GetMapping("/getAllSchools")
    public ResponseEntity<List<SchoolDetails>> getAllSchools() {
        return schoolDetailService.getAllSchools();
    }

    @PostMapping("/saveSchoolDetails")
    public ResponseEntity<?> saveSchoolDetails(@Validated @RequestBody SchoolDetails s) {
        try {
            return schoolDetailService.saveSchoolDetails(s);
        } catch (Exception e) {
            logger.error("Error saving school details: {}", e.getMessage());
            return new ResponseEntity<>("Error saving school details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
