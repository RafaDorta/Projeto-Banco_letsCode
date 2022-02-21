package com.company;

public abstract class Contas {

    private int conta;
    private double saldo;
    private double dinehiroInvestido;
    private String nome;
    private String tipo;
    private double rendimento;
    private double taxa;

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getDinehiroInvestido() {
        return dinehiroInvestido;
    }

    public void setDinehiroInvestido(double dinehiroInvestido) {
        this.dinehiroInvestido = dinehiroInvestido;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
