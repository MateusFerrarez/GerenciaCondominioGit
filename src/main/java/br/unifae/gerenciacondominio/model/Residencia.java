/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model;

/**
 *
 * @author android
 */
public class Residencia {

    private Long idResidencia;
    private String rua;
    private String numero;
    private String cep;

    public Residencia(String rua, String numero, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public Residencia(Long idResidencia, String rua, String numero, String cep) {
        this.idResidencia = idResidencia;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public Long getIdResidencia() {
        return idResidencia;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
