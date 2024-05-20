package org.generation.italy;

//import
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class Bingo {

	// inizio main
	public static void main(String[] args) {
		HashSet<Integer> numeriEstratti = new HashSet<Integer>();
		HashSet<Integer> numeriCart1 = new HashSet<Integer>();
		HashSet<Integer> numeriCart2 = new HashSet<Integer>();
		HashSet<Integer> numeriCart3 = new HashSet<Integer>();
		ArrayList<Integer> numeriTab = new ArrayList<Integer>();
		ArrayList<Integer> cart = new ArrayList<Integer>();
		ArrayList<Integer> numeriPoss1 = new ArrayList<Integer>();
		ArrayList<Integer> numeriPoss2 = new ArrayList<Integer>();
		ArrayList<Integer> numeriPoss3 = new ArrayList<Integer>();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int conR1 = 0, conR2 = 0, conR3 = 0, randomNum;
		boolean cinquina = false;
		// benvenuto
		System.out.println("Benvenuto al Bingo!");
		// creazione tabellone
		for (int i = 0; i < 91; i++) {
			numeriTab.add(i);
			if (numeriTab.contains(0)) {
				numeriTab.remove(0);
			}
		}
		// cereazione cartella

		// riga 1
		for (int i = 0; i < 5; i++) {
			numeriCart1.add(r.nextInt(91));
			do {
				if (numeriCart1.contains(0)) {
					numeriCart1.remove(0);
					numeriCart1.add(r.nextInt(91));
				}
			} while (numeriCart1.contains(0));
		}

		// riga 2
		do {
			for (int i = 0; i < 5; i++) {
				numeriCart2.add(r.nextInt(91));
				do {
					if (numeriCart2.contains(0)) {
						numeriCart2.remove(0);
						numeriCart2.add(r.nextInt(91));
					}
					if (numeriCart2.containsAll(numeriCart1)) {
						numeriCart2.removeAll(numeriCart1);
						numeriCart2.add(r.nextInt(91));
					}
				} while (numeriCart2.contains(0) || numeriCart2.containsAll(numeriCart1));
			}
		} while (numeriCart2.size() < 5 || numeriCart2.size() > 5);

		// riga 3
		do {
			for (int i = 0; i < 5; i++) {
				numeriCart3.add(r.nextInt(91));
				do {
					if (numeriCart3.contains(0)) {
						numeriCart3.remove(0);
						numeriCart3.add(r.nextInt(91));
					}
					if (numeriCart3.containsAll(numeriCart1)) {
						numeriCart3.removeAll(numeriCart1);
						numeriCart3.add(r.nextInt(91));
					}
					if (numeriCart3.containsAll(numeriCart2)) {
						numeriCart3.removeAll(numeriCart2);
						numeriCart3.add(r.nextInt(91));
					}
				} while (numeriCart3.contains(0) || numeriCart3.containsAll(numeriCart1)
						|| numeriCart3.containsAll(numeriCart1));
			}
		} while (numeriCart3.size() < 5 || numeriCart3.size() > 5);
		System.out.println("la prima riga della tua cartella ha questi numeri: " + numeriCart1);
		System.out.println("la seconda riga della tua cartella ha questi numeri: " + numeriCart2);
		System.out.println("la terza riga della tua cartella ha questi numeri: " + numeriCart3);
		// fine creazione cartella

		// estrazione numeri
		System.out.println("E' il momento di estrarre i numeri...");
		for (int i = 0; i < numeriTab.size(); i++) {
			do {
				randomNum = r.nextInt(91);
				if (randomNum == 0)
					randomNum = r.nextInt(91);
			} while (numeriEstratti.contains(randomNum));
			numeriEstratti.add(randomNum);
			System.out.println("il " + (i + 1) + "° numero uscito è " + randomNum);
			if (numeriCart1.contains(randomNum)) {
				numeriPoss1.add(randomNum);
			}
			if (numeriPoss1.containsAll(numeriCart1))
				conR1 = 5;

			if (numeriCart2.contains(randomNum)) {
				numeriPoss2.add(randomNum);
			}
			if (numeriPoss2.containsAll(numeriCart2))
				conR2 = 5;

			if (numeriCart3.contains(randomNum)) {
				numeriPoss3.add(randomNum);
			}
			if (numeriPoss3.containsAll(numeriCart3))
				conR3 = 5;

			System.out.println("la prima riga della tua cartella ha questi numeri: " + numeriCart1);
			System.out.println("la seconda riga della tua cartella ha questi numeri: " + numeriCart2);
			System.out.println("la terza riga della tua cartella ha questi numeri: " + numeriCart3);
			System.out.println("i numeri che possiedi sulla riga 1 sono " + numeriPoss1);
			System.out.println("i numeri che possiedi sulla riga 2 sono " + numeriPoss2);
			System.out.println("i numeri che possiedi sulla riga 3 sono " + numeriPoss3);
			if (cinquina == false && conR3 == 5) {
				System.out.println("hai fatto cinquina alla riga 3 ");
				cinquina = true;
			}
			if (cinquina == false && conR2 == 5) {
				System.out.println("hai fatto cinquina alla riga 2 ");
				cinquina = true;
			}
			if (cinquina == false && conR1 == 5) {
				System.out.println("hai fatto cinquina alla riga 1 ");
				cinquina = true;
			}
			System.out.println("premi invio per estrarre il numero successivo");
			if (conR1 == 5 && conR2 == 5 && conR3 == 5) {
				System.out.println("Hai fattto BINGO!");
				break;
			}
			sc.nextLine();
		}

	}// fine main

}
