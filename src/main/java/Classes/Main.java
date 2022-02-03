package Classes;

public class Main {

    public static void main(String[] args)
    {//■
        Room testRoom = new Room("Stone");
        Block stone = new Block("Stone", "▢" , "Passable");
        testRoom.addValidBlock(stone);
        testRoom.CreateRoom();
        System.out.println(testRoom.getDisplayRoom());


    }
}
