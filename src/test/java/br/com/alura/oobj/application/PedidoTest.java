package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PedidoTest {

    @Test
    public void getTotalDeveRetornarTotalDeUmItem(){
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setValorUnitario(new BigDecimal("100.0"));
        itemPedido.setQuantidade(1);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(itemPedido);

        Pedido pedido = new Pedido(itens);

        assertEquals(new BigDecimal("100.0"), pedido.getTotal());
    }


    @Test
    public void getTotalDeveRetornarTotalDeVariosItens(){

        ItemPedido itemPedido1 = new ItemPedido();
        itemPedido1.setValorUnitario(new BigDecimal("100.0"));
        itemPedido1.setQuantidade(1);

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setValorUnitario(new BigDecimal("100.0"));
        itemPedido2.setQuantidade(1);

        ItemPedido itemPedido3 = new ItemPedido();
        itemPedido3.setValorUnitario(new BigDecimal("100.0"));
        itemPedido3.setQuantidade(1);

        List<ItemPedido> itens = new ArrayList<>();

        itens.add(itemPedido1);
        itens.add(itemPedido2);
        itens.add(itemPedido3);

        Pedido pedido = new Pedido(itens);

        assertEquals(new BigDecimal("300.0"), pedido.getTotal());

    }

    @Test
    public void getTotalDeveRetornarExceptionQuandoListaDeItensForNula(){

        List<ItemPedido> itens = null;

        try{
            new Pedido(itens);
            fail("Lista não está nula");
        } catch (IllegalArgumentException ignored){

        }
    }
}