CREATE TABLE telefone (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
	,numero VARCHAR(14) NOT NULL
	,tipo_telefone_id BIGINT UNSIGNED NOT NULL
	,contato_id BIGINT UNSIGNED NOT NULL
	,FOREIGN KEY (tipo_telefone_id) REFERENCES tipo_telefone(id)
	,FOREIGN KEY (contato_id) REFERENCES contato(id)
);
