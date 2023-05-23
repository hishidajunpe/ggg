package com.example.kintai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kintai.model.Attendance;
import com.example.kintai.repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	//新規勤怠登録した情報を保存する
	public void createAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}
	
	//保存した勤怠情報の更新
	public void updateAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}
	
	//保存した勤怠の月間テーブルの表示
	public List<Attendance> getAttendanceMonth(Integer mm){
		
		return attendanceRepository.findByMm(mm);
	}
	
}
