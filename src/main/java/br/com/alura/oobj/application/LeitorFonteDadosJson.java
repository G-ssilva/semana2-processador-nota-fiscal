package br.com.alura.oobj.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class LeitorFonteDadosJson implements LeitorFonteDados {

    @Override
    public Pedido recupera(String nomeArquivo) {
        try {
            Reader reader = new FileReader(nomeArquivo);
            JsonMapper mapper = new JsonMapper();
            List<ItemPedido> itemPedidos = mapper.readValue(reader, new TypeReference<List<ItemPedido>>() {});

            return new Pedido(itemPedidos);
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
