package org.example.domain;
import org.example.domain.enums.TipoAutomovel;

public class Automovel {

    private TipoAutomovel tipoAutomovel;
    private double valorBase;

    public Automovel(TipoAutomovel tipoAutomovel, double valorBase) {
        this.tipoAutomovel = tipoAutomovel;
        this.valorBase = valorBase;
    }

    public double getValorBase() {
        return this.valorBase;
    }

    public TipoAutomovel getTipoAutomovel() {
        return this.tipoAutomovel;
    }
}
