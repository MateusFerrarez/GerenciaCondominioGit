/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.gerenciacondominio.model;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class ParcelaResidencia {

    private double vlReceber;
    private double vlRecebido;
    private LocalDate dtVencimento;
    private Long idParcela;
    private Long idResidencia;
    private boolean emDia;

    public ParcelaResidencia(double vlReceber, double vlRecebido, LocalDate dtVencimento, Long idParcela, boolean emDia) {
        this.vlReceber = vlReceber;
        this.vlRecebido = vlRecebido;
        this.dtVencimento = dtVencimento;
        this.idParcela = idParcela;
        this.emDia = emDia;
    }

    public ParcelaResidencia(double vlReceber, double vlRecebido, LocalDate dtVencimento, Long idResidencia) {
        this.vlReceber = vlReceber;
        this.vlRecebido = vlRecebido;
        this.dtVencimento = dtVencimento;
        this.idResidencia = idResidencia;
    }
    
    

    public ParcelaResidencia(double vlReceber, double vlRecebido, LocalDate dtVencimento) {
        this.vlReceber = vlReceber;
        this.vlRecebido = vlRecebido;
        this.dtVencimento = dtVencimento;
    }
    
    

    public Long getIdResidencia() {
        return idResidencia;
    }

    public Long getIdParcela() {
        return idParcela;
    }

    public boolean isEmDia() {
        return emDia;
    }

    
    
    public double getVlReceber() {
        return vlReceber;
    }

    public void setVlReceber(double vlReceber) {
        this.vlReceber = vlReceber;
    }

    public double getVlRecebido() {
        return vlRecebido;
    }

    public void setVlRecebido(double vlRecebido) {
        this.vlRecebido = vlRecebido;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

}
