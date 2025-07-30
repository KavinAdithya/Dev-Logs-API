package com.techcrack.devlog;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techcrack.devlog.entity.Developer;
import com.techcrack.devlog.entity.Log;
import com.techcrack.devlog.entity.Project;

@Service
public class DeveloperService {
	
	public void updatePartialData(Developer sDev, Developer dev) {
		if (dev.getDob() != null) {
			sDev.setDob(dev.getDob());
		}
		
		if (dev.getDomain() != null) {
			sDev.setDomain(dev.getDomain());
		}
		
		if (dev.getGitHubLink() != null) {
			sDev.setGitHubLink(dev.getGitHubLink());
		}
		
		if (dev.getLinkedInLink() != null) {
			sDev.setLinkedInLink(dev.getLinkedInLink());
		}
		
		if (dev.getSkills() != null) {
			sDev.getSkills().clear();
			sDev.getSkills().addAll(dev.getSkills());
		}
	}
	
	public void fillDev(Developer dev, List<Project> projects, List<Log> logs) {
		for (Project p : projects) {
			p.setDev(dev);
		}
		
		for (Log l : logs) {
			l.setDev(dev);
		}
	}
	
	public URI buildLocation(int id) {
		return ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id)
				.toUri();
	}
}
