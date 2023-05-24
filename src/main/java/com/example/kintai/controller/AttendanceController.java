package com.example.kintai.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kintai.model.Attendance;
import com.example.kintai.repository.AttendanceRepository;
import com.example.kintai.service.AttendanceService;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private AttendanceService attendanceService;
	
	//トップページに遷移する
	@GetMapping("/")
    public String getIndex(Model model) {
        LocalDate date = LocalDate.now();
        model.addAttribute("date", date);
		return "index";
    }
	
	//新規勤怠登録画面に遷移する
	@GetMapping("/register")
    public String getRegister(Model model, Attendance attendance) {
		LocalDate date = LocalDate.now();
        model.addAttribute("date", date);
        return "register";
    }
	
	//新規勤怠登録した情報を保存する
	@PostMapping("/register")
	public String createRegister(@Valid Attendance attendance, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		attendanceService.createAttendance(attendance);
		return "index2";
	}
	
	//保存一覧画面に遷移する
	@GetMapping("/save")
	public String getSave() {
		return "save";
	}
	
	//月選択された保存一覧画面の勤怠テーブルの表示
	@PostMapping("/save")
	public String changeSave(@Valid Integer mm, Model model) {
		List<Attendance> attendance = attendanceService.getAttendanceMonth(mm);
		model.addAttribute("tableAttendance", attendance);
		return "save";
	}
	
	//勤怠編集画面に遷移する
	@GetMapping("/edit/{id}")
	public String getEdit(@PathVariable("id") Attendance attendance, Model model) {
		model.addAttribute("Attendance", attendance);
		return "edit";
	}
	
	//勤怠保存したものを編集する
		@PostMapping("/edit/{id}")
		public String createEdit(@Valid Attendance attendance, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				return "/edit";
			}
			attendanceService.updateAttendance(attendance);
			return "redirect:/save";
		}

}
