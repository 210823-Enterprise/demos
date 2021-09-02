  
-- This is the script where I'm going to create the tables for my app

DROP TYPE IF EXISTS sophiag.user_role CASCADE;
CREATE TYPE sophiag.user_role AS ENUM ('Admin', 'Employee', 'Customer');

-- This is just a demo of JDBC connection, and YOUR projhect 0 script does not need to be exactly like this

DROP TABLE IF EXISTS sophiag.users CASCADE;
CREATE TABLE sophiag.users(
	
	-- it does NOT need to be the same name as your User.java instance variables
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role sophiag.user_role NOT NULL
);

DROP TABLE IF EXISTS sophiag.accounts CASCADE;
CREATE TABLE sophiag.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES sophiag.users(id),
	active BOOLEAN DEFAULT FALSE -- this IS determining whether the account has been activated
);

-- This is demonstrating a MANY to MANY relationship....
DROP TABLE IF EXISTS sophiag.users_account_jt CASCADE;
CREATE TABLE sophiag.users_account_jt (
	acc_owner INTEGER NOT NULL REFERENCES sophiag.users(id),
	account INTEGER NOT NULL REFERENCES sophiag.accounts(id)
);

-- this table represents pending applications of users who want to open an account
DROP TABLE IF EXISTS sophiag.applications CASCADE;
CREATE TABLE sophiag.applications (
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES sophiag.users(id)
);

SELECT * FROM sophiag.users;

-- When you truncate a table, you remove all of the data inside of it, without
-- actually deleting the table itself.
TRUNCATE TABLE sophiag.users CASCADE;


-- We need to trigger an insert of the necessary data INTO the users_account_jt,
-- WHENEVER an account is inserted into the accounts table

SELECT * FROM sophiag.users_account_jt;

/*
PL/pgSQL procedural language adds many procedural elements, 
e.g., control structures, loops, and complex computations, 
to extend standard SQL. It allows you to insert elements automatically into a table...
*/

/*
	PL/pgSQL = Procedural Language extension of PostgreSQL
	
		- NOT A SUBLANGUAGE OF SQL!
		- Allows devs to create:
			- stored functions (returns a result)
			- stored procedures (since postgres 11)
			- triggers
			- custom types
			
		- Adds procedural features to the normally declarative SQL scripts
			- loops
			- exception handling
			- if statements
			
*/

/*
	Stored Functions
	
		create [or replace] function [name] (params)
		returns [type]
		as '
			begin
				[logic]
			end
		'
		language plpgsql;
*/

-- Create the function to insert elements of a new ACCOUTN recorD into the
-- THE users_account_jt table
CREATE OR REPLACE FUNCTION sophiag.auto_insert_into_jt() RETURNS TRIGGER AS
$BODY$
BEGIN
	
	INSERT INTO
		sophiag.users_account_jt(acc_owner, account)
		VALUES(NEW.acc_owner, NEW.id);
	
			RETURN NEW;
END
$BODY$
LANGUAGE plpgsql;

-- set the trigger so that every time a new row is inserted into the ACCOUNTS
-- table, it automatically populates the users_accounts_jt table;
CREATE TRIGGER trig
	AFTER INSERT ON sophiag.accounts 
	FOR EACH ROW
	EXECUTE PROCEDURE sophiag.auto_insert_into_jt();

SELECT * FROM sophiag.users;
SELECT * FROM sophiag.accounts;
SELECT * FROM sophiag.users_account_jt;

TRUNCATE TABLE sophiag.users CASCADE;
TRUNCATE TABLE sophiag.accounts CASCADE;


INSERT INTO sophiag.users(username, pwd, user_role) 
	VALUES ('Larry', 'secret', 'Employee'),
			('Mary', '1234', 'Customer'),
			('Bary', 'pass', 'Customer');


INSERT INTO sophiag.accounts (balance, acc_owner)
	VALUES (100, 4),  -- Larry's ID IS 4
		   (200, 5), -- Mary's ID IS 5
		   (2000, 5), -- Mary's ID IS 5
		    (300, 6); -- Bary's ID IS 6


-- This query is literally pulling from the users_account_jt table to select all accounts owned by a aprticualr user
-- JOIN from the accounts table and the users_account_jt WHERE the accowner_id is the same as the userId
SELECT sophiag.accounts.id, sophiag.accounts.balance FROM sophiag.accounts
	INNER JOIN sophiag.users_account_jt 
		ON sophiag.accounts.id = sophiag.users_account_jt.account	
			WHERE sophiag.users_account_jt.acc_owner = 5;
-- The above query helps use find all the accounts that belong to a specific owner based on their ID
