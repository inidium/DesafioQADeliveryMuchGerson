package deliverymuchbrasil.com.automation_test;

public class Utils {
	private static String getExtenseNumberBasic(int number, Boolean requireNegative, Functions.languages language) {
		String ex = "";
		String isNegative = "";
		if (number < 0 && requireNegative) {
			number = number * (-1);
			if (language == Functions.languages.pt_BR)
				isNegative = "menos ";
			else
				isNegative = "minus ";
		}
		switch (number) {
			case 1:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "um";
				else
					ex = isNegative + "one";
				break;
			case 2:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "dois";
				else
					ex = isNegative + "two";
				break;			
			case 3:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "três";
				else
					ex = isNegative + "three";
				break;
			case 4:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "quatro";
				else
					ex = isNegative + "four";
				break;
			case 5:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "cinco";
				else
					ex = isNegative + "five";
				break;
			case 6:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "seis";
				else
					ex = isNegative + "six";
				break;
			case 7:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "sete";
				else
					ex = isNegative + "seven";
				break;
			case 8:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "oito";
				else
					ex = isNegative + "eight";
				break;
			case 9:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "nove";
				else
					ex = isNegative + "nine";
				break;
			case 10:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "dez";
				else
					ex = isNegative + "ten";
				break;
			case 11:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "onze";
				else
					ex = isNegative + "eleven"; 
				break;
			case 12:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "doze";
				else
					ex = isNegative + "twelve";
				break;
			case 13:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "treze";
				else
					ex = isNegative + "thirteen";
				break;
			case 14:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "quatorze";
				else
					ex = isNegative + "fourteen";
				break;
			case 15:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "quinze";
				else
					ex = isNegative + "fifteen";
				break;
			case 16:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "dezesseis";
				else
					ex = isNegative + "sixteen";
				break;
			case 17:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "dezessete";
				else
					ex = isNegative + "seventeen";
				break;
			case 18:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "dezoito";
				else
					ex = isNegative + "eighteen";
				break;
			case 19:
				if (language == Functions.languages.pt_BR)
					ex = isNegative + "dezenove";
				else
					ex = isNegative + "nineteen";
				break;
		}
		return ex;
	}
	private static String getExtenseNumberTwoDecimalPlace(int number, Boolean requireNegative, Functions.languages language) {
		String isNegative = "";
		String numberInText = String.valueOf(number);
		if (number < 0 && requireNegative) {
			number = number * (-1);
			numberInText = String.valueOf(number);
			if (language == Functions.languages.pt_BR)
				isNegative = "menos ";
			else
				isNegative = "minus ";
		}
		String ex = isNegative;
		int numberConstruct = Integer.parseInt(String.valueOf(numberInText.charAt(1)));
		if (numberInText.charAt(0) == '2') {
			if (numberInText.charAt(1) == '0'){
				if (language == Functions.languages.pt_BR)
					ex += "vinte";
				else
					ex += "twenty";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "vinte e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "twenty " + getExtenseNumberBasic(numberConstruct, false, language);
			}
		}
		if (numberInText.charAt(0) == '3')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "trinta";
				else
					ex += "thirty";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "trinta e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "thirty-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		if (numberInText.charAt(0) == '4')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "quarenta";
				else
					ex += "forty";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "quarenta e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "forty-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		if (numberInText.charAt(0) == '5')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "cinquenta";
				else
					ex += "fifty";
			}else {
				if (language == Functions.languages.pt_BR)
					ex += "cinquenta e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "fifty-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		if (numberInText.charAt(0) == '6')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "sessenta";
				else
					ex += "sixty";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "sessenta e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "sixty-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		if (numberInText.charAt(0) == '7')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "setenta";
				else
					ex += "seventy";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "setenta e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "seventy-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		if (numberInText.charAt(0) == '8')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "oitenta";
				else
					ex += "eighty";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "oitenta e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "eighty-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		if (numberInText.charAt(0) == '9')
			if (numberInText.charAt(1) == '0') {
				if (language == Functions.languages.pt_BR)
					ex += "noventa";
				else
					ex += "ninety";
			} else {
				if (language == Functions.languages.pt_BR)
					ex += "noventa e " + getExtenseNumberBasic(numberConstruct, false, language);
				else
					ex += "ninety-" + getExtenseNumberBasic(numberConstruct, false, language);
			}
		return ex;
	}
	
	private static String getExtenseNumberTreeColab(String firstWord, int number, Functions.languages language) {
		if ((number > 0 && number < 20) || (number < 0 && number > -20)) {
			return firstWord + getExtenseNumberBasic(number, false, language);
		}else{
			return firstWord + getExtenseNumberTwoDecimalPlace(number, false, language);
		}
	}
	private static String getExtenseNumberThreeDecimalPlace(int number, Boolean requireNegative, Functions.languages language) {
		String isNegative = "";
		String numberInText = String.valueOf(number);
		if (number < 0 && requireNegative) {
			number = number * (-1);
			numberInText = String.valueOf(number);
			if (language == Functions.languages.pt_BR)
				isNegative = "menos ";
			else
				isNegative = "minus ";
		}
		String ex = isNegative;
		int numberConstruct = Integer.parseInt(String.valueOf(numberInText.charAt(1)) + String.valueOf(numberInText.charAt(2)));
		switch (numberInText.charAt(0)) {
			case '1':
				if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
					if (language == Functions.languages.pt_BR)
						ex += "cem";
					else
						ex += "one hundred";
				}else {
					if (language == Functions.languages.pt_BR)
						ex += getExtenseNumberTreeColab("cento e um ", numberConstruct, language);
					else
						ex += getExtenseNumberTreeColab("one hundred and ", numberConstruct, language);
				}
				break;
			case '2':
				if (numberInText.charAt(0) == '2') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "duzentos";
						else
							ex += "two hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("duzentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("two hundred and ", numberConstruct, language);
					}
				}
				break;
			case '3':
				if (numberInText.charAt(0) == '3') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "trezentos";
						else
							ex += "three hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("trezentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("three hundred and ", numberConstruct, language);
					}
				}
				break;
			case '4':
				if (numberInText.charAt(0) == '4') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "quatrocentos";
						else
							ex += "four hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("quatrocentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("four hundred and ", numberConstruct, language);
					}
				}
				break;
			case '5':
				if (numberInText.charAt(0) == '5') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "quinhentos";
						else
							ex += "five hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("quinhentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("five hundred and ", numberConstruct, language);
					}
				}
				break;
			case '6':
				if (numberInText.charAt(0) == '6') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "seiscentos";
						else
							ex += "six hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("seiscentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("six hundred and ", numberConstruct, language);
					}
				}
				break;
			case '7':
				if (numberInText.charAt(0) == '7') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "setecentos";
						else
							ex += "seven hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("setecentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("seven hundred and ", numberConstruct, language);
					}
				}
				break;
			case '8':
				if (numberInText.charAt(0) == '8') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "oitocentos";
						else
							ex += "eight hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("oitocentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("eight hundred and ", numberConstruct, language);
					}
				}
				break;
			case '9':
				if (numberInText.charAt(0) == '9') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "novecentos";
						else
							ex += "nine hundred";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberTreeColab("novecentos e ", numberConstruct, language);
						else
							ex += getExtenseNumberTreeColab("nine hundred and ", numberConstruct, language);
					}
				}
				break;
		}
		return ex;
	}
	
	private static String getExtenseNumberFourColab(String firstWord, int number, Functions.languages language) {
		String extensionReturn = "";
		String numberInText = String.valueOf(number);
		if ((number > 0 && number < 20) || (number < 0 && number > -20))
			extensionReturn = firstWord + getExtenseNumberBasic(number, false, language);
		else if ((number >= 20 && number < 100) || (number <= -20 && number > -100)) {
			extensionReturn = firstWord + getExtenseNumberTwoDecimalPlace(number, false, language);
		}else if ((number >= 100 && number < 10000) || (number <= -100 && number > -10000)) {
			if (language == Functions.languages.pt_BR) {
				if (numberInText.charAt(1) != '0' && numberInText.charAt(2) != '0')
					firstWord = firstWord.replace(" e ", " ");				
			}else {
				firstWord = firstWord.replace(" and ", ", ");
			}
			extensionReturn = firstWord + getExtenseNumberThreeDecimalPlace(number, false, language);
		}
		return extensionReturn;
	}
	private static String getExtenseNumberFourDecimalPlace(int number, Boolean requireNegative, Functions.languages language) {
		String isNegative = "";
		String numberInText = String.valueOf(number);
		if (number < 0 && requireNegative) {
			number = number * (-1);
			numberInText = String.valueOf(number);
			if (language == Functions.languages.pt_BR)
				isNegative = "menos ";
			else
				isNegative = "minus ";
		}
		String ex = isNegative;
		int numberConstruct = Integer.parseInt(String.valueOf(numberInText.charAt(1)) + String.valueOf(numberInText.charAt(2)) + String.valueOf(numberInText.charAt(3)));
		switch (numberInText.charAt(0)) {
			case '1':
				if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0' && numberInText.charAt(3) == '0'){
					if (language == Functions.languages.pt_BR)
						ex += "mil";
					else
						ex += "thousand";
				}else {
					if (language == Functions.languages.pt_BR)
						ex += getExtenseNumberFourColab("mil e ", numberConstruct, language);
					else
						ex += getExtenseNumberFourColab("one thousand and ", numberConstruct, language);
				}
				break;
			case '2':
				if (numberInText.charAt(0) == '2') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "dois mil";
						else
							ex += "two thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("dois mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("two thousand and ", numberConstruct, language);
					}
				}
				break;
			case '3':
				if (numberInText.charAt(0) == '3') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "três mil";
						else
							ex += "three thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("três mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("three thousand and ", numberConstruct, language);
					}
				}
				break;
			case '4':
				if (numberInText.charAt(0) == '4') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "quatro mil";
						else
							ex += "four thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("quatro mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("four thousand and ", numberConstruct, language);
					}
				}
				break;
			case '5':
				if (numberInText.charAt(0) == '5') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "cinco mil";
						else
							ex += "five thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("cinco mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("five thousand and ", numberConstruct, language);
					}
				}
				break;
			case '6':
				if (numberInText.charAt(0) == '6') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "seis mil";
						else
							ex += "six thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("seis mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("six thousand and ", numberConstruct, language);
					}
				}
				break;
			case '7':
				if (numberInText.charAt(0) == '7') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "sete mil";
						else
							ex += "seven thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("sete mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("seven thousand and ", numberConstruct, language);
					}
				}
				break;
			case '8':
				if (numberInText.charAt(0) == '8') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "oito mil";
						else
							ex += "eight thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("oito mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("eight thousand and ", numberConstruct, language);
					}
				}
				break;
			case '9':
				if (numberInText.charAt(0) == '9') {
					if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0'){
						if (language == Functions.languages.pt_BR)
							ex += "nove mil";
						else
							ex += "nine thousand";
					}else {
						if (language == Functions.languages.pt_BR)
							ex += getExtenseNumberFourColab("nove mil e ", numberConstruct, language);
						else
							ex += getExtenseNumberFourColab("nine thousand and ", numberConstruct, language);
					}
				}
				break;
		}
		return ex;
	}

	private static String getExtenseNumberFiveDecimalPlace(int number, Boolean requireNegative, Functions.languages language) {
		String isNegative = "";
		String numberInText = String.valueOf(number);
		if (number < 0 && requireNegative) {
			number = number * (-1);
			numberInText = String.valueOf(number);
			if (language == Functions.languages.pt_BR)
				isNegative = "menos ";
			else
				isNegative = "minus ";
		}
		String ex = isNegative;
		switch (numberInText.charAt(0)) {
			case '1':
				if (numberInText.charAt(1) == '0' && numberInText.charAt(2) == '0' && numberInText.charAt(3) == '0' && numberInText.charAt(4) == '0'){
					ex += "ten thousand";
				}
				break;
		}
		return ex;
	}
	
	
	
	public static String returnExtenseNumber(int number, Functions.languages language) {
		String ex = "";
		int numberZize = String.valueOf(number).length();
    	if (number == 0 ) {
    			return "zero";
    	}	
		if (number < 0)
			numberZize = String.valueOf(number).length() - 1;
		if ((number > 0 && number < 20) || (number < 0 && number > -20))
			return getExtenseNumberBasic(number, true, language);
		if (numberZize == 2) {
			ex = getExtenseNumberTwoDecimalPlace(number, true, language);
		}else if (numberZize == 3) {
			ex = getExtenseNumberThreeDecimalPlace(number, true, language);
		}else if (numberZize == 4) {
			ex = getExtenseNumberFourDecimalPlace(number, true, language);
		}else {
			ex = getExtenseNumberFiveDecimalPlace(number, true, language);
		}
		return ex;
	}
}
