/**
 * @author Isaac Roetman - ijroetman
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="models")
public class Models {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MODELNAME")
	private String modelName;
	
	public Models() {
		super();
	}
	
	public Models(String modelName) {
		super();
		this.modelName = modelName;
	}
	
	public Models(int id, String modelName) {
		super();
		this.id = id;
		this.modelName = modelName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	@Override
	public String toString() {
		return "Models [id =" + id + ", modelName=" + modelName + "]";
	}
}
