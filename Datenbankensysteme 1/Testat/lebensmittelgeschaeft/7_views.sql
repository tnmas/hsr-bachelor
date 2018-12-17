-- Aufgabe 3: Views
-- 3.1 Views
-- Eine View, die mindestens drei Tabellen umfasst
-- Zeigt alle Produkte mit Onlinebestellungen und Versand 

create view produkte_view(produktname, bestelldatum, versanddatum, dauer)
as 
select pr.produktname, o.bestelldatum, v.versanddatum, v.dauer
from produkt pr
inner join onlinebestellung o on pr.produktnr = o.produktnr_id
inner join versand v on v.onlinebestell_id = o.id
order by pr.produktnr, o.bestelldatum;

select * from produkte_view;

-- 3.2 Weitere View
-- Personen View 

create view person_view(personid, nachname, vorname, address, produkt_id, onlinebestell_id, bestelldatum)
as 
select p.id, p.nachname, p.vorname, p.address, pr.produktnr, o.id, o.bestelldatum
from person p
inner join onlinebestellung o on p.id = o.person_id
inner join produkt pr on pr.produktnr = o.produktnr_id
order by p.id, p.nachname, p.vorname, o.id;

select * from person_view;

-- Erstelle Regeln, welche das Einfügen in die Tabellen person und onlinebestellung via person_view
-- erlauben.

create rule person_view_insert_onlinebestellung as on update to person_view
do instead (
	update person -- (id, nachname, vorname, address)
	set nachname = new.nachname,
		vorname = new.vorname,
		address = new.address
	where id = new.personid;
	update onlinebestellung
	set bestelldatum = new.bestelldatum,
		produktnr_id = new.produkt_id,
		id = new.onlinebestell_id
	where person_id = new.personid;
);

update person_view
set nachname = 'Emanuel',
	vorname = 'Simon',
	address = 'Peacestrasse 102',
	produkt_id = 103,
	bestelldatum = '2018.11.22'
where personid = 1;

-- Shows Updated person_view
select * from person_view
where personid = 1;

-- Shows updated person table
select * from person
where id = 1;

-- Shows updated onlinebestellung table
select * from onlinebestellung
where person_id = 1;
