package com.techcrack.devlog.starter;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.techcrack.devlog.entity.Developer;
import com.techcrack.devlog.entity.Log;
import com.techcrack.devlog.entity.Project;
import com.techcrack.devlog.repos.DeveloperRepository;

@Controller
public class StarterDataPersist implements CommandLineRunner{
	
	@Autowired
	private DeveloperRepository devRepo;
	
	@Override
	public void run(String... args) {
		Developer dev = new Developer();
		
		dev.setDob(LocalDate.now().minusYears(18));
		dev.setDomain("Java Backend developer");
		dev.setGitHubLink("https://github.com/KavinAdithya");
		dev.setLinkedInLink("www.linkedin.com/in/kavinadithya");
		dev.setSkills(Arrays.asList("Java", "Spring Boot"));
		
		Project pro = new Project();
		pro.setDev(dev);
		pro.setDescription("Developer Log Management Rest API");
		pro.setGitHubLink("https://github.com/KavinAdithya/dev-log");
		pro.setTechStack("Java, Spring Boot, Spring MVC, Rest API");
		pro.setTitle("Developer Log Management");
		
		dev.setProjects(Arrays.asList(pro));
		
		Log log = new Log();
		
		log.setDate(LocalDate.now());
		log.setDev(dev);
		log.setTitle("Developer Management Developed");
		log.setDescription("Testing Single Module");
		
		dev.setLogs(Arrays.asList(log));
		
		devRepo.save(dev);
	}
}