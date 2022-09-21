import java.util.Scanner;
// Vi starter med at oprette UserInterface classen som har databasen og en scanner.
public class UserInterface {
    private Database db;
    Scanner sc;
// UserInterfacen indeholder nu en scanner og databasen, forstår ikke helt denne del??
    public UserInterface() {
        db = new Database();
        sc = new Scanner(System.in);
    }
// Vi laver en metode der starter hele programmet op. Programmet spørger brugeren at vælge ud fra menuen.
    public void startProgram() {
        int brugerValg = 0;
        while (brugerValg != 9) {
            System.out.println("""
                    Velkommen til Super Hero Databasen
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Søg efter en superhelt
                    4. Slet en superhelt
                    9. Afslut    
                        """);


// Vi laver en masse bruger input for at modtage input og tilføjer scanner.

            brugerValg = readInt();
            // Scanner bug
            sc.nextLine();
            // Vi benytter funktionen nedenfor for at der rent faktisk sker noget når brugeren inputter et tal.
            håndterBrugerValg(brugerValg);

        }
    }
// Dette er metoden der gør, at der sker noget, når brugeren tager et valg.
    // Hvert valg udløser en metode som vi har lavet længere nede.
    public void håndterBrugerValg(int brugerValg) {
        if (brugerValg == 1)
            tilføjSuperhelt();
        else if (brugerValg == 2)
            udskrivSuperhelte();
        else if (brugerValg == 3)
            søgSuperhelt();
        else if (brugerValg == 4)
            sletSuperhelt();
        else if (brugerValg == 9)
            System.exit(9);

    }

// Dette er vores første metode, der tillader brugeren at oprette en superhelt
    public void tilføjSuperhelt() {
        System.out.println("Indtast Super-helte navnet på din superhelt");
        String navn = sc.nextLine();
        System.out.println("Hvis din superhelt har et menneske navn så indtast det her, ellers skriv ingen");
        String superNavn = sc.nextLine();
        System.out.println("Er din helt et menneske? Svar Ja/nej");
        // Her kalder vi på en metode som tvinger brugeren til at skrive Ja eller nej for at fortsætte.
        menneskeTrueFalse();
        boolean erMenneske = menneskeTrueFalse();
        /* Oprindelig kode vi startede med
        String svar = sc.next();
        if (svar.equalsIgnoreCase("Ja")) {
            erMenneske = true;
        } else if (svar.equalsIgnoreCase("Nej")) {
            erMenneske = false;
        } */

        //System.out.println("");
        // boolean erMenneske = sc.nextLine(); TODO

        System.out.println("Hvilket år blev din superhelt opfundet?");
        int oprindelsesÅr = readInt();
        System.out.println("Hvor stærk er superhelten fra 1-100?");
        double strength = readDouble();
        System.out.println("Hvad er din superheltes superkraft?");
        String superKraft = sc.next(); //Udskriver kun første ord? TODO
        db.tilføjSuperhelt(navn, superNavn, erMenneske, oprindelsesÅr, strength, superKraft);

    }
// Vi laver en metode der udskriver alle superhelte i databasen. Vi benytter metoden vi har oprettet i database
    // klassen. som bare hedder getDatabaseForSuperHero. Vi laver en for loop der gennemgår hvad hele vores
    // arraylist har og printer det ud.
    public void udskrivSuperhelte() {
        for (Superhero superheroListe : db.getDatabaseForSuperHero()) {
            System.out.println(superheroListe);
        }
    }
// Her laver vi en metode der søger efter en superhelt. Vi har en metode i database klassen der hedder
    // søgSuperHero som vi kalder. Alt hvad vi gør her er at oprette brugerinputtet (søgHelt) hvor inputtet bliver
    // lagt derind og metoden kaldes. Se database klassen efter søgSuperHero for at forstå det bedre.
    public void søgSuperhelt() {
        System.out.println("Indtast navn du søger efter");
        String søgHelt;
        søgHelt = sc.next();
        Superhero værdi = db.søgSuperHero(søgHelt);
        if (værdi == null)
            System.out.println("Superhelten findes ikke i databasen");
        else System.out.println(værdi);
    }
// Her laver vi en metode der tvinger brugeren til at indtaste ja eller nej for at fortsætte.
    // Metoden kører sig selv i ring ved sidste else statement. Den siger at så længe der bliver indtastet andet
    // end ja eller nej, så kører selve menneskeTrueFalse metoden igen og returnere vores boolean.
    public boolean menneskeTrueFalse() {
        String tekst = sc.next();
        boolean b = false;
        if (tekst.equalsIgnoreCase("Ja")) {
            b = true;
        } else if (tekst.equalsIgnoreCase("Nej")) {
            b = false;
        } else {
            System.out.println("Du skal indtaste ja eller nej for at fortsætte. Er superhelten et menneske?");


        } return b;

    }
    // Her laver vi en metode for at slette en superhelt. Vi benytter vores søgSuperhelt metode
    // så vores bruger kan søge efter en superhelt.
    public void sletSuperhelt() {
        System.out.println("Søg efter superhelten du vil slette");
        String søgSuperhelt = sc.nextLine();
        // Her får vi fat i vores metode søgSuperhelt ved at oprette en ny Superhero ?class? som hedder
        // sletSuperhelt der svarer til at vi benytter vores søgSuperhero metode i databasen hvor
        // metoden søgSuperhelt er metoden vi oprettede tidligere, så programmet søger efter inputtet fra brugeren.
        Superhero sletSuperhelt = db.søgSuperHero(søgSuperhelt);
        if (sletSuperhelt != null) {
            // sletSuperhelt i dette tilfælde er vores indeks, altså superhelt objektet der bliver fundet.
            System.out.println("Dette er superhelten du har søgt efter" + sletSuperhelt);
        } else if (sletSuperhelt == null) {
            System.out.println("Dit søgeresultat gav ingen resultater");
        }
        // Vi spørger brugeren om personen vil slette denne superhelte objekt.
        System.out.println("Vil du slette denne superhelt?");
        String jaNej = sc.nextLine();
        if (jaNej.equalsIgnoreCase("Ja")) {
            // Vi opretter vores indeks. Indekset svarer til sletSuperhelt som er objektet
            int n;
            n = db.getDatabaseForSuperHero().indexOf(sletSuperhelt);
            db.getDatabaseForSuperHero().remove(n);

        } else if (jaNej.equalsIgnoreCase("Nej")) {
            System.exit(0);
        }
    }


    public int readInt() {
        while (!sc.hasNextInt()) {
            String tekst = sc.next();
            System.out.println("Inputtet " + tekst + " må du ikke skrive. Du skal skrive et tal. Forsøg igen");
        }
        return sc.nextInt();


    }

    public double readDouble() {
        while (!sc.hasNextDouble()) {
            String tekst = sc.next();
            System.out.println("Inputtet " + tekst + " må du ikke skrive. Du skal skrive et tal. Forsøg igen");
        }
        return sc.nextDouble();
    }
}




