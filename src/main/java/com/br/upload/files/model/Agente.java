package com.br.upload.files.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@XmlRootElement(name = "agente")
public class Agente {
    @XmlElement(name = "codigo")
    private String codigo;

    @XmlElement(name = "data")
    private String data;

    @XmlElement(name = "regiao")
    private List<Regiao> regiao;
}
