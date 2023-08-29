package org.example.domain.enums;

public enum TipoAutomovel {
    PASSEIO(0.12),
    PASSEIO_PROFISSIONAL(0.143),
    TRANSPORTE(0.135),
    CARGA(0.08);

    private Double percentual;

    TipoAutomovel(Double percentual){
        this.percentual = percentual;
    }

    public Double getPercentual() {
        return this.percentual;
    }
}
