/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.Mapper;
import com.company.dto.TerrenoDTO;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Freguesia;
import com.company.model.Terreno;
import com.company.repo.Dados;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class TerrenosService {

    public static void addTerreno(TerrenoDTO terrenoDTO, String freguesia) {
        Terreno terreno = Mapper.terrenoDTO2Terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(terreno, freguesia);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static ListaTerrenoDTO getTerrenos(String freguesia) {
        ListaTerrenoDTO listaTerrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Terreno> terrenos = autarquia.getTerrenos(freguesia);
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }
    
    public static TerrenoDTO getTerreno(String freguesia, int terreno){
        TerrenoDTO terrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        Terreno t = autarquia.getTerreno(freguesia, terreno);
        terrenoDTO = Mapper.terreno2TerrenoDTO(t);
        return terrenoDTO;
    }
}
