package construaFacil;

import java.util.Scanner;

public class ConstruaFacil {

    public static void main(String[] args){
        Operacoes operacoes = new Operacoes(); //Construtor da Classe Operacoes

       /*************************************************************************************************
        *
        * Print de um menu de entrada/instrução:
        * **********CALCULADORA**********
        * (1) Somar
        * (2) Subtrair
        * (3) Multiplicar
        * (4) Dividir
        * Escolha o cálculo desejado:
        *
        *************************************************************************************************/

        System.out.print("**********CALCULADORA********** \n(1) Somar \n(2) Subtrair \n(3) Multiplicar " +
                "\n(4) Dividir \nEscolha o cálculo desejado: ");

        int intInput = operacoes.lerIntInput(); //Recebe input pelo teclado do usuário
        while (!operacoes.validarStrInput(intInput)) { //Tratamento de input inválido
            System.out.print("***Entrada Inválida*** \nEscolha o cálculo desejado: ");
            intInput = operacoes.lerIntInput();
        }

        System.out.print("Digite um número: ");
        int intN1 = operacoes.lerIntInput(); //Recebe input pelo teclado do usuário convertido para int
        System.out.print("Digite outro número: ");
        int intN2 = operacoes.lerIntInput(); //Recebe input pelo teclado do usuário convertido para int
        System.out.println("O resultado da operação é: " + operacoes.seletorOperacao(intInput, intN1, intN2));
    }

}
