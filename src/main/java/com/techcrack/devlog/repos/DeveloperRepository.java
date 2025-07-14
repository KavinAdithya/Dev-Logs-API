package com.techcrack.devlog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.devlog.entity.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer>{

}
