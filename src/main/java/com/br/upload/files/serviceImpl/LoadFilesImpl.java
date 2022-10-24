package com.br.upload.files.serviceImpl;

import com.br.upload.files.service.LoadFilesService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class LoadFilesImpl implements LoadFilesService {
    private final Path root = Paths.get("uploads");
    private final String pathFile = Paths.get("uploads").toAbsolutePath().toString();

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível inicializar a pasta para guardar os arquivos!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            if (new File(pathFile + "\\" + file.getOriginalFilename()).exists()) {
                new File(pathFile + "\\" + file.getOriginalFilename()).delete();
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            this.readFile(pathFile + "\\" + file.getOriginalFilename());
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível salvar o arquivo. Erro: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Não foi possível ler o arquivo!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Ocorreu um erro: " + e.getMessage());
        }
    }

    public void readFile(String filename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("agente");
            showXmlContent(nList);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void showXmlContent(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("agentes/agente[" + (temp+1) + "]/Código : "  + eElement.getElementsByTagName("codigo").item(0).getTextContent());
            }
        }

    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
