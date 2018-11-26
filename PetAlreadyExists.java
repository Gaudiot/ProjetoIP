package petsErrors;

public class PetAlreadyExists extends Exception{
	
	public PetAlreadyExists() {
		super("This pet already exists, choose another name");
	}
}
