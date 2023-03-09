package ex14Lab.edu.ucalgary.oop;

public class CharacterRogue extends GameCharacter {
    private String weapon = "knife";

    /* Constructor */
    public CharacterRogue(String characterName, int attackPriority) throws IllegalArgumentException{
        super(characterName, "rogue", attackPriority, 10);
    }

    @Override
    public String getAttackMessage() {
        String returnMsg = this.getCharacterName() + " attacks with their " + this.getWeapon() + ".";
        return returnMsg;
    }

    @Override
    public String talk(String message) {
        String talk = "....(" + message + ")....";
        return talk;
    }

    public String getWeapon() {
        return this.weapon;
    }
}
