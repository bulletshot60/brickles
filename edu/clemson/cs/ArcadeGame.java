package edu.clemson.cs;
public abstract class ArcadeGame extends Object {
    protected ArcadeGameMatch _match;
    protected String _name;

    public ArcadeGame(String name) {
        _name = name;
    }

    public ArcadeGameMatch getMatch() {
        return _match;
    }

    public String getName() {
    	return _name;
    }
    
    public abstract PlayingField newPlayingField(ArcadeGameMatch aGame);

    public abstract void lost();
};
