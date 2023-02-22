/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaum;

/**
 *
 * @author NOTE
 */
import java.util.Scanner;
public class Jogo {
    private char matriz[][] = new char[7][7];
    private int numPecas = 48;
    
    public Jogo() {
        for(int i = 0; i < 7; i ++){
            for (int j = 0; j < 7; j++){
                if((i == 0 || i == 1 || i == 5 || i == 6) && (j == 0 || j == 1 || j == 5 || j == 6)){
                    matriz[i][j] = ' ';
                }
                else{
                    matriz[i][j] = '1';
                }
            }
        }
        matriz[3][3] = '0';
    }
    public void reiniciar(){
        for(int i = 0; i < 7; i ++){
            for (int j = 0; j < 7; j++){
                if((i == 0 || i == 1 || i == 5 || i == 6) && (j == 0 || j == 1 || j == 5 || j == 6)){
                    matriz[i][j] = ' ';
                }
                else{
                    matriz[i][j] = '1';
                }
            }
        }
        matriz[3][3] = '0'; 
    }
    public void imprimeMatriz(){
        System.out.println("  0 1 2 3 4 5 6");
        for (int i = 0; i < 7; i++) {
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j < 7; j++) {
                System.out.print(matriz[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void jogar(int linhaPeca, int colunaPeca, int linhaEspaco, int colunaEspaco) {
        if (verSeTemJogada() && numPecas!=1) {
            System.out.println();
            if ((linhaPeca < 7) && (colunaPeca < 7) && (linhaEspaco < 7) && (colunaEspaco >= 0) && (linhaPeca >= 0) && (colunaPeca >= 0) && (linhaEspaco >= 0) && (colunaEspaco >= 0)&&(matriz[linhaEspaco][colunaEspaco]=='0')) {
                if ((colunaPeca + 2)<7 && matriz[linhaPeca][colunaPeca+2]!=' ' && (colunaPeca+2) == colunaEspaco && linhaPeca == linhaEspaco) {
                    if(matriz[linhaPeca][colunaPeca + 2] == '0') {
                    matriz[linhaPeca][colunaPeca + 1] = '0';
                    matriz[linhaPeca][colunaPeca + 2] = '1';
                    matriz[linhaPeca][colunaPeca] = '0';
                    numPecas--;
                    }
                } else if ((colunaPeca - 2)>=0 && matriz[linhaPeca][colunaPeca-2]!=' ' && (colunaPeca-2) == colunaEspaco && linhaPeca == linhaEspaco){
                    if(matriz[linhaPeca][colunaPeca - 2] == '0'){
                    matriz[linhaPeca][colunaPeca - 1] = '0';
                    matriz[linhaPeca][colunaPeca - 2] = '1';
                    matriz[linhaPeca][colunaPeca] = '0';
                    numPecas--;
                    }
                } else if ((linhaPeca + 2)<7 && matriz[linhaPeca+2][colunaPeca]!=' ' && colunaPeca == colunaEspaco && (linhaPeca+2) == linhaEspaco){
                    if(matriz[linhaPeca + 2][colunaPeca] == '0'){
                    matriz[linhaPeca + 1][colunaPeca] = '0';
                    matriz[linhaPeca + 2][colunaPeca] = '1';
                    matriz[linhaPeca][colunaPeca] = '0';
                    System.out.println(matriz[linhaPeca][colunaPeca]);
                    numPecas--;
                    }
                } else if ((linhaPeca - 2)>=0 && matriz[linhaPeca-2][colunaPeca]!=' ' && colunaPeca == colunaEspaco && (linhaPeca-2) == linhaEspaco){
                    if(matriz[linhaPeca - 2][colunaPeca] == '0'){
                    matriz[linhaPeca - 1][colunaPeca] = '0';
                    matriz[linhaPeca - 2][colunaPeca] = '1';
                    matriz[linhaPeca][colunaPeca] = '0';
                    numPecas--;
                    }
                } else {
                    System.out.println("Jogada invalida");
                }
                imprimeMatriz();
            } else {
                System.out.println("Jogada invalida");
            }
        } else if(!verSeTemJogada() && numPecas!=1)
            System.out.println("Voce Perdeu, nao e possivel realizar mais jogadas");
        else if(!verSeTemJogada() && (numPecas == 1))
            System.out.println("Parabens! Voce ganhou!");
    } 
    
    private boolean verSeTemJogada(){
        boolean temJogada = false;
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 7; j ++){
                if(matriz[i][j]=='1'){
                    if((i-1)>=0 && (i-2)>=0){
                        if(matriz[i-1][j]=='1' && matriz[i-2][j]=='0'){
                            temJogada = true;
                            break;
                        }
                    }
                    if((i+2)<7){
                        if(matriz[i+1][j]=='1' && matriz[i+2][j]=='0'){
                            temJogada = true;
                            break;
                        }                        
                    } 
                    if((j-2)>=0){
                        if(matriz[i][j-1]=='1' && matriz[i][j-2]=='0'){
                            temJogada = true;
                            break;
                        }
                    }
                    if((j+2)<7){
                        if(matriz[i][j+1]=='1' && matriz[i][j+2]=='0'){
                            temJogada = true;
                            break;
                        }
                    }
                }
            }
        }
        return temJogada;
    }
    
}
