package Controller;

import Model.Model;

public class Controller {
    Model m = new Model();

    public void storeIntoModel(int num1, int num2){
        m.setData(num1, num2);
    }

    public void getSuma(){
        int temp = m.getInfo_num1() + m.getInfo_num2();
        m.setResultado(temp);
    }

    public int getInfo_num1(){
        return m.getInfo_num1();
    }

    public int getInfo_num2(){
        return m.getInfo_num2();
    }

    public int getInfo_Resultado(){
        return m.getInfo_Resultado();
    }
}
