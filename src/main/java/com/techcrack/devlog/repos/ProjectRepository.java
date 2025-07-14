package com.techcrack.devlog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.devlog.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
