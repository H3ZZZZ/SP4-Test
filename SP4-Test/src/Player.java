import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private int sandwich;
    private int studyPoints;
    private int energyLevel;
    private int maxEnergyLevel;
    private int coffee;
    private Backpack inventory;
    private int wrongAnswers;
    private int correctAnswers;
    Scanner input;
    private int money;


    private String name;

    public Player(String name) {
        this.name = name;
        this.coffee = 0;
        this.studyPoints = 0;
        this.energyLevel = 100;
        this.wrongAnswers = 0;
        this.correctAnswers = 0;
        this.money = 100;
        this.inventory = new Backpack();
        this.maxEnergyLevel = 100;
    }

    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void addItemToInventory(Item newItem) {
        this.inventory.addToBackPack(newItem);
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public Backpack getInventory() {
        return inventory;
    }

    public void setInventory(Backpack inventory) {
        this.inventory = inventory;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getMaxEnergyLevel() {
        return maxEnergyLevel;
    }

    public void setMaxEnergyLevel(int maxEnergyLevel) {
        this.maxEnergyLevel = maxEnergyLevel;
    }
   /* Player player = new Player("John", 1);

    public void drinkCoffee() {
        Storyline.clearAll();
        if (player.kaffe >=1) {
            player.energyLevel += 25;
            System.out.println("Du drikker en kop dejlig, varm og forfriskende kaffe! Din energi stiger og du har nu " + player.energyLevel + "/100 energi!");
        } else {
            System.out.println("Du har ikke noget kaffe, køb eventuelt noget i kantinen.");
        }
    }*/

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSandwich() {
        return sandwich;
    }

    public void setSandwich(int sandwich) {
        this.sandwich = sandwich;
    }

    public void viewInventory() {
        System.out.println(inventory.toString());
    }

    public void readBook(int bookID) {

        Book b = inventory.getSpecificBook(bookID);
        if (b == null) {
            System.out.println("Den her bog har du ikke");
            return;
        } else {
            System.out.println("Du læste den spændende bog ved navn: " + b.getBookTitle());
            System.out.println("Det er en rigtig spændende bog som giver dig " + b.getStudyPoints() + " ekstra Study Points");
            Storyline.player.setStudyPoints(Storyline.player.getStudyPoints() + b.getStudyPoints());
            System.out.println("Efter at have læst bogen er du nu i alt oppe på " + Storyline.player.getStudyPoints() + " Study Points");

        }

    }



    public void lootBook1() {
        Book book1 = new Book("Hvordan tænder man sin pc",25, 1);
        addItemToInventory(book1);
        System.out.println("Bog tilføjet: '" + book1.getBookTitle() + "' \n" +
                "Det er en rigtig god bog som kan give dig " + book1.getStudyPoints() + " Study Points");
    }


    public void lootBook2() {
        Book book2 = new Book("Hvad er processing?",35,2);
        addItemToInventory(book2);
        System.out.println("Bog tilføjet: '" + book2.getBookTitle() + "' \n" +
                "Det er en rigtig god bog som kan give dig " + book2.getStudyPoints() + " Study Points");
    }

    public void lootBook3() {
        Book book3 = new Book("Strings for nybegyndere",30,3);
        addItemToInventory(book3);
        System.out.println("Bog tilføjet: '" + book3.getBookTitle() + "' \n" +
                "Det er en rigtig god bog som kan give dig " + book3.getStudyPoints() + " Study Points");
    }


    public void buyCoffee() {
        if (getMoney() >= 10) {
            setMoney(getMoney() - 10);
            System.out.println("Du har nu købt en dejlig varm kop kaffe for 10 kroner" +
                    "\n Du har nu " + getMoney() + " kroner tilbage");
            addItemToInventory(new Coffee());
        } else {
            System.out.println("Du har ikke råd til en kaffe lige nu");
        }
    }


    public void buySandwich() {
        if (getMoney() >= 25) {
            setMoney(getMoney() - 25);
            System.out.println("Du har nu købt en Homestyle Singapore Fried Chicken x Henrik Jyrk (Standard Recipe) \n" +
                    "Energi (kcal):642 kcal (32% RI) \n" +
                    "Fedt (g):28 g (40% RI) \n" +
                    "heraf mættede fedtsyrer (g):4,5 g (22% RI) \n" +
                    "Kulhydrater (g):71 g (27% RI) \n" +
                    "heraf sukkerarter (g):11 g (13% RI) \n" +
                    "Protein (g):25 g (49% RI) \n" +
                    "Salt (g):3 g (51% RI) \n" +
                    "Kostfibre (g):3,1 g");

            addItemToInventory(new Sandwich());
            System.out.println("Du har nu " + getMoney() + " kroner tilbage");

        } else {
            System.out.println("Du har ikke råd din fattiglus.");
        }

    }
}
