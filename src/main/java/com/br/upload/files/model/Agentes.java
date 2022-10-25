package com.br.upload.files.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@XmlRootElement(name = "agentes")
public class Agentes {

    @XmlAttribute(name = "versao")
    private String versao;

    @XmlElement(name = "agente")
    private List<Agente> agente;
}
