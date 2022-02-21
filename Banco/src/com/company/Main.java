package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int v = 1;
        int escolha = 0;
        int escolha2 = 0;
        int escolha3 = 0;
        String login;
        String senha;
        String nomeC;
        String loginC;
        String senhaC;
        String senhaV;
        int conta =0;
        int conta2 =0;
        double X = 0;
        Banco b = new Banco();


        Cliente clienteAtual = new Cliente();
        do {


            System.out.println("Digite o login: ");
            login = input.next();
            System.out.println("Digite a senha: ");
            senha = input.next();

            if (login.equals("0000") && senha.equals("0000")) {
                System.out.println("1-Deseja cadastrar novo Cliente;\n2-Deseja abrir uma conta para um Cliente;\n3-Sair;\nR:");
                escolha3 = input.nextInt();
                switch(escolha3) {
                    case 1:
                    {

                        System.out.println("Digite o nome do cliente: ");
                        nomeC = input.next();
                        System.out.println("Digite o login do cliente: ");
                        loginC = input.next();
                        System.out.println("Digite a senha do cliente: ");
                        senhaC= input.next();
                        System.out.println("A Conta será de pessoa jurídica?\n1- Sim;\n2- Não;\nR: " );
                        escolha= input.nextInt();
                        b.criarCLiente(nomeC,loginC,senhaC,escolha);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Digite o login do Cliente: ");
                        login = input.next();
                        System.out.println("Digite a senha do Cliente: ");
                        senha = input.next();
                        if (b.verificaCliente(login, senha))
                        {

                            clienteAtual = b.retornaClienteAtual();
                                if (clienteAtual.pessoaFisica)
                                {
                                    System.out.println("Deseja abrir conta:\n1- Corrente;\n2- Poupança;\n3- Investimento;\n4- Voltar;\nR:");
                                    escolha2 = input.nextInt();
                                    if (escolha2 == 1) {
                                        b.abrirConta(v, "Corrente", clienteAtual);
                                        v++;

                                    } else if (escolha2 == 2) {
                                        b.abrirConta(v, "Poupança", clienteAtual);
                                        v++;
                                    } else if (escolha2 == 3) {
                                        b.abrirConta(v, "Investimento", clienteAtual);
                                        v++;
                                    } else {
                                        break;
                                    }

                                } else
                                {
                                    System.out.println("Deseja abrir conta:\n1- Corrente;\n2- Investimento;\n3- Voltar;\nR:");
                                    escolha2 = input.nextInt();
                                    if (escolha2 == 1) {
                                        b.abrirConta(v, "Corrente", clienteAtual);
                                        v++;
                                    } else if (escolha2 == 2) {
                                        b.abrirConta(v, "Investimento", clienteAtual);
                                        v++;
                                    } else {
                                        break;
                                }
                            }

                        }else
                        {
                            System.out.println("Usuário Inválido!");
                        }
                        break;
                    }
                    case 3: break;
                    default:
                        System.out.println("Opção Inválida!");
                }



            }else{

                    if(b.verificaCliente(login,senha)){
                        do {
                            clienteAtual = b.retornaClienteAtual();
                            System.out.println("Bem-Vindo, " + clienteAtual.getNome() + '\n' + "O que deseja realizar?");
                            System.out.println("1 - Sacar;\n" + "2 - Depositar;\n" + "3 - Transferência;\n" + "4 - Investir;\n" + "5 - Verificar Saldo;\n" + "6 - Sair;");
                            escolha = input.nextInt();

                            switch (escolha){
                                case 1:
                                    System.out.println("Digite o número da Conta:");
                                    conta = input.nextInt();
                                    System.out.println("Digite o valor da Retirada:");
                                    X = input.nextDouble();
                                    System.out.println("Digite sua senha:");
                                    senhaV = input.next();

                                    b.sacar(conta,senhaV,X);
                                    b.verificaSaldo(conta);

                                break;
                                case 2:
                                    System.out.println("Digite o número da Conta:");
                                    conta = input.nextInt();
                                    System.out.println("Digite o valor do Deposito:");
                                    X = input.nextDouble();
                                    b.depositar(conta,X);
                                    b.verificaSaldo(conta);
                                    break;
                                case 3:
                                    System.out.println("Digite o número da Conta Remetente:");
                                    conta = input.nextInt();
                                    System.out.println("Digite o número da Conta Destino:");
                                    conta2 = input.nextInt();
                                    System.out.println("Digite o valor do Deposito:");
                                    X = input.nextDouble();
                                    System.out.println("Digite sua senha:");
                                    senhaV = input.next();
                                    b.transferir(conta,conta2,X,senhaV);
                                    b.verificaSaldo(conta);
                                    break;
                                case 4:
                                    System.out.println("Digite o número da Conta:");
                                    conta = input.nextInt();
                                    System.out.println("Digite o valor do Investimento:");
                                    X = input.nextDouble();
                                    b.investir(conta,X);

                                    break;
                                case 5:
                                    System.out.println("Digite o número da Conta:");
                                    conta = input.nextInt();
                                    b.verificaSaldo(conta);

                                    break;
                                case 6: break;
                            }

                        }while(escolha != 6);
                    }


            }



        }while(!login.equals("9999") && !senha.equals("9999"));
    }
}
