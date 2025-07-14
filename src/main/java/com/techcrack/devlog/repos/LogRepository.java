package com.techcrack.devlog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.devlog.entity.Log;

public interface LogRepository extends JpaRepository<Log, Integer>{

}
