package ibu.edu.homework6;
public class RadixSort {
	public static void sort(IPaddress[] elements) {
	long max = getMax(elements);							
	for (long exp = 1; max / exp > 0; exp *= 10) {		
			sort(elements, exp);							
		}
	}

	private static void sort(IPaddress[] elements, long exp) {
		IPaddress[] aux = new IPaddress[elements.length];					
		int[] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		
		
		for (int i = 0; i < elements.length; i++) {		
			long digit = elements[i].ipFrom / exp % 10;				
			frequency[ (int) digit]++;									
		}
		
		for (int i = 1; i < 10; i++) {							
			frequency[i] += frequency[i - 1];					
		}
		
		for (int i = elements.length - 1; i >= 0; i--) {
			long digit = (elements[i].ipFrom / exp) % 10;				
			aux[frequency[(int) digit] - 1] = elements[i];			
			frequency[(int) digit]--;									
		}
		
		for (int i= 0; i < elements.length; i++) {				
			elements[i] = aux[i];							
		}
	}
	
	private static long getMax(IPaddress[] elements) {
		IPaddress max = elements[0];					
		for (int i = 1; i < elements.length; i++) {		
			if (elements[i].compareTo(max) > 0) {		
				max = elements[i];						
			}
		}
		return max.ipFrom;										
	}
}
