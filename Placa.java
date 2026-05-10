public class Placa extends Produto{
    
    private String lga;

    public Placa (String nome, double preco, int qtd, String lga){
        super(nome, preco, qtd);
        this.lga = lga;
    }

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("LGA: " + lga);
    }
}
