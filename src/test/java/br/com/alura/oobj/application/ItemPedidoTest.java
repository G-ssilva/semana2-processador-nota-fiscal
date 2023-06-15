package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    @Test
    public void getSubtotalDeveRetornarValorUnitarioVezesUm(){
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setValorUnitario(new BigDecimal("100.0"));
        itemPedido.setQuantidade(1);

        assertEquals(new BigDecimal("100.0"), itemPedido.getSubtotal());
    }

    @Test
    public void getSubtotalDeveRetornarValorUnitarioVezesQuantidade(){
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setValorUnitario(new BigDecimal("100.0"));
        itemPedido.setQuantidade(2);

        assertEquals(new BigDecimal("200.0"), itemPedido.getSubtotal());
    }

}