package david.itacademy.Nivell01;

import java.util.*;

public class Restaurant {
    /*
    FASE1
    Creeu una variable int per cada un dels bitllets i/o monedes que existeixen des de 1€ a 500€.
    Haureu de crear una altra variable per guardar el preu total del menjar.
    Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat.
    */
    //Variables diners
    private static int m01, m02, b05, b10, b20, b50, b100, b200, b500;
    private static int total;

    //Arrays menú i preu
    private static String menu[]=new String[10];
    private static int preus[]= new int [10];

    //Menú i preus amb HashMap
    private static HashMap<String, Integer> menuPreus = new HashMap<String, Integer>();
    //ArrayList comanda usuari
    private static ArrayList<String>comanda=new ArrayList<String>();

    //El faig protected perque només els vui usar a la clase i al package
    protected static void menuRestaurant(){
        //Omplim el HashMap
        menuPreus.put("Carbonara", 12);
        menuPreus.put("Barbacoa", 14);
        menuPreus.put("Quatre Formatges", 11);
        menuPreus.put("Margarita", 11);
        menuPreus.put("Especial de la Casa", 13);
        menuPreus.put("Campesina", 10);
        menuPreus.put("Vegetal", 10);
        menuPreus.put("Extravaganzza", 15);
        menuPreus.put("Mediterrania", 14);
        menuPreus.put("Napolitana", 16);

        //Omplim els array amb el K,V
        int introduir=0;
        for (Map.Entry<String, Integer>dades: menuPreus.entrySet()) {
            menu[introduir]= dades.getKey();
            preus[introduir]= dades.getValue();
            introduir ++;
        }

        //Mostrar Array
        System.out.println("MENU");
        menuPreus.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " ----> " + entry.getValue());
        });
    }

    protected static void comandaUsuaris(Scanner sc){
        System.out.println("Indica quantes pizzas vols:");
        int numplats=sc.nextInt();

        //Començem a preguntar per les pizzes que vol
        System.out.println("Indica el nom de les pizzas que vols.");
        for (int i = 0; i < numplats; i++) {
            System.out.print((i+1)+" ");
            String nomMenu=primeraMayusculas(sc.next());
            comanda.add(nomMenu);
        }
        System.out.println("---- AQUESTA ES LA TEVA COMANDA ----");
        //Mostrem al usuari la seva comanda
        for (String veura:comanda) {
            System.out.println(veura);
        }
    }

    protected static void faseTres(){
        /*
        - Fase 3
        Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet al principi.
        En el cas que la informació que hem introduït a la List coincideixi amb la del array, haurem de sumar
        el preu del producte demanat; en el cas contrari haurem de mostrar un missatge que digui
        que el producte que hem demanat no existeix.
        Finalment mostrarem el preu total de la comanda i els bitllets/monedes amb les quals s'hauria de pagar
         */
        //Faig un array a on posarem les pizzes que no estan a la nostre carta.
        ArrayList<String>eliminadas=new ArrayList<String>();

        for (int i = 0; i < comanda.size(); i++) {
            //Comprobem si la llista de comanda están les mateixes pizzas de la nostre carta
            if(menuPreus.containsKey(comanda.get(i))){
                //fem la suma dels valors de la pizza que es troben a la nostre carta
                total+=menuPreus.get(comanda.get(i));
            }else{
                eliminadas.add(comanda.get(i));
                comanda.remove(comanda.get(i));
            }
        }
        if(!eliminadas.isEmpty()){
            System.out.println("Aquestes pizzes que ens has indicat:");
            for (int i = 0; i < eliminadas.size(); i++) {
                System.out.println(eliminadas.get(i));
            }
            System.out.println("Están mal escrites o no existeixen");
            System.out.println("-----------------------------------------------------------");
            System.out.println();
        }
        System.out.println("---- COMANDA FINAL ----");
        for (String comandafinal:comanda) {
            System.out.println(comandafinal);
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("El total de la comanda es: " + total + " €");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Bitllets/monedes amb les quals s'hauria de pagar la comanda:");
        billetsMonedas(total);
    }

    protected static void billetsMonedas(int total){
        b500=total/500;
        System.out.println(b500 + " billets de 500 euros.");
        total=total%500;
        b200=total/200;
        System.out.println(b200 + " billets de 200 euros.");
        total=total%200;
        b100=total/100;
        System.out.println(b100 + " billets de 100 euros.");
        total=total%100;
        b50=total/50;
        System.out.println(b50 + " billets de 50 euros.");
        total=total%50;
        b20=total/20;
        System.out.println(b20 + " billets de 20 euros.");
        total=total%20;
        b10=total/10;
        System.out.println(b10 + " billets de 10 euros.");
        total=total%10;
        b05=total/5;
        System.out.println(b05 + " billets de 5 euros.");
        total=total%5;
        m02=total/2;
        System.out.println(m02 + " monedas de 2 euros.");
        total=total%2;
        m01=total/1;
        System.out.println(m01 + " monedas de 1 euro.");
        total=total%1;
    }

    public static String primeraMayusculas(String pizza) {
        if (pizza == null || pizza.isEmpty()) {
            return pizza;
        } else {
            return  pizza.toUpperCase().charAt(0) + pizza.substring(1, pizza.length()).toLowerCase();
        }
    }

}


