/* 
Porter Clevidence
Version 2
*/
/*
The magical class of hero and enemy
*/
public interface Magical {
    public static final String MAGIC_MENU = "1. MagicMissile\n2. Fireball";  //the menu for magic attack interactions
    public int NUM_MAGIC_MENU_ITEMS = 2;  //the max amount of available options to choose form in the magic menu
    public String magicMissile(Entity e);  //the magic missile attack message
    public String fireball(Entity e);  //the fireball attack message
}
