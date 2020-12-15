-- Mostrar todos os atletas

select * 
    from Atleta;
    
-- Mostrar tudo sobre os atletas, ordenando por g�nero(crescente) e nome (descendente)

select * 
    from Atleta
    order by genero, nome desc;
    
-- Mostrar todos os atletas cujo nome cont�m 'MC'

select *
    from Atleta
    where nome like '%Mc%';
    
-- Mostrar todos os atletas cujo primeiro nome come�a por 'A' e o �ltimo por 'M'
select *
    from Atleta
    where nome like 'A% M%';
    
-- Mostrar as competi��es que t�m '%' no seu nome
select * 
    from Competicao
    where nome like '%\%%' escape '\';
    
-- Mostrar o nic e o nome dos atletas e o nome das competi��es em que participaram
-- A coluna nome da competi��o deve chamar-se nome_competicao
select a.nic, a.nome, c.nome nome_competicao
    from Atleta a 
    join Participa b on (a.id = b.id_atleta)
    join Competicao c on (b.id_competicao = c.id);
    
--Mostrar o nic e o nome dos atletas que nunca participaram em competi��es
select nic, nome
    from Atleta
    where id not in (select id_atleta from Participa);

select b.nic, b.nome 
from (    
    select id
        from Atleta
        minus
    select id_atleta
        from Participa
        ) a join Atleta b on (a.id = b.id);
            
select nic, nome
    from Atleta
    where not exists (select * from Participa where id_atleta = Atleta.id);
    
-- Mostrar o nic e o nome dos atletas femininos que nunca participaram em competi��es
select nic, nome
    from Atleta
    where id not in (select id_atleta from Participa)
    and genero = 'F';
    
-- Mostrar o id dos atletas e o n�mero de competi��es em que participaram,
-- ordenado por n�mero de competi��es e id de atleta
select id_atleta, count(*) competicoes
    from Participa
    group by id_atleta
    order by 2, 1;
    
-- Obter o nic e o nome dos atletas e o n�mero de competi��es em que participaram,
-- ordenado por n�mero de competi��es e nome do atleta
select b.nic, b.nome, a.competicoes
    from (select id_atleta, count(*) competicoes
        from Participa
        group by id_atleta) a join Atleta b on (a.id_atleta = b.id)
    order by a.competicoes, b.nome;    
    
-- Obter o nic e o nome dos atletas e o n�mero de competi��es em que participaram,
-- ordenado por n�mero de competi��es e nome do atleta
-- Os atletas que n�o participaram em competi��es tamb�m devem ser mostrados
select b.nic, b.nome, nvl(a.competicoes ,0) competicoes
    from(
        select id_atleta, count(*) competicoes
        from Participa
        group by id_atleta
    ) a right join Atleta b on (a.id_atleta = b.id)
    order by nvl(a.competicoes, 0), b.nome;
    
select nic, nome,
    (select count(*)
        from Participa
        where id_atleta = Atleta.id) competicoes
    from Atleta
    order by 3, nome;
    
-- Obter o nic e o nome dos atletas e o n�mero de competi��es em que participaram de
-- atletas que participaram em mais que 2 competi��es
-- ordenado por n�mero de competi��es e nome do atleta
select * from 
(
    select b.nic, b.nome, a.competicoes
        from(
            select id_atleta, count(*) competicoes
            from Participa
            group by id_atleta
        ) a right join Atleta b on (a.id_atleta = b.id)
        order by nvl(a.competicoes, 0), b.nome
) where competicoes >= 2
order by 3 , nome;

with w1 as
    (select id_atleta, count(*) competicoes
    from Participa
    group by id_atleta)
select b.nic, b.nome, a.competicoes
    from (select *
        from w1
        where competicoes >= 2) a join Atleta b on (a.id_atleta = b.id)
    order by a.competicoes, b.nome;
    
-- Obter o nic e o nome dos atletas e o n�mero de competi��es em que participaram em mais competi��es,
-- ordenado por n�mero de competi��es e nome do atleta
with w1 as
    (select id_atleta, count(*) competicoes
    from Participa
    group by id_atleta)
select b.nic, b.nome, a.competicoes
    from (select *
        from w1
        where competicoes >= (select max(competicoes) from w1)) a join Atleta b on (a.id_atleta = b.id)
    order by a.competicoes, b.nome;
    
-- Obter o id do atleta e o n�mero de atividades que pratica ordenando por ordem decrescente
-- do n�mero de atividades
select a.id, count(*)
    from Atleta a join AtividadeAtleta b on (a.id = b.id_atleta)
    group by a.id
    order by 2 desc;
    
-- Obter os atletas que praticam todas as atividades
select *
    from Atleta
    where not exists (select id
                            from Atividade
                            minus
                            select id_atividade
                            from AtividadeAtleta
                            where id_atleta = Atleta.id);

-- Obter os atletas que participaram em todas as competi��es que poderiam participar
select *
    from Atleta
    where not exists(select id
                        from Competicao a join AtividadeAtleta b on (a.id_atividade = b.id_atividade)
                        where b.id_atleta = Atleta.id
                        minus
                        select id_competicao
                        from Participa
                        where id_atleta = Atleta.id);
                        
-- Obter os registos de atletas que n�o t�m correspond�ncia na tabela de tipos de atletas
select *
    from Atleta
    where id not in (select id
                        from Profissional
                        union
                        select id 
                        from SemiProfissional
                        union
                        select id
                        from Amador);              
                        
insert into Amador(id)
    select id
        from Atleta
        where tipo_atleta = 3;
        
insert into Profissional(id)
    select id
        from Atleta
        where tipo_atleta = 1;
        
insert into SemiProfissional(id)
    select id
        from Atleta
        where tipo_atleta = 2;        
                        
-- Criar um procedimento para criar atletas
-- Os par�metros do procedimento devem ser: nome, nic, g�nero, data de nascimento e tipo de atleta
-- Os par�metros obrigat�rios devem ser: nome, nic e tipo de atleta

create or replace procedure criarAtleta(
    p_nome Atleta.nome%type,
    p_nic Atleta.nic%type,
    p_genero Atleta.genero%type default null,
    p_data_nascimento Atleta.data_nascimento%type default null,
    p_tipo_atleta Atleta.tipo_atleta%type)
is 
    v_id int;
begin
    select nvl(max(id), 0) + 1 into v_id from Atleta;
    insert into Atleta (id, nome, nic, genero, data_nascimento, tipo_atleta)
    values (v_id, p_home, p_nic, p_genero, p_data_nascimento, p_tipo_atleta);
    if p_tipo_atleta = 1 then
        insert into Profissional(id) values(v_id);
    elsif p_tipo_atleta = 2 then
        insert into SemiProfissional(id) values(v_id);
    elsif p_tipo_atleta = 3 then
        insert into Amador(id) values (v_id);
    end if;
end;    
/
        
begin
    criarAtleta(p_nome => 'Speedy Gonzales', p_nic => '18662716', p_genero => 'M', p_tipo_atleta => 1);
end;
/

create or replace trigger trgAtleta before insert or update on Atleta for each row
begin 
    if inserting then
        if :new.tipo_atleta = 1 then
            insert into Profissional(id) values(:new.id);
        elsif :new.tipo_atleta = 2 then
            insert into SemiProfissional(id) values(:new.id);
        elsif :new.tipo_atleta = 3 then
            insert into Amador(id) values(:new.id);
        end if;
        --
        if :old.tipo_atleta = 1 then
            delete from Profissional where id = :old.id;
        elsif :old.tipo_atleta = 2 then
            delete from SemiProfissional where id = :old.id;
        elsif :old.tipo_atleta = 3 then
            delete from Amador where id = :old.id;
        end if;    
    end if;
end;
/