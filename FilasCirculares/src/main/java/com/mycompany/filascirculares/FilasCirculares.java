/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filascirculares;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Marcelo
 */
public class FilasCirculares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a expressão matemática:");
        String expressao = scanner.nextLine();

        if (verificarParametrizacao(expressao)) {
            System.out.println("Expressão correta!");
        } else {
            System.out.println("Expressão incorreta!");
        }

        scanner.close();
    }

    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; 
                }

                char topoPilha = pilha.pop();

               
                if ((caractere == ')' && topoPilha != '(') ||
                    (caractere == ']' && topoPilha != '[') ||
                    (caractere == '}' && topoPilha != '{')) {
                    return false; 
                }
            }
        }

      
        return pilha.isEmpty();
    }
}