package Classes;

public class Block extends  Entity{

    public enum Validity {
        passable,
        impassable;
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
                this.valid = Validity.passable;
                break;
            default:
                this.valid = Validity.impassable;
                break;
        }

    }


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
