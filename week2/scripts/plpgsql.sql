  
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


CREATE OR REPLACE FUNCTION sophiag.multiply(x NUMERIC, y NUMERIC)
RETURNS NUMERIC
AS '

	begin
		return x * y;
	end

	'
LANGUAGE plpgsql;


SELECT multiply(5, '4'); -- postgresql has TYPE coercion!

CREATE OR REPLACE FUNCTION sophiag.multiply(x NUMERIC, y NUMERIC, z NUMERIC)
RETURNS NUMERIC
AS $$

	begin
		return $1 * $2 * $3; -- postgres ALSO provides another way accessing parameters WITH $
	end

	$$
LANGUAGE plpgsql;


-- we're  going to create a function with variables 
-- that fethces the ery last track from the chinook db
SELECT * FROM chinook."Track";


CREATE OR REPLACE FUNCTION chinook.get_last_track_info()
RETURNS TEXT 
AS $$
	
	DECLARE -- DECLARE variables TO use IN the FUNCTION body 
	largest INT;
	track_name TEXT;
	end_result TEXT;

BEGIN
	
	-- AGGREGATE FUNCTION
	SELECT max("TrackId")
		INTO largest
		FROM chinook."Track";
		
	-- Save the name as the Track name
	-- Select the "Name" columm from the track table where the TrackID is the largest
	SELECT "Name" 
		INTO track_name
		FROM chinook."Track" WHERE "TrackId" = largest;
	
	end_result := largest || ' ' || track_name;

	RETURN end_result;
END
	

$$
LANGUAGE plpgsql;


SELECT * FROM chinook.get_last_track_info();


















