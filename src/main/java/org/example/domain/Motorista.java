package org.example.domain;

import org.example.domain.enums.EstadoCivil;

public class Motorista extends Pessoa {

    private Automovel automovel;
    private Estacionamento estacionamento;

    public Motorista(String nome, EstadoCivil estadoCivil,Automovel automovel, Estacionamento estacionamento) {
        super(nome, estadoCivil);
        this.automovel = automovel;
        this.estacionamento = estacionamento;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }
}
