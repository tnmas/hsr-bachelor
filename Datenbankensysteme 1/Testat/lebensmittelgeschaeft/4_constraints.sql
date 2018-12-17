--CONSTRAINTS
	
-- Constraints versand
ALTER TABLE ONLY versand
	ADD CONSTRAINT versand_dauer_check check (dauer between 1 and 3);
