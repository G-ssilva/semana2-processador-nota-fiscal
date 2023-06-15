package br.com.alura.oobj.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FonteDadosTest {
    LeitorFonteDados tipoLeitor;

    @Test
    void deveRetornarLeitorFonteDadosCSV() {
        String nomeArquivoCSV = "extensao.csv";
        tipoLeitor = FonteDados.obtemLeitor(nomeArquivoCSV);
        assertEquals(LeitorFonteDadosCSV.class, tipoLeitor.getClass());
    }

    @Test
    void deveRetornarLeitorFonteDadosXML() {
        String nomeArquivoXML = "extensao.xml";
        tipoLeitor = FonteDados.obtemLeitor(nomeArquivoXML);
        assertEquals(LeitorFonteDadosXML.class, tipoLeitor.getClass());
    }

    @Test
    void deveRetornarIllegalArgumentException() {
        String nomeArquivoXML = "extensao";
        assertThrows(IllegalArgumentException.class, () -> FonteDados.obtemLeitor(nomeArquivoXML));
    }
}