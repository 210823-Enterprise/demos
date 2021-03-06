-- This is a single line comment

/*
	This is a multi-line comment
	
	you can put your cursor on the expression and press ctrl + enter to run the script
*/

CREATE SCHEMA sophiag;


DROP TABLE IF EXISTS public.employees CASCADE;
/*
 * CASCADE completetly removes the users table, regardless of any relationships
 * without CASCADE the drop would fail
 */

-- This is DDL: Data Definition Language - DEFINING TABLE STRUCTURE!
CREATE TABLE public.employees (
	id SERIAL PRIMARY KEY, -- SERIAL IS an autoincrememted number
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), -- CONSTRAINTS SERVe TO FILTER 
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE,
	employee_age INTEGER NOT NULL DEFAULT 0 CHECK(user_age >= 0),
	supervisor INTEGER
); 

-- Altering a table is also ddl
ALTER TABLE public.employees
	ADD CONSTRAINT employee_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES public.employees(id);


-- DML: Data Manipulation Language to add data to our tables
-- INSERT INTO TABLE_NAME (COLUMN1, COLUM2, ...) VALUES (?, ?);

INSERT INTO public.employees (first_name, last_name, email, employee_age)
	VALUES ('Tony', 'Stark', 'ironman@mail.com', 40);


INSERT INTO public.employees (first_name, last_name, email, employee_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@mail.com', 16, 1),
 		    ('Pepper', 'Potts', 'pepper@mail.com', 30, 1);


-- DQL: Data Query Language
SELECT * FROM public.employees;

-- selectively query names and save as a "virtual table" which is a view
CREATE VIEW names AS SELECT first_name, last_name FROM public.employees;

SELECT * FROM names;

-- concatenate and reformat the data with an alias with the AS keyword
SELECT first_name || ' ' || last_name AS "Full Name" FROM public.employees;

DROP TABLE IF EXISTS public.phonenumbers CASCADE;

CREATE TABLE public.phonenumbers (
	id SERIAL PRIMARY KEY,
	employee_id INTEGER NOT NULL REFERENCES employees(id), -- our FOREIGN key
	home VARCHAR(20),
	work_num VARCHAR(20),
	mobile VARCHAR(20)
);

INSERT INTO public.phonenumbers (employee_id, home, mobile) 
	VALUES (1, '111-222-3333', '222-333-4444'),
			(3, '777-888-9999', '434-222-0909');
		
SELECT * FROM phonenumbers;


-- DML How would we delete Pepper Potts phoine number from the phonenumbers table?
DELETE FROM public.phonenumbers WHERE employee_id = 3;

-- THIS IS DDL. HOW IS TRUNCATE DIFFERENT FROM DELETE? WHAT ABOUT DROP?
TRUNCATE TABLE public.phonenumbers;



















