import java.util.Scanner;

public class UserInterface {
    private Database db;
    Scanner sc;

    public UserInterface() {
        db = new Database();
        sc = new Scanner(System.in);
    }

    public void startProgram() {
        int brugerValg = 0;
        while (brugerValg != 9) {
            System.out.println("""
                    Velkommen til Super Hero Databasen
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Søg efter en superhelt
                    4. Rediger oplysninger på en superhelt
                    9. Afslut    
                        """);


// Vi laver en masse bruger input for at modtage input og tilføjer scanner.

            brugerValg = sc.nextInt();
            sc.nextLine();
            håndterBrugerValg(brugerValg);
        }
    }

    public void håndterBrugerValg(int brugerValg) {
        if (brugerValg == 1)
            tilføjSuperhelt();
        else if (brugerValg == 2)
            udskrivSuperhelte();
        else if (brugerValg == 3)
            søgSuperhelt();
        else if (brugerValg == 9)
            System.exit(9);
    }


    public void tilføjSuperhelt() {
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
        db.tilføjSuperhelt(navn, superNavn, erMenneske, oprindelsesÅr, strength, superKraft);

    }

    public void udskrivSuperhelte() {
        for (Superhero superheroListe : db.getDatabaseForSuperHero()) {
            System.out.println(superheroListe);
        }
    }
    public void søgSuperhelt() {
        System.out.println("Indtast navn du søger efter");
        String søgHelt;
        søgHelt = sc.next();
        Superhero værdi = db.søgSuperHero(søgHelt);
        if (værdi == null)
            System.out.println("Superhelten findes ikke i databasen");
        else System.out.println(værdi);
    }
}

