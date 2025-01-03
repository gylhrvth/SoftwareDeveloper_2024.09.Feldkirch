package Aylin.week08.Zoo;

public class ZooMain {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Central Florida Zoo & Botanical Gardens", 1975);

        Enclosure eWildlife = new Enclosure("Wildlife", 623, 7, "Wildlife Reserves");
        Enclosure eAviaries = new Enclosure("Aviaries", 200, 50, "Tropical Rainforests");
        Enclosure eTerrariums = new Enclosure("Terrarium" , 180, 5, "Freshwater Lakes");
        Enclosure eAquarium = new Enclosure("Aquarium", 100, 65, "Kelp forest");

        Food meat = new Food("Meat", "kg", 54);
        Food hay = new Food("Hay", "kg", 10);
        Food fruit = new Food("Fruit", "kg", 4);
        Food fishFlakes = new Food("Fish Flakes", "kg", 23);

        Zookeeper bill = new Zookeeper("Bill", "Lemur");
        Zookeeper bob = new Zookeeper("Bob", "Clownfish");
        Zookeeper liz = new Zookeeper("Liz", "");

        Veterinarian Shepherd = new Veterinarian("Derek");
        Veterinarian Mario = new Veterinarian("Mario");
        Veterinarian ELiza = new Veterinarian("Eliza");
        Veterinarian Christina = new Veterinarian("Christina");
        Veterinarian George = new Veterinarian("George");

        //Animals Wildlife
        Animals mammalLemurJulien = new Animals("King Julien", "Lemur", 20, "Male", fruit, 3, 99,  24);
        Animals mammalLemurMaurice = new Animals("Maurice", "Lemur", 25, "Male", fruit, 4, 79,  22);
        Animals mammalLemurMort = new Animals("Mort", "Lemur", 18, "Male", fruit, 2, 100, 14);
        Animals mammalElephant = new Animals("Henk", "Elephant", 23, "Male", fruit, 15, 85, 47);
        Animals mammalElephant2 = new Animals("Jumbo", "Elephant", 5, "Male", fruit, 6, 100, 10);
        Animals mammalLionKing = new Animals("Sir Roarsalot", "Lion", 6, "Male", meat, 7, 100, 42);
        Animals mammalLionQueen = new Animals("Lady Roarington", "Lion", 6, "Female", meat, 5, 100, 40);
        Animals mammalGiraffe = new Animals("Stretch Armstrong", "Giraffe", 21, "Male", fruit, 9, 90, 23);
        Animals mammalGiraffe2 = new Animals("Giraffey", "Giraffe", 16, "Female", fruit, 6, 95, 18);
        Animals mammalGiraffe3 = new Animals("Neckington", "Giraffe", 4, "Female", fruit, 2, 100, 10);
//        Animals mammalPuma = new Animals("Hagrit", "Puma", 18, "Male");
//        Animals mammalPuma2 = new Animals("Charlotte", "Puma", 12, "Female");
//        Animals mammalPuma3 = new Animals("leon", "Puma", 5, "Male");
//        Animals mammalPuma4 = new Animals("Whiskers", "Puma", 5, "Female");
//        Animals wildlifePenguinSkipper = new Animals("Skipper", "Penguin (Emperor)", 5, "Male");
//        Animals wildlifePenguinKowalski = new Animals("Kowalski", "Penguin (Adélie)", 4, "Male");
//        Animals wildlifePenguinPrivate = new Animals("Private", "Penguin (Chinstrap)", 3, "Male");
//        Animals wildlifePenguinRico = new Animals("Rico", "Penguin (Macaroni)", 6, "Male");

        //Animals Aviaries
        Animals aviaryHornbill = new Animals("Bingo", "Hornbill", 5, "Male", fruit, 6, 100,  40);
        Animals aviaryEagle = new Animals("Mighty", "Bald Eagle", 15, "Male", fruit, 3, 89,  18);
        Animals aviaryFlamingo = new Animals("Flame", "Flamingo", 4, "Male", fruit, 2, 100, 7);
        Animals aviaryPeacock = new Animals("Regal", "Peacock", 6, "Female", hay, 3, 100, 8);
        Animals aviaryGreyParrot = new Animals("Echo", "African Grey Parrot", 10, "Male", hay, 5, 95, 5);
//        Animals aviaryHarpyEagle = new Animals("Storm", "Harpy Eagle", 12, "Female");
//        Animals aviaryMacaw = new Animals("Sunny", "Macaw Parrot", 8, "Female");
//        Animals aviaryKeaParrot = new Animals("Kiwi", "Kea Parrot", 7, "Female");
//        Animals aviaryKingfisher = new Animals("Splash", "Kingfisher", 3, "Male");
//        Animals aviaryOwlet = new Animals("Whiskers", "Owlet", 2, "Female");

        //Animals Terrarium
        Animals reptileAligator = new Animals("George", "Alligator", 32, "Male", meat, 3, 80,  35);
        Animals reptileAligator2 = new Animals("Roxy", "Alligator", 24, "Female", meat, 3, 92,  35);
        Animals reptileAligator3 = new Animals("Rex", "Alligator", 1, "Male", meat, 1, 100, 15);
        Animals reptileTurtle = new Animals("Donatello", "Turtle", 8, "Male", fruit, 2, 100, 10);
        Animals reptileTurtle2 = new Animals("Slowpoke", "Turtle", 11, "Female", fruit, 3, 97, 12);

        //Animals Aquarium
        Animals aquariumAngelfish = new Animals("Angelina", "Angelfish", 4, "Female", fishFlakes, 1, 10,  2);
        Animals aquariumGramma = new Animals("Flame", "Royal Gramma", 2, "Female", fishFlakes, 1, 10,  1);
        Animals aquariumSurgeonfish = new Animals("Dory", "Blue Tang", 5, "Female", fishFlakes, 2, 10,  1);
        Animals aquariumClownfish = new Animals("Nemo", "Clownfish", 3, "Male", fishFlakes, 1, 10,  1);
//        Animals aquariumMorayEel = new Animals("Slick", "Moray Eel", 7, "Male");
//        Animals aquariumLionfish = new Animals("Spike", "Lionfish", 6, "Male");
//        Animals aquariumSeaTurtle = new Animals("Crush", "Green Sea Turtle", 50, "Male");
//        Animals aquariumSeahorse = new Animals("Pony", "Seahorse", 1, "Male");
//        Animals aquariumJellyfish = new Animals("Bubbles", "Jellyfish", 3, "Female");
//        Animals aquariumOctopus = new Animals("Inky", "Common Octopus", 4, "Male");

        //adding Enclosures to the zoo
        zoo.addEnclosure(eWildlife);
        zoo.addEnclosure(eAviaries);
        zoo.addEnclosure(eTerrariums);
        zoo.addEnclosure(eAquarium);

        //adding Animals to the enclosures
        eWildlife.addAnimals(mammalLemurJulien);
        eWildlife.addAnimals((mammalLemurMaurice));
        eAquarium.addAnimals(aquariumAngelfish);
        eAquarium.addAnimals(aquariumGramma);
        eAviaries.addAnimals(aviaryEagle);
        eAviaries.addAnimals(aviaryHornbill);
        eTerrariums.addAnimals(reptileAligator);
        eTerrariums.addAnimals(reptileAligator2);
        eAquarium.addAnimals(aquariumClownfish);
        eAquarium.addAnimals(aquariumSurgeonfish);
        eWildlife.addAnimals(mammalLemurMort);
        eWildlife.addAnimals(mammalElephant);
        eWildlife.addAnimals(mammalElephant2);
        eWildlife.addAnimals(mammalLionKing);
        eWildlife.addAnimals(mammalLionQueen);
        eWildlife.addAnimals(mammalGiraffe);
        eWildlife.addAnimals(mammalGiraffe2);
        eWildlife.addAnimals(mammalGiraffe3);
        eAviaries.addAnimals(aviaryFlamingo);
        eAviaries.addAnimals(aviaryPeacock);
        eAviaries.addAnimals(aviaryGreyParrot);
        eTerrariums.addAnimals(reptileAligator3);
        eTerrariums.addAnimals(reptileTurtle);
        eTerrariums.addAnimals(reptileTurtle2);

        //Printing the Structure
        zoo.printZooStructure();

        bill.addTask(eWildlife);
        bill.addTask((eAviaries));
        bob.addTask(eWildlife);
        bob.addTask(eAquarium);
        liz.addTask(eAviaries);
        liz.addTask(eTerrariums);

        zoo.addZookeeper(bill);
        zoo.addZookeeper(bob);
        zoo.addZookeeper(liz);

        zoo.addVet(Shepherd);
        zoo.addVet(Christina);
        zoo.addVet(George);
        zoo.addVet(ELiza);

        zoo.printFoodCost();

        zoo.startSimu();

    }
}
