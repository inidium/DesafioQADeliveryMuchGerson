package deliverymuchbrasil.com.automation_test;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import quimera.test.core.log.TestLogger;

public class Functions {
	
	public static enum languages {
		pt_BR,
		en_US
	}
	
	public static Object[][] readFromCSV(String fileName) { 
		List<NumberCSV> numberDataList = new ArrayList<NumberCSV>();
		Object[][] objectNumberData;
		Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader
		try {
			BufferedReader reader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
			String line = reader.readLine();
			while (line != null){
				String[] attributes = line.split(";");
				NumberCSV nCSV = new NumberCSV();
				nCSV.number = attributes[0];
				nCSV.statusCodeExpected = attributes[1];
				if(!nCSV.number.equals("Numero") && !nCSV.statusCodeExpected.equals("StatusCode")) {
					if (String.valueOf(nCSV.number).equals("&")) {
						Random randomNumber = new Random();
						int max = 10000; //10000
						int min = -10000; //-10000
						int initialNumber = randomNumber.nextInt((max - min) + 1) + min;
						int finalNumber = randomNumber.nextInt((initialNumber - (min)) + 1) + min;
						nCSV.number = String.valueOf(initialNumber) + ',' + String.valueOf(finalNumber);
						TestLogger.logInfo("Valore Randômicos: " + nCSV.number);
					}
					if (nCSV.number.contains(",")) {
						String[] numbers = nCSV.number.split(",");
						int numeroInicial = Integer.parseInt(numbers[0]);
						int numeroFinal = Integer.parseInt(numbers[numbers.length-1]);
						if (numeroInicial > 0) {
							if (numeroInicial < numeroFinal) {
								while(numeroInicial < numeroFinal + 1) {
									NumberCSV numberInLine = new NumberCSV();
									numberInLine.number = String.valueOf(numeroInicial);
									numberInLine.statusCodeExpected = nCSV.statusCodeExpected;
									numberDataList.add(numberInLine);
									numeroInicial++;
								}								
							}else {
								while(numeroInicial > numeroFinal - 1) {
									NumberCSV numberInLine = new NumberCSV();
									numberInLine.number = String.valueOf(numeroInicial);
									numberInLine.statusCodeExpected = nCSV.statusCodeExpected;
									numberDataList.add(numberInLine);
									numeroInicial--;
								}								
							}
						}else {
							int numF = numeroFinal + 1;
							if (numeroFinal < 0 )
								numF = numeroFinal - 1;
							if (numF > numeroInicial) {
								while(numeroInicial < numF) {
									NumberCSV numberInLine = new NumberCSV();
									numberInLine.number = String.valueOf(numeroInicial);
									numberInLine.statusCodeExpected = nCSV.statusCodeExpected;
									numberDataList.add(numberInLine);
									numeroInicial++;
								}								
							} else {
								while(numeroInicial > numF) {
									NumberCSV numberInLine = new NumberCSV();
									numberInLine.number = String.valueOf(numeroInicial);
									numberInLine.statusCodeExpected = nCSV.statusCodeExpected;
									numberDataList.add(numberInLine);
									numeroInicial--;
								}								
							}

						}
					}else {
						numberDataList.add(nCSV);
					}
				}
				line = reader.readLine();
			}
			objectNumberData = new Object[numberDataList.size()][2];
			int i = 0;
			for(NumberCSV nCSV : numberDataList) {
					objectNumberData[i][0] = nCSV.number;
					objectNumberData[i][1] = nCSV.statusCodeExpected;
					i++;
			}
		}catch (Exception e) {
			return null;
		}
		return objectNumberData;
	}

}
