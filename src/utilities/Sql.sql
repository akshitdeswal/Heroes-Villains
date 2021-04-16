CREATE DATABASE heroesvillains;
USE heroesvillains;

CREATE TABLE heroes(
firstName   varchar(20),
lastName 	varchar(20),
realName 	varchar(30),
strength 	int(3),
birthday 	DATE
);

INSERT INTO heroes (firstName, lastName, realName, strength, birthday) VALUES("Captain", "America", "Steve Rogers", "98", "2001-09-15");
INSERT INTO heroes (firstName, lastName, realName, strength, birthday) VALUES("Spider", "Man", "Peter Parker", "99", "2001-08-13");
INSERT INTO heroes (firstName, lastName, realName, strength, birthday) VALUES("Black", "Panther", "Tchaka Udaku", "95", "1998-05-23");
INSERT INTO heroes (firstName, lastName, realName, strength, birthday) VALUES("Lord", "Linghting", "Thor Odin", "97", "1998-05-23");

CREATE TABLE villains(
firstName   	varchar(20),
lastName 		varchar(20),
strength 		int(3),
birthday 		DATE,
evilPurpose 	varchar(50),
lethalWeapon 	varchar(20)
);

INSERT INTO villains (firstName, lastName, strength, birthday, evilPurpose, lethalWeapon) VALUES("Lord", "Tricks", "97", "1998-05-23", "Show his presence", "Tricks");
INSERT INTO villains (firstName, lastName, strength, birthday, evilPurpose, lethalWeapon) VALUES("Thanos", "Thanos", "100", "1997-02-23", "Balancing Population", "Infinty Stones");
INSERT INTO villains (firstName, lastName, strength, birthday, evilPurpose, lethalWeapon) VALUES("Venom", "Venom", "95", "1999-01-2", "Revenge On leader", "Black Plasma");
INSERT INTO villains (firstName, lastName, strength, birthday, evilPurpose, lethalWeapon) VALUES("Hydra", "Organisation", "96", "1999-05-23", "Rule Over Earth", "Genetic Weapons");

CREATE TABLE movies(
realName varchar(30),
movie varchar(100)
);

INSERT INTO movies (realName, movie) VALUES("Steve Rogers", "The First Winter Solder");
INSERT INTO movies (realName, movie) VALUES("Peter Parker", "Amazing SpiderMan");
INSERT INTO movies (realName, movie) VALUES("Tchaka Udaku", "The Black Panther");
INSERT INTO movies (realName, movie) VALUES("Thor Odin", "Thor: The Dark World");

SELECT * FROM heroes INNER JOIN movies ON heroes.realName = movies.realName;
