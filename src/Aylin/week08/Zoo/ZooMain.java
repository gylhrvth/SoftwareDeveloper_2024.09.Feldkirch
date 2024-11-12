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

        Zookeeper bill = new Zookeeper("Bill", "King Julien");
        Zookeeper bob = new Zookeeper("Bob", "Nemo");
        Zookeeper liz = new Zookeeper("Liz", "");


        //Animals Wildlife

        Animals mammalLemurJulien = new Animals("King Julien", "Lemur", 20, "Male", fruit, 3);
        Animals mammalLemurMaurice = new Animals("Maurice", "Lemur", 25, "Male", fruit, 4);
//        Animals mammalLemurMort = new Animals("Mort", "Lemur", 18, "Male");
//        Animals mammalElephant = new Animals("Henk", "Elephant", 23, "Male");
//        Animals mammalElephant2 = new Animals("Jumbo", "Elephant", 5, "Male");
//        Animals mammalLionKing = new Animals("Sir Roarsalot", "Lion", 6, "Male");
//        Animals mammalLionQueen = new Animals("Lady Roarington", "Lion", 6, "Female");
//        Animals mammalGiraffe = new Animals("Stretch Armstrong", "Giraffe", 21, "Male");
//        Animals mammalGiraffe2 = new Animals("Giraffey", "Giraffe", 16, "Female");
//        Animals mammalGiraffe3 = new Animals("Neckington", "Giraffe", 4, "Female");
//        Animals mammalPuma = new Animals("Hagrit", "Puma", 18, "Male");
//        Animals mammalPuma2 = new Animals("Charlotte", "Puma", 12, "Female");
//        Animals mammalPuma3 = new Animals("leon", "Puma", 5, "Male");
//        Animals mammalPuma4 = new Animals("Whiskers", "Puma", 5, "Female");
//        Animals wildlifePenguinSkipper = new Animals("Skipper", "Penguin (Emperor)", 5, "Male");
//        Animals wildlifePenguinKowalski = new Animals("Kowalski", "Penguin (Adélie)", 4, "Male");
//        Animals wildlifePenguinPrivate = new Animals("Private", "Penguin (Chinstrap)", 3, "Male");
//        Animals wildlifePenguinRico = new Animals("Rico", "Penguin (Macaroni)", 6, "Male");

        //Animals Aviaries
        Animals aviaryHornbill = new Animals("Bingo", "Hornbill", 5, "Male", fruit, 6);
        Animals aviaryEagle = new Animals("Mighty", "Bald Eagle", 15, "Male", fruit, 3);
//        Animals aviaryFlamingo = new Animals("Flame", "Flamingo", 4, "Male");
//        Animals aviaryPeacock = new Animals("Regal", "Peacock", 6, "Female");
//        Animals aviaryGreyParrot = new Animals("Echo", "African Grey Parrot", 10, "Male");
//        Animals aviaryHarpyEagle = new Animals("Storm", "Harpy Eagle", 12, "Female");
//        Animals aviaryMacaw = new Animals("Sunny", "Macaw Parrot", 8, "Female");
//        Animals aviaryKeaParrot = new Animals("Kiwi", "Kea Parrot", 7, "Female");
//        Animals aviaryKingfisher = new Animals("Splash", "Kingfisher", 3, "Male");
//        Animals aviaryOwlet = new Animals("Whiskers", "Owlet", 2, "Female");

        //Animals Terrarium
        Animals reptileAligator = new Animals("George", "Alligator", 32, "Male", meat, 3);
        Animals reptileAligator2 = new Animals("Roxy", "Alligator", 24, "Female", meat, 3);
//        Animals reptileAligator3 = new Animals("Rex", "Alligator", 1, "Male");
//        Animals reptileTurtle = new Animals("Donatello", "Turtle", 8, "Male");
//        Animals reptileTurtle2 = new Animals("Slowpoke", "Turtle", 11, "Female");

        //Animals Aquarium
        Animals aquariumAngelfish = new Animals("Angelina", "Angelfish", 4, "Female", fishFlakes, 1);
        Animals aquariumGramma = new Animals("Flame", "Royal Gramma", 2, "Female", fishFlakes, 1);
        Animals aquariumSurgeonfish = new Animals("Dory", "Blue Tang", 5, "Female", fishFlakes, 2);
        Animals aquariumClownfish = new Animals("Nemo", "Clownfish", 3, "Male", fishFlakes, 1);
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

        //Printing the Structure
        zoo.printZooStructure();

        bill.addTask(eWildlife);
        bill.addTask((eAviaries));
        bob.addTask(eWildlife);
        bob.addTask(eAquarium);
        liz.addTask(eAviaries);
        liz.addTask(eTerrariums);

        //adding Zookeeper to visit and feed the animals
//        bill.assignEnclosureAndFeed(eWildlife);
//        bob.assignEnclosureAndFeed(eTerrariums);

        zoo.addZookeeper(bill);
        zoo.addZookeeper(bob);
        zoo.addZookeeper(liz);

        zoo.printFoodCost();

        zoo.startSimu();



    }
}
