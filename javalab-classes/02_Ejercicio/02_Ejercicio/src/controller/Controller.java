package controller;

import model.Model;

public class Controller {
    Model m = new Model();

    public void calcularResultado(){
        int ALMACENES = this.getNumAlmacenes();
        int PRODUCTOS = this.getNumProductos();
        float[][] ventas = this.getTablaVentas();
        float[][] precios = this.getTablaPrecios();
        float[] temp = new float[ALMACENES];
        float beneficios = 0;

        for(int alm = 0; alm < ALMACENES; alm++){
            for(int prod = 0; prod < PRODUCTOS; prod++){
                temp[alm] = ventas[alm][prod] * precios[alm][prod];
                beneficios += temp[alm];
            }
        }
        m.setResultado(beneficios);
    }

    public int getNumAlmacenes(){
        return m.getNUMALMACENES();
    }

    public int getNumProductos(){
        return m.getNUMPRODUCTOS();
    }

    public void guardarEnModelVentas(float[][] tempVentas){
        m.setVentas(tempVentas);
    }

    public void guardarEnModelPrecios(float[][] tempPrecios){
        m.setPrecios(tempPrecios);
    }

    public float[][] getTablaPrecios(){
        return m.getTablaPrecios();
    }

    public float[][] getTablaVentas(){
        return m.getTablaVentas();
    }

    public float getResultados(){
        return m.getResultado();
    }
}
