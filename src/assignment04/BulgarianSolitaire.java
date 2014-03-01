package assignment04;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BulgarianSolitaire {
    private ArrayList<Integer> piles = new ArrayList<Integer>();
    private Random rand = new Random();
    
    public void initPiles() {
        int totalUsed = 0;
        while(totalUsed < 45) {
            int cards = 1 + rand.nextInt(45 - totalUsed);
            piles.add(cards);
            totalUsed += cards;
        }
        System.out.println(piles);
    }

    public void play() {
// HERE IS WHERE YOU HAVE TO IMPLEMENT THE STEP DESCRIBED IN THE GAME.
// NOTE THAT YOU MUST REMOVE ANY PILES THAT BECOME EMPTY.
// THERE IS A TRICK TO THIS AND YOU SHOULD READ THE DISCUSSION IN THE 
// section7_7_7.pdf LINK ABOVE, WHICH COMES FROM THE 5th EDITION.
    	
    	if (!(piles.contains(1) && piles.contains(2) && piles.contains(3) && piles.contains(4) && piles.contains(5) 
    			&& piles.contains(6) && piles.contains(7) && piles.contains(8) && piles.contains(9))) {
//add an element whose value equals to the size of the arraylist
    		piles.add(piles.size()+1);
//the value of each element minus 1
    		for (int j = 0; j < piles.size(); j++) {
    			piles.set (j, piles.get(j)-1);
    		}
//delete elements whose value is 0
    		int i = 0;
    		while (i < piles.size()) {
    			int pile = piles.get(i);
    			if (pile == 0) piles.remove(i);
    			else i++;
    		}
    	}
        System.out.println(piles);
    }

    public static void main(String[] args) {
        BulgarianSolitaire game = new BulgarianSolitaire();
        game.initPiles();
        Scanner keyboard = new Scanner(System.in);
        boolean playOn = true;
        do {
            System.out.println("Do you want to go on [Y/y]? (another char exits)");
            String line = keyboard.nextLine();
            if(line.length() == 0 || (line.length() == 1 && line.toUpperCase().charAt(0) == 'Y')) {
                game.play();
            } else {
                playOn = false;
            }
        } while (playOn);
        keyboard.close();
    }

}
