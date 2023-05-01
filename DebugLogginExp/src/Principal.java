import java.util.Scanner;
import java.util.logging.*;
import java.io.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		Log log = new Log("Log.txt");
		try {
			log.logger.setLevel(Level.INFO);
			log.logger.info("Log de informação");
			log.logger.warning("Log de Aviso");
			log.logger.severe("Log Severo");
		} catch (Exception e) {
			log.logger.warning("Aviso de exceção: "+e.getMessage());
			System.out.println("Falha: " + e);
		}
		
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();
			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado de " + a + " " + operador + " " + b + " �:" + resultado);


			//Adicioando o tipo de operação realizada dentro do obj operador (não funcionou)
			/*switch (operador) {
			case '+': {
				operador. = 'Adição';
				break;
			}
			
			case '-': {
				operador = 'Subtração';
				break;
			}
			
			case '*': {
				operador = 'Multiplicação';
				break;
			}
			
			case '/': {
				operador = 'Divisão';
				break;
			}
			
			}*/
			//Log dos dados inseridos e o tipo de operação
			log.logger.info("Operação realizada: "+operador+ "\n1º Valor inserido: "+a+"\n2º Valor inserido: "+b);
		}

	}

}
