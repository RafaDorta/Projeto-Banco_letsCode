package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Banco  {
    Cliente clienteAtual = new Cliente();
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public ArrayList<Contas> contasCliente = new ArrayList<Contas>();


    public boolean criarCLiente(String nome, String login, String senha, int flag){


        Cliente c = new Cliente();
        c.setNome(nome);
        c.setSenha(senha);
        if(!verificaLogin(login)){
            c.setLogin(login);
        }else{
            return false;
        }

        if(flag == 2){
            c.setPessoaFisica(true);
        }
        clientes.add(c);
        return true;

    }


    public boolean verificaLogin(String login ){
        for (Cliente c : clientes){
            if(c.getLogin().equals(login)){
                return true;
            }
        }

        return false;
    }

    public boolean verificaCliente(String login , String senha){
        for (Cliente c : clientes){
            if(c.getLogin().equals(login) && c.getSenha().equals(senha)){
                clienteAtual = c;
                return true;
            }
        }

        return false;
    }

    public Cliente retornaClienteAtual(){
        return clienteAtual;
    }


    public void abrirConta(int numeroConta, String tipoConta,Cliente cAtual) {
        switch(tipoConta)
        {
            case "Corrente":
                ContaCorrente cC = new ContaCorrente();
                cC.setConta(numeroConta);
                cC.setNome(cAtual.getNome());
                if(!cAtual.isPessoaFisica()) {
                    cC.setTaxa(1.005);
                }else
                {
                    cC.setTaxa(1);
                }
                this.contasCliente.add(cC);
                System.out.println("O número da sua Conta é: " + numeroConta);
                break;

            case "Poupança":
                ContaPoupanca cP = new ContaPoupanca();
                cP.setConta(numeroConta);
                cP.setNome(cAtual.getNome());
                cP.setTaxa(1);
                this.contasCliente.add(cP);

                System.out.println("O número da sua Conta é: " + numeroConta);
                break;

            case "Investimento":
                ContaInvestimento cE = new ContaInvestimento();
                cE.setConta(numeroConta);
                cE.setNome(cAtual.getNome());
                if(!cAtual.isPessoaFisica()) {
                    cE.setTaxa(1.005);
                    cE.setRendimento(1.04);
                }else
                {
                    cE.setTaxa(1);
                    cE.setRendimento(1.02);
                }
                this.contasCliente.add(cE);
                System.out.println("O número da sua Conta é: " + numeroConta);
                break;
        }
    }

    public void sacar(int conta, String senha, double valor)
    {
        for(Contas c : contasCliente)
        {
            if(c.getConta() == conta && clienteAtual.getSenha().equals(senha) && c.getNome().equals(clienteAtual.getNome()))
            {

                if(c.getSaldo()- (valor * c.getTaxa()) < 0) {

                    break;
                }

                c.setSaldo(c.getSaldo() - (valor * c.getTaxa()));





            }
        }

    }
    public void depositar(int conta, double valor)
    {
        for(Contas c : contasCliente)
        {
            if(c.getConta() == conta && c.getNome().equals(clienteAtual.getNome()))
            {


                c.setSaldo(c.getSaldo() + valor);

                break;


            }
        }

    }

    public void verificaSaldo(int conta)
    {
        for(Contas c : contasCliente)
        {
            if(c.getConta() == conta && c.getNome().equals(clienteAtual.getNome()))
            {

                System.out.println("O seu saldo é de: R$:" + c.getSaldo());
                if(c.getTipo().equals("Investimento"))
                {
                    rodaInvestimento();
                    System.out.println("O seu dinheiro investido é de: R$: "+c.getDinehiroInvestido());
                }
            }

        }

    }

    public void transferir(int conta1, int conta2, double valor, String senha)
    {
        for(Contas c : contasCliente)
        {
            if(c.getConta() == conta1 && clienteAtual.getSenha().equals(senha) && c.getNome().equals(clienteAtual.getNome()))
            {

                if(c.getSaldo()- valor  < 0) {
                    System.out.println("Saldo insuficiente!");
                    break;
                }

                for(Contas c2 : contasCliente){
                    if(c2.getConta() == conta2){
                        c.setSaldo(c.getSaldo() - valor);
                        c2.setSaldo(c2.getSaldo()+ valor);
                    }
                }
            }
        }

    }

    public void investir(int conta, double valor)
    {
        for(Contas c : contasCliente)
        {
            if(c.getConta() == conta && c.getNome().equals(clienteAtual.getNome()))
            {

                c.setDinehiroInvestido(valor);

                break;


            }
        }
    }
    public void rodaInvestimento()
    {
        for(Contas c : contasCliente)
        {
           c.setDinehiroInvestido(c.getDinehiroInvestido() * c.getRendimento());
        }
    }



}
