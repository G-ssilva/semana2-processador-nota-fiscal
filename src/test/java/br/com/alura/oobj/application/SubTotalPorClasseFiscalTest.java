package br.com.alura.oobj.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubTotalPorClasseFiscalTest {
    ItemPedido itemPedido;
    SubTotalPorClasseFiscal subTotalPorClasseFiscal;

    @BeforeEach
    void beforeEach(){
        subTotalPorClasseFiscal = new SubTotalPorClasseFiscal();
    }

    @Test
    void deveAdicionarUmItemAoSubTotalPorClasseFiscal(){
        itemPedido = retornaUmItemCompleto();
        subTotalPorClasseFiscal.adicionaItemPedido(itemPedido);

        String classeFiscal = "2106.90.90";

        for (SubTotalPorClasseFiscal.Item item : subTotalPorClasseFiscal) {
            assertEquals(classeFiscal, item.getClasseFiscal());
            assertEquals(new BigDecimal("100.0"), item.getSubTotal());
        }

    }

    private ItemPedido retornaUmItemCompleto(){
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setCodigo(1L);
        itemPedido.setDescricao("Item para teste");
        itemPedido.setQuantidade(1);
        itemPedido.setValorUnitario(new BigDecimal("100.0"));
        itemPedido.setClasseFiscal("2106.90.90");

        return itemPedido;
    }

}