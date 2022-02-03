package Classes;

import java.util.ArrayList;

public class Room {

    Block[][] room = new Block[11][11];
    ArrayList<Block> validBlocks = new ArrayList<Block>();
    String defaultBlockName;
    Block blockToAdd = new Block();
    Player currentPlayer = new Player();
    int[][] doorLocations = new int[][] {{0,5}, {5,0}, {10,5},{5,10}};

    Room()
    {

    }

    Room(String defaultBlockName)
    {
        this.defaultBlockName = defaultBlockName;
    }

    private void setCurrentPlayer(Player player)
    {
        currentPlayer = player;
    }
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }


    private void addDefaultBlocks()
    {
        Block border = new Block ("Border", "■", "Impassable");
        Block door = new Block ("Door", " ", "Passable");
        validBlocks.add(border);
        validBlocks.add(door);
    }

    public void addValidBlock(Block block)
    {
        if(validBlocks.isEmpty()) addDefaultBlocks();
        if(!validBlocks.contains(block))
        {
            validBlocks.add(block);
        }
    }

    public void createRoom()
    {
        for (int i = 0; i < room.length; i++)
        {
            for (int j =0; j < room[i].length; j++)
            {
                if(i==0 || i == 10 || j == 0 || j==10)
                {
                    room[j][i] = validBlocks.get(0);
                    for (int[] d: doorLocations) {
                        if (d[0] == j && d[1] == i)
                        {
                            room[j][i] = validBlocks.get(1);
                        }
                    }
                }
                else
                {
                    for (Block b: validBlocks) {
                        if(b.getName().equals(defaultBlockName)){
                            blockToAdd = b;
                        }
                    }
                    room[i][j] = blockToAdd;
                }
            }
        }
    }

    public String getDisplayRoom()
    {
        String roomDisplay = "";
        for (int i = 0; i < room.length; i++)
        {
            for (int j =0; j < room[i].length; j++)
            {
                if(getCurrentPlayer().getPosition()[0] == j && getCurrentPlayer().getPosition()[1] == i)
                {
                    roomDisplay = roomDisplay + "P";
                }
                else {
                    roomDisplay = roomDisplay + room[j][i].getTileChar();
                }
                if(i <= 10)
                {
                    roomDisplay = roomDisplay + " ";
                }
            }
            roomDisplay = roomDisplay + "\n";
        }
        return roomDisplay;
    }

    public boolean validSpace(int xChange, int yChange)
    {
        int[] currentPosition =getCurrentPlayer().getPosition();
        System.out.println((room[currentPosition[0]+xChange][currentPosition[1]+yChange]).getName());
        boolean isValid = room[currentPosition[0]+xChange][currentPosition[1]+yChange].getValid().equals(Block.Validity.Passable);
        return isValid;
    }
}
