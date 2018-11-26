package petsPackage;

import petsErrors.*;

public class RepositoryPetsArray implements RepositoryPets{
	private Pets[] pets;
	private int indice;
	
	public RepositoryPetsArray() {
		this.indice = 0;
	}

	public void insert(Pets pet) throws PetTypeNotFound, PetAlreadyExists {
		//checa o tipo
		if(pet.getType().equals("Fairy") || pet.getType().equals("Elf") || pet.getType().equals("Platypus") || 
				pet.getType().equals("Dragon") || pet.getType().equals("Ogre") || pet.getType().equals("Wolf")) {
			//checa se ja existe
			if(!exists(pet.getOwner(), pet.getName())) {
				this.pets[indice] = pet;
				this.indice++;
			}else {
				PetAlreadyExists error = new PetAlreadyExists();
				throw error;
			}
		}else {
			PetTypeNotFound error = new PetTypeNotFound();
			throw error;
		}
	}

	public void update(Pets pet) throws PetNotFound, PetTypeNotFound {
		//checa o tipo
		if(pet.getType().equals("Fairy") || pet.getType().equals("Elf") || pet.getType().equals("Platypus") || 
				pet.getType().equals("Dragon") || pet.getType().equals("Ogre") || pet.getType().equals("Wolf")) {
			//checa se ja existe
			if(exists(pet.getOwner(), pet.getName())) {
				int i = getIndice(pet.getOwner(), pet.getName());
				this.pets[i] = pet;
			}else {
				PetNotFound error = new PetNotFound();
				throw error;
			}
		}else {
			PetTypeNotFound error = new PetTypeNotFound();
			throw error;
		}
	}

	public void remove(String owner, String name) throws PetNotFound {
		if(exists(owner, name)) {
			int i = getIndice(owner, name);
			for(int f = i ; f < indice - 1 ; f++) {
				this.pets[f] = this.pets[f+1];
			}
			
			this.pets[indice - 1] = null;
			this.indice--;
		}else {
			PetNotFound error = new PetNotFound();
			throw error;
		}
	}

	public Pets find(String owner, String name) throws PetNotFound {
		Pets pet = null;
		boolean found = false;
		
		for(int f = 0 ; f < indice && !found; f++) {
			if(pets[f].getOwner().equals(owner) && pets[f].getName().equals(name)) {
				pet = this.pets[f];
				found = true;
			}
		}
		
		if(pet == null){
			PetNotFound error = new PetNotFound();
			throw error;
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
