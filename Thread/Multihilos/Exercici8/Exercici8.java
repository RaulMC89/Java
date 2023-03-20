/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici8;

/** Hem d'incrementar en 1 el valor del comptador N vegades.
 * Si s'executen 100 incrementadors, el resultat del comptador hauria de ser 100.
 * @author Yolanda
 */
public class Exercici8 {
    
    public static void main(String[] args) {
        
        Exercici8_Sumador[] fils = new Exercici8_Sumador[10];
        Exercici8_Comptador comptador = new Exercici8_Comptador();
                
        for (int i = 0; i < fils.length; i++) {
            fils[i] = new Exercici8_Sumador(i, comptador);
        }
            
        for (int i = 0; i < fils.length; i++) {
            fils[i].start();
        }
        
    }
}
