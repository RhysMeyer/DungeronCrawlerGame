package Classes;

import java.util.ArrayList;

public class Room {

    Block[][] room = new Block[11][11];
    ArrayList<Block> validBlocks = new ArrayList<Block>();
    String defaultBlockName;
    Block blockToAdd = new Block();

    Room()
    {

    }

    Room(String defaultBlockName)
    {
        this.defaultBlockName = defaultBlockName;
    }

    private void addBorder()
    {
        Block border = new Block ("Border", "■", "Impassable");
        validBlocks.add(border);
    }

    public void addValidBlock(Block block)
    {
        if(validBlocks.isEmpty()) addBorder();
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
                    room[i][j] = validBlocks.get(0);
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
                roomDisplay = roomDisplay + room[i][j].getTileChar();
            }
            roomDisplay = roomDisplay + "\n";
        }
        return roomDisplay;
    }

}
