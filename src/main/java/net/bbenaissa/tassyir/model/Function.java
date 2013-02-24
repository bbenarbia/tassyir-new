package net.bbenaissa.tassyir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import net.bbenaissa.tassyir.model.common.NamedEntity;
import net.bbenaissa.tassyir.model.enums.EnumFonction;

/**
 * 
 * @author benaissa
 *
 */

@Entity
@Table(name = "fonction")
public class Function extends NamedEntity{

	@Enumerated(EnumType.ORDINAL)
    @Column(name = "fonction_type")
	private EnumFonction type;

	public EnumFonction getType() {
		return type;
	}

	public void setType(EnumFonction type) {
		this.type = type;
	} 


}
