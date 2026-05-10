public class Jaguar extends Carro {

    public Jaguar(String marca, String modelo, String cor, int ano, int velocidade, boolean ligado){
        super(marca, modelo, cor, ano, velocidade, ligado);
    }

    public void acelerar(){
        if (!getLigado()){
            System.out.println("O carro não esta ligado.");
        } else { 
            setVelocidade(getVelocidade() + 10);
            System.out.println("Velocidade atual: " + getVelocidade());
        }
    }
}
