CREATE TABLE cliente (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cpf_cnpj VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cliente (nome, cpf_cnpj) values ('João Silva','19242977012');
INSERT INTO cliente (nome, cpf_cnpj) values ('Pedro Silveira','29933861824');

CREATE TABLE favorecido (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cpf_cnpj VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO favorecido (nome, cpf_cnpj) values ('Mauro Silva','29933861824');
INSERT INTO favorecido (nome, cpf_cnpj) values ('Rafael Siqueira','29933861824');
INSERT INTO favorecido (nome, cpf_cnpj) values ('Paulo Santos','19242977012');
INSERT INTO favorecido (nome, cpf_cnpj) values ('Joel Santos','19242977012');
