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

import com.example.Entity.EmployeeEntity;
import com.example.Entity.PositionEntity;
import com.example.Repository.EmployeeRepo;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepo erepo;
	
	
	@PostMapping("/employee")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity emp){
        EmployeeEntity savedUser = erepo.save(emp);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/employee")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
        List<EmployeeEntity> users = erepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        Optional<EmployeeEntity> user = erepo.findById(id);
        if(user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") Long id,
                                           @RequestBody EmployeeEntity u){
	 Optional<EmployeeEntity> user = erepo.findById(id);
         if(user.isPresent()) {
	 
         return new ResponseEntity<>(erepo.save(user.get()), HttpStatus.OK);
         }
         else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
	
	
	
	@DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
	 Optional<EmployeeEntity> user = erepo.findById(id);
	 if(user.isPresent()) {
		 erepo.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
    }
	
	
	

}
