package model;

import java.util.*;

public class Model {
    /*
     * Util file
     */
    private Util util = new Util();

    public Util getUtils() {
        return util;
    }

    public void setUtils(Util util) {
        this.util = util;
    }
    

    /*
     * ArrayList figures
     */
    public ArrayList<Figure> listFigures;

    public Model() {
        listFigures = new ArrayList<>();
    }


    /*
     * Gallery management
     */
    public void addFigureToInventory(String csvIdentifier, Float csvHeight, String csvMaterial, Integer csvQuantity, Integer csvYear, String csvPhoto, String csvManufacturer) {
        Figure figure = new Figure(csvIdentifier, csvHeight, csvMaterial, csvQuantity, csvYear, csvPhoto, csvManufacturer);
        listFigures.add(figure);
    }

    public String queryDataOfAFigure(String identifier) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                return figure.toString();
            }
        }
    
        return "ERROR: No se ha encontrado la figura con el identificador: " + identifier;
    }

    public Figure removeFigureFromInventory(String identifier) {
        Figure deletedItem = null;

        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                deletedItem = figure;
                break;
            }
        }

        if (null != deletedItem) {
            listFigures.remove(deletedItem);
        }
        return deletedItem;
    }

    public Boolean figureExists(String identifier) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier))
                return true;
        }

        return false;
    }

    public String modifyFigureHeight(String identifier, Float height) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                figure.setHeight(height);
                return "INFO: La altura de la figura ha sido actualizada correctamente.";
            }
        }
        
        return "ERROR: No ha sido posible cambiar la altura. Por favor, pruebe de nuevo.";
    }

    public String modifyFigureMaterial(String identifier, String material) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                figure.setMaterial(material);
                return "INFO: El material de la figura ha sido actualizado correctamente.";
            }
        }
        
        return "ERROR: No ha sido posible cambiar la altura. Por favor, pruebe de nuevo.";
    }

    public String modifyFigureQuantity(String identifier, Integer quantity) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                figure.setQuantity(quantity);
                return "INFO: El valor de la cantidad de la figura ha sido actualizado correctamente.";
            }
        }
        
        return "ERROR: No ha sido posible cambiar la altura. Por favor, pruebe de nuevo.";
    }

    public String modifyFigureYear(String identifier, Integer year) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                figure.setYear(year);
                return "INFO: El año de la figura ha sido actualizado correctamente.";
            }
        }
        
        return "ERROR: No ha sido posible cambiar la altura. Por favor, pruebe de nuevo.";
    }

    public String modifyFigurePhoto(String identifier, String photo) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                figure.setPhoto(photo);
                return "INFO: La foto de la figura ha sido actualizada correctamente.";
            }
        }
        
        return "ERROR: No ha sido posible cambiar la altura. Por favor, pruebe de nuevo.";
    }

    public String modifyFigureManufacturer(String identifier, String manufacturer) {
        for (Figure figure : listFigures) {
            if (figure.getIdentifier().equals(identifier)) {
                figure.setManufacturer(manufacturer);
                return "INFO: El fabricante de la figura ha sido actualizado correctamente.";
            }
        }
        
        return "ERROR: No ha sido posible cambiar la altura. Por favor, pruebe de nuevo.";
    }


    /*
     * Listing menu
     */
    public ArrayList<Figure> listByIdentifier() {
        ArrayList<Figure> sortedList = listFigures;
        sortedList.sort(Comparator.comparing(Figure::getIdentifier));
        return sortedList;
    }

    public ArrayList<Figure> listByYearAndIdentifier() {
        ArrayList<Figure> sortedList = listFigures;
        sortedList.sort((Comparator.comparing(Figure::getYear).reversed()).thenComparing(Figure::getIdentifier));
        return sortedList;
    }

    public ArrayList<Figure> listByManufacturerAndYear() {
        ArrayList<Figure> sortedList = listFigures;
        sortedList.sort(Comparator.comparing(Figure::getManufacturer).thenComparing(Figure::getYear));
        return sortedList;
    }

    /*
     * Debug use
     */
    public ArrayList<Figure> getList() {
        return listFigures;
    }

}