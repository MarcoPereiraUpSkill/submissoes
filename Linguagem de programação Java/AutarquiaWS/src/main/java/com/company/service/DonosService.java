/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.ListaPessoaDTO;
import com.company.dto.Mapper;
import com.company.dto.PessoaDTO;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Pessoa;
import com.company.repo.Dados;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class DonosService {

    public static void addDono(String freguesia, int terreno, PessoaDTO pessoaDTO) {
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);

        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addDono(freguesia, terreno, pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("Pessoa inválida!");
        }
    }

    public static ListaPessoaDTO getDonos(String freguesia, int terreno) {
        ListaPessoaDTO listaPessoasDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Pessoa> donos = autarquia.getDonos(freguesia, terreno);
        listaPessoasDTO = Mapper.listPessoa2PessoaDTO(donos);
        return listaPessoasDTO;
    }

}
