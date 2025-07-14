package com.techcrack.devlog.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String description;
	
	private String techStack;
	
	private String gitHubLink;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Developer dev;
	
	public Project() {
		super();
	}
	
	public Project(Integer id, String title, String description, String techStack, String gitHubLink) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.techStack = techStack;
		this.gitHubLink = gitHubLink;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public String getGitHubLink() {
		return gitHubLink;
	}

	public void setGitHubLink(String gitHubLink) {
		this.gitHubLink = gitHubLink;
	}
	
	public Developer getDev() {
		return dev;
	}

	public void setDev(Developer dev) {
		this.dev = dev;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, gitHubLink, id, techStack, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(description, other.description) && Objects.equals(gitHubLink, other.gitHubLink)
				&& Objects.equals(id, other.id) && Objects.equals(techStack, other.techStack)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", description=" + description + ", techStack=" + techStack
				+ ", gitHubLink=" + gitHubLink + "]";
	}
}