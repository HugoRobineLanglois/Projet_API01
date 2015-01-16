use booksmatching;

DROP TABLE `booksmatching`.`User`;

CREATE TABLE `booksmatching`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(15) NOT NULL,
  `adresse` VARCHAR(85) UNIQUE NULL,
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
SELECT * FROM booksmatching.user;

DROP TABLE `booksmatching`.`administrateurs`;

CREATE TABLE `booksmatching`.`administrateurs` (
  `adresse` VARCHAR(25) ,
  `nom` VARCHAR(25) NOT NULL,
  `prenom` VARCHAR(25) NOT NULL,
  `pwd` VARCHAR(15) NOT NULL,
  `telephone` VARCHAR(15),
  `date_creation` VARCHAR(20),
	PRIMARY KEY(`adresse`));

INSERT INTO `booksmatching`.`administrateurs`
	(`adresse`,
	`nom`,
	`prenom`,
	`pwd`,
	`telephone`,
	`date_creation`)
VALUES
	('rootAdmin1@mail.com',
	'Admin1',
	'root',
	'rootadmin1',
	'0643368953',
	'01/01/2014 00:00:00'),
	('rootAdmin2@mail.com',
	'Admin2',
	'root',
	'rootadmin2',
	'0643368953',
	'01/06/2014 00:00:00'),
	('rootAdmin3@mail.com',
	'Admin3',
	'root',
	'rootadmin3',
	'0643368953',
	'01/03/2014 00:00:00'),
	('rootAdmin4@mail.com',
	'Admin4',
	'root',
	'rootadmin4',
	'0643368953',
	'01/01/2014 00:00:00');

SELECT * FROM `booksmatching`.`administrateurs`;	

select * from user;

