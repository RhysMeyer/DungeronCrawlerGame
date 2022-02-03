package Classes;

abstract class Entity {

    int[] position = new int[2];

    public void setPosition(int x, int y)
    {
        position[0] = x;
        position[1] = y;
    }
    public int[] getPosition()
    {
       return position;
    }

}
