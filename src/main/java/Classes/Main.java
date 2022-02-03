package Classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {//■
        boolean playing = true;
        Room testRoom = new Room("Stone");
        Room currentRoom = testRoom;
        Block stone = new Block("Stone", "□", "Passable");
        testRoom.addValidBlock(stone);
        currentRoom.createRoom();
        currentRoom.getCurrentPlayer().setPosition(5, 5);
        String input;
        Scanner userInput = new Scanner(System.in);
        int[] playerMovement = new int[2];

        do {
            System.out.println(testRoom.getDisplayRoom());
            input = userInput.nextLine();
            switch (input) {
                case "up":
                    playerMovement[0] = 0;
                    playerMovement[1] = -1;
                    break;
                case "down":
                    playerMovement[0] = 0;
                    playerMovement[1] = 1;
                    break;
                case "right":
                    playerMovement[0] = 1;
                    playerMovement[1] = 0;
                    break;
                case "left":
                    playerMovement[0] = -1;
                    playerMovement[1] = 0;
                    break;
                default:
                    System.out.println("Invalid input");

            }
            if(currentRoom.validSpace(playerMovement[0],playerMovement[1])) {
                currentRoom.getCurrentPlayer().move(playerMovement[0], playerMovement[1]);
            }
            else
            {
                System.out.println("Thats not a valid space to move onto!");
            }


        } while (playing);


    }
}
