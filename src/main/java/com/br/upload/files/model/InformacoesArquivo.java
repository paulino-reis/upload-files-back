package com.br.upload.files.model;

import lombok.Data;

@Data
public class InformacoesArquivo {
    private String name;
    private String url;

    public InformacoesArquivo(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
