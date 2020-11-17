package model;

import java.util.stream.IntStream;

public class Model {
    private DatosDeAlumno[] dal;
    
    public String[][] tablaDeDirecciones(){
        //Number of rows = number of students
        //Number of columns = 4 (name of string, number, letter, DNI)
        String[][] resultado = new String[dal.length][4];
        for (int n = 0; n< dal.length; n++){
            resultado[n][0]= dal[n].dd.calle;
            resultado[n][1]= dal[n].dd.numero + "";
            resultado[n][2]= dal[n].dd.letra;
            resultado[n][3]= dal[n].dd.DNI;
        }
        return resultado;
    }
    
    public String[][] tablaDatosPersonales(){
        String[][] resultado = new String[dal.length][4];
        for (int n = 0; n< dal.length; n++){
            resultado[n][0]= dal[n].dp.nombre;
            resultado[n][1]= dal[n].dp.apellidos;
            resultado[n][2]= dal[n].dp.edad +"";
            resultado[n][3]= dal[n].dp.DNI;
        }
        return resultado;
    }
    
    public String[][] tablaGeneralDeDatos(){
        String[][] resultado = new String[dal.length][7];
        for (int n = 0; n< dal.length; n++){
            resultado [n][0] = dal[n].dp.nombre;
            resultado [n][1] = dal[n].dp.apellidos;
            resultado [n][2] = dal[n].dp.edad + "";
            resultado [n][3] = dal[n].dd.DNI;
            resultado [n][4] = dal[n].dd.calle;
            resultado [n][5] = dal[n].dd.numero + "";
            resultado [n][6] = dal[n].dd.letra;
        }
        return resultado;
    }
    
    public void crearLista(){
        this.dal =  new DatosDeAlumno[10];
        //for(int n; n<dal.length; n++)
        for (int n: IntStream.range(0, dal.length).toArray()){
            dal[n] = new DatosDeAlumno();
        }
    }
}