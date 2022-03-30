package com.example.mypackage;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initGame();
    }
    private static void initGame() {
        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String[] direction = scanner.nextLine().split(" ");

            if(direction.length == 1){
                String character = direction[0].split("")[0].toUpperCase();
                if(exits.containsKey(character)){
                    loc = exits.get(character);
                }else {
                    System.out.println("You cannot go in that direction");
                }
            } else if(direction.length == 2){
                if(direction[0].toUpperCase().equals("GO") || direction[0].toUpperCase().equals("RUN")){
                    System.out.println("Inside check GO or RUN");
                    String character = direction[1].split("")[0].toUpperCase();
                    if(exits.containsKey(character)){
                        loc = exits.get(character);
                    }else {
                        System.out.println("You cannot go in that direction");
                    }
                } else {
                    System.out.println("You cannot go in that direction");
                }
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
