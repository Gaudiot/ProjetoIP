package petsPackage;

import petsErrors.*;

public class SignupPets {
	private RepositoryPets pets;

    public SignupPets(boolean type) {

        if (type) {
            this.pets = new RepositoryPetsList();
        } else {
            this.pets = new RepositoryPetsArray();
        }
    }

    public void insert(Pets pet)
            throws PetAlreadyExists, PetTypeNotFound {
        //checa o tipo
		if(pet.getType().equals("Fairy") || pet.getType().equals("Elf") || pet.getType().equals("Platypus") || 
				pet.getType().equals("Dragon") || pet.getType().equals("Ogre") || pet.getType().equals("Wolf")) {
			//checa se ja existe
			if(!exists(pet.getOwner(), pet.getName())) {
				this.pets.insert(pet);
			}else {
				PetAlreadyExists error = new PetAlreadyExists();
				throw error;
			}
		}else {
			PetTypeNotFound error = new PetTypeNotFound();
			throw error;
		}
    }

    public void remove(String owner, String name)
            throws PetNotFound {
        if(exists(owner, name)) {
			this.pets.remove(owner, name);
		}else {
			PetNotFound error = new PetNotFound();
			throw error;
		}
    }

    public Pets find(String owner, String name)
            throws PetNotFound {
        if(this.pets.exists(owner, name)) {
			if(this.pets.getOwner().equals(owner) && this.pets.getName().equals(name)) {
				return this.pets.find(owner, name);
			}
		}else {
			PetNotFound error = new PetNotFound();
			throw error;
		}
    }

    public void update(Pets pet)
            throws PetNotFound, PetTypeNotFound {
        this.pets.update(pet);
    }

    public boolean exists(String owner, String name) {
        return this.pets.exists(owner, name);
    }
}
