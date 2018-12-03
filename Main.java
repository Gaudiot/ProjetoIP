package petsPackage;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String insertedName;
		String insertedType;
		
		boolean b = false;
		
		System.out.println("Digite um nome para este pet, com a primeira letra ma�uscula "
				+ "e o restante contendo apenas letras min�sculas, n�meros ou espa�os:");
		do {
			if(b) {
				System.out.println("Digite um nome v�lido como instru�do acima!");
			}
			insertedName = in.nextLine();
			b = true;
		}while(!insertedName.matches("[A-Z][a-z[ \t][0-9]]*"));
		
		b = false;
		System.out.println("Digite qual tipo voc� deseja que seu pet seja: Fairy, Elf, Platypus, Dragon, Ogre, Wolf(Digite exatamente como est� escrito):");
		do {
			if(b) {
				System.out.println("Verifique novamente os tipos dispon�veis.");
			}
			insertedType = in.nextLine();
			b = true;
		}while(insertedType.equals("Fairy") || insertedType.equals("Elf") || insertedType.equals("Platypus") || insertedType.equals("Dragon") || insertedType.equals("Ogre") || insertedType.equals("Wolf"));
	}
}
