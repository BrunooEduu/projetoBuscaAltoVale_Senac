--etapas
-- 1 excluir as 2 tabelas abaixo e deixar apenas uma tabela...
-- 2 - criar apenas 1 tabela de pessoa e 1 coluna de tipo (1 - fisica - 2- Juridica)

drop table tbpessoafisica;
drop table tbpessoajuridica;

CREATE TABLE public.tbpessoa(
    pescodigo serial NOT null,
    pesnome varchar(100) NOT NULL,
    pescpfcnpj varchar(20) NOT NULL,
    pesemail varchar(100) NOT NULL,
    pessenha varchar(100) NOT NULL,
    pestelefone varchar(25) NOT null,
    pescidade varchar(100) not null,
    pesestado varchar(100) not null,
    pestipo int not null default 1,-- (1 - fisica - 2- Juridica)
    pesdescricao varchar(400) null,
    pesatuacao varchar(400) null,
    CONSTRAINT pk_tbpessoa PRIMARY KEY (pescodigo)
);

-- Nao deixa cadastrar 2 cpf/cnpj iguais
create unique index tbpessoa_cpfcnpj_idx on tbpessoa using btree (pescpfcnpj);

-- Nao deixa cadastrar 2 e-mail iguais
create unique index tbpessoa_email_idx on tbpessoa using btree (pesemail);

-- FK DE EMPRESA PARA PESSOA
alter table public.tbempresa add CONSTRAINT "FK_TBEMPRESA=>TBPESSOA" FOREIGN KEY (pescodigo)
REFERENCES public.tbpessoa(pescodigo);

-- TIPO DE USUARIO
CREATE TABLE public.tbtipousuario (
	tipcodigo serial NOT null,
	tipnome varchar(100) not null,  --(ADMINISTRADOR, EMPRESA, FUNCIONARIO, ETC)
	CONSTRAINT pk_tbtipousuario PRIMARY KEY (tipcodigo)
);


-- Ligacao de usuario com tipos de usuarios 
-- Cada pessoa pertence a um tipo de usuario 
CREATE TABLE public.tbpessoatipousuario (
	pescodigo int not null,
	tipcodigo int not null,
	CONSTRAINT pk_tbpessoatipousuario PRIMARY KEY (pescodigo,tipcodigo)
);