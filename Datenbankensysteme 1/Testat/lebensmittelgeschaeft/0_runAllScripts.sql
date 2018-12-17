


\echo \conninfo
\echo
\echo -n 'client encoding: '\encoding
\echo

SET client_min_messages = ERROR;
\set user tsigu 
\set password '\'tsigu\''
\set database 'lmgeschaeft'
\set promptvar ''

\echo -------------------------------------
\echo passwort for user :user = :password
\echo -------------------------------------
\echo

SELECT pg_terminate_backend(pg_stat_activity.pid)
    FROM pg_stat_activity
    WHERE pg_stat_activity.datname = 'lmgeschaeft'
      AND pid <> pg_backend_pid();
	  

DROP DATABASE if exists :database;
DROP USER if exists :user;

CREATE USER :user WITH PASSWORD :password;
CREATE DATABASE :database WITH OWNER :user ENCODING 'UTF8';
\c :database :user

-- specify encoding to match your files encoding, usually UTF8
\encoding 'UTF8'

-- create schema
\ir 2_schema.sql

-- insert data in slo-mo or use COPY for speedup
\ir 3_inserts.sql

-- create primary keys, constraints, indexes
\ir 4_constraints.sql

\echo
\prompt 'Execute Queries (\\q or Ctrl-C to abort)?' promptvar
:promptvar

-- set client encoding for query results to auto
-- > adjust if the detected default is not what you want
-- valid values are: 'UTF8', 'LATIN1', 'WIN1252'
\encoding 'auto'

-- query the database

\set ECHO queries
\ir 5_queries.sql

\set ECHO queries
\ir 6_CTE.sql

\set ECHO queries
\ir 7_views.sql

\set ECHO queries
\ir 8_zusatzaufgaben.sql
