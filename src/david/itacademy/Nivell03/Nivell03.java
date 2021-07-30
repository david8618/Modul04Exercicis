package david.itacademy.Nivell03;

import java.util.Scanner;

public class Nivell03 {

    public static void main(String[] args) throws ExceptionTipus {
        /*
        NIVELL 03
        Crea excepcions personalitzades amb fitxers nous e implementa-les al codi actual.
        Has de crear Excepcions personalitzades per: Revisió de tipus, introducció de plats, revisió de plats de la comanda.
        El text ha de ser personalitzat. No cal que propaguis l’excepció.
        Rodeja amb un try/catch cada part que has de revisar amb una excepció.
         */

        //FASE 1
        System.out.println("----------- BENVINGUT AL RESTAURANTE COLISEUM ----------");
        System.out.println("Aquesta es la nostra carta de pizzes:");

        //FASE2
        RestaurantExceptionNivell03.MenuRestaurant();

        //Pregutem al usuari que vol menjar
        Scanner sc = new Scanner(System.in);
        //Variable opcio
        int opc=0;
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ara toca triar-les!");
        System.out.println("-----------------------------------------------------------");
        System.out.println();

        try {

            RestaurantExceptionNivell03.comandaUsuaris(sc);


            if(RestaurantExceptionNivell03.preguntaUsuaris(opc,sc)==0){
                RestaurantExceptionNivell03.comandaUsuaris(sc);
                RestaurantExceptionNivell03.billetsMonedas();
            }else{
                RestaurantExceptionNivell03.billetsMonedas();
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }
}
