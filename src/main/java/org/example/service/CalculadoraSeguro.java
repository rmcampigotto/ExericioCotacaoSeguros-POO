package org.example.service;

import org.example.domain.Estacionamento;
import org.example.domain.Motorista;
import org.example.domain.enums.EstadoCivil;
import org.example.domain.enums.TipoAutomovel;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraSeguro {

    public BigDecimal toBigDecimal(double valor){
        try {
            return new BigDecimal(valor).setScale(3, RoundingMode.HALF_EVEN);
        }catch (Exception e){
            return BigDecimal.ZERO;
        }
    }

    public Double calcular(Motorista motorista) {
        double valorFipe = motorista.getAutomovel().getValorBase();
        double pctTipoAutomovel = motorista.getAutomovel().getTipoAutomovel().getPercentual();
        double pctEstadoCivil = motorista.getEstadoCivil().getPercentual();


        double primeiroValor = valorFipe * pctTipoAutomovel;
        double segundoValor = (valorFipe * pctEstadoCivil) - valorFipe;
        
        double valorTotalSeguro = primeiroValor + segundoValor;
        double valorDesconto = 0.0;
                
        if (motorista.getEstacionamento() != null){
            valorDesconto = motorista.getEstacionamento().valorDesconto(valorTotalSeguro);
            return valorTotalSeguro - valorDesconto;
        }
        return valorTotalSeguro;
    }


}
