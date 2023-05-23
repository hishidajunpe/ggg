package com.example.kintai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Request {
	
	
	//申請ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//申請日時
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate requesttime;
	
	//主キーrequest
	@OneToMany(mappedBy="request")
	private List<Attendance> attendance;
	
	
}
