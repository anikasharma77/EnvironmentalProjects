//Weight of CO2

import java.util.*;
import java.text.DecimalFormat;

public class peeb {

	public static void main(String[] args) {

		giveIntro();

		Scanner console = new Scanner(System.in);

		double pressure = 14.700000;		//atmospheric pressure
		double ppmvCO2 = 400;				//2015 volume concentration CO2
		double population = 7.3E9;			//2015 human population

//		double radiusEarth = getInput("radius of Earth (mi) = ", console);
		double cFootprint = getInput("carbon footprint per person (tons) = ", console);
		double cAbsorption = getInput("annual per capita CO2 absorption capacity = ", console);
		System.out.println();

		//weight CO2
		double radiusEarth = 3959;
		double surfaceAreaSqMi = 4*Math.PI*Math.pow(radiusEarth, 2);
		double surfaceAreaSqIn = surfaceAreaSqMi*Math.pow(5280*12, 2);
		double weightAtmosphereLbs = surfaceAreaSqIn*pressure;
		double weightAtmosphereTons = weightAtmosphereLbs/2000;
		double ppmwCO2 = ((ppmvCO2*44)/(780000*28 + 210000*32 + ppmvCO2*44))*1000000; //weight conc CO2
		double wtPercentCO2 = ppmwCO2 / 1000000 * 100; //weight percent CO2
		double wtCO2 = weightAtmosphereTons*wtPercentCO2/100;

		//anthropomorphic CO2 contribution
		double anthroCarbon = population*cFootprint; //total anthropomorphic carbon footprint
		double anthroPercent = anthroCarbon/wtCO2*100; //anthropomorphic %

		//zero-emissions time to reduce CO2 from 400 to 280 ppmv
		double wtCO2in1750 = wtCO2*280/400; //weight CO2 pre-Industrial Revolution
		double wtGain = wtCO2 - wtCO2in1750; //CO2 weight gain from 1750 to present
		double totalAbsorption = population*cAbsorption; //total CO2 absorption capacity
		double timeToAbsorb = wtGain/totalAbsorption; //zero-emmisions time (years) to absorb CO2 weight gain

		//future projections
		double exponent = Math.log10(400.0/280.0)/115.0; //using compound interest formula
		double interestRateSince1900 = (Math.pow(10, exponent) - 1)*100;
		double years20 = Math.pow(1 + anthroPercent/100, 20); //50 years at 2015 interest rate
		double years50 = Math.pow(1 + anthroPercent/100, 50); //50 years at 2015 interest rate
		double years100 = Math.pow(1 + anthroPercent/100, 100); //100 years at 2015 interest rate


		DecimalFormat df1 = new DecimalFormat("0.00E00");
		//weight CO2
		System.out.println("surface area Earth (sq mi) = " + df1.format(surfaceAreaSqMi));
		System.out.println("surface area Earth (sq in) = " + df1.format(surfaceAreaSqIn));
		System.out.println("weight of atmosphere (lbs) = " + df1.format(weightAtmosphereLbs));
		System.out.println("weight of atmosphere (tons) = " + df1.format(weightAtmosphereTons));
		System.out.println("weight concentration CO2 (ppmw) = " + Math.round(ppmwCO2));
		System.out.printf("weight percent CO2 = %.3f\n", wtPercentCO2);
		System.out.println("weight CO2 (tons) = " + df1.format(wtCO2));
		System.out.println();

		//anthropomorphic CO2 contribution
		System.out.println("anthropormorphic CO2 footprint (tons) = " + df1.format(anthroCarbon));
		System.out.printf("anthropomorphic CO2 percent = %.3f\n", anthroPercent);
		System.out.println();

		//zero-emissions time to reduce CO2 from 400 to 280 ppmv
		System.out.println("weight CO2 in 1750 (tons) = " + df1.format(wtCO2in1750));
		System.out.println("CO2 weight gain (tons) = " + df1.format(wtGain));
		System.out.println("CO2 annual absorption capacity (tons) = " + df1.format(totalAbsorption));
		System.out.println("zero-emissions absorption time (years) = " + Math.round(timeToAbsorb));
		System.out.println();

		//future projections
		System.out.printf("average CO2 interest rate since 1900 (percent) = %.3f\n", interestRateSince1900);
		System.out.printf("20 year factor @ 2015 interest rate = %.2f\n", years20);
		System.out.printf("50 year factor @ 2015 interest rate = %.2f\n", years50);
		System.out.printf("100 year factor @ 2015 interest rate = %.2f\n", years100);
	}

    public static String getPlanetName(String prompt, Scanner console) {
        System.out.print(prompt);
        String input = console.next();
        return input;
    }

	public static void giveIntro() {
		System.out.println("Calculate weight% of CO2 in Earth's atmosphere and");
		System.out.println("anthropomorphic contribution to that weight. Estimate");
		System.out.println("zero-emissions recovery time and project future trends.");
		System.out.println();
	}
	public static double getInput(String prompt, Scanner console) {
        System.out.print(prompt);
        double input = console.nextDouble();
        return input;
    }
}