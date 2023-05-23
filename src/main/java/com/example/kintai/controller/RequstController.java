package com.example.kintai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kintai.model.Request;
import com.example.kintai.repository.RequestRepository;
import com.example.kintai.service.RequestService;

@Controller
public class RequstController {

	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private RequestService requestService;
	
	//勤怠保存したものを申請する
	@PostMapping("/save")
	public String createRequest(Request request) {
		requestService.createRequest(request);
		return "index3";
	}
	
	//申請済一覧画面に遷移する
	@GetMapping("/application")
	public String getApplication(Request request) {
		return "application";
	}
	
	//申請一覧画面に遷移する
	@GetMapping("/applicationDisplay/{id}")
	public String getDisplay(@PathVariable("Id") Request request, Model model) {
		model.addAttribute("Request", request);
		return "applicationDisplay";
	}
	
	
}
