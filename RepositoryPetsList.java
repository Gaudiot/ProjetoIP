package petsPackage;

import petsErrors.*;

public class RepositoryPetsList implements RepositoryPets{
	private Pets pets;
	private RepositoryPetsList next;
	
	public RepositoryPetsList() {
		this.pets = null;
		this.next = null;
	}

	public void insert(Pets pet){
		if(this.next == null) {
			this.pets = pet;
			this.next = new RepositoryPetsList();
		}else {
			this.next.insert(pet);
		}
	}

	public void update(Pets pet) throws PetNotFound, PetTypeNotFound {
		if(this.pets.getOwner().equals(pet.getOwner()) && this.pets.getName().equals(pet.getName())) {
			this.pets = pet;
		}else {
			this.next.update(owner, name);
		}
	}

	public void remove(String owner, String name){
		if(this.pets.getOwner().equals(owner) && this.pets.getName().equals(name)) {
			this.pets = this.next.pets;
			this.next = this.next.next;
		}else {
			this.next.remove(owner, name);
		}
	}

	public Pets find(String owner, String name){
		if(this.pets.getOwner().equals(owner) && this.pets.getName().equals(name)) {
			return this.pets;
		}else {
			this.next.find(owner, name);
		}
	}

	public boolean exists(String owner, String name){
		if(this.next != null) {
			if(this.pets.getOwner().equals(owner) && this.pets.getName().equals(name)) {
				return true;
			}else {
				this.next.exists(owner, name);
			}
		}
		return false;
	}

}
