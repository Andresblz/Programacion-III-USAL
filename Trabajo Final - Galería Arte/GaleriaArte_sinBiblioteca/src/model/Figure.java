package model;

import java.io.Serializable;

public class Figure implements Serializable {
    String identifier;
    Float height; 
    String material;
    Integer quantity;
    Integer year;
    String photo;
    String manufacturer;

    /*
     * Constructors
     */
    public Figure() {}

    public Figure(String identifier, Float height, String material, Integer quantity, Integer year, String photo, String manufacturer) {
        this.identifier = identifier;
        this.height = height;
        this.material = material;
        this.quantity = quantity;
        this.year = year;
        this.photo = photo;
        this.manufacturer = manufacturer;
    }
    
    
    /*
     * Getters and setters
     */
    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Float getHeight() {
        return this.height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    
    /*
     * toString
     */
    @Override
    public String toString() {
        return "{" +
            " identifier='" + getIdentifier() + "'" +
            ", height='" + getHeight() + "'" +
            ", material='" + getMaterial() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", year='" + getYear() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", manufacturer='" + getManufacturer() + "'" +
            "}";
    }

    /*
     * toCSV
     */
    public String toCSV(Figure f) {
        String csv;
        String height = prettyPrint(f.getHeight());
        csv = String.format("%s,%s,%s,%d,%d,%s,%s%n",
                            f.getIdentifier(), height, f.getMaterial(), 
                            f.getQuantity(), f.getYear(), f.getPhoto(), f.getManufacturer());
        return csv;
    }

    /*
     * toHTML
     */
    public String toHTML(Figure f) {
        String html;
        String height = prettyPrint(f.getHeight());
        html = String.format("\t\t\t<TR>%n\t\t\t<TD>%s</TD>%n\t\t\t<TD>%s</TD>%n\t\t\t<TD>%s</TD>"
                           + "%n\t\t\t<TD>%d</TD>%n\t\t\t<TD>%4d</TD>%n\t\t\t<TD>%s</TD>%n\t\t\t<TD>%s</TD></TR>",
                           f.getIdentifier(), height, f.getMaterial(), f.getQuantity(), 
                           f.getYear(), f.getPhoto(), f.getManufacturer());
        return html;
    }

    /*
     * toColumn
     */
    public String toColumn(Figure f) {
        String column;
        String height = prettyPrint(f.getHeight());
        column = String.format("| %-15s | %-10s | %-15s | %-8s | %-6s | %-10s | %-15s |",
                           f.getIdentifier(), height, f.getMaterial(), f.getQuantity(), 
                           f.getYear(), f.getPhoto(), f.getManufacturer());
        return column;
    }


    /*
     * prettyPrint()
     * 
     * Input            Output
     * ---              ---
     * 232.0000         232
     * 4.580            4.58
     */
    public static String prettyPrint(Float d) {
        int i = d.intValue();
        return d == i ? String.valueOf(i) : String.valueOf(d);
    }

}