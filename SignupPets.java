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

    public void signup(Pets pet)
            throws PetAlreadyExists, PetTypeNotFound {
        this.pets.insert(pet);
    }

    public void remove(String owner, String name)
            throws PetNotFound {
        this.pets.remove(owner, name);;
    }

    public Pets find(String owner, String name)
            throws PetNotFound {
        return this.pets.find(owner, name);
    }

    public void update(Pets pet)
            throws PetNotFound, PetTypeNotFound {
        this.pets.update(pet);
    }

    public boolean exists(String owner, String name) {
        return this.pets.exists(owner, name);
    }
}
