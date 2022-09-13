import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	
	static final int MIN = 0;
	static final int MAX = 1000000;
	static int vidas = 5;
	//cambiar esta variable para que nos chive el numero (para testear)
	static final boolean CHIVATO = true;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
		Lambda lmb = (n1, n2) -> n1 == n2;

		System.out.println("Adivina el numero entre " + MIN+ " y " + MAX+".");
		if (CHIVATO) {
			System.out.println("Chivato: pss! el numero es " + randomNum);
		}
		while (vidas > 0) {
			System.out.print("El número es... ");
			int userNum = sc.nextInt();
			if (hitCheck(userNum, randomNum, lmb)) {
				System.out.println("Lo adivinaste, eres el campeón!");
				break;
			} else {
				vidas--;
				if (vidas > 0) {
					System.out.println("Lo siento, " + userNum + " no es el número correcto. Intentalo de nuevo!");
					System.out.println("Te quedan " + vidas +" intentos.");
				} else {
					System.out.println("Lo siento, " + userNum + " no es el número correcto. Buena suerte la proxima vez...");
					System.out.println("Has perdido el juego...");
				}
			}
		}
		sc.close();
	}
	
	public static boolean hitCheck(int checkThis, int againstThis, Lambda lambdaFunction) {
		return lambdaFunction.runCheck(checkThis, againstThis);
	}

}
