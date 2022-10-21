package com.br.upload.files.model;

import lombok.Data;

@Data
public class InformacoesDoArquivo {
    private String name;
    private String url;

    public InformacoesDoArquivo(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
