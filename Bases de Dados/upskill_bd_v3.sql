drop table SemiProfissional;
drop table Profissional;
drop table Amador;
drop table FCM;
drop table FormulaFCM;
drop table Premio;
drop table Participa;
drop table Competicao;
drop table Atividade;
drop table TipoProfissional;
drop table TipoSemiProfissional;
drop table TipoAmador;
drop table Atleta;
drop table Genero;
drop table TipoAtleta;

create table TipoAtleta(
    tipo int,
        constraint pk_TipoAtleta primary key(tipo),
    nome varchar(20));
    
create table Genero (
    genero varchar(1) 
        constraint pk_Genero primary key 
        constraint ck_Genero_genero 
        check (upper(genero) in ('F', 'M')));

create table Atleta(
    nome varchar(50),
    id int,
    nic varchar(15),
        constraint pk_Atleta primary key(nic),
    genero varchar(1),
        constraint fk_Atleta_Genero foreign key (genero) references Genero(genero),
    data_nascimento date,
    tipo_atleta int,
        constraint fk_Atleta_TipoAtleta foreign key (tipo_atleta) references TipoAtleta(tipo));
    
create table TipoAmador(
    tipo int constraint pk_TipoAmador primary key,
    pct_variavel number(5, 2));
    

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

create table Atividade(
    id int 
        constraint pk_atividade primary key, 
    nome varchar(50));
    
create table Competicao(
    id int,
        constraint pk_competicao primary key(id),
    data date, 
    nome varchar(50),
    id_atividade int 
        constraint fk_Competicao_atividade references Atividade(id));
        
create table Participa(
    atleta_nic varchar(15), 
        constraint fk_Participa_Atleta foreign key (atleta_nic) references Atleta(nic),
    competicao_id int,
        constraint fk_Participa_Competicao foreign key (competicao_id) references Competicao(id),
        constraint pk_Participa primary key (atleta_nic, competicao_id));


create table Premio(
    id int 
        constraint pk_Premio primary key,
    atleta_nic varchar(15),
    competicao_id int,
        constraint fk_Premio_Participa foreign key (atleta_nic, competicao_id) 
        references Participa(atleta_nic, competicao_id),
    valor number
        constraint ck_Premio_Valor check(valor > 0));    

create table FormulaFCM(
    id int,
        constraint pk_FormulaFCM primary key(id),
    formula varchar(50));
    
create table FCM(
    formulaFCMMid int,
        constraint fk_FCM_FormulaFCM foreign key (formulaFCMMid) references FormulaFCM(id),
    genero_formula varchar(1),
        constraint fk_FCM_Genero foreign key (genero_formula) references Genero(genero),
    atividade_formula int,
        constraint fk_FCM_atividade foreign key (atividade_formula) references Atividade(id),
        constraint pk_FCM primary key (formulaFCMMid, genero_formula, atividade_formula)
    );
    
create table Amador(
    amador_nic varchar(50),
        constraint fk_Amador_Atleta foreign key (amador_nic) references Atleta(nic),
        constraint pk_Amador primary key(amador_nic));    
        
create table Profissional(
    profissional_nic varchar(50),
        constraint fk_Profissional_Atleta foreign key (profissional_nic) references Atleta(nic),
        constraint pk_Profissional primary key(profissional_nic),
    parcela_fica int    
);

create table SemiProfissional(
    semiprofissional_nic varchar(50),
        constraint fk_SemiProfissional_Atleta foreign key (semiprofissional_nic) references Atleta(nic),
        constraint pk_SemiProfissional primary key(semiprofissional_nic));   
        
        
