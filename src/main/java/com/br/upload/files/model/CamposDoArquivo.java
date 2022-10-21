package com.br.upload.files.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class CamposDoArquivo {
    public int codigo;
    public OffsetDateTime data;
    public String siglaRegiao;
    public List<Geracao> geracao;
    public List<Compra> compra;

    public CamposDoArquivo(int codigo, OffsetDateTime data, String siglaRegiao, List<Geracao> geracao, List<Compra> compra) {
        this.codigo = codigo;
        this.data = data;
        this.siglaRegiao = siglaRegiao;
        this.geracao = geracao;
        this.compra = compra;
    }
}
