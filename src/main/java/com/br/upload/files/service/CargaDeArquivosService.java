package com.br.upload.files.service;

import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface CargaDeArquivosService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
