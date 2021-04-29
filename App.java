import java.util.*;

import javax.swing.filechooser.FileNameExtensionFilter;

public class App {
    public static void main(String[] args) {

        boolean sair = false;
        boolean error = false;
        boolean preferencia = false;

        int respPreferencia = 0;
        int tamanho = 0;

        int cont = 0;
        int cont2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Boa tarde! Bem-vindo ao Banco da Sabrina!");

        System.out.println("Quantos clientes cabem na fila do seu banco?(Limite da fila)");
        tamanho = sc.nextInt();
        FilaCliente fila = new FilaCliente(tamanho);

        System.out.println("---Você adicionou um limite de: " + tamanho + " clientes a sua fila.");
        System.out.println(
                "\n Você deseja:\n1 - Adicionar novo cliente na fila\n2 - Chamar o próximo cliente\n3 - Mostrar todos os clientes\n4 - sair");

        do {

            do {
                error = false;
                if (cont2 > 0) {
                    System.out.println(
                            "Você deseja:\n1 - Adicionar novo cliente na fila\n2 - Chamar o próximo cliente\n3 - Mostrar todos os clientes\n4 - sair");

                }

                int resp = sc.nextInt();

                if (resp == 1) {
                    System.out.println("---------Opção: ADICIONAR CLIENTE---------");

                    if (fila.isFull() == false) {
                        do {
                            System.out.println("\nO cliente é preferencial?\n  0 - SIM\n  1 - NÃO");

                            respPreferencia = sc.nextInt();

                            if (respPreferencia == 0) {
                                fila.enqueue(true);
                                

                            } else if (respPreferencia == 1) {
                                fila.enqueue(false);
                                
                            } else {
                                System.out.println("-----COMANDO INVÁLIDO-----");
                            }
                           
                        } while (respPreferencia != 0 && respPreferencia != 1);
                       
                    } else {

                        System.out.println("\nA fila está cheia, chame o próximo cliente para abrir mais espaço\n");
                    }

                    cont2++;

                } else if (resp == 2) {
                    System.out.println("Opção: PRÓXIMO CLIENTE");
                    if (fila.isEmpty() == false) {
                        fila.proximoCliente();
                    } else {
                        System.out.println("\nA fila está vazia, espere um novo cliente\n\n");
                    }
                    cont2++;

                } else if (resp == 3) {
                    System.out.println("Opção: MOSTRAR CLIENTES");
                    fila.imprimeFila();
                    cont2++;

                } else if (resp == 4) {
                    System.out.println("Opção: SAIR ");
                    sair = true;
                    cont2++;
                } else {
                    System.out.println("Opção: INVÁLIDA, INSIRA NOVAMENTE");
                    error = true;
                    cont2++;

                }

            } while (error == true);

        } while (sair == false);

    }
}
