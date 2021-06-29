package unitTests;

import construaFacil.Operacoes;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestConstruaFacil {
    Operacoes operacoes = new Operacoes(); //Construtor da Classe "Operacoes"

    @Test
    public void testarSomarDoisNumeros(){
        //Given
        int n1 = 5;
        int n2 = 3;
        String resultadoEsperado = "8";
        String resultadoObtido;
        //When
        resultadoObtido = operacoes.somarDoisNumeros(n1, n2);
        //Then
        assertEquals(resultadoObtido, resultadoEsperado);
    }
    @Test
    public void testarSubtrairDoisNumeros(){
        //Given
        int n1 = 5;
        int n2 = 3;
        String resultadoEsperado = "2";
        String resultadoObtido;
        //When
        resultadoObtido = operacoes.subtrairDoisNumeros(n1, n2);
        //Then
        assertEquals(resultadoObtido, resultadoEsperado);
    }

    @Test
    public void testarMultiplicarDoisNumeros(){
        //Given
        int n1 = 5;
        int n2 = 3;
        String resultadoEsperado = "15";
        String resultadoObtido;
        //When
        resultadoObtido = operacoes.multiplicarDoisNumeros(n1, n2);
        //Then
        assertEquals(resultadoObtido, resultadoEsperado);
    }

    @Test
    public void testarDividirDoisNumeros(){
        //Given
        int n1 = 15;
        int n2 = 3;
        String resultadoEsperado = "5";
        String resultadoObtido;
        //When
        resultadoObtido = operacoes.dividirDoisNumeros(n1, n2);
        //Then
        assertEquals(resultadoObtido, resultadoEsperado);
    }

    @Test
    public void testarDividirDoisNumerosZero(){
        //Given
        int n1 = 15;
        int n2 = 0;
        String resultadoEsperado = "Erro! Não pode divisão por zero";
        String resultadoObtido;
        //When
        resultadoObtido = operacoes.dividirDoisNumeros(n1, n2);
        //Then
        assertEquals(resultadoObtido, resultadoEsperado);
    }
}
