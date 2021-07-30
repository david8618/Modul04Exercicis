package david.itacademy.Nivell02;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //FASE 1
        System.out.println("----------- BENVINGUT AL RESTAURANTE COLISEUM ----------");
        System.out.println("Aquesta es la nostra carta de pizzes:");

        //FASE2
        RestaurantException.menuRestaurant();

        //Pregutem al usuari que vol menjar
        Scanner sc = new Scanner(System.in);
        //Variable opcio
        int opc=0;
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ara toca triar-les!");
        System.out.println("-----------------------------------------------------------");
        System.out.println();

        try {
            RestaurantException.comandaUsuaris(sc);
            //Pregutem al usuari
            if(RestaurantException.preguntaUsuaris(opc,sc)==0){
                RestaurantException.comandaUsuaris(sc);
                RestaurantException.billetsMonedas();
            }else{
               RestaurantException.billetsMonedas();
           }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        sc.close();
    }
}
