/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.TerrenoDTO;
import com.company.service.TerrenosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/api")
public class TerrenosController {

    @RequestMapping(value = "/freguesias/{nome}/terrenos",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoFreguesia(@PathVariable("nome") String freguesia, @RequestBody TerrenoDTO terrenoDTO) {
        try {
            TerrenosService.addTerreno(terrenoDTO, freguesia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenosFreguesia(@PathVariable("nome") String freguesia) {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getTerrenos(freguesia);
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{terreno}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenoFreguesia(@PathVariable("nome") String freguesia, @PathVariable("terreno") int terreno) {
        try {
            TerrenoDTO terrenoDTO = TerrenosService.getTerreno(freguesia, terreno);
            if (terrenoDTO != null) {
                return new ResponseEntity<>(terrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{terreno}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTerrenoFreguesia(@PathVariable("nome") String nome, @RequestBody TerrenoDTO terrenoDTO) {
        try {
            TerrenosService.updateTerreno(nome, terrenoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{terreno}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> deleteTerrenoFreguesia(@PathVariable("nome") String nome, @PathVariable("terreno") int numero) {
        try {
            TerrenosService.deleteTerreno(nome, numero);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
