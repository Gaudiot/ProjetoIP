package petsPackage;

import petsErrors.*;

public class RepositoryPetsArray implements RepositoryPets{
	private Pets[] pets;
	private int indice;
	
	public RepositoryPetsArray() {
		this.pets = new Pets[100];
		this.indice = 0;
	}

	public void insert(Pets pet){
		if(this.indice >= pets.length()){
			private Pets[] temp = new Pets[pets.length() + 100];
			for(int i = 0 ; i < pets.length() ; i++){
				temp[i] = pets[i];
			}

			this.pets = temp;
		}
		this.pets[indice] = pet;
		this.indice++;
	}

	public void update(Pets pet) throws PetNotFound, PetTypeNotFound {
		int i = getIndice(pet.getOwner(), pet.getName());
		this.pets[i] = pet;
	}

	public void remove(String owner, String name){
		int i = getIndice(owner, name);
		for(int f = i ; f < indice - 1 ; f++) {
			this.pets[f] = this.pets[f+1];
		}
		this.pets[indice - 1] = null;
		this.indice--;
	}

	public Pets find(String owner, String name){
		Pets pet = null;
		boolean found = false;
		
		for(int f = 0 ; f < indice && !found; f++) {
			if(pets[f].getOwner().equals(owner) && pets[f].getName().equals(name)) {
				pet = this.pets[f];
				found = true;
			}
		}
		return pet;
	}

	public boolean exists(String owner, String name) {
		for(int f = 0 ; f < indice ; f++) {
			if(this.pets[f].getOwner().equals(owner) && this.pets[f].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	private int getIndice(String owner, String name) {
		for(int f = 0 ; f < indice ; f++) {
			if(this.pets[f].getOwner().equals(owner) && this.pets[f].getName().equals(name)) {
				return f;
			}
		}
		return 0;
	}
}
