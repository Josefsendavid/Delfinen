DROP database if exists delfinen;
CREATE database delfinen;
USE delfinen;

create table delfinen.medlemmer (
cpr				int NOT NULL UNIQUE,
navn				varchar(30),
alder				int,
aldersgruppe                    varchar(80),
svømmeniveau                    varchar(80),
aktivtmedlemsskab               boolean,
primary key			(cpr)
);

create table delfinen.svømmeresultater (
medlemsCPR			int,
dato				int,
placering			int,
diciplin			varchar(80),
svømmeresultat                  double,
konkurrence			varchar(30),
stævne				varchar(80),
foreign key			(medlemsCPR) REFERENCES medlemmer(cpr)
);

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (1, 'TEST1', 22, 'Senior', 'Motionist', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (1, 12, 6, 'Crawl', 23.23, 'nej', 'nej');

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (2, 'TEST2', 23, 'Senior', 'Konkurrence', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (2, 12, 8, 'Bryst', 45.23, 'ja', 'Herning');

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (3, 'TEST3', 82, 'Senior', 'Motionist', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (3, 12, 9, 'Crawl', 55.23, 'nej', 'nej');

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (4, 'TEST4', 36, 'Senior', 'Konkurrence', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (4, 12, 1, 'Crawl', 23.10, 'nej', 'nej');

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (5, 'TEST5', 45, 'Senior', 'Motionist', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (5, 12, 4, 'Crawl', 22.23, 'nej', 'nej');

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (6, 'TEST6', 12, 'Junior', 'Konkurrence', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (6, 12, 2, 'Crawl', 11.23, 'ja', 'Herning');

INSERT INTO medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (7, 'TEST7', 16, 'Junior', 'Konkurrence', True);
INSERT INTO svømmeresultater (medlemsCPR, dato, placering, diciplin, svømmeresultat, konkurrence, stævne) VALUES (7, 12, 1, 'Crawl', 33.23, 'nej', 'nej');