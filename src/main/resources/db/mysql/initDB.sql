drop database IF EXISTS  petclinic;
CREATE DATABASE IF NOT EXISTS petclinic;
GRANT ALL PRIVILEGES ON petclinic.* TO pc@localhost IDENTIFIED BY 'pc';

USE petclinic;

CREATE TABLE IF NOT EXISTS vets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialties (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  UNIQUE (vet_id,specialty_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS types (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS owners (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS users (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  login VARCHAR(30),
  password VARCHAR(30),
  connected tinyint(1),
  locked  tinyint (1),
  is_admin  tinyint (1),
  fk_contact INT(4),
  fk_categorieutilisateur INT(4),  
  INDEX(last_name),
  FOREIGN KEY (fk_categorieutilisateur) REFERENCES user_categories(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS user_categories (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  INDEX(name)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS fonction (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    fonction_type INT(4),
    fk_categorieutilisateur_fonction INT(4),  
  	INDEX(name),
    FOREIGN KEY (fk_categorieutilisateur_fonction) REFERENCES user_categories(id)
)engine=InnoDB;



CREATE TABLE IF NOT EXISTS pets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INT(4) UNSIGNED NOT NULL,
  owner_id INT(4) UNSIGNED NOT NULL,
  INDEX(name),
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS roles (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  fk_categorieutilisateur_roles INT(4),  
  FOREIGN KEY (fk_categorieutilisateur_roles) REFERENCES user_categories(id)
  index(name)
  ) engine=InnoDB;

 CREATE TABLE IF NOT EXISTS user_role (
  id_user INT(4) UNSIGNED NOT NULL ,
  id_role INT(4) UNSIGNED NOT NULL ,
  FOREIGN KEY (id_user) REFERENCES users(id),
  FOREIGN KEY (id_role) REFERENCES roles(id),
  UNIQUE(id_user,  id_role)
  ) engine=InnoDB;
  
CREATE TABLE IF NOT EXISTS visits (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id INT(4) UNSIGNED NOT NULL,
  visit_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS contact (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  typecontact INT(4) DEFAULT 0,
  name VARCHAR(30),
  nomsocietecontact VARCHAR(30),
  titrecontact VARCHAR(30),
  adressecontact1 VARCHAR(255),
  adressecontact2 VARCHAR(255),
  alertesurtelephone1  tinyint (1),
  alertesurtelephone2  tinyint (1),
  codepostalcontact INT(5) UNSIGNED NOT NULL,
  estcontactprincipal  tinyint (1),
  villecontact VARCHAR(80),
  adressemailcontact VARCHAR(80),
  faxcontact VARCHAR(80),
  sitewebcontact VARCHAR(80),
  telephonecontact1 VARCHAR(80),
  telephonecontact2 VARCHAR(80),
  INDEX(name)
)engine=InnoDB;