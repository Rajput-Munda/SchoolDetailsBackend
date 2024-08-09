package com.school.details.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.details.Model.SchoolDetails;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface SchoolDetailService {
    public ResponseEntity<List<SchoolDetails>> getAllSchools();
    public ResponseEntity<String> saveSchoolDetails(SchoolDetails s);   
    
}
