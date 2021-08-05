package application;

import entities.Calculator;
import entities.Produtos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       novaLista(sc);

    }

    public static void novaLista(Scanner sc){
        char c = 'S';
       while(c == 'S'){
            try{
                System.out.print("Deseja Criar Nova Lista? ");
                c = sc.next().toUpperCase().charAt(0);
                if(c == 'S'){
                    System.out.println("Criando Nova Lista");
                    menu(sc);
                }else{
                    System.out.println("Nova Lista Dispensada");
                }
            }catch(Exception e){
                e.getMessage();
            }
       }


    }

    public static void menu(Scanner sc){


        int op = 1;
        Produtos produtos = new Produtos();

        while (op != 0){
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Produtos na Lista");
            System.out.println("2 - Arquivar Lista gerada");
            System.out.println("3 - Gerar Lista Arquivada");
            System.out.println("4 - Ler Lista Criada");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço do Produto: ");
                    Double preco = sc.nextDouble();

                    produtos.adicionaLista(new Produtos(nome, preco));

                    break;
                case 2:
                    System.out.print("caminho e nome do Arquivo: ");
                    String caminho = sc.next();

                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))){
                       String [] lines = {produtos.toString()};
                       for(String l: lines){
                           bw.write(l);
                           bw.newLine();
                       }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;

                case 3:
                    System.out.print("Informe o Caminho para leitura: ");
                    caminho = sc.next();
                    try {

                        FileReader fr = new FileReader(caminho);
                        BufferedReader br = new BufferedReader(fr);
                        String line = br.readLine();
                        while(line!=null){
                            System.out.println(line);
                            line = br.readLine();
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println(produtos.toString());
                    break;
                case 5:
                    //aqui dá errado pois creio que terei que instanciar uma nova lista separada
                    // para fazer as comparações List <Produto> list = new ArrayList<>();
                    List<Produtos>list = new ArrayList<>();
                    System.out.print("Informe o Caminho para Comparar maior produto: ");
                    caminho = sc.next();
                    try {

                        FileReader fr = new FileReader(caminho);
                        BufferedReader br = new BufferedReader(fr);
                        String line = br.readLine();

                        while(line!=null){
                            String [] lines =  line.split(",");
                            list.add(new Produtos(lines[0],Double.parseDouble(lines[1])));

                            //list.add(new Produtos(lines[0], Double.parseDouble(lines[1]))
                            produtos.adicionaLista(new Produtos(lines[0], Double.parseDouble(lines[1])));
                            System.out.println(line);
                            line = br.readLine();
                        }
                        Produtos x = Calculator.calcularMaior(list);
                        System.out.print("Produto Mais Caro: " + x.getNome() + ", " + x.getPreco());
                        System.out.println();


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
            }

        }


    }


}
