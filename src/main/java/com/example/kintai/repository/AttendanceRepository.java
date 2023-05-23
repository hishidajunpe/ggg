package com.example.kintai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintai.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{
	List<Attendance> findAllByDatetimeBetween(LocalDate start, LocalDate end);
}
