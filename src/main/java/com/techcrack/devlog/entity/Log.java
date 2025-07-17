package com.techcrack.devlog.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "logs")
public class Log {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private LocalDate date;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Developer dev;
	
	public Log() {
		super();
	}

	public Log(String title, String description, LocalDate date) {
		super();
		this.title = title;
		this.date = date;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Developer getDev() {
		return dev;
	}

	public void setDev(Developer dev) {
		this.dev = dev;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, dev, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(dev, other.dev) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", title=" + title + ", date=" + date + ", description=" + description + ", dev=" + dev
				+ "]";
	}
}
