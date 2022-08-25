package ibu.edu.homework6;
import java.io.IOException;
public class App {
	public static void main(String[] args) throws IOException {
		IPaddress[] ipAddress = new IPaddress[100];
		long start=System.currentTimeMillis();
		ipAddress = IPaddress.readNumbers("/Users/acaus/Downloads/IP-COUNTRY-REGION-CITY-SHUFFLED/IP-COUNTRY-REGION-CITY-SHUFFLED.csv");
		RadixSort.sort(ipAddress);
		System.out.println((System.currentTimeMillis()-start)+ " ms");
		IPaddress.writeToFile("/Users/acaus/Downloads/radixsort.csv", ipAddress);
			}
		}


