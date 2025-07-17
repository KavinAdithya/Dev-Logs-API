package com.techcrack.devlog;

import org.springframework.stereotype.Service;

import com.techcrack.devlog.entity.Developer;

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
}
