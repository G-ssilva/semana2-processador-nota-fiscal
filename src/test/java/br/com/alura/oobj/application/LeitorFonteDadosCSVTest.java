package br.com.alura.oobj.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeitorFonteDadosCSVTest {
    LeitorFonteDadosCSV leitorFonteDadosCSV;

    @BeforeEach
    void beforeEach(){
        leitorFonteDadosCSV = new LeitorFonteDadosCSV();
    }

    @Test
    void deveRetornarUmPedido(){
        String nomeArquivo = "src/test/resources/itens-pedido-test.csv";
        Pedido pedido = leitorFonteDadosCSV.recupera(nomeArquivo);

        assertEquals(1, pedido.getItens().size());
        assertEquals(10L, pedido.getItens().get(0).getCodigo());
        assertEquals("Coca-Cola Zero Lata 310 ML", pedido.getItens().get(0).getDescricao());
        assertEquals(1, pedido.getItens().get(0).getQuantidade());
        assertEquals(new BigDecimal("10.0"), pedido.getItens().get(0).getValorUnitario());
        assertEquals("2202.10.00", pedido.getItens().get(0).getClasseFiscal());
    }

}