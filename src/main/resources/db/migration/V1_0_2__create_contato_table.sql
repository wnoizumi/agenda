CREATE TABLE contato (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
	,nome VARCHAR(75) NOT NULL
    ,sobrenome VARCHAR(75)
    ,email VARCHAR(150)
    ,data_nascimento DATE
    ,usuario_id BIGINT UNSIGNED NOT NULL
    ,FOREIGN KEY(usuario_id ) REFERENCES usuario(id) 
);

