CREATE TABLE public.tbpessoafisica (
	fiscodigo serial NOT null,
	fisnome varchar(100) NOT NULL,
	fiscpf varchar(20) NOT NULL,
	fisemail varchar(100) NOT NULL,
	fissenha varchar(100) NOT NULL,
	fistelefone varchar(25) NOT null,
	fiscidade varchar(100) not null,
	fisestado varchar(100) not null,
	CONSTRAINT pk_tbpessoafisica PRIMARY KEY (fiscodigo, fiscpf, fisemail)
);


CREATE TABLE public.tbpessoajuridica (
	jurcodigo serial NOT null,
	jurrazaosocial varchar(100) NOT NULL,
	jurcnpj varchar(20) NOT NULL,
	juremail varchar(100) NOT NULL,
	jursenha varchar(100) NOT NULL,
	jurtelefone varchar(25) NOT null,
	jurcidade varchar(100) not null,
	jurestado varchar(100) not null,
	jurdescricao text not null,
	juratuacao varchar(100) not null,
	CONSTRAINT pk_tbpessoajuridica PRIMARY KEY (jurcodigo, jurcnpj, juremail)
);





