package controller;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import model.*;

public class Controller {
    private Model m = new Model();

    /*
     * Program start and end
     */
    public String importDataFromBinaryFile() {
        Path desktopFolder = m.getUtils().getPathToFolder();
        Path binaryFile = m.getUtils().getPathToBinFile();
        Path csvFile = m.getUtils().getPathToCsvFile();

        if (Files.exists(desktopFolder)) {
            if (Files.exists(binaryFile)) {
                this.readBinaryFile();
                return "\n\nINFO: Fichero binario importado con éxito";
            } else {
                if (Files.exists(csvFile)) {
                    try {
                        String info = this.importCSV();
                        return info;
                    } catch (IOException e) {
                        System.err.println("\n\nERROR: No se ha podido importar de figuras.csv.");
                    }
                }
            }
        } else {
            try {
                Files.createDirectories(desktopFolder);
                return "\n\nINFO: carpeta 'datos_figuras' creada en el escritorio.";
            } catch (IOException e) {
                System.err.println("\n\nERROR: No se ha podido crear la carpeta 'datos_figuras' en el escritorio.");
            }
        }
        return "\n\nINFO: Carpeta 'datos_figuras' se encuentra vacía.";
    }

    @SuppressWarnings("unchecked")
    private void readBinaryFile() {
        Path p = m.getUtils().getPathToBinFile();

        try {
            FileInputStream fis = new FileInputStream(p.toFile());
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            m.listFigures = (ArrayList<Figure>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("ERROR: No se ha podido leer el archivo binario.");
        }
    }

    public void exportToBinaryFile() {
        Path p = m.getUtils().getPathToBinFile();

        try {
            FileOutputStream fos = new FileOutputStream(p.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(m.listFigures);
            oos.close();
        } catch (IOException e) {
            System.err.println("ERROR: No se ha podido guardar el archivo binario.");
        }
    }

    
    /*
     * Files menu
     */
    public String importCSV() throws IOException {
        Path csvFile = m.getUtils().getPathToCsvFile();
        Integer fail = 0, lines = 0;

        List<String> data = Files.readAllLines(csvFile);

        for (String line : data) {
            lines++;
            Boolean flag = true;
            String csvIdentifier, csvMaterial, csvPhoto, csvManufacturer;
            Float csvHeight = 0f;
            Integer csvQuantity = 0, csvYear = 0;
            String[] arg = line.split(",");

            /*
             * Data from file
             */
            csvIdentifier = arg[0].trim();
            if (m.figureExists(csvIdentifier))
                flag = false;

            try {
                csvHeight = Float.valueOf(arg[1]);
            } catch (NullPointerException | NumberFormatException e) {
                flag = false;
            }

            csvMaterial = arg[2].trim();

            try {
                csvQuantity = Integer.valueOf(arg[3]);
            } catch (NumberFormatException e) {
                flag = false;
            }

            try {
                csvYear = Integer.valueOf(arg[4]);
            } catch (NumberFormatException e) {
                flag = false;
            }

            csvPhoto = arg[5].trim();
            csvManufacturer = arg[6].trim();

            if (csvIdentifier.isEmpty() || csvMaterial.isEmpty() || csvPhoto.isEmpty() || csvManufacturer.isEmpty()) flag = false;
            
            if (flag) {
                m.addFigureToInventory(csvIdentifier, csvHeight, csvMaterial, csvQuantity, csvYear, csvPhoto, csvManufacturer);
            } else {
                fail++;
            }
        }

        /*
         * Return to View
         */
        Integer percentage = ((lines - fail) * 100) / lines;
        return "\n\nArchivo CSV leído con éxito: \n"
             + "Líneas totales leidas >> " + lines + "\n"
             + "Líneas sin fallos >> " + (lines-fail) + "\n"
             + "Líneas con fallos >> " + fail + "\n"
             + "Porcentaje registros transformados >> " + percentage + "%\n";
    }

    public void exportCSV() throws IOException {
        try {
            PrintWriter pw = new PrintWriter(new File(m.getUtils().getPathToCsvFile().toString()));

            for (Figure f : m.getList())
                pw.printf("%s", f.toCSV(f));
            
            pw.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }

    public void exportHTML() throws IOException {
        String identifier = "IDENTIFICADOR",
               height = "ALTURA", 
               material = "MATERIAL", 
               quantity = "CANTIDAD",
               year = "AÑO",
               photo = "FOTOGRAFÍA",
               manufacturer = "FABRICANTE";
               
        try {
            PrintWriter pw = new PrintWriter(new File(m.getUtils().getPathToHtmlFile().toString()));
            pw.printf("<HTML><HEAD><meta charset='utf-8'></HEAD><BODY><TABLE cellspacing=20>");
            pw.printf("<TR><TH>%55s</TH>%n<TH>%15s</TH>%n<TH>%35s</TH>%n<TH>%15s</TH>%n<TH>%15s</TH>%n<TH>%15s</TH>%n<TH>%35s</TH>%n",
            identifier, height, material, quantity, year, photo, manufacturer);

            for (Figure figure : m.getList())
                pw.printf("%s", figure.toHTML(figure));

            pw.print("</TABLE></HTML>");
            pw.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }


    /*
     * Gallery management menu
     */
    public String addFigureToInventory(String identifier, Float height, String material, Integer quantity, Integer year, String photo, String manufacturer) { // TO - DO
        Boolean figureExists = m.figureExists(identifier);

        if (!figureExists) {
            /*
             * Data validation
             */
            int intHeight = height.intValue();
            if (intHeight == height) {
                if (height > m.getUtils().getMaxHeightInteger()) 
                    return "ERROR: No se ha podido añadir la figura al inventario. La altura introducida no debe superar los " + m.getUtils().getMaxHeightInteger() + " cm.";
            } else {
                if (height > m.getUtils().getMaxHeightFloat())
                    return "ERROR: No se ha podido añadir la figura al inventario. La altura introducida no debe superar los " + m.getUtils().getMaxHeightFloat() + " m.";
            }

            if (quantity < 1) return "ERROR: No se ha podido añadir la figura al inventario. La cantidad debe ser 1 o superior.";
            if (year < m.getUtils().getMinYear() || year > m.getUtils().getMaxYear()) return "ERROR: No se ha podido añadir la figura al inventario. El año debe estar entre " + m.getUtils().getMinYear() + " y " + m.getUtils().getMaxYear();
            if (!photo.endsWith(m.getUtils().getPhotoExtension())) return "ERROR: No se ha podido añadir la figura al inventario. La extensión de la foto debe ser: " + m.getUtils().getPhotoExtension();

            /*
             * Figure creation
             */
            m.addFigureToInventory(identifier, height, material, quantity, year, photo, manufacturer);
            return "INFO: La figura ha sido añadida correctamente al inventario";
        }

        return "ERROR: No se ha podido añadir la figura al inventario. Ya existe una figura con el identificador " + identifier;
    }

    public String queryDataOfAFigure(String identifier) {
        return m.queryDataOfAFigure(identifier);
    }

    public String modifyFigureData(String value, String identifier, Integer i) {
        String info;
        switch (i) {
            case 1 -> { // Modify height
                Float height;
                try {
                    height = Float.valueOf(value);
                } catch (NumberFormatException e) {
                    return "ERROR: El formato de la altura introducida es erroneo.";
                }

                int intHeight = height.intValue();
                if (intHeight == height) {
                    if (height > m.getUtils().getMaxHeightInteger()) 
                        return "ERROR: No se ha podido añadir la figura al inventario. La altura introducida no debe superar los " + m.getUtils().getMaxHeightInteger() + " cm.";
                } else {
                    if (height > m.getUtils().getMaxHeightFloat())
                        return "ERROR: No se ha podido añadir la figura al inventario. La altura introducida no debe superar los " + m.getUtils().getMaxHeightFloat() + " m.";
                }

                info = m.modifyFigureHeight(identifier, height);
                return info;
            }

            case 2 -> { // Modify material
                info = m.modifyFigureMaterial(identifier, value);
                return info;
            }

            case 3 -> { // Modify quantity
                Integer quantity;
                try {
                    quantity = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    return "ERROR: El formato de la cantidad introducida es erroneo.";
                }

                if (quantity < 1) return "ERROR: No se ha podido añadir la figura al inventario. La cantidad debe ser 1 o superior.";

                info = m.modifyFigureQuantity(identifier, quantity);
                return info;
            }

            case 4 -> { // Modify year
                Integer year;
                try {
                    year = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    return "ERROR: El formato del año introducido es erroneo.";
                }

                if (year < m.getUtils().getMinYear() || year > m.getUtils().getMaxYear()) return "ERROR: No se ha podido añadir la figura al inventario. El año debe estar entre " + m.getUtils().getMinYear() + " y " + m.getUtils().getMaxYear();
                
                info = m.modifyFigureYear(identifier, year);
                return info;
            }

            case 5 -> { // Modify photo
                if (!value.endsWith(m.getUtils().getPhotoExtension())) return "ERROR: No se ha podido añadir la figura al inventario. La extensión de la foto debe ser: " + m.getUtils().getPhotoExtension();
                info = m.modifyFigurePhoto(identifier, value);
                return info;
            }

            case 6 -> { // Modify manufacturer
                info = m.modifyFigureManufacturer(identifier, value);
                return info;
            }
        }
        return "ERROR: No se ha podido modificar el valor.";
    }

    public Figure removeFigureFromInventory(String identifier) {
        return m.removeFigureFromInventory(identifier);
    }

    
    /*
     * Listing menu
     */
    public String[][] listByIdentifier() {
        return m.listByIdentifier();
    }

    public String[][] listByYearAndIdentifier() {
        return m.listByYearAndIdentifier();
    }

    public String[][] listByManufacturerAndYear() {
        return m.listByManufacturerAndYear();
    }
}