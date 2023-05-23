package com.example.kintai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintai.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{
	
	//指定された〇月の勤怠保存データと現在の日時データを取得
	List<Attendance> findAllByMm(Integer mm);
}
