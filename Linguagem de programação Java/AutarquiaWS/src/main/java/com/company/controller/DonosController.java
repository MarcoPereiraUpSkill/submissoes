/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.ListaPessoaDTO;
import com.company.dto.PessoaDTO;
import com.company.dto.TerrenoDTO;
import com.company.service.DonosService;
import com.company.service.PessoasService;
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
public class DonosController {

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{numero}/donos",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addDonoTerreno(@PathVariable("nome") String freguesia, @PathVariable("numero") int terreno,
            @RequestBody PessoaDTO pessoaDTO) {
        try {
            DonosService.addDono(freguesia, terreno, pessoaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{numero}/donos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoas(@PathVariable("nome") String freguesia, @PathVariable("numero") int terreno) {
        try {
            ListaPessoaDTO listaPessoaDTO = DonosService.getDonos(freguesia, terreno);
            if (listaPessoaDTO.getPessoas().size() > 0) {
                return new ResponseEntity<>(listaPessoaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
