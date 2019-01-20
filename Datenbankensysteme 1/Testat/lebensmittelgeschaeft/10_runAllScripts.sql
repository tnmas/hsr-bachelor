


\echo \conninfo
\echo
\echo -n 'client encoding: '\encoding
\echo

SET client_min_messages = ERROR;
\set user bibliothek_user 
\set password '\'user\''
\set database 'bibliothek'
\set promptvar ''

\echo -------------------------------------
\echo passwort for user :user = :password
\echo -------------------------------------
\echo

SELECT pg_terminate_backend(pg_stat_activity.pid)
    FROM pg_stat_activity
    WHERE pg_stat_activity.datname = 'bibliothek'
      AND pid <> pg_backend_pid();
	  

DROP DATABASE if exists :database;
DROP USER if exists :user;

CREATE USER :user WITH PASSWORD :password;
CREATE DATABASE :database WITH OWNER :user ENCODING 'UTF8';
\c :database :user

-- specify encoding to match your files encoding, usually UTF8
\encoding 'UTF8'

-- create schema
\ir 9_bibliothek.sql

--\ir test.sql