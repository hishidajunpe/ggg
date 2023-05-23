package com.example.kintai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintai.model.Request;

//勤怠申請した日時データを取得
public interface RequestRepository extends JpaRepository<Request,Integer>{

}
