-- Aufgabe 1: Einfache Queries

-- 1.1. DISTINCT
-- Es gibt drei Personen, die den gleichen Nachname und Vorname haben
-- Wir möchten alle Personen herausfinden, die nicht den gleichen Nachname und Vorname haben

-- Resultat: 7 Personen
select distinct p.nachname, p.vorname
from person as p
order by p.nachname;

-- 1.2. Join über drei oder mehr Tabellen enthält
-- Zeige alle Mitarbeiter, die versandte Bestellungen haben.

-- Resultat: Zeigt Nachname, Vorname, Personid, Bestelldatum, Anstellungsdatum, und dauer
select p.id, p.nachname, p.vorname, o.bestelldatum, m.anstellungsdatum, v.dauer
from person as p
inner join onlinebestellung as o on p.id = o.person_id
inner join mitarbeiter as m on p.id = m.person_id
inner join versand as v on o.id = v.onlinebestell_id
order by p.id, v.dauer;

-- 1.3. Unterabfrage (Korreliert)
-- Zeige alle Bestellungen, die einen Versand kleiner als 3 Tage haben

-- Resultat: Zeigt bestelldatum und produktnr_id

select v.versanddatum, v.onlinebestell_id, v.dauer
from versand as v
where 1 = 
(
	select count(dauer) from versand ve
	where ve.dauer <= v.dauer and ve.dauer <= 3
);

-- 1.4 Query mit IN
-- Zeigt alle Personen, die nicht am 23.11.2018 oder im 21.11.2018 ein Produkt bestellt haben.

-- Resultat: Zeigt nachname, vorname, id und bestelldatum
select p.nachname, p.vorname, p.id, o.bestelldatum
from person as p
inner join onlinebestellung o on p.id = o.person_id
where o.bestelldatum NOT IN ('2018/11/23', '2018/11/21');


-- Testat 4
-- Aufgabe 5
-- Tests
-- 1 
-- ENUM
/*INSERT INTO person(id, vorname, nachname, address, email, geschlecht)
VALUES(10,'Michal', 'Bauer', 'Dorfstrasse 30', 'michal.78@gmail.com', 'Unknown');
*/
-- BOOLEAN
/*INSERT INTO versand(id, versanddatum, dauer, erhalten, onlinebestell_id)
VALUES(24,'2018-11-24', 3, 'What', 111);*/

-- 2. UNIQUE-CONSTRAINT verletzen
/*INSERT INTO mitarbeiter(id, anstellungsdatum, person_id, lmgeschaeft_id)
VALUES(4, '2017-1-1', 3, 9);*/
