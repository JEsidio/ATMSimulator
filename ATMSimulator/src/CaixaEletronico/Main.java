package CaixaEletronico;

import java.awt.event.KeyEvent;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Main {
    public static void main(String[] args ) {

        /*Cria os clientes*/
        Cliente clienteTitular = new Cliente("Tony", 17);
        Cliente clienteFavorecido = new Cliente("Steve",   13);

        /*Cria as contas*/
        Conta contaTitular = new Conta(clienteTitular,1717,201817);
        contaTitular.depositar(50000);
        Conta contaFavorecida = new Conta(clienteFavorecido,1313,200613);



        /*scanner para pegar as informações que o usuario digitar em tela*/
        Scanner entrada = new Scanner(System.in);
        Scanner inputAux = new Scanner(System.in);

        String escolhaDoMenu;
        String escolhaAuxiliar;



        System.out.println("Olá," + clienteTitular.getNome() );
        System.out.println("Agencia    : " + contaTitular.getAgenciaConta());
        System.out.println("Conta      : " + contaTitular.getNumeroConta());
        System.out.println("Saldo atual: " + contaTitular.getSaldo());
        System.out.println("\n");



        do {
            System.out.println(" ------ Operações Disponiveis ------\n");
            System.out.println("D - Deposito");
            System.out.println("E - Extrato");
            System.out.println("S - Saque");
            System.out.println("T - Transferencia");
            System.out.println("V - Visualizar Saldo");
            System.out.println("X - Sair\n");
            System.out.println("Escolha (D,E,S,T,V ou X): " );

            /*captura entrada do usuario*/
            escolhaDoMenu = toUpperCase(entrada.next());


            switch (escolhaDoMenu){

                case "D":
                    System.out.println("Você escolheu DEPÓSITO.");
                    System.out.println("Digite o valor: ");
                    contaTitular.depositar(inputAux.nextFloat());
                    System.out.println("Saldo: " + contaTitular.getSaldo());
                    break;
                case "E":
                    System.out.println("Você escolheu EXTRATO.");
                    contaTitular.vizualizeExtrato();
                    break;

                case "S":
                    System.out.println("Você escolheu SAQUE.");
                    System.out.println("Digite o valor: ");
                    contaTitular.sacar(inputAux.nextDouble());
                    System.out.println("Saldo: " + contaTitular.getSaldo());
                    break;

                case "T":
                    System.out.println("Você escolheu TRANSFERENCIA.");
                    System.out.println("Favorecido Cadastrado: " + clienteFavorecido.getNome());
                    System.out.println("Agencia: " + contaFavorecida.getAgenciaConta());
                    System.out.println("Conta  : " + contaFavorecida.getNumeroConta());
                    System.out.println("Digite o valor: ");
                    contaTitular.transferir(contaFavorecida, inputAux.nextDouble());
                    System.out.println("Saldo: " + contaTitular.getSaldo());
                    break;
                case "V":
                    System.out.println("Você escolheu Saldo.");
                    System.out.println("Saldo: " + contaTitular.getSaldo());
                    break;

                case "X":
                    System.out.println("Você escolheu SAIR.");
                    break;
                default:
                    System.out.println( escolhaDoMenu + " não é uma opção valida.");
                    break;

            }

            System.out.println("Pressione C para continuar...") ;
            escolhaAuxiliar = toUpperCase(inputAux.next());


        } while (!escolhaDoMenu.equalsIgnoreCase("X") );

        System.out.println("Saido do sistema...") ;
        System.out.println("Tchau...") ;
    }
}
