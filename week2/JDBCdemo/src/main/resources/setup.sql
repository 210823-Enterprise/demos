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