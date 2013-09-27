package no.hib.dat104.klasser;

import java.util.ArrayList;
import java.util.List;

public class Sortering {

	
	public static List<Deltager> sort(List<Deltager> list){
		Deltager[] A = new Deltager[list.size()];
		int indeks = 0;
		for (Deltager deltager : list){
			A[indeks] = deltager;
			indeks++;
		}
			
		List<Deltager> temp = new ArrayList<>();
		 for(int i = 1; i < A.length; i++){
			    Deltager value = A[i];
			    int j = i - 1;
			    while(j >= 0 && A[j].getForNavn().compareTo(value.getForNavn()) > 0){
			      A[j + 1] = A[j];
			      j = j - 1;
			    }
			    A[j + 1] = value;
			  }
		 
		 for (Deltager del : A)
			 temp.add(del);
		  return temp;
	}
}
