package Classes;

public class Block extends  Entity{

    public enum Validity {
        Passable,
        Condtional,
        Impassable;
    }
    private String tileChar;

    private Validity valid;

    Block()
    {

    }
    Block(String name, String tileChar, String valid)
    {
        setName(name);
        setTileChar(tileChar);
        switch(valid) {
            case "Passable":
                this.valid = Validity.Passable;
                break;
            case "Condtional":
                this.valid = Validity.Condtional;
                break;
            case "Impassable":
                this.valid = Validity.Impassable;
            default:
                this.valid = Validity.Impassable;
        }

    }

//    public Validity getValidtyEnum()
//    {
//        return Validity;
//    }

    public void setValidity(Validity x)
    {
        valid = x ;
    }

    public Validity getValid()
    {
        return valid;
    }

    public void setTileChar(String tileChar)
    {
        this.tileChar = tileChar;
    }

    public String getTileChar()
    {
        return tileChar;
    }


}
