package org.example.domain;

public class Estacionamento {

    private Boolean portaoAutomatico;

    public Estacionamento(Boolean portaoAutomatico) {
        this.portaoAutomatico = portaoAutomatico;
    }

    public Double valorDesconto(Double valorSeguro) {
        if (portaoAutomatico) {
            return valorSeguro * 0.045;
        }
        return valorSeguro * 0.02;
    }

}
