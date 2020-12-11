drop table TipoAmador;
drop table TipoSemiProfissional;
drop table TipoProfissional;
drop table TipoAtleta;

create table TipoAtleta(
tipo int,
nome varchar(20));

alter table TipoAtleta add constraint pk_TipoAtleta primary key(tipo);

create table TipoAmador(
tipo int constraint pk_TipoAmador primary key,
pct_variavel number(5, 2));

alter table TipoAmador
  add constraint fk_TipoAmador_TipoAtleta foreign key (tipo) references TipoAtleta(tipo);

create table TipoSemiProfissional(
tipo int
  constraint pk_TipoSemiProfissional primary key
  constraint fk_TipoSemiProfissional references TipoAtleta(tipo),
pct_fixa number(5, 2));

create table TipoProfissional(
tipo int
  constraint pk_TipoProfissional primary key
  constraint fk_TipoProfissional references TipoAtleta(tipo),
pct_variavel number(5, 2));
