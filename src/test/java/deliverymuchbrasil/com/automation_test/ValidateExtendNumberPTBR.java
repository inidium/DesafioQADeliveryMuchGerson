package deliverymuchbrasil.com.automation_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import quimera.test.core.log.TestLogger;
import quimera.test.core.request.TestRequest;
import quimera.test.core.request.TestRequest.HttpMethod;
import quimera.test.extension.api.TestExtension;
import quimera.test.utilities.assertion.AssertThat;

public class ValidateExtendNumberPTBR extends TestExtension {
	Utils utilitario = new Utils();
	String URLAPI =  getUrlAPI() + "/";
	
	@DataProvider(name = "extensionData", parallel = false)
	public Object[][] getExtensionData() {
		try {
			String file = System.getProperty("user.dir") + "/Resource/NumbersDataSource.csv";
			return Functions.readFromCSV(file);
		}catch (Exception e) {
			TestLogger.logInfo("Erro: " + e.getMessage());
			return null;
		}
	 };

 
	@SuppressWarnings("static-access")
	@Test (testName = "Valida envio de número inválido URL - pr_BR", description = "Valida Código Cenário Inválido")
	public void validateInvalidNumberPTBR() {
		String number = "10001";
		int statusCodeExpected = 400;
		String APIPatch = URLAPI + number;
		Response resultData = TestRequest.request(HttpMethod.GET, false, "", "", APIPatch);
		AssertThat.rest()
			.isEqualStatusCode(resultData, statusCodeExpected)
			.rest().isEqualText(resultData, "Invalid data", "extenso");
	}

	@Test (testName = "Valida envio de número inválido - pt_BR", description = "Valida Código de Status da URL - pt_BR", dataProvider = "extensionData")
	public void validateStatusCodePTBR(String number, String statusCode) {
		int statusCodeExpected = Integer.parseInt(statusCode);
		String APIPatch = URLAPI + number;
		Response resultData = TestRequest.request(HttpMethod.GET, false, "", "", APIPatch);
		AssertThat.rest()
			.isEqualStatusCode(resultData, statusCodeExpected);
	}
	
	@Test (testName = "Valida envio de número inválido URL - pt_BR", description = "Valida extensão dos números URL - pt_BR", dataProvider = "extensionData")
	public void validateNumberExtensionPTBR(String number, String statusCode) {
		String APIPatch = URLAPI + number;
		Response resposta = TestRequest.request(HttpMethod.GET, false, "", "", APIPatch);
		AssertThat.rest()
			.isEqualText(resposta, Utils.returnExtenseNumber(Integer.parseInt(number), Functions.languages.pt_BR), "extenso");
	}

}
