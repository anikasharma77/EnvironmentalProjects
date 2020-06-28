//Weight of CO2

import java.util.*;
import java.text.DecimalFormat;

public class Peeb3 {

	public static void main(String[] args) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00E00");
		Scanner console = new Scanner(System.in);
		double constantPressure = 14.7;		
		double constantPPMCO2 = 400;				
		double constantPOP = 73E8;	
		double constantEarthRadius = 3959;		
		System.out.println("Calculate weight% of CO2 in Earth's atmosphere and");
		System.out.println("anthropomorphic contribution to that weight. Estimate");
		System.out.println("zero-emissions recovery time and project future trends.");
		System.out.println();
		testing();
		testing();
		System.out.print("carbon footprint per person (tons) = ");
		double carbonFoot = console.nextDouble();
		System.out.println("annual per capita CO2 absorption capacity = ");
		double carbonAbsorption = console.nextDouble();
		System.out.println();
		testing();
		double earthSurfaceArea = Math.pow(constantEarthRadius, 2) * (4 * Math.PI);
		testing();
		double earthSurfaceAreaInches = Math.pow(63360, 2) * earthSurfaceArea;
		testing();
		double atmosphereWeightPounds = earthSurfaceAreaInches*constantPressure;
		testing();
		double atmosphereWeightTons = atmosphereWeightPounds/2E3;
		double numerator = constantPPMCO2*44;
		double denominator = 780000*28 + 210000*32 + constantPPMCO2*44;
		double carbonPPMW = numerator/denominator;
		carbonPPMW *= 1E6;
		double carbonWeightPercent = (carbonPPMW / 1000000);
		carbonWeightPercent = mult100(carbonWeightPercent);
		double carbonWeight = (atmosphereWeightTons*carbonWeightPercent);
		carbonWeight /= 100;
		System.out.println("surface area Earth (sq mi) = " + decimalFormat.format(earthSurfaceArea));
		System.out.println("surface area Earth (sq in) = " + decimalFormat.format(earthSurfaceAreaInches));
		System.out.println("weight of atmosphere (lbs) = " + decimalFormat.format(atmosphereWeightPounds));
		System.out.println("weight of atmosphere (tons) = " + decimalFormat.format(atmosphereWeightTons));
		System.out.println("weight concentration CO2 (ppmw) = " + Math.round(carbonPPMW));
		System.out.printf("weight percent CO2 = %.3f\n", carbonWeightPercent);
		System.out.println("weight CO2 (tons) = " + decimalFormat.format(carbonWeight));
		System.out.println();	
		double anthroCarbon = constantPOP*carbonFoot;
		double anthroPercent = (anthroCarbon/carbonWeight);
		anthroPercent = mult100(anthroPercent);
		System.out.println("anthropormorphic CO2 footprint (tons) = " + decimalFormat.format(anthroCarbon));
		System.out.printf("anthropomorphic CO2 percent = %.3f\n", anthroPercent);
		System.out.println();
		double carbonWeight1750 = (carbonWeight * 280) /400;
		double weightGain = carbonWeight - carbonWeight1750; 
		double totalAbs = constantPOP * carbonAbsorption; 
		double absorbtionTime = weightGain / totalAbs; 
		System.out.println("weight CO2 in 1750 (tons) = " + decimalFormat.format(carbonWeight1750));
		System.out.println("CO2 weight gain (tons) = " + decimalFormat.format(weightGain));
		System.out.println("CO2 annual absorption capacity (tons) = " + decimalFormat.format(totalAbs));
		System.out.println("zero-emissions absorption time (years) = " + Math.round(absorbtionTime));
		System.out.println();
		double exponent = Math.log10(400.0/280.0)/115.0; 
		double interest1900 = (returnPow(10, exponent) -1);
		interest1900 = mult100(interest1900);
		double twenty = returnPow(1 + anthroPercent/100, 20); 
		double twenty82 = returnPow(1 + 0.82/100, 20);
		double fifty = returnPow(1 + anthroPercent/100, 50); 
		double hundred = returnPow(1 + anthroPercent/100, 100); 
		System.out.printf("average CO2 interest rate since 1900 (percent) = %.3f\n", interest1900);
		System.out.printf("20 year factor @ 2015 interest rate = %.2f\n", twenty);
		System.out.printf("20 year factor 0.82 interest rate = %.2f\n", twenty82);
		System.out.printf("50 year factor @ 2015 interest rate = %.2f\n", fifty);
		System.out.printf("100 year factor @ 2015 interest rate = %.2f\n", hundred);
	}

	public static double returnPow(double first, double second){
		return Math.pow(first, second);
	}

	public static double mult100(double number){
		return number *100;
	}

	public static void testing(){
		for(double i = 10.0; i <= Math.sqrt(100000000.0); i=i+1.0 ){
			Math.sqrt(i);
		}
	}


}