package Classes;

abstract class Entity {

    int[] position = new int[2];
    private String name;

    public void setPosition(int x, int y)
    {
        position[0] = x;
        position[1] = y;
    }
    public int[] getPosition()
    {
       return position;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
       return name;
    }
}
