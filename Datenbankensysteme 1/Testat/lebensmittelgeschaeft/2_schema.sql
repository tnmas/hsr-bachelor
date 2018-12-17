
CREATE TABLE lebensmittelgeschaeft (
	id SERIAL PRIMARY KEY,
	name VARCHAR(80) NOT NULL
);

-- Sequence Anpassung
SELECT setval('lebensmittelgeschaeft_id_seq', 2, true);

CREATE TABLE produkt (
	produktnr INTEGER NOT NULL PRIMARY KEY UNIQUE,
	produktname VARCHAR(80), 
	menge FLOAT NOT NULL,
	preis FLOAT NOT NULL,
	lmgeschaeft_id INTEGER NOT NULL REFERENCES lebensmittelgeschaeft(id) ON DELETE CASCADE
);

CREATE TABLE person (
	id INTEGER PRIMARY KEY,
	nachname VARCHAR(50) NOT NULL,
	vorname VARCHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL,
	email VARCHAR(50) NULL
);

CREATE TABLE onlinebestellung (
	id INTEGER PRIMARY KEY,
	bestelldatum DATE NOT NULL,
	produktnr_id INTEGER NULL REFERENCES produkt(produktnr) ON DELETE CASCADE,
	person_id INTEGER NULL REFERENCES person(id) ON DELETE CASCADE
);

CREATE TABLE mitarbeiter (
	id INTEGER PRIMARY KEY,
	anstellungsdatum DATE NOT NULL,
	person_id INTEGER NOT NULL REFERENCES person(id) ON DELETE CASCADE,
	lmgeschaeft_id INTEGER NOT NULL REFERENCES lebensmittelgeschaeft(id) ON DELETE CASCADE
);

CREATE TABLE versand(
	id INTEGER PRIMARY KEY,
	versanddatum DATE NOT NULL,
	dauer INTEGER NOT NULL,
	onlinebestell_id INTEGER NOT NULL REFERENCES onlinebestellung(id) ON DELETE CASCADE
);

-- Testat 4
-- Aufgabe 3: Schema-Evolution ff.
-- Enum 
-- Geschlecht von der Person

CREATE TYPE geschlecht_type AS ENUM ('Weiblich', 'Männlich');

ALTER TABLE person
ADD geschlecht geschlecht_type;

-- BOOLEAN 
-- Checkt, ob der Versand erhalten ist
ALTER TABLE versand
ADD erhalten BOOLEAN NULL;
