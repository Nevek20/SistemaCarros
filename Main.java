import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        int escolha_menu = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("carros.txt"))){
            String linha;

            while ((linha = reader.readLine()) != null){
                String[] partes = linha.split(";");

                String marca = partes[0];
                String modelo = partes[1];
                String cor = partes[2];
                int ano = Integer.parseInt(partes[3]);
                int velocidade = Integer.parseInt(partes[4]);
                boolean ligado = Boolean.parseBoolean(partes[5]);

                carros.add(new Carro(marca, modelo, cor, ano, velocidade, ligado));
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo");
        }

        while (escolha_menu != 6){
            System.out.println("\nMenu - Carros\n\n1) Cadastrar carro\n2) Listar carros\n3) Remover carros\n4) Buscar carros\n5) Editar carros\n6) Sair\n");
            escolha_menu = ler.nextInt();
            ler.nextLine();
            switch(escolha_menu){
                case 1:
                    cadastrarCarro(carros, ler);
                    break;
                case 2:
                    listarCarro(carros);
                    break;
                case 3:
                    removerCarro(carros, ler);
                    break;
                case 4:
                    buscarCarro(carros, ler);
                    break;
                case 5:
                    editarCarro(carros, ler);
                    break;
                case 6:
                    break;
            }
        }
    ler.close();
    }
    public static void salvarArquivo (ArrayList<Carro> carros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("carros.txt"))) {
            for (Carro c : carros){
                writer.write(c.getMarca() + ";" + c.getModelo() + ";" + c.getCor() + ";" + c.getAno() + ";" + c.getVelocidade() + ";" + c.getLigado());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo.");
        }      
    }

    public static void cadastrarCarro (ArrayList<Carro> carros, Scanner ler) {
        System.out.println("Digite a marca:");
        String marca = ler.nextLine();
        System.out.println("Digite o modelo:");
        String modelo = ler.nextLine();
        System.out.println("Digite a cor:");
        String cor = ler.nextLine();
        System.out.println("Digite o ano: ");
        int ano = ler.nextInt();
        ler.nextLine();
        System.out.println("digite a velocidade:");
        int velocidade = ler.nextInt();
        ler.nextLine();
        System.out.println("Ele esta ligado? (True | False)");
        boolean ligado = ler.nextBoolean();
        ler.nextLine();

        carros.add(new Carro(marca, modelo, cor, ano, velocidade, ligado));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("carros.txt", true))) {
            writer.write(marca + ";" + modelo + ";" + cor + ";" + ano + ";" + velocidade + ";" + ligado);
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo.");
        }
        salvarArquivo(carros);
    }

    public static void listarCarro(ArrayList<Carro> carros) {
        if (carros.isEmpty()){
            System.out.println("Nenhum carro encontrado");
        } else {
                for (Carro c : carros){
                    System.out.println("=============================");
                    c.mostrarDados();
                    System.out.println("=============================");
            }
        }
    }
    public static void removerCarro(ArrayList<Carro> carros, Scanner ler) {
        for (int i = 0; i < carros.size(); i++){
            System.out.println("Carro " + i + ": " + carros.get(i).getMarca());
            }
            System.out.println("\nQual carro você quer remover?");
            int indice = ler.nextInt();
            if (indice >= 0 && indice < carros.size()){
                carros.remove(indice);
                System.out.println("Carro removido.");
                salvarArquivo(carros);
            } else {
                System.out.println("Carro inválido.");
        }
    }
    public static void buscarCarro (ArrayList<Carro> carros, Scanner ler) {
        boolean encontrou = false;
        System.out.println("Busque a marca do seu carro: ");
        String bMarca = ler.nextLine();
        for (Carro c : carros){
            if (c.getMarca().equalsIgnoreCase(bMarca)){
                if(!encontrou){
                    System.out.println("Carros encontrados:\n");
                }
                c.mostrarDados();
                System.out.println("=============================");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Não encontramos nenhum carro.");
        }
    }
    public static void editarCarro (ArrayList<Carro> carros, Scanner ler) {
        System.out.println("Escolha o carro (numeros): ");
        int escolha = ler.nextInt();
        ler.nextLine();
        if (escolha >= 0 && escolha < carros.size()){
            System.out.println("Escolha a marca nova: ");
            String marcaNova = ler.nextLine();
            carros.get(escolha).setMarca(marcaNova);
            System.out.println("Carro atualizado com sucesso!");
            salvarArquivo(carros);
        } else {
            System.out.println("Escolha invalida.");
        }
    }
}