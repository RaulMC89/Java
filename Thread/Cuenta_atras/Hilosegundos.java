package raulyagus;

public class Hilosegundos extends Thread {

    int segundosRestantes;
    int segundosTotal;
    int segundosmas;
    static boolean pausar = true;

    public Hilosegundos(int segundos) {
        if (segundos >= 25) {
            this.segundosRestantes = segundos;
            this.segundosTotal = segundos;
            this.segundosmas = segundos;
        } else {
            segundos = 25;
            this.segundosRestantes = segundos;
            this.segundosTotal = segundos;
            this.segundosmas = segundos;
        }
    }

    @Override
    public void run() {
        try {
            while (segundosRestantes >= 0) {
                System.out.println(segundosRestantes + " restants - " + porcentaje() + " %");
                segundosRestantes--;
                sleep(500);
                while (!pausar) {
                    sleep(500);
                }
            }
        } catch (InterruptedException ex) {
        }
    }

    private double porcentaje() {
        return (double) (100.0 - (100.0 * segundosRestantes) / segundosmas);
    }

    public void set10Time() {
        segundosmas += 10;
        segundosRestantes += 10;
    }

    public void setResTime() {
        segundosRestantes = segundosTotal;
        segundosmas = segundosTotal;
    }

    public void setpausar() {
        pausar = false;
    }

    public void setreanudar() {
        pausar = true;
    }
}
