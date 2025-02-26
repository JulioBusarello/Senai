package com.mycompany.calculator;

/**
 * @author julio_busarello
 */
public class Calculator {

    public double soma(double a, double b) {
        return a + b;
    }
    
    public double subtrair(double a, double b) {
        return a - b;
    }
    
    public double multiplicar(double a, double b) {
        return a * b;
    }
    
    public double dividir(double a, double b) {
        if(b == 0){
            throw new IllegalArgumentException("Não é possível dividir por zero!");
        } else {
            return a / b;
        }
    }
    
    public double potencializar(double a, double b) {
        return Math.pow(a, b);
    }
    
    
    
    public static void main(String[] args) {
        Calculator calculadora = new Calculator();
        double resultadoSoma = calculadora.soma(1,2);
        double resultadoSubtracao = calculadora.subtrair(1,2);
        
        if(resultadoSoma == 3) {
            System.out.println("Soma deu certo");
        }else{
            System.out.println("Soma deu errado");
        }
        
        if(resultadoSubtracao == -1) {
            System.out.println("Subtracao deu certo");
        } else{
            System.out.println("Subtracao deu errado");
        }
        
        System.out.println("");
    }
}
