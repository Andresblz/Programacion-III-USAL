package model;

import static com.coti.tools.OpMat.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Model {

    private List<HardDisk> lista;

    public Model() {
        this.lista = new ArrayList<>();
    }

    public void giveRandomValuesToList() {
        lista.clear();
        for (int i = 0; i < 10; i++) {
            lista.add(HardDisk.instanceWithRandomAttributes());
        }
    }

    public void exportListToDelimitedFile(Path path, String delimiter) throws IOException {
        List<String> lines = new ArrayList<>();
        for (HardDisk hd : lista) {
            lines.add(hd.exportStateWithDelimiters(delimiter));
        }
        Files.write(path, lines, Charset.forName("UTF8"));
    }

    public void importListFromDelimitedFile(Path delimitedFilePath, String delimiter) {
        String[][] tabla;

        try {
            tabla = importFromDisk(delimitedFilePath.toFile(), delimiter);
        } catch (Exception ex) {
            System.err.printf("%nERROR: No ha sido posible importar la informacion.");
            System.err.printf("%nERROR: %s%n", ex.toString());
            return;
        }

        List<HardDisk> result = new ArrayList<>();
        HardDisk hd;
        for (String[] fila : tabla) {
            hd = HardDisk.factory(fila);
            if (null != hd) {
                result.add(hd);
            }
        }

        lista.clear();
        lista.addAll(result);
    }

    public List<String> getListOfItemsAsColumns() {
        List<String> tmp = new ArrayList<>();
        for (var hd : lista) {
            tmp.add(hd.stateAsColumns());
        }
        return tmp;
    }

    public List<HardDisk> getLista() {
        return lista;
    }

    public void sortBy(String opcion) {
        Comparator<HardDisk> c;
        c = switch (opcion) {
            case "1" ->
                Comparator.comparing(HardDisk::getFabricante);
            case "2" ->
                Comparator.comparing(HardDisk::getMegabytes);
            case "3" ->
                Comparator.comparing(HardDisk::getModelo);
            case "4" ->
                Comparator.comparing(HardDisk::getNumeroDeSerie);
            case "5" ->
                Comparator.comparing(HardDisk::getTasaDeTransmision);
            case "6" ->
                Comparator.comparing(HardDisk::getTecnologia);
            case "7" ->
                Comparator.comparing(HardDisk::getTipoDeInterface);
            case "8" ->
                Comparator.comparing(HardDisk::getVelocidadDeRotacion);
            default ->
                Comparator.comparing(HardDisk::getFabricante);
        };
        lista.sort(c);
    }

    public void guardar(Path bp) {
        try {
            FileOutputStream fos = new FileOutputStream(bp.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(lista);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("%nERROR: guardar() no ha encontrado el archivo.%n");
        } catch (IOException ex) {
            System.err.printf("%nERROR: %s%n", ex.toString());
        }
    }

    public void leer(Path bp) {
        try {
            FileInputStream fis = new FileInputStream(bp.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            this.lista = (ArrayList<HardDisk>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("%nERROR: leer() no ha encontrado el archivo.%n");
        } catch (IOException ex) {
            System.err.printf("%nERROR: %s%n", ex.toString());
        } catch (ClassNotFoundException ex) {
            System.err.printf("%nERROR: leer() no ha encontrado la clase.%n");
        }
    }
} /* End of Model */
