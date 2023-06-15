package br.com.alura.oobj.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessadorFonteDadosTest {

    private ProcessadorFonteDados processador;
    String nomeArquivo = "src/test/resources/itens-pedido-test.csv";

    @Mock
    private LeitorFonteDados leitor;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        processador = new ProcessadorFonteDados(leitor);
    }

    @Test
    public void deveriaRetornarUmProcessadorFonteDados() {
        Pedido pedido = retornaPedidoComUmItemCompleto();

        Mockito.when(leitor.recupera(nomeArquivo)).thenReturn(pedido);
        ResultadoProcessamento resultadoProcessamento = processador.processa(nomeArquivo);

        for (SubTotalPorClasseFiscal.Item item : resultadoProcessamento.getSubTotalPorClasseFiscal()) {
            assertEquals(pedido.getItens().get(0).getSubtotal(), item.getSubTotal());
            assertEquals(pedido.getItens().get(0).getClasseFiscal(), item.getClasseFiscal());
        }
        assertEquals(new BigDecimal("100.0"), resultadoProcessamento.getTotalPedido());
        Mockito.verify(leitor,Mockito.times(1)).recupera(nomeArquivo);
    }

    private Pedido retornaPedidoComUmItemCompleto(){
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setCodigo(1L);
        itemPedido.setDescricao("Item para teste");
        itemPedido.setQuantidade(1);
        itemPedido.setValorUnitario(new BigDecimal("100.0"));
        itemPedido.setClasseFiscal("2106.90.90");

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(itemPedido);

        return new Pedido(itens);
    }

}