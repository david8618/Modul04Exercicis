package david.itacademy.Nivell01;

import java.util.Scanner;

public class Main {
    /*
    L’exercici consisteix a mostrar per consola una carta d’un restaurant on afegirem diferents plats i
    després escollirem que volem per menjar. Un cop fet això s’haurà de calcular el preu del menjar, i el
    programa ens dirà amb quins bitllets hem de pagar.
     */

    public static void main(String[] args) {
	    //FASE 1
        System.out.println("----------- BENVINGUT AL RESTAURANTE COLISEUM ----------");
        System.out.println("Aquesta es la nostra carta de pizzes:");

        //FASE2
        Restaurant.menuRestaurant();

        //Pregutem al usuari que vol menjar
        Scanner sc = new Scanner(System.in);
        //Variable opcio
        int opc=0;
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ara toca triar-les!");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        do{
            Restaurant.comandaUsuaris(sc);
            //Le pregutem si vol afegir alguna pizza mes a la seva comanda
            System.out.print("Aquestes son les pizzes que has demanat.\n¿Vols demanar alguna pizza mes?{0->Si / 1->No}");
            opc=sc.nextInt();
            if(opc==0){
                Restaurant.comandaUsuaris(sc);
                opc=1;
            }
        }while (opc!=1);
        //FASE3
        Restaurant.faseTres();
        sc.close();
    }
}
