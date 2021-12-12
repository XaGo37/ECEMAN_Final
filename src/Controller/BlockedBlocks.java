package Controller;


public enum BlockedBlocks {  //Renvoie en char les blocks non passable
    M('M'),X('X'),W('W');

    public char asChar() {
        return asChar;
    }
    private final char asChar;

    BlockedBlocks(char asChar){
        this.asChar = asChar;
    }
}
