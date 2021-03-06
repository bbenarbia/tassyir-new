package net.bbenaissa.tassyir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.bbenaissa.tassyir.model.common.NamedEntity;

@Entity
@Table(name = "roles")
public class Role extends NamedEntity{

	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
