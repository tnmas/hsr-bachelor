-- Lebensmittelgeschaeft Inserts
INSERT INTO lebensmittelgeschaeft (name)
VALUES('Eat'),
	('Ocado'),
	('Freshdirect'),
	('Walmart'),
	('Groceries'),
	('Tesco'),
	('BritishCornerShop');

--Produkt Inserts
INSERT INTO produkt(produktnr, produktname, menge, preis, lmgeschaeft_id)
VALUES(101,'Honey', 3.5, 20.0, 8),
	(102, 'Rice', 2.0, 3.0, 3),
	(103, 'Olive', 1.0, 7.0, lastval()),
	(104, 'Noodles', 5.0, 10.0, 4),
	(105, 'Twinings', 3.0, 6.0, 7),
	(106, 'Starbucks Tea', 2.0, 4.0, 5),
	(107, 'Chocolate', 5.0, 50.0, 6);

--Person Inserts
INSERT INTO person(id, vorname, nachname, address, email, geschlecht)
VALUES(1,'Edward', 'Mueller', 'Altestrasse 2', 'edward12@gmail.com', 'Männlich'),
	(2, 'Elena', 'Herbst', 'Zuerichstrasse 80', 'elena.herbst@gmail.com', 'Weiblich'),
	(3, 'Stevan', 'Steiner', 'Winterthurstrasse 200', 'edward12@britishco.org', 'Männlich'),
	(4, 'Natalie', 'Peter', 'Sonnengasse 1', 'enatalie.peter@freshdirect.ch', 'Weiblich'),
	(5, 'Michael', 'David', 'Loewenstrasse 30', 'michael.david@ocado.uk', 'Männlich'),
	(6, 'Martha', 'John', 'Bahnhofstrasse 11', 'martha.john@gmail.com', 'Weiblich'),
	(7, 'Martha', 'John', 'Bergstrass 20', 'martha.me@tesco.net', 'Weiblich'),
	(8, 'Adrian', 'Peter', 'Ottikerstrasse 4', 'peter11@gw.org', 'Männlich'),
	(9, 'Adrian', 'Peter', 'Wollishoferstrasse 74', 'peter.adrian@mgb.ch', 'Männlich');

--OnlineBestellung Inserts
INSERT INTO onlinebestellung(id, bestelldatum, produktnr_id, person_id)
VALUES(111, '2018-11-21', 103, 2),
	(212, '2018-11-23', 102, 3),
	(323, '2018-11-21', 107, 1),
	(434, '2018-11-23', 101, 4),
	(545, '2018-11-23', 106, 5),
	(646, '2018-11-22', 106, 4),
	(565, '2018-11-23', 106, 5),
	(423, '2018-11-22', 106, 3),
	(324, '2018-11-23', 106, 5),
	(656, '2018-11-21', 105, 6),
	(767, '2018-11-21', 104, 7),
	(878, '2018-11-23', 104, 6),
	(989, '2018-11-23', 104, 7),
	(1001, '2018-11-22', 101, 8);
	
	
--Mitarbeiter Inserts
INSERT INTO mitarbeiter(id, anstellungsdatum, person_id, lmgeschaeft_id)
VALUES(1, '2017-1-1', 3, 9),
	(2, '2016-10-15', 2, 3),
	(3, '2018-9-1', 7, 8),
	(4, '2012-2-1', 1, 5),
	(5, '2000-8-8', 6, 4),
	(6, '2003-3-3', 5, 7),
	(7, '2005-5-5', 4, 6);
		
	
--Versand Inserts
INSERT INTO versand(id, versanddatum, dauer, erhalten, onlinebestell_id)
VALUES(10,'2018-11-22', 1, FALSE, 111),
	(11, '2018-11-25', 2, TRUE, 212),
	(12, '2018-11-23', 2, TRUE, 323),
	(13, '2018-11-26', 3, TRUE, 434),
	(14, '2018-11-25', 2, TRUE, 545),
	(15, '2018-11-25', 3, TRUE, 646),
	(16, '2018-11-26', 3, TRUE, 565),
	(17, '2018-11-24', 2, TRUE, 423),
	(18, '2018-11-26', 3, TRUE, 324),
	(19, '2018-11-24', 2, TRUE, 656),
	(20, '2018-11-24', 3, TRUE, 767),
	(21, '2018-11-23', 2, TRUE, 878),
	(22, '2018-11-26', 3, TRUE, 989),
	(23, '2018-11-24', 2, TRUE, 1001);
