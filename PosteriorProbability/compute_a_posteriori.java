//package PosteriorProb;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;

public class compute_a_posteriori {

	public static void main(String[] args) throws FileNotFoundException {

		 PrintStream originalOut = System.out;
         PrintStream fileOut = new PrintStream("./result.txt");
         System.setOut(fileOut);
		double ph1 = 0.1;
		double ph2 = 0.2;
		double ph3 = 0.4;
		double ph4 = 0.2;
		double ph5 = 0.1;
		
		double QL1 = 0;
		double QL2 = 0.25;
		double QL3 = 0.5;
		double QL4 = 0.75;
		double QL5 = 1;
		
		double QC1 = 1;
		double QC2 = 0.75;
		double QC3 = 0.5;
		double QC4 = 0.25;
		double QC5 = 0;
		
		double limeDem = 0;
		double cherryDem = 0;
		
		DecimalFormat df = new DecimalFormat("#.#####");
		
		System.out.println("Observation sequence Q: "+args[0]);
		//originalOut.println("Observation sequence Q: "+args[0]);
		int length = args[0].length();
		System.out.println("Length of Q: "+length);
		limeDem = (ph1*QL1)+(ph2*QL2)+(ph3*QL3)+(ph4*QL4)+(ph5*QL5);
		cherryDem = (ph1*QC1)+(ph2*QC2)+(ph3*QC3)+(ph4*QC4)+(ph5*QC5);
		for(int i=0; i<length; i++) {
			char Q = args[0].charAt(i);
			System.out.println("\n");
			int printi = i+1;
			System.out.println("After Observation "+ printi +" =  " +Q+ ":");
			System.out.println("\n");
			
			if(Q == 'L') {
				ph1 = (ph1*QL1)/limeDem;
				ph2 = (ph2*QL2)/limeDem;
				ph3 = (ph3*QL3)/limeDem;
				ph4 = (ph4*QL4)/limeDem;
				ph5 = (ph5*QL5)/limeDem;
			}else {
				ph1 = (ph1*QC1)/cherryDem;
				ph2 = (ph2*QC2)/cherryDem;
				ph3 = (ph3*QC3)/cherryDem;
				ph4 = (ph4*QC4)/cherryDem;
				ph5 = (ph5*QC5)/cherryDem;
			}
			
			limeDem = (ph1*QL1)+(ph2*QL2)+(ph3*QL3)+(ph4*QL4)+(ph5*QL5);
			cherryDem = (ph1*QC1)+(ph2*QC2)+(ph3*QC3)+(ph4*QC4)+(ph5*QC5);
			
			/*System.out.println("P(h1 | Q) = "+df.format(ph1));
			System.out.println("P(h2 | Q) = "+df.format(ph2));
			System.out.println("P(h3 | Q) = "+df.format(ph3));
			System.out.println("P(h4 | Q) = "+df.format(ph4));
			System.out.println("P(h5 | Q) = "+df.format(ph5));
			System.out.println("\n");
			System.out.println("Probability that the next candy we pick will be C, given Q: "+df.format(cherryDem));
			System.out.println("Probability that the next candy we pick will be L, given Q: "+df.format(limeDem));*/
			
			System.out.println("P(h1 | Q) = "+ph1);
			System.out.println("P(h2 | Q) = "+ph2);
			System.out.println("P(h3 | Q) = "+ph3);
			System.out.println("P(h4 | Q) = "+ph4);
			System.out.println("P(h5 | Q) = "+ph5);
			System.out.println("\n");
			System.out.println("Probability that the next candy we pick will be C, given Q: "+cherryDem);
			System.out.println("Probability that the next candy we pick will be L, given Q: "+limeDem);
			
			
		}
	}
}