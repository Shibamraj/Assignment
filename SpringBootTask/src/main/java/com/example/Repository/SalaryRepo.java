package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.SalaryEntity;

public interface SalaryRepo extends JpaRepository<SalaryEntity, Long> {

}
