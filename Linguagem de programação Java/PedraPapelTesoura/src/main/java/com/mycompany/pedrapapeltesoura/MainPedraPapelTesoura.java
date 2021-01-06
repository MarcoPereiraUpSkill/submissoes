package com.mycompany.pedrapapeltesoura;

import java.util.Scanner;

public class MainPedraPapelTesoura {

    public enum Sinal {
        PEDRA, PAPEL, TESOURA
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int vitoriasJog1 = 0;
        int vitoriasJog2 = 0;
        int opcao;
        Sinal escolha1;
        Sinal escolha2;

        while (vitoriasJog1 < 3 && vitoriasJog2 < 3) {
            do {
                System.out.println("Jogador 1 (Enter 1-Pedra, 2-Papel, 3-Tesoura)");
                opcao = scanner.nextInt();
                escolha1 = Sinal.values()[opcao - 1];
            } while(opcao > 3 || opcao < 0);
           
            do {
                System.out.println("Jogador 2 (Enter 1-Pedra, 2-Papel, 3-Tesoura)");
                opcao = scanner.nextInt();
                escolha2 = Sinal.values()[opcao - 1];
            } while(opcao > 3 || opcao < 0);
       
            if(escolha1 == Sinal.PEDRA && escolha2 == Sinal.TESOURA || escolha1 == Sinal.TESOURA && escolha2 == Sinal.PAPEL 
                    || escolha1 == Sinal.PAPEL && escolha2 == Sinal.PEDRA){
                System.out.println("Ganhou jogador 1");
                vitoriasJog1++;
            } else if (escolha1 == Sinal.TESOURA && escolha2 == Sinal.PEDRA || escolha1 == Sinal.PAPEL && escolha2 == Sinal.TESOURA 
                    || escolha1 == Sinal.PEDRA && escolha2 == Sinal.PAPEL){
                System.out.println("Ganhou jogador 2!");
                vitoriasJog2++;
            } else if (escolha1 == escolha2){
                System.out.println("Empate!");
            }
        }
        
        if(vitoriasJog1 == 3){
            System.out.println("Jogador 1 é o vencedor!!");
        } else {
            System.out.println("Jogador 2 é o vencedor!!");
        }
    }

}
