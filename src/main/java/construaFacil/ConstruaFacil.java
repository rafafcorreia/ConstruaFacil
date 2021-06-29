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
        String strInput = operacoes.lerStrInput();
        operacoes.loopValidarStrInput(strInput); //Loop para tratamento de input de operação inválida
        int intInput = Integer.parseInt(strInput);
        System.out.print("Digite um número: ");
        String strN1 = operacoes.lerStrInput();
        operacoes.loopValidarStrNumInput(strN1); //Loop para tratamento de input de número inválido
        int intN1 = Integer.parseInt(strN1);
        //int intN1 = operacoes.lerIntInput(); //Recebe input pelo teclado do usuário convertido para int
        System.out.print("Digite um número: ");
        String strN2 = operacoes.lerStrInput();
        operacoes.loopValidarStrNumInput(strN2); //Loop para tratamento de input de número inválido
        int intN2 = Integer.parseInt(strN2);
        //int intN2 = operacoes.lerIntInput(); //Recebe input pelo teclado do usuário convertido para int
        System.out.println("O resultado da operação é: " + operacoes.seletorOperacao(intInput, intN1, intN2));
    }

}
