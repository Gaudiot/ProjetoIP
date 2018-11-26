package petsPackage;

import petsErrors.PetNotFound;
import petsErrors.PetTypeNotFound;

public class Pets {
	// Atributos da classe
		private String owner;
		private String name;
		private String type;
		private String hability;
		private double habilityPoints;

		//Construtor do objeto
		public Pets(String owner, String name, String type, int level) throws PetNotFound{
			this.owner = owner;
			this.name = name;
			this.type = type;
			this.hability = setHability(type);
			this.habilityPoints = level;
		}
		
		public String getOwner() {
			return this.owner;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return this.type;
		}

		public void setType(String type) throws PetTypeNotFound{
			if(type.equals("Fairy") || type.equals("Elf") || type.equals("Platypus") || type.equals("Dragon") || type.equals("Ogre") || type.equals("Wolf")) {
				this.type = type;
				this.hability = setHability(type);
			}else {
				PetTypeNotFound error = new PetTypeNotFound();
				throw error;
			}
		}

		public String getHability() {
			return this.hability;
		}

		private String setHability(String type){
			if(type.equals("Fairy") || type.equals("Elf") || type.equals("Platypus")) {
				return "Heal";
			}else if(type.equals("Dragon") || type.equals("Ogre") || type.equals("Wolf")) {
				return "Damage";
			}
			return "";
		}

		public double getHabilityPoints() {
			return this.habilityPoints;
		}

		public void setHabilityPoints(double points) {
			this.habilityPoints = points;
		}
}
