import java.util.*;

public class PEEB4 {

	public static void main(String[] args) {

		System.out.println("Calculate surface temperature as a function of");
		System.out.println("emissivity for the single-layer atmosphere model.");

		Scanner console = new Scanner(System.in);

		double stefan = 5.67E-8;	
		double albedoConstant = 0.3;
		double saveConstant = 342;

		System.out.print("enter emissivity: ");
		double emissivity = console.nextDouble();

	
		double temperature = Math.pow((2*(1 - albedoConstant)*saveConstant)/(stefan*(2 - emissivity)), 0.25);
		System.out.println("emissivity (= absorptivity) = " + emissivity);

		int rounded = (int)Math.round(temperature);
		System.out.println("surface temperature = " + rounded  + "K");

	}

	
}