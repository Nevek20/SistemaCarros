public class Produto {
    private String nome;
    private double preco;
    private int qtd;

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public int getQtd(){
        return qtd;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPreco(double preco){
        if (preco <= 0){
            System.out.println("O preço não pode ser abaixo ou igual a zero;");
        } else {
            this.preco = preco;
        }
    }

    public void setQtd(int qtd){
        if (qtd < 0) {
            System.out.println("A quantidade digitada não pode ser negativa");
        } else {
            this.qtd = qtd;
        }
    }

    public Produto(String nome, double preco, int qtd){
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public void mostrarDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPreco());
        System.out.println("Quantidade: " + getQtd());
    }

    public double valorTotal(){
        return preco * qtd;
    }

    public int adicionarEstoque(int aumentar){
        return qtd += aumentar;
    }

    public int vender(int qtd_vendas){
        if (qtd <= 0 ){
            System.out.println("Não é possivel vender, produto fora do estoque.");
            return 0;
        } else  if (qtd_vendas > qtd){
            System.out.println("Não é possivel vender, venda maior que o estoque.");
            return 0;
        } else if (qtd_vendas <= 0){
            System.out.println("Não é possivel vender, numero digitado incorreto");
            return 0;
        } else {
            qtd -= qtd_vendas;
            return qtd;
        }
    }
}
