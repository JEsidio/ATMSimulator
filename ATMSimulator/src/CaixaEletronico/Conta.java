package CaixaEletronico;

import java.util.ArrayList;

public class Conta  {

    private Cliente cliente ;
    private int agenciaConta;
    private int numeroConta;
    private double saldo;

    public Conta(Cliente cliente, int agenciaConta, int numeroConta) {
        this.cliente = cliente;
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
    }

    ArrayList<String> extrato = new ArrayList();

    public void  vizualizeExtrato(){
        int n = extrato.size();
        System.out.println("------ EXTRATO ------");
        int i;
        for (i=0; i<n; i++) {
            System.out.println(extrato.get(i));
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(int agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double depositar(double valor){
        if (valor > 0){
            extrato.add("Entrada: " + valor);
            return saldo += valor;
        }
        else {
            System.out.println("Não é possivel depositar um valor menor ou igual a zero");
            return saldo;
        }
    }

    double sacar(double valor){
        if(valor <= saldo) {
            extrato.add("Saida:   " + valor);
            return saldo -= valor;
        }
        else {
            System.out.println("Saldo Insuficiente");
            return saldo;
        }
    }

    public void transferir ( Conta contaDestino, double valor){
        this.sacar(valor);
        contaDestino.depositar(valor);

    }

}
