package ibu.edu.homework6;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class IPaddress implements Comparable<IPaddress> {
	long ipFrom;
	long ipTo;
	static boolean swapped;
	String countryCode;
	String countryName;
	String regionName;
	String cityName;
	
	public IPaddress( long ipFrom, long ipTo, String countryCode, String countryName, String regionName, String cityName) {
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionName = regionName;
		this.cityName = cityName;
	}
	
	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int compareTo( IPaddress that) {
		if (this.ipFrom > that.ipFrom) {
			return 1;
		} else if(this.ipFrom < that.ipFrom) {
			return -1;
		} else {
			return 0;
		}
		
	}
	public static IPaddress convertTOIPAddterss(String numbers){
		
			String[] ipAddress = numbers.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			int i = 0;
			while (i< ipAddress.length) {
			
				ipAddress[i] = ipAddress[i].replace("\"", "");
				ipAddress[i] = ipAddress[i].replace(" ", "");
				i++;
			}
			
			long ipFrom = Long.parseLong(ipAddress[0]);
			long ipTo = Long.parseLong(ipAddress[1]);
			String countryCode = ipAddress[2];
			String countryName = ipAddress[3];
			String region = ipAddress[4];
			String city = ipAddress[5];
			
			return new IPaddress(ipFrom, ipTo, countryCode, countryName, region, city);
		}
	
	public static IPaddress[] readNumbers(String path) throws FileNotFoundException {
        String[] ip = new String[100];
        Scanner scanner = new Scanner(new File(path));
        int i = 0; 
        while (scanner.hasNextLine() && i<100) {
        	String temp = scanner.nextLine();
            ip[i] = temp;
            i++;
        }
        scanner.close();
        IPaddress[] ipaddresses = new IPaddress[100];
        for (int j = 0; j<ip.length;j++) {
        	IPaddress tmp = convertTOIPAddterss(ip[j]);
        	ipaddresses[j] = tmp;
        }
        	
        return ipaddresses;
    }
	
	public static void writeToFile(String path, IPaddress[] array) throws IOException {
		File file = new File(path);
		FileWriter fw = new FileWriter(file);
		
		for (int i = 0; i < array.length; i++)
		fw.write(array[i].toString());
		System.out.print("done");
		fw.close();
	}
	
	public String toString(){  
		  return "\"" + this.ipFrom+"\"" + ", "+"\"" + this.ipTo + "\"" + ", " + "\"" + this.cityName+"\""+ ", "+"\""+this.countryCode+"\""+ ", "+"\""+this.countryName+"\""+ ", "+"\""+this.regionName+"\""+ "\n";  
		 } 
	public static void swap (Comparable[] elements, int a, int b) {
		Comparable t = elements[a];
		elements[a] = elements[b];
		elements[b] = t;
		swapped = true; 
	}
}




