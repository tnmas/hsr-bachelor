-- 1. Lateral Join Query
-- Zeigt Person_Id, Erste Bestellungdatum von einer Person, Nächste Bestellungdatum, 
-- und Bestellung_Id von der Nächste Bestellungdatum

select person_id, erste_bestelldatum, naechste_bestelldatum, id 
from 
(select person_id, min(bestelldatum) as erste_bestelldatum 
	from onlinebestellung
	group by person_id
) be1
left join lateral
(select id, bestelldatum as naechste_bestelldatum
	from onlinebestellung
	where person_id = be1.person_id and bestelldatum > be1.erste_bestelldatum
	order by bestelldatum asc limit 1
)be2 on true;

-- Aufgabe 4
-- INDEXE
CREATE INDEX person_lower_email ON person(lower(email));
