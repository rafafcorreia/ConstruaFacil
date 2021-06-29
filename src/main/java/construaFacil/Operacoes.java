package construaFacil;

import java.util.Scanner;

public class Operacoes {
    Scanner teclado = new Scanner(System.in);

    public String lerStrInput(){
        return teclado.next();
    }

    public String seletorOperacao(int intInput, int intN1, int intN2){
        String resultado;

        switch (intInput){
            case 1:
                resultado = somarDoisNumeros(intN1, intN2);
                break;
            case 2:
                resultado = subtrairDoisNumeros(intN1, intN2);
                break;
            case 3:
                resultado = multiplicarDoisNumeros(intN1, intN2);
                break;
            case 4:
                resultado = dividirDoisNumeros(intN1, intN2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + intInput);
        }
        return resultado;
    }

    public String somarDoisNumeros(int intN1, int intN2){
        return Integer.toString(intN1 + intN2);

    }

    public String subtrairDoisNumeros(int intN1, int intN2){
        return Integer.toString(intN1 - intN2);
    }

    public String multiplicarDoisNumeros(int intN1, int intN2){
        return Integer.toString(intN1 * intN2);
    }

    public String dividirDoisNumeros(int intN1, int intN2){ //Impedir divisão por zero
        String resultado;
        if (intN2 != 0) {
            resultado = Integer.toString(intN1 / intN2);
        }
        else {
            resultado = "Erro: Não pode divisão por zero";
        }
        return resultado;
    }

    public boolean validarIntInput(int intInput){ //Se o input não for entre 1 e 4, retorna false
        return intInput >= 1 && intInput <= 4;
    }


    public boolean validarStrInput(String strInput){ //Tratamento para inputs diferentes de "1", "2", "3" e "4"
        boolean boolResp;
        switch (strInput){
            case "1":
            case "2":
            case "3":
            case "4":
                boolResp = true;
                break;
            default:
                boolResp = false;
                break;
        }
        return boolResp;
    }

    public void loopValidarStrInput(String strInput){ //Tratamento de input de operação inválida
        while (!validarStrInput(strInput)){
            System.out.print("***Entrada Inválida*** \nEscolha o cálculo desejado: ");
            strInput = lerStrInput();
        }
    }

    public void loopValidarStrNumInput(String strNum){ //Tratamento de input de número inválido
        while (!strNum.matches("-?\\d+")){
            System.out.print("***Entrada Inválida*** \nDigite um número: ");
            strNum = lerStrInput();
        }

    }
}
