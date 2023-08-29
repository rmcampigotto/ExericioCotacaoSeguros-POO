package org.example.domain;

import org.example.domain.enums.EstadoCivil;

public abstract class Pessoa{

    private String nome;
    private EstadoCivil estadoCivil;

    public Pessoa(String nome, EstadoCivil estadoCivil) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
    }

    public EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }
}
