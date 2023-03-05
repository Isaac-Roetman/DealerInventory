/**
 * @author Isaac Roetman - ijroetman
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InventoryDetails {
	@Id
	@GeneratedValue
	private int id;
	private String inventoryName;
	private LocalDate acquisitionDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Models models;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Descriptions> listOfDescriptions;
	
	public InventoryDetails() {
		super();
	}
	
	public InventoryDetails(int id, String inventoryName, LocalDate acquisitionDate, Models models, List<Descriptions> listOfDescriptions) {
		this.id = id;
		this.inventoryName = inventoryName;
		this.acquisitionDate = acquisitionDate;
		this.models = models;
		this.listOfDescriptions = listOfDescriptions;
	}
	public InventoryDetails(String inventoryName, LocalDate acquisitionDate, Models models) {
		super();
		this.inventoryName = inventoryName;
		this.acquisitionDate = acquisitionDate;
		this.models = models;
	}

	public InventoryDetails(String inventoryName, LocalDate acquisitionDate, Models models, List<Descriptions> listOfDescriptions) {
		super();
		this.inventoryName = inventoryName;
		this.acquisitionDate = acquisitionDate;
		this.models = models;
		this.listOfDescriptions = listOfDescriptions;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public LocalDate getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(LocalDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Models getModels() {
		return models;
	}

	public void setModels(Models models) {
		this.models = models;
	}

	public List<Descriptions> getListOfDescriptions() {
		return listOfDescriptions;
	}

	public void setListOfDescriptions(List<Descriptions> listOfDescriptions) {
		this.listOfDescriptions = listOfDescriptions;
	}
	@Override
	public String toString() {
		return "InventoryDetails [id=" + id + ", inventoryName=" + inventoryName + ", acquisitionDate=" + acquisitionDate + ", models="
				+ models + ", listOfDescriptions=" + listOfDescriptions + "]";
	}
}
