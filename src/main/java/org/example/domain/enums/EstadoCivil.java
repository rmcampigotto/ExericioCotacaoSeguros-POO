package org.example.domain.enums;

public enum EstadoCivil {
    SOLTEIRO_DIVORCIADO(1.08),
    CASADO_UNIAO(0.975),
    VIUVO(0.95);

    private Double percentual;

    EstadoCivil(Double percentual){
        this.percentual = percentual;
    }

    public Double getPercentual() {
        return this.percentual;
    }
}
