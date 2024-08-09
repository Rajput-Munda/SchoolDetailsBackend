package com.school.details.Service.Impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import com.school.details.Model.SchoolDetails;
// import com.school.details.Service.SchoolDetailService;
// import jakarta.persistence.EntityManager;
// import jakarta.transaction.Transactional;
// @Service
// public class SchoolDetailServiceImpl implements SchoolDetailService {
//     @Autowired
//     private EntityManager entityManager;
//     @Override
//     @Transactional
//     public ResponseEntity<List<SchoolDetails>> getAllSchools() {
//         List<SchoolDetails> list = entityManager.createQuery("select s from SchoolDetails s", SchoolDetails.class)
//                 .getResultList();
//         return new ResponseEntity<>(list, HttpStatus.OK);
//     }
//     @Override
//     @Transactional
//     public ResponseEntity<String> saveSchoolDetails(SchoolDetails s) {
//         entityManager.persist(s);
//         return new ResponseEntity<>("Saved successfully", HttpStatus.OK);
//     }
// }
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.details.Model.SchoolDetails;
import com.school.details.Service.SchoolDetailService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class SchoolDetailServiceImpl implements SchoolDetailService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolDetailServiceImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public ResponseEntity<List<SchoolDetails>> getAllSchools() {
        logger.info("Fetching all schools");
        List<SchoolDetails> list = entityManager.createQuery("select s from SchoolDetails s", SchoolDetails.class)
                .getResultList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // @Override
    // @Transactional
    // public ResponseEntity<String> saveSchoolDetails(SchoolDetails s) {
    //     try {
    //         logger.info("Saving school details: {}", s);
    //         entityManager.persist(s);
    //         logger.info("School details saved successfully");
    //         return new ResponseEntity<>("Saved successfully", HttpStatus.OK);
    //     } catch (Exception e) {
    //         logger.error("Error saving school details", e);
    //         return new ResponseEntity<>("Error saving school details", HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    @Override
    @Transactional
    public ResponseEntity<String> saveSchoolDetails(SchoolDetails s) {
        try {
            entityManager.persist(s);
            return new ResponseEntity<>("Saved successfully", HttpStatus.OK);
        } catch (Exception e) { // Log the exception for further analysis
            // Or use a logger
            // Or use a logger
            return new ResponseEntity<>("Error saving school details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Override
    // public ResponseEntity<String> saveSchoolDetails(SchoolDetails s) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'saveSchoolDetails'");
    // }
}
