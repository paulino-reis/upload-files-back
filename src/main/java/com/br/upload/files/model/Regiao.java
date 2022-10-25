package com.br.upload.files.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Regiao {

    @XmlAttribute(name = "sigla")
    private String sigla;

    @XmlElement(name = "geracao")
    private List<Geracao> geracao;

    @XmlElement(name = "compra")
    private List<Compra> compra;

    @XmlElement(name = "precoMedio")
    private List<PrecoMedio> precoMedio;
}
