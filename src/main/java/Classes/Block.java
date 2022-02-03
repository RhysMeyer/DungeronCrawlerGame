package Classes;

abstract class Block extends  Entity{

    private enum Validity {
        Passable,
        Condtional,
        Impassable
    }

    private Validity valid;

    public void setValidity(Validity x)
    {
        valid = x ;
    }

    public Validity getValidity()
    {
        return valid;
    }


}
