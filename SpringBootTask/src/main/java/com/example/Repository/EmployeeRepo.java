package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {

}
