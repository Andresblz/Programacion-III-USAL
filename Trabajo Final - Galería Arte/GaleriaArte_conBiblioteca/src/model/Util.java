package model;

import java.nio.file.*;
import com.coti.tools.Rutas;

public class Util {
    private final String desktopFolder = "datos_figuras";
    private final String binFile = "figuras.bin";
    private final String csvFile = "figuras.csv";
    private final String htmlFile = "figuras.html";
    
    Path pathToFolder = Rutas.pathToFolderOnDesktop(desktopFolder);
    Path pathToBinFile = Rutas.pathToFileInFolderOnDesktop(desktopFolder, binFile);
    Path pathToCsvFile = Rutas.pathToFileInFolderOnDesktop(desktopFolder, csvFile);
    Path pathToHtmlFile = Rutas.pathToFileInFolderOnDesktop(desktopFolder, htmlFile);

    public Path getPathToFolder() {
        return pathToFolder;
    }

    public void setPathToFolder(Path pathToFolder) {
        this.pathToFolder = pathToFolder;
    }

    public Path getPathToBinFile() {
        return pathToBinFile;
    }

    public void setPathToBinFile(Path pathToBinFile) {
        this.pathToBinFile = pathToBinFile;
    }

    public Path getPathToCsvFile() {
        return pathToCsvFile;
    }

    public void setPathToCsvFile(Path pathToCsvFile) {
        this.pathToCsvFile = pathToCsvFile;
    }

    public Path getPathToHtmlFile() {
        return pathToHtmlFile;
    }

    public void setPathToHtmlFile(Path pathToHtmlFile) {
        this.pathToHtmlFile = pathToHtmlFile;
    }

    String PHOTO_EXTENSION = ".png";
    Integer MIN_YEAR = 0;
    Integer MAX_YEAR = 2100;
    Integer MAX_HEIGHT_INTEGER = 150;
    Float MAX_HEIGHT_FLOAT = 1.5f;

    public String getPhotoExtension() {
        return PHOTO_EXTENSION;
    }

    public void setPhotoExtension(String PHOTO_EXTENSION) {
        this.PHOTO_EXTENSION = PHOTO_EXTENSION;
    }

    public Integer getMinYear() {
        return MIN_YEAR;
    }

    public void setMinYear(Integer MIN_YEAR) {
        this.MIN_YEAR = MIN_YEAR;
    }

    public Integer getMaxYear() {
        return MAX_YEAR;
    }

    public void setMaxYear(Integer MAX_YEAR) {
        this.MAX_YEAR = MAX_YEAR;
    }

    public Integer getMaxHeightInteger() {
        return MAX_HEIGHT_INTEGER;
    }

    public void setMaxHeightInteger(Integer MAX_HEIGHT_INTEGER) {
        this.MAX_HEIGHT_INTEGER = MAX_HEIGHT_INTEGER;
    }

    public Float getMaxHeightFloat() {
        return MAX_HEIGHT_FLOAT;
    }

    public void setMaxHeightFloat(Float MAX_HEIGHT_FLOAT) {
        this.MAX_HEIGHT_FLOAT = MAX_HEIGHT_FLOAT;
    }

}