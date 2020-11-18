package controller;

import model.Model;

public class Controller {
    
    Model m = new Model();

    public void guardar(int[][] cant, float[][] precios) {
        m.setVentas(cant);
        m.setPrecios(precios);
    }

    public void realizarCalculos() {
        int filas = m.getVentas().length;
        int columnas = m.getVentas()[0].length;
        float beneficio = 0;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                beneficio += m.getVentas()[i][j] * m.getPrecios()[i][j];
            }
        }
        
        m.setBeneficio(beneficio);
    }

    public int [][] getMatVentas() {
        return m.getVentas();
    }

    public float [][] getMatPrecios() {
        return m.getPrecios();
    }

    public float getBeneficio() {
        return m.getBeneficio();
    }
}