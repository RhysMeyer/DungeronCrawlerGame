package Classes;

import java.util.ArrayList;

public class Room {

    Block[][] roomMap = new Block[11][11];
    ArrayList<Block> validBlocks = new ArrayList<>();
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
        for (int i = 0; i < roomMap.length; i++)
        {
            for (int j = 0; j < roomMap[i].length; j++)
            {
                if(i==0 || i == 10 || j == 0 || j==10)
                {
                    roomMap[j][i] = validBlocks.get(0);
                    for (int[] d: doorLocations) {
                        if (d[0] == j && d[1] == i)
                        {
                            roomMap[j][i] = validBlocks.get(1);
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
                    roomMap[i][j] = blockToAdd;
                }
            }
        }
    }

    public String getDisplayRoom()
    {
        StringBuilder roomDisplay = new StringBuilder();
        //String roomDisplay = "";
        for (int i = 0; i < roomMap.length; i++)
        {
            for (int j = 0; j < roomMap[i].length; j++)
            {
                if(getCurrentPlayer().getPosition()[0] == j && getCurrentPlayer().getPosition()[1] == i)
                {
                    //roomDisplay = roomDisplay + "P";
                    roomDisplay.append("P");
                }
                else {
                    roomDisplay = roomDisplay.append(roomMap[j][i].getTileChar());
                }
                if(i <= 10)
                {
                    roomDisplay.append(" ");
                }
            }
            roomDisplay = roomDisplay.append("\n");
        }
        return roomDisplay.toString();
    }

    public boolean validSpace(int xChange, int yChange)
    {
        int[] currentPosition =getCurrentPlayer().getPosition();
        System.out.println((roomMap[currentPosition[0]+xChange][currentPosition[1]+yChange]).getName());
        boolean isValid = roomMap[currentPosition[0]+xChange][currentPosition[1]+yChange].getValid().equals(Block.Validity.passable);
        return isValid;
    }
}
