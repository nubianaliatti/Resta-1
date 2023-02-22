/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.restaum;

/**
 *
 * @author NOTE
 */
import java.util.Scanner;
public class RestaUm {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Scanner s = new Scanner(System.in);
        String escolha = " ";
        jogo.imprimeMatriz();
        int linhaPeca, colunaPeca, linhaEspaco, colunaEspaco;
        while (!(escolha.equals("sair")) ) {
            System.out.println("Digite sua opcao de jogo, seguindo o padrao(nao esqueca dos espacos): (a, b, c, d)");
            escolha = s.nextLine();
            if(escolha.equals("reiniciar")){
                jogo.reiniciar();
                jogo.imprimeMatriz();
            }
            else {
                linhaPeca = Integer.parseInt(escolha.substring(1, 2));
                colunaPeca = Integer.parseInt(escolha.substring(4, 5));
                linhaEspaco = Integer.parseInt(escolha.substring(7, 8));
                colunaEspaco = Integer.parseInt(escolha.substring(10, 11));
                jogo.jogar(linhaPeca,colunaPeca,linhaEspaco,colunaEspaco);
            }
        }
    }
}
