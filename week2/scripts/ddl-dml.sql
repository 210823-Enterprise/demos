-- This is a single line comment

/*
	This is a multi-line comment
	
	you can put your cursor on the expression and press ctrl + enter to run the script
*/

CREATE SCHEMA sophiag;


DROP TABLE IF EXISTS public.users CASCADE;
/*
 * CASCADE completetly removes the users table, regardless of any relationships
 * without CASCADE the drop would fail
 */

-- This is DDL: Data Definition Language - DEFINING TABLE STRUCTURE!
CREATE TABLE public.users (
	id SERIAL PRIMARY KEY, -- SERIAL IS an autoincrememted number
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), -- CONSTRAINTS SERVe TO FILTER 
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE,
	user_age INTEGER NOT NULL DEFAULT 0 CHECK(user_age >= 0),
	supervisor INTEGER
); 

-- Altering a table is also ddl
ALTER TABLE public.users
	ADD CONSTRAINT user_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES public.users(id);
	


-- DQL: Data Query Language
SELECT * FROM public.users;


-- DML: Data Manipulation Language to add data to our tables
-- INSERT INTO TABLE_NAME (COLUMN1, COLUM2, ...) VALUES (?, ?);

INSERT INTO public.users (first_name, last_name, email, user_age)
	VALUES ('Tony', 'Stark', 'ironman@mail.com', 40);


INSERT INTO public.users (first_name, last_name, email, user_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@mail.com', 16, 1),
 		    ('Pepper', 'Potts', 'pepper@mail.com', 30, 1);










