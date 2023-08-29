package org.example.service;
import org.example.domain.Automovel;
import org.example.domain.Estacionamento;
import org.example.domain.enums.EstadoCivil;
import org.example.domain.enums.TipoAutomovel;
import org.example.domain.Motorista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculadoraSeguroTest {

    @Test
    public void deveCalcularSolteiroSemEstacionamento(){
        Automovel automovel = new Automovel(TipoAutomovel.PASSEIO, 45000);

        Motorista motorista = new Motorista("Rafael", EstadoCivil.SOLTEIRO_DIVORCIADO, automovel, null);
        CalculadoraSeguro calculadoraSeguro = new CalculadoraSeguro();

        Double resultado = calculadoraSeguro.calcular(motorista);

        Assertions.assertEquals(9000.0, resultado);

    }

    @Test
    public void deveCalcularSolteiroComPortaoManual(){
        //5400.00
        //3600.00
        //9000.00
        //aplico desconto do portao 8820.00

        Automovel automovel = new Automovel(TipoAutomovel.PASSEIO, 45000);
        Estacionamento estacionamento = new Estacionamento(false);

        Motorista motorista = new Motorista("Joao", EstadoCivil.SOLTEIRO_DIVORCIADO, automovel, estacionamento);

        CalculadoraSeguro calculadoraSeguro = new CalculadoraSeguro();

        Double resultado = calculadoraSeguro.calcular(motorista);
        Assertions.assertEquals(8820.0, resultado);

    }

    @Test
    public void deveCalcularCasadoPortaoAutomaticoTransporte(){
        //16267,5
        //3012,5

        //13255,0
        // desconto de 596,475

        //valor final 12658,525

        Automovel automovel = new Automovel(TipoAutomovel.TRANSPORTE, 120500.0);
        Estacionamento estacionamento = new Estacionamento(true);

        Motorista motorista = new Motorista("Pedro", EstadoCivil.CASADO_UNIAO, automovel, estacionamento);

        CalculadoraSeguro calculadoraSeguro = new CalculadoraSeguro();

        Double resultado = calculadoraSeguro.calcular(motorista);

        NumberFormat formatter = new DecimalFormat(".###");

        Assertions.assertEquals(calculadoraSeguro.toBigDecimal(12658.525), calculadoraSeguro.toBigDecimal(resultado)); //falta arredondar

    }

    @Test
    public void deveCalcularTipoCargaComPortaoAutomaticaViuvo(){
        //inicial 16800
        //desconto viuvo 10500
        //desconto portao 283,5
        //resultado:  6016.5

        Automovel automovel = new Automovel(TipoAutomovel.CARGA, 210000.0);
        Estacionamento estacionamento = new Estacionamento(Boolean.TRUE); //método static final

        Motorista motorista = new Motorista("Antonio", EstadoCivil.VIUVO, automovel, estacionamento);

        CalculadoraSeguro calculadoraSeguro = new CalculadoraSeguro();

        Double resultado = calculadoraSeguro.calcular(motorista);

        Assertions.assertEquals(6016.5, resultado);
    }

}
