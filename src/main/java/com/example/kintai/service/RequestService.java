package com.example.kintai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.kintai.model.Request;
import com.example.kintai.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;
	
	//新規勤怠登録した情報を保存する
	public void createRequest(Request request) {
		requestRepository.save(request);
	}
	
}
