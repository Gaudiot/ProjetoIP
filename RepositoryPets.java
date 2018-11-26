package petsPackage;

import petsErrors.*;

public interface RepositoryPets {

	public void insert(Pets pet)
		throws PetTypeNotFound, PetAlreadyExists;
	            
	public void update(Pets pet) 
		throws PetNotFound, PetTypeNotFound;          

	public void remove(String owner, String name) 
	    throws PetNotFound;
	           

	public Pets find(String owner, String name) 
	    	throws PetNotFound;
	            
	    
	public boolean exists(String owner, String name);
}
