
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
'robineaaaaa',
'ca ne vous regarde pas',
'0613141560',
'12-12-2014',
'inactive'), 
('clemou',
'clemouaaaaaa',
'qq part loin d ici',
'0656067834',
'07-02-2012',
'active'), 
('luluche',
'lulucheaaaaa',
'sous un  pont',
'0665349672',
'28-01-2013',
'inactive'), 
('root',
'rootaaaaaaa',
'sur une route',
'0667239076',
'01-11-2014',
'active'); 
SELECT * FROM booksmatching.User;

 DROP TABLE `booksmatching`.`administrateurs`;

CREATE TABLE `booksmatching`.`administrateurs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(25) UNIQUE NOT NULL,
  `tel` VARCHAR(15) NULL,
  `pwd` VARCHAR(15) NULL,
  PRIMARY KEY (`id`, `nom`));

INSERT INTO `booksmatching`.`administrateurs`
(`nom`,
`tel`,
`pwd`)
VALUES
('rootAdmin1',
'0643368953',
'rootAdmin1'),
('rootAdmin2',
'062976435',
'rootAdmin2'),
('rootAdmin3',
'064230956',
'rootAdmin3'),
('rootAdmin4',
'0646994368',
'rootAdmin4');

SELECT * FROM `booksmatching`.`administrateurs`;

DROP TABLE `booksmatching`.`books`; 

CREATE TABLE `booksmatching`.`books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titre` VARCHAR(45) NULL,
  `auteur` VARCHAR(45) NULL,
  `editeur` VARCHAR(45) NULL,
  `genre` VARCHAR(45) NULL,
  `isbn` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


  
  
INSERT INTO `booksmatching`.`books`
(`titre`,
`auteur`,
`editeur`,
`genre`,
`isbn`)
VALUES
('livre1',
'livre1',
'livre1',
'livre1',
'livre1'),
('livre2',
'livre2',
'livre2',
'livre2',
'livre2'),
('livre3',
'livre3',
'livre3',
'livre3',
'livre3'),
('livre4',
'livre4',
'livre4',
'livre4',
'livre4');


SELECT * FROM  `booksmatching`.`books` ;

CREATE TABLE `booksmatching`.`note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NULL,
  `idBooks` INT NULL,
  `qWriting` INT NULL,
  `dRead` INT NULL,
  `dAutor` INT NULL,
  `dRecommend` INT NULL,
  PRIMARY KEY (`id`));

select * from user;


