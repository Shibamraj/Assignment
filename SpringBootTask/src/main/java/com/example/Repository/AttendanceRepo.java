package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.AttendanceEntity;

public interface AttendanceRepo extends JpaRepository<AttendanceEntity, Long> {

}
