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


CREATE TABLE public.tbadministrador (
    pescodigo int NOT null,
    CONSTRAINT pk_tbadministrador PRIMARY KEY (pescodigo)
);

-- fazer web 
CREATE TABLE public.tbvagas (
    vagcodigo serial NOT null,
    pescodigo int not null, -- empresa
    vagnome varchar (300) NOT NULL, -- gerente producao
    vagdescricao varchar (300) NOT NULL, -- requisitos, atividades a desenvolver
    CONSTRAINT pk_tbvagas PRIMARY KEY (vagcodigo)
);

insert into public.tbvagas(pescodigo,vagnome,vagdescricao) values(3, 'PROGRAMADOR DE SISTEMAS PHP', 'FAZER MANUETENCAO DE SISTEMAS EM PHP');

select * from tbvagas

CREATE TABLE public.tbvagasempresa (
    pescodigo serial NOT null,
    codigovaga int NOT NULL,
    CONSTRAINT pk_tbvagasempresa PRIMARY KEY (pescodigo, codigovaga)
);


insert into public.tbvagasempresa (PESCODIGO, codigovaga) values (3,1);
