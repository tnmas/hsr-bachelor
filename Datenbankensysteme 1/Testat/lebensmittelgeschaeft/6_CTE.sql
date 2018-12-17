-- Aufgabe 2: Common Table Expressions und Window-Funktionen

-- Aufgabe 2.1 CTE with subquery
-- Alle Bestellungen, deren versand_dauer grösser als der Durchschnitt.
-- Unkorrelierte Unterabfrage


select o.id, o.bestelldatum, o.produktnr_id, v.versanddatum, v.dauer
from onlinebestellung as o
inner join versand v on o.id = v.onlinebestell_id
where v.dauer >
(
	select avg(dauer) from versand
);

-- CTE with query
-- Resultat: Zeigt produktname, onlinebestellung id, bestelldatum, produktnr_id von der Produkte, denen Versand grösser
-- als die Minimum von Durchschnitt von Dauer ist.
with avglen(avg) as (
	select avg(dauer)
	from versand
)
select o.id, o.bestelldatum, o.produktnr_id, v.versanddatum, v.dauer
from onlinebestellung as o 
inner join versand v on v.onlinebestell_id = o.id
where v.dauer > 
( 
	select avg from avglen
);
-- 2.2 Group-By und Window-Funktionen
-- Group-By 
-- Find the number of orders per product.

select o.produktnr_id, count(o.produktnr_id) as "anzahl"
from onlinebestellung as o
inner join produkt p on p.produktnr = o.produktnr_id
group by o.produktnr_id
order by o.produktnr_id;

-- Window-Funktionen
-- Zeigt ein Produkt mit Id 106, wann ist es bestellt, wann ist es vesendet, 
-- wie lange hat der Versand gedauert und die Durchschnittversand.

select pr.produktnr, v.dauer, o.bestelldatum, v.versanddatum,
avg(v.dauer) over (order by pr.produktnr) as "avgdauer"
from versand as v
inner join onlinebestellung o on o.id = v.onlinebestell_id
inner join person p on p.id = o.person_id
inner join produkt pr on pr.produktnr = o.produktnr_id
where pr.produktnr = 106;
