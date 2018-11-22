package petPackage;

import petErrors.*;

public class Pet {
	// Atributos da classe Local;
		private String owner;
		private String name;
		private String type;
		private String hability;
		private double habilityPoints;

		//Construtor do objeto com bairro;
		public Pet(String owner, String name, String type, int level){
			this.owner = owner;
			this.name = name;
			this.type = type;
			if(type.equals("Fairy") ) {
				
			}else if(type.equals("wolf")) {
				
			}
			this.habilityPoints = level;
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

		public void setType(String type) {
			this.type = type;
		}

		public String getHability() {
			return this.hability;
		}

		private void setHability(String type) {
			
		}

		public double getHabilityPoints() {
			return this.habilityPoints;
		}

		public void setHabilityPoints(double points) {
			this.habilityPoints = points;
		}
}
