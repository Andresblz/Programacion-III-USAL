package model;

public class Model {
    
    private int ventas[][];
    private float precios[][];
    private float beneficio;

    public int[][] getVentas() {
        return ventas;
    }

    public void setVentas(int[][] ventas) {
        this.ventas = ventas;
    }

    public float[][] getPrecios() {
        return precios;
    }

    public void setPrecios(float[][] precios) {
        this.precios = precios;
    }

    public float getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }
}
