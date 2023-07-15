package com.hackerrank;

import java.util.Arrays;

public class Umbrelamanoon {
	public static void main(String[] args) {
		Integer[] umr = { 1, 2, 3, 5 };
		int req = 7;

		Arrays.sort(umr, (o1, o2) -> o2.compareTo(o1));

		int umbrela = getMinUmbrela(umr, req);

		System.out.println("Min Umb:: " + umbrela);

		for (int i : umr) {
			System.out.print(" " + i);
		}

	}

	private static int getMinUmbrela(Integer[] umr, int req) {
		int umcount = 1;
		int umrc[] = new int[umr.length];
		boolean found = false;
		for (int i = 0; i < umr.length - 1; i++) {
			if (umr[i] == req) {
				return 1;
			}
			int totalum = 0;
			for (i = 0; i < umr.length - 1; i++) {
				totalum += umr[i];
			}
			if (totalum < req) {
				return -1;
			}

			for (i = 0; i < umr.length - 1; i++) {
				System.out.println(" Req " + req + "  Umr " + umr[i]);
				if (req < umr[i]) {
					System.out.println("Umbrelamanoon.getMinUmbrela()");
				} else {
					int umr1 = umr[i];
					int umr2 = 0;
					for (int j = 1; j < umrc.length; j++) {
						umr2 += umr[j];
						umcount++;

						if (umr1 + umr2 == req) {
							found = true;
							break;
						}
					}
					if (found) {
						return umcount;
					}
				}

			}
		}
		return -1;
	}
}
