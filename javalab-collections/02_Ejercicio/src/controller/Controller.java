package controller;

import model.Model;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Controller {

    private final Model m = new Model();
    private final Path delimitedPath = Paths.get("archivodelimitado.txt");
    private final Path binaryPath = Paths.get("archivobinario.bin");

    public void darValores() {
        m.giveRandomValuesToList();
    }

    public List<String> obtenerListado() {
        return m.getListOfItemsAsColumns();
    }

    public void importar() throws IOException {
        m.importListFromDelimitedFile(delimitedPath, "\t");
    }

    public void exportar() throws IOException {
        m.exportListToDelimitedFile(delimitedPath, "\t");
    }

    public void ordenarPor(String opcion) {
        m.sortBy(opcion);
    }

    public int getNumeroDeDiscosDuros() {
        return m.getLista().size();
    }

    public void guardar() {
        m.guardar(binaryPath);
    }

    public void leer() {
        m.leer(binaryPath);
    }
} /* End of Controller */
