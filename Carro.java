public class Carro {
    private String marca, modelo, cor;
    private int ano;
    private boolean ligado;
    private int velocidade;

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }
    
    public String getCor(){
        return cor;
    }

    public int getAno(){
        return ano;
    }

    public boolean getLigado(){
        return ligado;
    }

    public int getVelocidade(){
        return velocidade;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setAno(int ano){
        if (ano < 1886){
            System.out.println("Impossivel desse carro existir....");
        } else {
            this.ano = ano;
        }
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public void setLigado(boolean ligado){
        this.ligado = ligado;
    }

    public void setVelocidade(int velocidade){
        if(velocidade >= 0){
            this.velocidade = velocidade;
        }
    }

    public Carro(String marca, String modelo, String cor, int ano, int velocidade, boolean ligado){
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.velocidade = velocidade;
        this.ligado = ligado;
    }

    public void mostrarDados(){
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("Cor: " + getCor());
        System.out.println("Velocidade: " + getVelocidade());
        System.out.println("Ligado: " + ligado);
    }

    public void ligar(){
        if (ligado == false){
            ligado = true;
            System.out.println("Carro ligado");
        } else {
            System.out.println("O carro ja esta ligado");
        }
    }

    public void desligar(){
        if (ligado == true){
            ligado = false;
            System.out.println("Carro desligado");
        } else {
            System.out.println("O carro ja esta desligado");
        }
    }
    
}
