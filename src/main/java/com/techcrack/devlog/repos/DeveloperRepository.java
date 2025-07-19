package com.techcrack.devlog.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techcrack.devlog.entity.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer>{
	
	 @Query("SELECT d FROM developers d WHERE :skill MEMBER OF d.skills")
	List<Developer> getDevelopersBySkill(@Param("skill") String skill);
}
