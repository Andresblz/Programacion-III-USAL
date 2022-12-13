package model;

import java.io.*;
import java.nio.file.*;

public class Util {
    private String desktopFolder = "datos_figuras";
    private String binFile = "figuras.bin";
    private String csvFile = "figuras.csv";
    private String htmlFile = "figuras.html";

    Path pathToDesktopFolder = FileSystems.getDefault().getPath(System.getProperty("user.home"), File.separator + "Desktop" + File.separator + desktopFolder);
    Path pathToBinFile = FileSystems.getDefault().getPath(pathToDesktopFolder + File.separator + binFile);
    Path pathToCsvFile = FileSystems.getDefault().getPath(pathToDesktopFolder + File.separator + csvFile);
    Path pathToHtmlFile = FileSystems.getDefault().getPath(pathToDesktopFolder + File.separator + htmlFile);

    public Path getPathToDesktopFolder() {
        return pathToDesktopFolder;
    }

    public void setPathToDesktopFolder(Path pathToDesktopFolder) {
        this.pathToDesktopFolder = pathToDesktopFolder;
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