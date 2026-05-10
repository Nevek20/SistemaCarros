public class Eletronico extends Produto {
    private int garantiaMeses;

    public Eletronico (String nome, double preco, int qtd, int garantiaMeses){
        super(nome, preco, qtd);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Garantia: " + garantiaMeses + " meses");
    }
}