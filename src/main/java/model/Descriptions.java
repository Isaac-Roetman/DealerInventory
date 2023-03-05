/**
 * @author Isaac Roetman - ijroetman
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="descriptions")
public class Descriptions {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COLOR")
	private String color;
	@Column(name="YEAR") // stores the players jersey number
	private int year;
	@Column(name="ACQUISITIONDATE") // stores the date the player started playing on the team
	private LocalDate acquisitionDate;

public Descriptions () {
	
}

public Descriptions(String color, int year, LocalDate acquisitionDate) {
	this.color = color;
	this.year = year;
	this.acquisitionDate = acquisitionDate;
}

public Descriptions(int id, String color, int year, LocalDate acquisitionDate) {
	this.id = id;
	this.color = color;
	this.year = year;
	this.acquisitionDate = acquisitionDate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public LocalDate getAcquisitionDate() {
	return acquisitionDate;
}

public void setAcquisitionDate(LocalDate acquisitionDate) {
	this.acquisitionDate = acquisitionDate;
}

@Override
public String toString() {
	return "Descriptions [id=" + id + ", color=" + color + ", year=" + year + ", acquisitionDate=" + acquisitionDate + "]";
}
}
