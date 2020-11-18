package controller;

import model.Model;

public class Controller {
	Model m = new Model();
    
    public void guardarNumeros(int n1, int n2) { 
        m.setNum1(n1);
        m.setNum2(n2);        
    }

    public void calcularSuma() {

       m.setResultado(m.getNum1()+m.getNum2());
        
    }
    
    public int getN1(){
        return m.getNum1();
    }
    
    public int getN2(){
        return m.getNum2();
    }
    
    
    public int getResul(){
        return m.getResultado();
    }
}