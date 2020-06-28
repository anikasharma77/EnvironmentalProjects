import java.util.*;

public class Peebtwo{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);


		double stefConstant = 5.67E-8;		
		double rofs = 700000;					
		double astronomical = 1.5E8;			
		double sunofs = 64.2E6;		

		System.out.println("Calculate radiant power per unit area for Sun and Planet using");
		System.out.println("Stefan-Boltzman Law. From balance equation for Planet,");
		System.out.println("(Power in) = (Power out), predict temperature of Planet.");
		System.out.print("Planet: ");
		String planet = console.next();
		System.out.print("distance of Planet from Sun (AU):");
		double distance = console.nextDouble();
		System.out.print(" radius of Planet (km):");
		double radius = console.nextDouble();
		System.out.print(" albedo of Planet: ");
		double albedo = console.nextDouble();
		
		

		double rpower = (sunofs)*( Math.pow((rofs/(distance*astronomical)),2) );		
		double average = rpower/4;										
		double averageAlbedo = average* (1 - albedo);					
		double kelvin = Math.pow(averageAlbedo/stefConstant, 0.25);
		double celcius = kelvin - 273.15;

		System.out.println("photon flux SP = " + Math.round(rpower));
		System.out.println("average photon flux SAve = " + Math.round(average));
		System.out.println("including albedo SAve x (1 - alpha) = " + Math.round(averageAlbedo));
		System.out.println("temperature TP (K) = " + Math.round(kelvin));
		System.out.println("temperature TP (C) = " + Math.round(celcius));


		

	}
}