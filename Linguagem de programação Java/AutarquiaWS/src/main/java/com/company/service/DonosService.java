/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.Mapper;
import com.company.dto.PessoaDTO;
import com.company.model.Autarquia;
import com.company.model.Pessoa;
import com.company.repo.Dados;

/**
 *
 * @author marco
 */
public class DonosService {

    public static void addDono(String freguesia, int terreno, PessoaDTO pessoaDTO) {
       Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
       
       if(pessoa != null){
           Autarquia autarquia = Dados.carregarDados();
           autarquia.addDono(freguesia, terreno, pessoa);
       }
    }
    
}
