package Controller;

public enum PassableBlocks {  //Renvoie en char les blocks passable
    o('o'),X('X'),E('E'),SPACE(' '),T('T'), t('t'),L('L'),B('<');

    public char asChar() {
        return asChar;
    }
    private final char asChar;

    PassableBlocks(char asChar){
        this.asChar = asChar;
    }

}
