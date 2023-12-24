package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.DepartmentEntity;



public interface DepartmentRepo extends JpaRepository<DepartmentEntity,Long> {

}
