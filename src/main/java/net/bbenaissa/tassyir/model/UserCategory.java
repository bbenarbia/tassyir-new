package net.bbenaissa.tassyir.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.bbenaissa.tassyir.model.common.NamedEntity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "user_categories")
public class UserCategory extends NamedEntity {

	@ManyToMany
	@JoinTable(name = "re_categorieUtilisateur_fonctions", joinColumns = @JoinColumn(name = "fk_categorieutilisateur"), inverseJoinColumns = @JoinColumn(name = "fk_fonction"))
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Function> fonctions = new HashSet<Function>();

	@ManyToMany
	@JoinTable(name = "re_categorieUtilisateur_droits", joinColumns = @JoinColumn(name = "fk_categorieUtilisateur"), inverseJoinColumns = @JoinColumn(name = "fk_droitsutilisateur"))
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<UserDroit> droitsUtilisateurs = new HashSet<UserDroit>();

	public Set<Function> getFonctions() {
		return fonctions;
	}

	public void setFonctions(Set<Function> fonctions) {
		this.fonctions = fonctions;
	}

	public Set<UserDroit> getDroitsUtilisateurs() {
		return droitsUtilisateurs;
	}

	public void setDroitsUtilisateurs(Set<UserDroit> droitsUtilisateurs) {
		this.droitsUtilisateurs = droitsUtilisateurs;
	}
}