CREATE TABLE buch (
buchnr INTEGER PRIMARY KEY, -- Default PK = NOT NULL
titel VARCHAR(256), -- Default NULL
seiten INTEGER
);
CREATE TABLE person (
persnr INTEGER PRIMARY KEY,
vorname VARCHAR(256),
nachname VARCHAR(256),
gebdat DATE,
verstorben DATE
);
CREATE TABLE kunde (
persnr INTEGER PRIMARY KEY,
eingeschrieben DATE,
treuepunkte INTEGER
);
CREATE TABLE mitarbeiter (
persnr INTEGER PRIMARY KEY,
eingestellt DATE,
gehalt INTEGER
);
CREATE TABLE ausleihe (
kpersnr INTEGER,
buchnr INTEGER,
mpersnr INTEGER,
ausleihdat DATE,
PRIMARY KEY (buchnr,ausleihdat)
);
CREATE TABLE rueckgabe (
buchnr INTEGER,
mpersnr INTEGER,
ausleihdat DATE,
rueckgabedat DATE,
PRIMARY KEY (buchnr,ausleihdat)
);
CREATE TABLE autor (
persnr INTEGER PRIMARY KEY,
nation VARCHAR(256)
);
CREATE TABLE autorenschaft (
autor INTEGER,
buch INTEGER,
PRIMARY KEY(autor,buch)
);