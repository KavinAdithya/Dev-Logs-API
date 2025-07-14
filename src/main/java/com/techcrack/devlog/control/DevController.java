package com.techcrack.devlog.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techcrack.devlog.entity.Developer;
import com.techcrack.devlog.repos.DeveloperRepository;

public class DevController {
	
	@Autowired
	private DeveloperRepository devRepo;
	
	@GetMapping("dev/{id}")
	public Developer getDeveloperById(@PathVariable Integer id) {
		return devRepo.findById(id).get();
	}
}
