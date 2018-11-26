package petsErrors;

public class PetNotFound extends Exception{
	
	public PetNotFound() {
		super("This pet wasn't found");
	}
}
