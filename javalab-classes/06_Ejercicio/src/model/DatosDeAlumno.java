package model;

public class DatosDeAlumno {
    DatosPersonales dp;
    DatosDireccion dd;
    
    public DatosDeAlumno() {
        dp = DatosPersonales.randomDatosPersonales();
        dd = DatosDireccion.randomDatosDireccion();
        dd.DNI = dp.DNI;
    }
}