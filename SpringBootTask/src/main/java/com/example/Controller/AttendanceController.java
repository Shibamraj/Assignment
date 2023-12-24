package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.AttendanceEntity;
import com.example.Entity.PositionEntity;
import com.example.Repository.AttendanceRepo;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepo arepo;
	
	
	
	@PostMapping("/attendances")
    public ResponseEntity<AttendanceEntity> createAttendance(@RequestBody AttendanceEntity atte){
		AttendanceEntity savedUser = arepo.save(atte);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/attendances")
    public ResponseEntity<List<AttendanceEntity>> getAllAttendance(){
        List<AttendanceEntity> users = arepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@GetMapping("/attendances/{id}")
    public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable Long id){
        Optional<AttendanceEntity> user = arepo.findById(id);
        if(user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PutMapping("/attendance/{id}")
    public ResponseEntity<AttendanceEntity> updateAttendance(@PathVariable("id") Long id,
                                           @RequestBody AttendanceEntity u){
	 Optional<AttendanceEntity> user = arepo.findById(id);
         if(user.isPresent()) {
	 
         return new ResponseEntity<>(arepo.save(user.get()), HttpStatus.OK);
         }
         else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
	
	
	
	@DeleteMapping("/attendances/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable("id") Long id){
	 Optional<AttendanceEntity> user = arepo.findById(id);
	 if(user.isPresent()) {
		 arepo.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
    }

}
