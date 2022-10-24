package com.br.upload.files.model;

import lombok.Data;

@Data
public class DetailsFiles {
    private String name;
    private String url;

    public DetailsFiles(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
