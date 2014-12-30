use booksmatching;

drop table User;

CREATE TABLE User(
	id_user int(10) unsigned NOT NULL auto_increment,
	nom varchar(20),
    adresse varchar(50), 
    telephone varchar(12)	, 
    dateCreation varchar(20),
    statutCompte varchar(20),
    mdp varchar(10),
    PRIMARY KEY(id_user)
);

insert into User (nom, adresse, telephone, dateCreation, statutCompte, mdp) values("test","test","test","test","test","test"); 

select * from User;