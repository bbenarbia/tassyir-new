package net.bbenaissa.tassyir.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.bbenaissa.tassyir.model.common.NamedEntity;

@Entity
@Table(name = "roles")
public class Role extends NamedEntity{

}
