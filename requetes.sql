
-- drop table User;

-- CREATE TABLE User(
-- 	id_user int(10) unsigned NOT NULL auto_increment,
-- 	nom varchar(20),
--     adresse varchar(50), 
--     telephone varchar(12)	, 
--     dateCreation varchar(20),
--     statutCompte varchar(20),
--     mdp varchar(10),
--     PRIMARY KEY(id_user)
-- );

-- insert into User (nom, adresse, telephone, dateCreation, statutCompte, mdp) values("test","test","test","test","test","test"); 

-- select * from User;

DROP TABLE `booksmatching`.`User`;

CREATE TABLE `booksmatching`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(15) NOT NULL,
  `adresse` VARCHAR(85) NULL,
  `telephone` VARCHAR(15) NULL,
  `dateCreation` VARCHAR(20) NULL,
  `statutCompte` VARCHAR(20) NULL,
  PRIMARY KEY (`id`, `nom`));


INSERT INTO `booksmatching`.`User`
(`nom`,
`pwd`,
`adresse`,
`telephone`,
`dateCreation`,
`statutCompte`)
VALUES
('robinelanglois',
'robine',
'ca ne vous regarde pas',
'0613141560',
'12-12-2014',
'inactive'), 
('clemou',
'clemou',
'qq part loin d ici',
'0656067834',
'07-02-2012',
'active'), 
('luluche',
'luluche',
'sous un  pont',
'0665349672',
'28-01-2013',
'inactive'), 
('root',
'root',
'sur une route',
'0667239076',
'01-11-2014',
'active'); 
SELECT * FROM booksmatching.User;
