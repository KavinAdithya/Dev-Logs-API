package com.techcrack.devlog.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "developers")
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ElementCollection
	private List<String> skills;
	
	private String domain;
	
	private String linkedInLink;
	
	private String gitHubLink;
	
	private LocalDate dob;
	
	@OneToMany(mappedBy="dev")
	private List<Project> projects;
	
	@OneToMany(mappedBy="dev")
	private List<Log> logs;
	
	public Developer() {
		super();
	}

	public Developer(Integer id, List<String> skills, String domain, String linkedInLink, String gitHubLink,
			LocalDate dob) {
		super();
		this.id = id;
		this.skills = skills;
		this.domain = domain;
		this.linkedInLink = linkedInLink;
		this.gitHubLink = gitHubLink;
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLinkedInLink() {
		return linkedInLink;
	}

	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}

	public String getGitHubLink() {
		return gitHubLink;
	}

	public void setGitHubLink(String gitHubLink) {
		this.gitHubLink = gitHubLink;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, domain, gitHubLink, id, linkedInLink, logs, projects, skills);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developer other = (Developer) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(domain, other.domain)
				&& Objects.equals(gitHubLink, other.gitHubLink) && Objects.equals(id, other.id)
				&& Objects.equals(linkedInLink, other.linkedInLink) && Objects.equals(logs, other.logs)
				&& Objects.equals(projects, other.projects) && Objects.equals(skills, other.skills);
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", skills=" + skills + ", domain=" + domain + ", linkedInLink=" + linkedInLink
				+ ", gitHubLink=" + gitHubLink + ", dob=" + dob + ", projects=" + projects + ", logs=" + logs + "]";
	}	
}
