/*
PROJECT GROUP #17 - Sec05
Porter Clevidence - 029238207
Lucas Gonzalez - 
Andrew Dante - 026050685
4/22/22
description: A program that has the user explore a dungeon maze and fight monsters
*/
public class Main {
    public static void main(String[] agrs){
        System.out.print("What is your name, traveler? ");  //user gives the name of the hero
        Hero player = new Hero(CheckInput.getString());
        PlayableMap map = PlayableMap.getInstance();

        boolean valid = true;
        int input;
 
        while(valid){   //Move Character
            System.out.println(player.toString());
            System.out.println(map.maptoString(player.getLocation()));
            input = mainMenu(player);
            System.out.println();
            if(input == 1){     //Go North
                char newSpot = player.goNorth();
                if(newSpot == 'x'){
                    System.out.println("Out of Bounds");
                    player.goSouth();       //Oppisite Direction
                }else if(newSpot == 'n'){   //Nothing
                    map.removeCharAtLoc(player.getLocation());
                    System.out.println("There was nothing here");
                }else if(newSpot == 's'){   //Store
                    store(player);
                }else if(newSpot == 'f'){   //Gate
                    System.out.print("You find a locked gate. ");
                    if(player.hasKey() == true){  //if character has the key, they can proceed
                        System.out.println("Luckily, you have a key! You proceed to the next area");
                        if(player.getLevel() < 3){  
                            player.levelUp();
                            map.loadMap(player.getLevel());
                        }else{  //if the player is level 3, they win the game
                            System.out.println("You've beat the game! " + player.getName());
                            valid = false;  //ends the program
                        }
                    }else{
                        System.out.print("However, it seems you haven't found the key.");  //if the player has no key, then they are denied
                    }
                    
                }else if(newSpot == 'i'){   //Item
                    if((int)Math.round(Math.random() * 1) == 0){
                        System.out.println("You found a potion!");
                        player.pickUpPotion();  //the hero gets an additional potion
                    }else{
                        System.out.println("You found a key!");
                        player.pickUpKey();  //the hero gets an additional key
                    }
                }else if(newSpot == 'm'){   //Monster
                    EnemyGenerator newEnemy = new EnemyGenerator();
                    monsterRoom(player, newEnemy.generateEnemy(player.getLevel()));//generates an an enemy
                }
        
            }else if(input == 2){  //Go South
                    char newSpot = player.goSouth();
                    if(newSpot == 'x'){
                        System.out.println("Out of Bounds");
                        player.goNorth();  //Opposite Direction to get back in bounds
                    }else if(newSpot == 'n'){
                        map.removeCharAtLoc(player.getLocation());
                        System.out.println("There was nothing here");
                    }else if(newSpot == 's'){
                        store(player);  //Store
                    }else if(newSpot == 'f'){
                        System.out.print("You find a locked gate. ");  //Go to gate to get to the next level/end the game
                        if(player.hasKey() == true){
                            System.out.println("Luckily, you have a key! You proceed to the next area");
                            if(player.getLevel() < 3){
                                player.levelUp();  //levels up the player for passing the level
                                map.loadMap(player.getLevel());
                            }else{
                                System.out.println("You've beat the game! " + player.getName());  //if the player is level 3, then he beats the game and ends the program
                                valid = false;
                            }
                        }else{
                            System.out.print("However, it seems you haven't found the key.");  //if player doesn't have the key, then he can't proceed to the next level/end the game
                        }
                    }else if(newSpot == 'i'){
                        if((int)Math.round(Math.random() * 1) == 0){  //Determines whether the user finds a potion or key
                            System.out.println("You found a potion!");
                            player.pickUpPotion();// the player finds a potion
                        }else{
                            System.out.println("You found a key!");
                            player.pickUpKey();  //the player finds a key
                        }
                    }else if(newSpot == 'm'){
                        EnemyGenerator newEnemy = new EnemyGenerator();
                        monsterRoom(player, newEnemy.generateEnemy(player.getLevel()));
                    }
            }else if(input == 3){   //Go East
                    char newSpot = player.goEast();
                    if(newSpot == 'x'){
                        System.out.println("Out of Bounds");
                        player.goWest();       //Opposite Direction to get back in bounds
                    }else if(newSpot == 'n'){
                        map.removeCharAtLoc(player.getLocation());
                        System.out.println("There was nothing here");
                    }else if(newSpot == 's'){
                        store(player);  //Store
                    }else if(newSpot == 'f'){
                        System.out.print("You find a locked gate. ");  //Go to gate to get to the next level/end the game
                        if(player.hasKey() == true){
                            System.out.println("Luckily, you have a key! You proceed to the next area");
                            if(player.getLevel() < 3){  //levels up the player for passing the level
                                player.levelUp();
                                map.loadMap(player.getLevel());
                            }else{
                                System.out.println("You've beat the game! " + player.getName());  //if the player is level 3, then he beats the game and ends the program
                                valid = false;
                            }
                        }else{
                            System.out.print("However, it seems you haven't found the key.");  //if player doesn't have the key, then he can't proceed to the next level/end the game
                        }
                    }else if(newSpot == 'i'){
                        if((int)Math.round(Math.random() * 1) == 0){  //Determines whether the user finds a potion or key
                            System.out.println("You found a potion!");
                            player.pickUpPotion();  //the player finds a potion
                        }else{
                            System.out.println("You found a key!");
                            player.pickUpKey();  //the player finds a key
                        }
                    }else if(newSpot == 'm'){
                        EnemyGenerator newEnemy = new EnemyGenerator();
                        monsterRoom(player, newEnemy.generateEnemy(player.getLevel()));
                    }
            }else if(input == 4){      //Go West
                    char newSpot = player.goWest();
                    if(newSpot == 'x'){
                        System.out.println("Out of Bounds");
                        player.goEast();       //Opposite Direction to get back in bounds
                    }else if(newSpot == 'n'){
                        map.removeCharAtLoc(player.getLocation());
                        System.out.println("There was nothing here");
                    }else if(newSpot == 's'){
                        store(player);  //Store
                    }else if(newSpot == 'f'){
                        System.out.println("You find a locked gate. ");  //Go to gate to get to the next level/end the game
                        if(player.hasKey() == true){
                            System.out.print("Luckily, you have a key! You proceed to the next area");
                            if(player.getLevel() < 3){  //levels up the player for passing the level
                                player.levelUp();
                                map.loadMap(player.getLevel());
                            }else{
                                System.out.println("You've beat the game! " + player.getName());  //if the player is level 3, then he beats the game and ends the program
                                valid = false;
                            }
                        }else{
                            System.out.print("However, it seems you haven't found the key.");  //if player doesn't have the key, then he can't proceed to the next level/end the game
                        }
                    }else if(newSpot == 'i'){
                        if((int)Math.round(Math.random() * 1) == 0){  //Determines whether the user finds a potion or key
                            System.out.println("You found a potion!");
                            player.pickUpPotion();  //the player finds a potion
                        }else{
                            System.out.println("You found a key!");
                            player.pickUpKey();  //the player finds a key
                        }
                    }else if(newSpot == 'm'){
                        EnemyGenerator newEnemy = new EnemyGenerator();
                        monsterRoom(player, newEnemy.generateEnemy(player.getLevel()));
                    }
            }else{      //Quit
                valid = false;
            }
            
        }
    }
/*
Prompts the user to go in any direction
@return The user's input deciding where to go
*/
    public static int mainMenu(Hero h){
        System.out.println("1. Go North");
        System.out.println("2. Go South");
        System.out.println("3. Go East");
        System.out.println("4. Go West");
        System.out.println("5. Quit");
        return CheckInput.getIntRange(1, 5);
    }

/* 
Displays enemy and prompts the user to fight, run , or drink a potion
@param e, the enemy generated for the encounter
@param h, player
@return true, if Hero is still alive after encounter
*/
    public static boolean monsterRoom(Hero h, Enemy e){
        System.out.println("You've encountered a " + e.getName());
        boolean valid = true;
        int input;
        while(valid){
            System.out.println(e.toString());
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            System.out.println("3. Drink Potion");
            input = CheckInput.getIntRange(1,3);

            if(input == 1){     //Fight Option
                if(fight(h, e) == true){
                    valid =  false;
                }
            }else if(input == 2){   //Run Away Option
                int randDir = (int)Math.round(Math.random() * 3);  //when running awa from an enemy, gives a random direction to run
                if(randDir == 0){
                    h.goNorth();
                    valid = false;
                }else if(randDir == 1){
                    h.goEast();
                    valid = false;
                }else if(randDir == 2){
                    h.goWest();
                    valid = false;
                }else if(randDir == 3){ 
                    h.goSouth();
                    valid = false;
                }
            }else if(input == 3){       //Drink Potion Option
                if(h.hasPotion()){
                    h.usePotion();
                }else{
                    System.out.println("Out of Potions");
                }
            }else{
                System.out.println("Not an Option");
            }

            if(h.getHp() == 0){     //if hero's hp reaches 0
                valid = false;
                return false;
            }
        }

        return true;
    }

/*
A single round of attack where the user has multiple options of attacking. If the enemy is still alive, it will attack back
@param e, the enemy generated for the encounter
@param h, player
@return true, if enemy is dead
*/
    public static boolean fight(Hero h, Enemy e){
        System.out.println(h.getAtackMenu());
        int attackChoice = CheckInput.getIntRange(1, h.getNumAttackMenuItems());
        System.out.println(h.getSubAttackMenu(attackChoice));
        int subAttackChoice = CheckInput.getIntRange(1, h.getNumSubAttackMenuItems());
        System.out.println(h.attack(e, attackChoice, subAttackChoice));
        
        if(e.getHp() > 0){      //if the enemies hp isn't 0
            System.out.println( e.attack(h));
            return false;
        }else{      //if the enemies hp is 0
            System.out.println("You have defeated the evil " + e.getName());
            h.collectGold(5 + (2 * h.getLevel()));
            return true;
        }
    }
/*
Item store where the hero can by a potion or key
*/
    public static void store(Hero h){
        System.out.println("Welcome to my store. What would you like to buy?");
        boolean valid = true;
        int input;
        while(valid){
            System.out.println("1. Health Potion - 25g");
            System.out.println("2. Key - 50g");
            System.out.println("3. Nothing, just browsing...");

            input = CheckInput.getIntRange(1, 3);
            if(input == 1){     //Potion Option
                if(h.getGold() >= 25){
                    h.pickUpPotion();
                }else{
                    System.out.println("Tt seems you don't have enough coin, come back when you're a little... mmmm... richer");
                }
            }else if(input == 2){   //Key Option
                if(h.getGold() >= 0){
                    h.pickUpKey();
                }else{
                    System.out.println("It seems you don't have enough coin, come back when you're a little... mmmm... richer");
                }
            }else{      //Exit
                valid = false;
            }
        }
    }
}
