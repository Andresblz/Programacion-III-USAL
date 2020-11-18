package Model;

public class Model {
    private int info1, info2, resultado;

    public void setData(int num1, int num2){
        this.info1 = num1;
        this.info2 = num2;
    }

    public int getInfo_num1(){
        return this.info1;
    }

    public int getInfo_num2(){
        return this.info2;
    }

    public void setResultado(int temp){
        this.resultado = temp;
    }

    public int getInfo_Resultado(){
        return this.resultado;
    }
}
