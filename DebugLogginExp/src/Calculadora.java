import java.io.IOException;
import java.util.logging.Level;

public class Calculadora {
	public float calcular(float a, float b, char operacao) throws IOException {
		Log logCalc = new Log("Log.txt");		
		try {
			logCalc.logger.setLevel(Level.INFO);
			logCalc.logger.info("Log de informação");
			logCalc.logger.warning("Log de Aviso");
			logCalc.logger.severe("Log Severo");
		} catch (Exception e) {
			logCalc.logger.warning("Aviso de execução da calculadora: "+e.getMessage());
			System.out.println("Falha: " + e);
		}
		
		float resultado = 0;
		//adicionado break; faltando nos cases
		switch (operacao) {
		case '+': {
			resultado = a + b;
			break;
		}
		case '-': {
			//verificando qual dos números tem valor maior (e aplicando "módulo") e inserindo qual "caso" é no log
			if (a>b){
				resultado = a - b;
				logCalc.logger.info("O 1º valor digitado é maior.");
			}
			if (b>a){
				resultado = b - a;
				logCalc.logger.info("O 2º valor digitado é maior.");
			}
			break;
		}
		case '/': {
			resultado = a / b;
			break;
		}
		case '*': {
			resultado = a * b;
			break;
		}		

		}
		return resultado;
		
	}
}
