import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Vi bringer vores database class ind i main (Instiansiere)
        Database superheroDataBase = new Database();

        int brugerValg = 0;

        do {
            System.out.println("""
                    Velkommen til Super Hero Databasen
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Søg efter en superhelt
                    9. Afslut    
                        """);

// Vi laver en masse bruger input for at modtage input og tilføjer scanner.
            Scanner sc = new Scanner(System.in);
            brugerValg = sc.nextInt();
            sc.nextLine();
            String søgHelt;
            boolean fundet = false;


            if (brugerValg == 3) {
                System.out.println("Indtast navn du søger efter");
                søgHelt = sc.next();
                Superhero værdi = superheroDataBase.søgSuperHero(søgHelt);
                if (værdi == null)
                    System.out.println("Superhelten findes ikke i databasen");
                else System.out.println(værdi);

            }
            


                if (brugerValg == 1) {
                    System.out.println("Indtast Super-helte navnet på din superhelt");
                    String navn = sc.nextLine();
                    System.out.println("Hvis din superhelt har et menneske navn så indtast det her, ellers skriv ingen");
                    String superNavn = sc.nextLine();
                    System.out.println("Er din helt et menneske? Svar Ja/nej");
                    boolean erMenneske = false;
                    String svar = sc.next();
                    if (svar.equalsIgnoreCase("Ja")) {
                        erMenneske = true;
                    } else if (svar.equalsIgnoreCase("Nej")) {
                        erMenneske = false;
                    }

                    //System.out.println("");
                    // boolean erMenneske = sc.nextLine(); TODO

                    System.out.println("Hvilket år blev din superhelt opfundet?");
                    int oprindelsesÅr = sc.nextInt();
                    System.out.println("Hvor stærk er superhelten fra 1-100?");
                    double strength = sc.nextDouble();
                    System.out.println("Hvad er din superheltes superkraft?");
                    String superKraft = sc.next(); //Udskriver kun første ord? TODO
                    superheroDataBase.tilføjSuperhelt(navn, superNavn, erMenneske, oprindelsesÅr, strength, superKraft);


// Vi kalder på vores funktion tilføjSuperhelt som blev lavet i Database classen.
                    // Vi angiver de variabler vi vil have med i vores funktion. Disse variabler blev instaniseret længere oppe

                    // vis hele listen - flyt senere!
                } else if (brugerValg == 2) {
                    for (Superhero superheroListe : superheroDataBase.getDatabaseForSuperHero()) {
                        System.out.println(superheroListe);
                    }

                } else {
                    System.exit(0);
                }
            }
            while (brugerValg != 9) ;


        }
    }

