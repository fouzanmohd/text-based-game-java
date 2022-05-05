import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainGame {

    /*
     * Author: Joe Yuen, for CS3IOS Project 2021-2022
     * block
     * 0 (Forest) 1(Ocean) 2(Desert)
     * 3(Island) 4 (Home) 5(N/A)
     * 6(Mountain) 7 (Exit Gate) 8 (Airport)
     */
    /*
     * solvePuzzle() :A function will be called when player uses the key at the exit
     * gate. The function returns true if player has solved the puzzle, false
     * otherwise.
     *
     * block_0(String action, shtring noun) :A function will be called when player
     * enters the particular block and issue a command. The function returns
     * "undefined" if the action is invalid
     * : each function represents one block in the game world. The arrangement is
     * listed above
     * block_8(String action, string noun) block_0: means the block with ID 0
     *
     * getNextBlock(int currentBlock, String dir) :get the ID of the block next to
     * the current block in "dir" direction. currentBlock=ID of currentBlock,
     * dir={north|west|east|south}
     *
     * getBlockName(int i) :return the name of the block with give an ID (i)
     *
     * printBag(String bag[]) :print out the content of player's bag
     *
     * printMap(int playerLocation) :Given the player's location (in term of block
     * ID), print the map around the player
     *
     * start() :The main game loop. The main component is a while loop that keep
     * reading "action" and "noun" from user input until "exit" is entered
     *
     * main() :The main method which create the MainGame object and call the method
     * start to start the game.
     *
     */
    boolean puzzleSolved = false;

    boolean solvePuzzle(String gameLevel) {
        int token = 3;
        Scanner in = new Scanner(System.in);
        System.out.println("Congratulation, you reach the final challenge... Now answer the riddles to move forward!");
        System.out.println("What gets wet while drying ?");
        while (token > 0) {

            String ans = in.nextLine().toLowerCase();
            if (ans.equals("towel")) {
                if (gameLevel.equals("2") || gameLevel.equals("3")) {
                    System.out.println("I am tall when I am young, and I am short when I am old. What am I ?");
                    while (token > 0) {
                        String ans2 = in.nextLine().toLowerCase();
                        if (ans2.equals("candle")) {
                            if (gameLevel.equals("3")) {
                                System.out.println("What goes up but never comes down");
                                while (token > 0) {
                                    String ans3 = in.nextLine().toLowerCase();
                                    if (ans3.equals("age")) {
                                        System.out.println(
                                                "You are so smart!  you may use the key to unlock the gate, if you have the key hahaha!");
                                        return true;
                                    } else {
                                        token -= 1;
                                        if (token > 0)
                                            System.out.println(
                                                    "Sorry, it is incorrect.  You can try " + token + " more time. "
                                                            + "Hint: Search for elixir and drink elixir in a desert and answer will show up");
                                    }
                                }
                            } else {
                                System.out.println(
                                        "You are so smart!  you may use the key to unlock the gate, if you have the key hahaha!");
                                return true;
                            }
                        } else {
                            token -= 1;
                            if (token > 0)
                                System.out.println("Sorry, it is incorrect.  You can try " + token + " more time. "
                                        + "Hint: Find a pen and use it in mountain and you shall have your answer!");
                        }

                    }

                } else {
                    System.out.println(
                            "You are so smart!  you may use the key to unlock the gate, if you have the key hahaha!");
                    return true;
                }

            } else {
                token -= 1;
                if (token > 0)
                    System.out.println("Sorry, it is incorrect.  You can try " + token + " more time. "
                            + "Hint: collect water and use it in airport to find answer");
            }

        }

        return false;
    }

    String block0(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "forest";
        } else if (action.equals("examine")) {
            // return "ok" if the (1)examining item is valid (2) the command is "examine
            // all". Otherwise, return "undefined"
            if (noun.equals("all")) {

                System.out.println("1. tickets");
                System.out.println("2. swimsuit");
                System.out.println("3. woods");
                System.out.println("4. animalskin");
                System.out.println("5. key");

            } else if (noun.equals("tickets")) {
                System.out.println(getHint("tickets"));
            } else if (noun.equals("swimsuit")) {
                System.out.println(getHint("swimsuit"));
            } else if (noun.equals("woods")) {
                System.out.println(getHint("woods"));
            } else if (noun.equals("key")) {
                System.out.println(getHint("key"));
            } else if (noun.equals("animalskin")) {
                System.out.println(getHint("animalskin"));

            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("tickets")) {
                addToBag("tickets");
            } else if (noun.equals("swimsuit")) {
                addToBag("swimsuit");
            } else if (noun.equals("woods")) {
                addToBag("woods");
            } else if (noun.equals("animalskin")) {
                addToBag("animalskin");
            } else if (noun.equals("key")) {
                addToBag("key");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        }
        return "undefined";
    }

    String block1(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "ocean";
        } else if (action.equals("examine")) {
            // return "ok" if the (1)examining item is valid (2) the command is "examine
            // all". Otherwise, return "undefined"
            if (noun.equals("all")) {

                System.out.println("1. torch");
                System.out.println("2. water");
                System.out.println("3. fish");
                System.out.println("4. pearls");
                System.out.println("5. salt");

            } else if (noun.equals("torch")) {
                System.out.println(getHint("torch"));
            } else if (noun.equals("water")) {
                System.out.println(getHint("water"));
            } else if (noun.equals("fish")) {
                System.out.println(getHint("fish"));
            } else if (noun.equals("pearls")) {
                System.out.println(getHint("pearls"));
            } else if (noun.equals("salt")) {
                System.out.println(getHint("salt"));

            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("torch")) {
                addToBag("torch");
            } else if (noun.equals("water")) {
                addToBag("water");
            } else if (noun.equals("fish")) {
                addToBag("fish");
            } else if (noun.equals("pearls")) {
                addToBag("pearls");
            } else if (noun.equals("salt")) {
                addToBag("salt");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        } else if (action.equals("use")) {
            useItem(noun);
        }
        return "undefined";
    }

    String block2(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "desert";
        } else if (action.equals("examine")) {
            // return "ok" if the (1)examining item is valid (2) the command is "examine
            // all". Otherwise, return "undefined"
            if (noun.equals("all")) {

                System.out.println("1. swimsuit");
                System.out.println("2. sand");
                System.out.println("3. cactus");
                System.out.println("4. boots");

            } else if (noun.equals("swimsuit")) {
                System.out.println(getHint("swimsuit"));
            } else if (noun.equals("sand")) {
                System.out.println(getHint("sand"));
            } else if (noun.equals("cactus")) {
                System.out.println(getHint("cactus"));
            } else if (noun.equals("boots")) {
                System.out.println(getHint("boots"));
            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("swimsuit")) {
                addToBag("swimsuit");
            } else if (noun.equals("sand")) {
                addToBag("sand");
            } else if (noun.equals("cactus")) {
                addToBag("cactus");
            } else if (noun.equals("boots")) {
                addToBag("boots");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        } else if (action.equals("use")) {
            if (noun.equals("elixir") && bagItems.contains("elixir")) {
                System.out.println("You have drank elixir! you can live till your age hits 1000");
            } else {
                useItem(noun);
            }
        }
        return "undefined";
    }

    String block3(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "island";
        } else if (action.equals("examine")) {
            // return "ok" if the (1)examining item is valid (2) the command is "examine
            // all". Otherwise, return "undefined"
            if (noun.equals("all")) {

                System.out.println("1. torch");
                System.out.println("2. binocular");
                System.out.println("3. boots");
                System.out.println("4. shells");

            } else if (noun.equals("torch")) {
                System.out.println(getHint("torch"));
            } else if (noun.equals("binocular")) {
                System.out.println(getHint("binocular"));
            } else if (noun.equals("boots")) {
                System.out.println(getHint("boots"));
            } else if (noun.equals("shells")) {
                System.out.println(getHint("shells"));
            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("torch")) {
                addToBag("torch");
            } else if (noun.equals("binocular")) {
                addToBag("binocular");
            } else if (noun.equals("shells")) {
                addToBag("shells");
            } else if (noun.equals("boots")) {
                addToBag("boots");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        } else if (action.equals("use")) {
            useItem(noun);
        }
        return "undefined";
    }

    String block4(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "home";
        } else if (action.equals("examine")) {
            // return "ok" if the (1)examining item is valid (2) the command is "examine
            // all". Otherwise, return "undefined"
            if (noun.equals("all")) {

                System.out.println("1. water");
                System.out.println("2. swimsuit");
                System.out.println("3. tickets");
                System.out.println("4. food");
                System.out.println("5. pen");
                System.out.println("6. book");

            } else if (noun.equals("water")) {
                System.out.println(getHint("water"));
            } else if (noun.equals("swimsuit")) {
                System.out.println(getHint("swimsuit"));
            } else if (noun.equals("tickets")) {
                System.out.println(getHint("tickets"));
            } else if (noun.equals("food")) {
                System.out.println(getHint("food"));
            } else if (noun.equals("pen")) {
                System.out.println(getHint("pen"));
            } else if (noun.equals("book")) {
                System.out.println(getHint("book"));

            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("water")) {
                addToBag("water");
            } else if (noun.equals("swimsuit")) {
                addToBag("swimsuit");
            } else if (noun.equals("tickets")) {
                addToBag("tickets");
            } else if (noun.equals("food")) {
                addToBag("food");
            } else if (noun.equals("pen")) {
                addToBag("pen");
            } else if (noun.equals("book")) {
                addToBag("book");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        } else if (action.equals("use")) {
            useItem(noun);
        }
        return "undefined";
    }

    String block5(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "n/a";
        }
        return "undefined";
    }

    String block6(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "mountain";
        } else if (action.equals("examine")) {

            if (noun.equals("all")) {

                System.out.println("1. tickets");
                System.out.println("2. water");
                System.out.println("3. leaves");
                System.out.println("4. elixir");

            } else if (noun.equals("tickets")) {
                System.out.println(getHint("tickets"));
            } else if (noun.equals("water")) {
                System.out.println(getHint("water"));
            } else if (noun.equals("leaves")) {
                System.out.println(getHint("leaves"));
            } else if (noun.equals("elixir")) {
                System.out.println(getHint("elixir"));
            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("tickets")) {
                addToBag("tickets");
            } else if (noun.equals("water")) {
                addToBag("water");
            } else if (noun.equals("leaves")) {
                addToBag("leaves");
            } else if (noun.equals("elixir")) {
                addToBag("elixir");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        } else if (action.equals("use")) {
            if (noun.equals("pen") && bagItems.contains("pen")) {
                System.out.println("only a candle business can help you at this point");
            } else {
                useItem(noun);
            }
        }
        return "field";
    }

    String block7(String action, String noun) {

        if (action.equals("check") && noun.equals("block")) {
            return "Exit Gate";
        } else if (action.equals("examine")) {
            if (noun.equals("all")) {
                System.out.println("1. gate");
                System.out.println("2. giant");

            } else if (noun.equals("gate")) {
                System.out.println("The gate is locked");
            } else if (noun.equals("giant")) {
                if (puzzleSolved) {
                    System.out.println("You already solved the puzzle");
                } else if (solvePuzzle(gameLevel)) {
                    puzzleSolved = true;
                } else {
                    System.out.println("Please try again if you know the answer or find the hints!");
                }
            } else {
                System.out.println("Item not found");
            }
        } else if (action.equals("take")) {
            System.out.println("You cannot collect an item which is not present in this room!");
            return "undefined";

        } else if (action.equals("use")) {

            if (noun.equals("key")) {
                if (!bagItems.contains("key")) {
                    System.out.println("You do not have keys yet. Collect key first");
                    return "invalid";
                } else if (puzzleSolved) {
                    System.out.println("Game Completed");
                    return "GameCompleted";
                } else {
                    System.out.println("Talk to the giant first");
                    return "invalid";
                }
            } else {
                System.out.println(noun + " cannot be used here");
            }
        } else if (action.equals("drop")) {
            removeFromBag(noun);
        }

        return "undefined";
    }

    String block8(String action, String noun) {
        if (action.equals("check") && noun.equals("block")) {
            return "airport";
        } else if (action.equals("examine")) {

            if (noun.equals("all")) {

                System.out.println("1. tickets");
                System.out.println("2. food");
                System.out.println("3. water");
                System.out.println("4. pen");

            } else if (noun.equals("tickets")) {
                System.out.println(getHint("tickets"));
            } else if (noun.equals("food")) {
                System.out.println(getHint("food"));
            } else if (noun.equals("water")) {
                System.out.println(getHint("water"));
            } else if (noun.equals("pen")) {
                System.out.println(getHint("pen"));
            } else {
                System.out.println("Item not found");
                return "Item not found";
            }
            return "ok";
        } else if (action.equals("take")) {
            if (noun.equals("tickets")) {
                addToBag("tickets");
            } else if (noun.equals("food")) {
                addToBag("food");
            } else if (noun.equals("water")) {
                addToBag("water");
            } else if (noun.equals("pen")) {
                addToBag("pen");
            } else {
                System.out.println("You cannot collect an item which is not present in this room!");
                return "undefined";
            }
        }

        else if (action.equals("drop")) {
            removeFromBag(noun);
        } else if (action.equals("use")) {
            if (noun.equals("water") && bagItems.contains("water")) {
                System.out.println("only a towel man can answer your question");
            } else {
                useItem(noun);
            }

        }
        return "undefined";
    }

    // Player's bag management functions - Adding and removing bag contents
    ArrayList<String> bagItems = new ArrayList<String>();

    ArrayList<String> addToBag(String item) {

        boolean itemPresent = bagItems.contains(item);
        int sizeOfBag = bagItems.size();
        if (itemPresent) {
            System.out.println("Sorry,Item already exist in bag");
        } else if (sizeOfBag < 5) {
            bagItems.add(item);
            System.out.println(item + " added to your bag");
        } else {
            System.out.println("Sorry, you can only add upto 5 items in bag");
        }

        return bagItems;
    }

    ArrayList<String> removeFromBag(String item) {

        boolean itemPresent = bagItems.contains(item);
        if (!itemPresent) {
            System.out.println("There is no " + item + " in bag to drop. Try again with another item.");
        } else if (itemPresent) {
            bagItems.remove(item);
            System.out.println(item + " is removed from bag");
        }

        return bagItems;
    }

    int getNextBlock(int currentBlock, String dir) {
        int nextBlock = -1;

        if (dir.equals("north")) {
            nextBlock = currentBlock - 3;
            if (nextBlock < 0)
                nextBlock = -1;
        } else if (dir.equals("east")) {
            nextBlock = currentBlock + 1;
            if (nextBlock == 3 || nextBlock == 6 || nextBlock == 9)
                nextBlock = -1;
        } else if (dir.equals("south")) {
            nextBlock = currentBlock + 3;
            if (nextBlock > 8)
                nextBlock = -1;
        } else if (dir.equals("west")) {
            nextBlock = currentBlock - 1;
            if (nextBlock == 2 || nextBlock == 5)
                nextBlock = -1;
        }

        if (nextBlock != -1) {
            if (nextBlock == 0 && block0("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 1 && block1("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 2 && block2("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 3 && block3("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 4 && block4("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 5 && block5("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 6 && block6("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 7 && block7("check", "block") != "n/a")
                return nextBlock;
            if (nextBlock == 8 && block8("check", "block") != "n/a")
                return nextBlock;
            nextBlock = -1;
        }
        return nextBlock;
    }

    String getBlockName(int id) {
        String name = "Error";
        if (id == 0) {
            name = block0("check", "block");
        } else if (id == 1) {
            name = block1("check", "block");
        } else if (id == 2) {
            name = block2("check", "block");
        } else if (id == 3) {
            name = block3("check", "block");
        } else if (id == 4) {
            name = block4("check", "block");
        } else if (id == 5) {
            name = block5("check", "block");
        } else if (id == 6) {
            name = block6("check", "block");
        } else if (id == 7) {
            name = block7("check", "block");
        } else if (id == 8) {
            name = block8("check", "block");
        }
        return name;
    }

    // function for printing items in bag - this is invoked by 'show bag' comment.
    void printBag(ArrayList<String> bag) {
        if (bag.size() == 0) {
            System.out.println("Bag is Empty!");
        } else {
            System.out.println();
            System.out.println("Items in bag");
            System.out.println("-------------");
            for (int i = 0; i < bag.size(); i++) {
                System.out.println((i + 1) + ": " + bag.get(i));
            }
        }
    }

    // function for printing Map position of player - this is invoked by 'show map'
    void printMap(int playerLocation) {
        String north = fetchLocation(playerLocation, "north");
        String west = fetchLocation(playerLocation, "west");
        String current = getBlockName(playerLocation);
        String east = fetchLocation(playerLocation, "east");
        String south = fetchLocation(playerLocation, "south");

        String firstLine = "| North: " + north + " |";
        String secondLine = "| West: " + west + " | <- | Current: " + current + " | -> | East: " + east + " |";
        String thirdLine = "| South: " + south + " |";
        int middleIndexnumber = secondLine.indexOf(":", 7);
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j < secondLine.length(); j++) {
                if ((i == 0) && (j == middleIndexnumber - 7)) {
                    System.out.print(firstLine);
                } else if ((i == 1) && (j == middleIndexnumber)) {
                    System.out.print("^");
                } else if ((i == 2) && (j == middleIndexnumber)) {
                    System.out.print("|");
                } else if ((i == 3)) {
                    System.out.print(secondLine.charAt(j));
                } else if ((i == 4) && (j == middleIndexnumber)) {
                    System.out.print("|");
                } else if ((i == 5) && (j == middleIndexnumber)) {
                    System.out.print("v");
                } else if ((i == 6) && (j == middleIndexnumber - 7)) {
                    System.out.print(thirdLine);
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    // function for fetching player's location. this function is used in printMap
    String fetchLocation(int playerLocation, String direction) {
        int result = getNextBlock(playerLocation, direction);
        String location = getBlockName(result);
        if (location.equals("Error")) {
            return "N/A";
        } else if (location.equals("ocean")) {
            return "Ocean";
        } else if (location.equals("forest")) {
            return "Forest";
        } else if (location.equals("desert")) {
            return "Desert";
        } else if (location.equals("island")) {
            return "Island";
        } else if (location.equals("home")) {
            return "Home";
        } else if (location.equals("mountain")) {
            return "Mountain";
        } else if (location.equals("airport")) {
            return "Airport";
        } else if (location.equals("Exit Gate")) {
            return "Exit Gate";
        } else {
            return "undefined";
        }

    }

    Map<String, String> itemsAndHints = new HashMap<>();

    void putHint(String key, String value) {
        itemsAndHints.put(key, value);
    }

    String getHint(String key) {
        return itemsAndHints.get(key);
    }

    void useItem(String noun) {
        boolean isPresent = bagItems.contains(noun);

        if (!isPresent) {
            System.out.println("There is no such item in bag to use. Please collect it first");
        } else {
            String hint = getHint(noun);
            System.out.println(hint);
        }

    }

    String assignGameLevel() {
        String gameDifficulty = "";
        boolean chosen = false;
        while (!chosen) {
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your game difficulty(Enter 1/2/3)");
            System.out.println("1. Easy");
            System.out.println("2. Intermediate");
            System.out.println("3. Hard");
            System.out.println("-----------------------------------------");
            gameDifficulty = in.nextLine();
            if (!gameDifficulty.equals("1") && !gameDifficulty.equals("2") && !gameDifficulty.equals("3")) {
                System.out.println("You can only choose 1 or 2 or 3. Try again");
            } else {
                chosen = true;
            }
        }
        System.out.println("Bravo! You have choosen difficulty Level " + gameDifficulty);
        return gameDifficulty;
    }

    String gameLevel;

    void start() {
        Scanner in = new Scanner(System.in);

        String action = "";
        String noun = "";
        int currentBlock = 4;
        putHint("water", "Without me you cannot enter the yellow sand world!");
        putHint("swimsuit", "Sea or ocean - I am a must!");
        putHint("tickets", "No one can see islands without me");
        putHint("food", "I am a necessity - am I ?");
        putHint("pen", "I might come to use if you are stuck!");
        putHint("book", "I am of no use if you got no pen. haha");
        putHint("woods", "I am of value only if you are a carpenter");
        putHint("animalskin", "Trade me for good value and get rich!");
        putHint("key", "Keep me safe and use me wisely if you wish to get out of this place!");
        putHint("torch", "I am a blessing if you are going to forest!");
        putHint("binocular", "Use me only if you want to see things near");
        putHint("boots", "without me you cannot climb any mountains");
        putHint("shells", "Think before you take me into bag");
        putHint("leaves", "Wish to decorate your bag? Take me");
        putHint("elixir", "you can drink it, if you want to be immortal. haha");
        putHint("fish", "ocean's biggest resource");
        putHint("pearls", "it can only help you to get rich");
        putHint("salt", "unless you are cooking, I am of no use haha");
        System.out.println(
                "==================================== \n Welcome to your CS3IOS Coursework (Java version)! \n | Game started, type 'exit' to quit. | \n==================================== \n");
        System.out.print("Enter Player's Name: ");
        String name = in.nextLine();
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Welcome to Escape Room, " + name);
        System.out.println("----------------------------------------");

        gameLevel = assignGameLevel();

        System.out.println("You may start exploring the game world! Read instructions below: ");
        System.out.println();
        System.out.println("You can move across the world using 'go south/go north/go east/go west'");
        System.out.println(
                "You can move collect items using 'take' keyword followed by items present in a world. collected items will be in your bag");
        System.out.println("You can move check items present in a world by entering 'examine all' keyword");
        System.out.println("You can view your bag by using 'show bag' keyword");
        System.out.println("You can view your position by using 'show map' keyword");
        System.out.println("Happy Playing! All the best");
        System.out.println();
        System.out.println("Start Typing below");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        while (!action.equals("exit")) {
            String[] words = in.nextLine().split(" ");
            // action = in.next();
            action = words[0];
            if (words.length > 1)
                noun = words[1];
            if (!action.equals("go") && !action.equals("examine") && !action.equals("take") && !action.equals("drop")
                    && !action.equals("use") && !action.equals("exit") && !action.equals("show")
                    && !action.equals("check") && !action.equals("help")) {
                System.out.println("Invalid command, please use go|examine|take|drop|use|show|check|exit");
            } else if (words.length > 2) {
                System.out.println("Invalid command, please use \"action noun\"");
            } else {
                if (action.equals("exit")) {
                    System.out.println("You have quit the game successfully");
                    System.exit(0);
                }

                if (action.equals("help")) {
                    System.out.println(" You may start exploring the game world! Read instructions below: ");
                    System.out.println();
                    System.out.println("You can move across the world using 'go south/go north/go east/go west'");
                    System.out.println(
                            "You can move collect items using 'take' keyword followed by items present in a world. collected items will be in your bag");
                    System.out.println("You can move check items present in a world by entering 'examine all' keyword");
                    System.out.println("You can view your bag by using 'show bag' keyword");
                    System.out.println("You can view your position by using 'show map' keyword");
                }

                if (action.equals("go")) {
                    // check whether the destination is a valid move
                    int n;
                    if (noun.equals("north") || noun.equals("east") || noun.equals("south") || noun.equals("west")) {
                        n = getNextBlock(currentBlock, noun);
                        if (n != -1) {

                            if (currentBlock == 4 && noun.equals("north")) {
                                if (bagItems.contains("swimsuit")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter ocean without suit");
                                }
                            }

                            else if (currentBlock == 4 && noun.equals("west")) {
                                if (bagItems.contains("tickets")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter island without documents");
                                }
                            }

                            else if (currentBlock == 3 && noun.equals("north")) {
                                if (bagItems.contains("torch")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter forest without lighting");
                                }
                            }

                            else if (currentBlock == 3 && noun.equals("south")) {
                                if (bagItems.contains("boots")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter mountains without shoes");
                                }
                            }

                            else if (currentBlock == 6 && noun.equals("north")) {
                                if (bagItems.contains("tickets")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter island without documents");
                                }
                            }

                            else if (currentBlock == 0 && noun.equals("south")) {
                                if (bagItems.contains("tickets")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter island without documents");
                                }
                            }

                            else if (currentBlock == 0 && noun.equals("east")) {
                                if (bagItems.contains("swimsuit")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter ocean without suit");
                                }
                            }

                            else if (currentBlock == 1 && noun.equals("east")) {
                                if (bagItems.contains("water")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter desert without thirst-buster!");
                                }
                            }

                            else if (currentBlock == 1 && noun.equals("west")) {
                                if (bagItems.contains("torch")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter forest without lighting");
                                }
                            }

                            else if (currentBlock == 2 && noun.equals("west")) {
                                if (bagItems.contains("swimsuit")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter ocean without suit");
                                }
                            }

                            else if (currentBlock == 7 && noun.equals("west")) {
                                if (bagItems.contains("boots")) {
                                    currentBlock = n;
                                    System.out.println("Player moves to " + getBlockName(currentBlock));
                                    printMap(currentBlock);
                                } else {
                                    System.out.println("Cannot enter mountain without shoes");
                                }
                            }

                            else {
                                currentBlock = n;
                                System.out.println("Player moves to " + getBlockName(currentBlock));
                                printMap(currentBlock);
                            }

                        } else {
                            System.out.println("You can't move to there");
                        }
                    } else {
                        System.out.println("Invalid direction, please use north|east|south|west");
                    }

                } else if (action.equals("show")) {
                    // action = show, noun is stored in the variable "noun", which should be map
                    if (noun.equals("map")) {
                        printMap(currentBlock);
                    } else if (noun.equals("bag")) {
                        printBag(bagItems);
                    } else {
                        System.out.println("Invalid noun, please use \"show map\" or \"show bag\"");
                    }
                } else if (action.equals("check")) {
                    // action = check, noun is stored in the variable "noun", which should be
                    // "block"
                    if (noun.equals("block")) {
                        System.out.println(getBlockName(currentBlock));
                    } else {
                        System.out.println("Invalid noun, please use \"check block\"");
                    }
                } else {
                    // Let the current block handle the command first
                    // The result of a given action will be stored in "result"
                    String result = "";
                    if (currentBlock == 0) {
                        result = block0(action, noun);
                    } else if (currentBlock == 1) {
                        result = block1(action, noun);
                    } else if (currentBlock == 2) {
                        result = block2(action, noun);
                    } else if (currentBlock == 3) {
                        result = block3(action, noun);
                    } else if (currentBlock == 4) {
                        result = block4(action, noun);
                    } else if (currentBlock == 5) {
                        result = block5(action, noun);
                    } else if (currentBlock == 6) {
                        result = block6(action, noun);
                    } else if (currentBlock == 7) {
                        result = block7(action, noun);
                    } else if (currentBlock == 8) {
                        result = block8(action, noun);
                    }
                    // Handle the result
                    //
                    if (action.equals("use") && noun.equals("key") && result.equals("GameCompleted")) {
                        System.out.println("Congratulation! You have finished this game!");
                        break;
                    }

                }
            }
        } // end while
    }

    public static void main(String[] args) {
        MainGame m = new MainGame();
        m.start();

    }
}
