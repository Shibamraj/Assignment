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

import com.example.Entity.DepartmentEntity;
import com.example.Entity.SalaryEntity;
import com.example.Repository.SalaryRepo;

@RestController
@RequestMapping("/api")
public class SalaryController {
 
	
	@Autowired
	private SalaryRepo srepo;
	
	
	@PostMapping("/salaries")
    public ResponseEntity<SalaryEntity> createSalary(@RequestBody SalaryEntity salary){
        SalaryEntity savedUser = srepo.save(salary);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	@GetMapping("/salaries")
    public ResponseEntity<List<SalaryEntity>> getAllSalary(){
        List<SalaryEntity> users = srepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@GetMapping("/salaries/{id}")
    public ResponseEntity<SalaryEntity> getSalaryById(@PathVariable Long id){
        Optional<SalaryEntity> user = srepo.findById(id);
        if(user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PutMapping("/salaries/{id}")
    public ResponseEntity<SalaryEntity> updateSalary(@PathVariable("id") Long id,
                                           @RequestBody SalaryEntity u){
	 Optional<SalaryEntity> user = srepo.findById(id);
         if(user.isPresent()) {
	 
         return new ResponseEntity<>(srepo.save(user.get()), HttpStatus.OK);
         }
         else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
	
	
	
	@DeleteMapping("/Salaries/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable("id") Long id){
	 Optional<SalaryEntity> user = srepo.findById(id);
	 if(user.isPresent()) {
		 srepo.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
    }
	
	
}
