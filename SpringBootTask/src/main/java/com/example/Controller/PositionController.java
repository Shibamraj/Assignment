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
import com.example.Entity.PositionEntity;
import com.example.Repository.PositionRepo;

@RestController
@RequestMapping("/api")
public class PositionController {

	@Autowired
	private PositionRepo prepo;
	
	
	@PostMapping("/position")
    public ResponseEntity<PositionEntity> createPosition(@RequestBody PositionEntity pos){
        PositionEntity savedUser = prepo.save(pos);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/position")
    public ResponseEntity<List<PositionEntity>> getAllPositipon(){
        List<PositionEntity> users = prepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@GetMapping("/position/{id}")
    public ResponseEntity<PositionEntity> getPositionById(@PathVariable Long id){
        Optional<PositionEntity> user = prepo.findById(id);
        if(user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PutMapping("/departments/{id}")
    public ResponseEntity<PositionEntity> updatePosition(@PathVariable("id") Long id,
                                           @RequestBody PositionEntity u){
	 Optional<PositionEntity> user = prepo.findById(id);
         if(user.isPresent()) {
	 
         return new ResponseEntity<>(prepo.save(user.get()), HttpStatus.OK);
         }
         else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
	
	
	
	@DeleteMapping("/position/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable("id") Long id){
	 Optional<PositionEntity> user = prepo.findById(id);
	 if(user.isPresent()) {
		 prepo.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
    }
	
	
	
	
	
	
}
