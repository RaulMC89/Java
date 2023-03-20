/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonacci;

import java.math.BigInteger;

/**
 *
 * @author mraul
 */
public class Fibonacci extends Thread {

    public Fibonacci(int n) {

        fibbonacci(n);

    }

    private void fibbonacci(int n) {
        try {
            BigInteger a = new BigInteger("1");
            BigInteger b = new BigInteger("1");
            BigInteger c;

            for (int i = 0; i < n; i++) {
                if (a.intValue() == 1 && b.intValue() == 1) {
                    System.out.println(a + "\n" + b);
                }
                c = b.add(a);
                a = a.subtract(a).add(b);
                b = b.subtract(b).add(c);

                System.out.println(b);
                Thread.sleep(2000);
            }

        } catch (Exception e) {
        }
    }

}
