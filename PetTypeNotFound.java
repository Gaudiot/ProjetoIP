package petsErrors;

public class PetTypeNotFound extends Exception{
	
	public PetTypeNotFound() {
		super("Pet type not found. \nFor Heal try: \n-Fairy \n-Elf \n-Platypus \n For damage try: \n-Dragon \n-Ogre \n-Wolf");
	}
}
