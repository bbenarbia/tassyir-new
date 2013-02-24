package net.bbenaissa.tassyir.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bbenaissa.tassyir.model.common.BaseUser;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name = "users")
public class User extends BaseUser {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_contact")
	private Contact contact;
	
	@ManyToOne(cascade = CascadeType.ALL)
//    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "fk_categorieprofilutilisateur")
	private UserCategory userCategory;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

//	  protected void setRolesInternal(Set<Role> roles) {
//	        this.roles = roles;
//	    }
//
//	    protected Set<Role> getRolesInternal() {
//	        if (this.roles == null) {
//	            this.roles = new HashSet<Role>();
//	        }
//	        return this.roles;
//	    }
//
//	    @XmlElement
//	    public List<Role> getSpecialties() {
//	        List<Role> sortedSpecs = new ArrayList<Role>(getRolesInternal());
//	        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
//	        return Collections.unmodifiableList(sortedSpecs);
//	    }
//
//	    public int getNrOfRoles() {
//	        return getRolesInternal().size();
//	    }
//
//	    public void addSpecialty(Role role) {
//	        getRolesInternal().add(role);
//	    }

	    
	

}
