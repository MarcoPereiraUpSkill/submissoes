/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.exception;

/**
 *
 * @author marco
 */
public class DataInvalidaException extends RuntimeException{
    public DataInvalidaException(String s){
        super(s);
    }
}
