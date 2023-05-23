package com.example.kintai.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Attendance {
	
	//勤怠Id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//月
	@NotNull(message ="登録する月を入力してください" )
	@Min(1)
	@Max(12)
	private Integer mm;
	
	//日（日にち範囲は月指定の月）
	@NotNull(message = "登録する日を入力してください。")
	@Min(1)
	@Max(31)
	private Integer dd;
	
	//現在の日時
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate nowtime;
	
	//出勤時間
	@NotBlank(message="出勤時間を入力してください")
	@Size(max=6,message="文字数は6文字以内にしてください")
    private String workStartTime ;
	
	//退勤時間
	@NotBlank(message="退勤時間を入力してください")
	@Size(max=6,message="文字数は6文字以内にしてください")
    private String workEndTime ;
	
	//休憩開始時間
	@NotBlank(message="休憩開始時間を入力してください")
	@Size(max=6,message="文字数は6文字以内にしてください")
    private String breakStartTime ;
	
	
	//休憩終了時間
	@NotBlank(message="休憩終了時間を入力してください")
	@Size(max=6,message="文字数は6文字以内にしてください")
    private String breakEndTime ;
	
	//外部キーattendance
	@ManyToOne
	private Request request;
	
}