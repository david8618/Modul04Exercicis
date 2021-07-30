package david.itacademy.Nivell03;

import java.util.*;

public class RestaurantExceptionNivell03 {
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


    protected static void MenuRestaurant(){
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

    protected static void comandaUsuaris(Scanner sc) throws ExceptionTipus, ExceptionPlats {
        try{
            System.out.println("Indica quantes pizzas vols:");
            int numplats=sc.nextInt();
            throw new ExceptionTipus("Has introduït un valor que no corresponia.");
        }catch (ExceptionTipus e){
            System.out.println(e.getMessage());
        }
        //Començem a preguntar per les pizzes que vol
        System.out.println("Indica el nom de les pizzas que vols: ");
        for (int i = 0; i < comanda.size(); i++) {
            System.out.print((i+1) + " ");
            try{
            String nomMenu=primeraMayusculas(sc.next());
            if(menuPreus.containsKey(nomMenu)) comanda.add(nomMenu);
            else {
                comanda.remove(nomMenu);
                throw new ExceptionPlats("Aquesta pizza que has indicat, no es troba a la carta.\n" +
                        "La hem eliminat de la teva comanda");

            }
            }catch (ExceptionPlats e){
            System.out.println(e.getMessage());
            }finally {
            continue;
            }
        }

        System.out.println("---- AQUESTA ES LA TEVA COMANDA ----");
        //Mostrem al usuari la seva comanda
        for (String veura:comanda) {
            System.out.println(veura);
        }
    }

    protected static int preguntaUsuaris(int opc, Scanner sc){
        boolean repetir;
        do{
            try{
                repetir=false;
                //Le pregutem si vol afegir alguna pizza mes a la seva comanda
                System.out.print("¿Vols demanar alguna pizza mes?{0->Si / 1->No}");
                opc=sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("T'has equivocat.Has d'introduir 0 o 1.");
                //System.out.println(e.getMessage());
                sc.next();
                repetir=true;
            }
        }while(repetir);
        return opc;
    }

    protected static void billetsMonedas(){
        for (int i = 0; i < comanda.size(); i++) {
            //Comprobem si la llista de comanda están les mateixes pizzas de la nostre carta
            if(menuPreus.containsKey(comanda.get(i))){
                //fem la suma dels valors de la pizza que es troben a la nostre carta
                total+=menuPreus.get(comanda.get(i));
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("El total de la comanda es: " + total + " €");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Bitllets/monedes amb les quals s'hauria de pagar la comanda:");
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

class ExceptionTipus extends Exception{

    public ExceptionTipus() {
    }

    public ExceptionTipus(String message) {
        super(message);
    }
}

class ExceptionPlats extends Exception{
    public ExceptionPlats() {
    }

    public ExceptionPlats(String message) {
        super(message);
    }
}


