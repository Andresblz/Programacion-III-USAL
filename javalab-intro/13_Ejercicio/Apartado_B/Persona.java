package apartado_b;

public class Persona {
    String nombre;
    int edad;
    private float talla;
    
    Persona (){
        nombre= "";
        edad = 0;
        talla = 0;
        
    }
    
    void setNombre (String nomb){
        this.nombre = nomb;           
    }
    
    void setEdad (int edad){
        this.edad = edad;
    }
    
    void setTalla (float talla){
        this.talla = talla;
    }
    
    String getNombre (){
        return nombre;
    }
    
    int getEdad (){
        return edad;
    }
    
    float getTalla (){
        return talla;
    }
}
