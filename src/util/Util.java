package util;

import java.util.Scanner;

/**
 *
 * @author Geam
 */
public class Util {

     
    /**
     * Realiza leitura do texto que o usuário informar
     *
     * @param texto
     * @param perguntaBooleana
     * @return int
     * @throws Exception
     */
    public static int lerEntradaInteiro(String texto, boolean perguntaBooleana) throws Exception {
        int num = 0;
        boolean leituraOK = true;
        Scanner scn = new Scanner(System.in);

        do {

            try {
                scn = new Scanner(System.in);
                System.out.println(texto);
                num = scn.nextInt();
                leituraOK = !(perguntaBooleana && (num > 2 || num < 0));
                leituraOK = (num > 0);
            } catch (Exception ex) {
                leituraOK = false;
                System.out.println("Número informado inválido!");
            }
        } while (!leituraOK);
        return num;
    }

}
