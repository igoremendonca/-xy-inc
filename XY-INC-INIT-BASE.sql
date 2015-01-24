
	-- 'Criando SCHEMA POI'

	CREATE SCHEMA poi AUTHORIZATION postgres;

	  -- ***************************
	  
	-- 'Criando TABELA POI'  
	  
	CREATE TABLE poi.poi ( id serial NOT NULL, nome text, coodx integer, coody integer) WITH (OIDS=FALSE);
	ALTER TABLE poi.poi OWNER TO postgres;
	 
	 
	-- 'Inserindo POIs'
	  
	INSERT INTO poi.poi(nome, coodx, coody) VALUES ('Lanchonete', 27, 12);
		
	INSERT INTO poi.poi(nome, coodx, coody) VALUES ('Posto', 31, 18);
		
	INSERT INTO poi.poi(nome, coodx, coody) VALUES ('Joalheria', 15, 12);
		
	INSERT INTO poi.poi(nome, coodx, coody) VALUES ('Floricultura', 19, 21);