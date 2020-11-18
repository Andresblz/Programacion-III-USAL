package model;

public class Model {
    final int NUMALMACENES = 5;
    final int NUMPRODUCTOS = 4;
    float[][] ventas;
    float[][] precios;
    private float resultados;

    public int getNUMALMACENES(){
        return this.NUMALMACENES;
    }

    public int getNUMPRODUCTOS(){
        return this.NUMALMACENES;
    }

    public void setVentas(float[][] tempVentas){
        this.ventas = tempVentas;
    }

    public void setPrecios(float[][] tempPrecios){
        this.precios = tempPrecios;
    }

    public float[][] getTablaPrecios(){
        return this.precios;
    }

    public float[][] getTablaVentas(){
        return this.ventas;
    }

    public void setResultado(float sum){
        this.resultados = sum;
    }

    public float getResultado(){
        return this.resultados;
    }
}
