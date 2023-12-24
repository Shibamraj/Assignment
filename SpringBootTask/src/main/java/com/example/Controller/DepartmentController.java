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
import com.example.Repository.DepartmentRepo;



@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentRepo deptrepo;
	
	@PostMapping("/departments")
    public ResponseEntity<DepartmentEntity> createUser(@RequestBody DepartmentEntity dept){
        DepartmentEntity savedUser = deptrepo.save(dept);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	@GetMapping("/departments")
    public ResponseEntity<List<DepartmentEntity>> getAllUsers(){
        List<DepartmentEntity> users = deptrepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentEntity> getUserById(@PathVariable Long id){
        Optional<DepartmentEntity> user = deptrepo.findById(id);
        if(user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentEntity> updateUser(@PathVariable("id") Long id,
                                           @RequestBody DepartmentEntity u){
	 Optional<DepartmentEntity> user = deptrepo.findById(id);
         if(user.isPresent()) {
	 
         return new ResponseEntity<>(deptrepo.save(user.get()), HttpStatus.OK);
         }
         else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
	
	
	
	@DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
	 Optional<DepartmentEntity> user = deptrepo.findById(id);
	 if(user.isPresent()) {
		 deptrepo.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
    }
	
}
