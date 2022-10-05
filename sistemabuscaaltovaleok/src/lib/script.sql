CREATE TABLE public.tbcadastropessoafisica (
	fisicocodigo serial NOT null,
	nomecompleto varchar(100) NOT NULL,
	cpf int4 NOT NULL,
	emailfisico varchar(100) NOT NULL,
	senhafisico varchar(100) NOT NULL,
	telefonefisico varchar(25) NOT null,
	CONSTRAINT pk_tbcadastropessoafisica PRIMARY KEY (fisicocodigo, cpf, emailfisico)
	
);

insert into tbcadastropessoafisica(
	nomecompleto,
	cpf,
	emailfisico,
	senhafisico,
	telefonefisico)values (
		'Bruno',
		'0515441616',
		'bruno@email.com',
		'123',
		'473525-1512'
	);

