import java.util.*;

public class Sanity {

    public enum Emotion {
        TRISTEZA, ENOJO, ANSIEDAD, ALEGRIA, NEUTRAL
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú de ejercicios ---");
            System.out.println("1. Test lógico de bienestar emocional");
            System.out.println("2. Registro de ánimo diario (7 días)");
            System.out.println("3. Alerta por mensajes negativos");
            System.out.println("0. Salir");
            System.out.print("Elige un ejercicio: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    ejercicio1(sc);
                    break;
                case 2:
                    ejercicio2(sc);
                    break;
                case 3:
                    ejercicio3(sc);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // Ejercicio 1: Test lógico de bienestar emocional
    private static void ejercicio1(Scanner sc) {
        System.out.println("\n🧠 Test de bienestar emocional (Responde con sí o no):\n");

        System.out.print("1. ¿Te has sentido cansado o sin energía hoy? ");
        String r1 = sc.nextLine().toLowerCase();

        System.out.print("2. ¿Has sentido ansiedad o preocupación constante? ");
        String r2 = sc.nextLine().toLowerCase();

        System.out.print("3. ¿Sientes que no tienes ganas de hablar con nadie hoy? ");
        String r3 = sc.nextLine().toLowerCase();

        System.out.println("\n📝 Resultado:");

        if (r1.equals("si") && r2.equals("si") && r3.equals("si")) {
            System.out.println("Parece que estás emocionalmente agotado. 😞");
            System.out.println("👉 Sugerencia: Intenta desconectarte un poco, respira profundo y habla con alguien de confianza.");
        } else if (r1.equals("si") || r2.equals("si")) {
            System.out.println("Tu día ha tenido momentos difíciles. 😐");
            System.out.println("👉 Sugerencia: Tómate un descanso, escucha música relajante o haz algo que disfrutes.");
        } else if (r3.equals("si")) {
            System.out.println("Es normal no querer socializar a veces. 🫂");
            System.out.println("👉 Sugerencia: Date tu espacio, pero no te aísles por mucho tiempo.");
        } else {
            System.out.println("¡Estás teniendo un buen día emocional! 😊");
            System.out.println("👉 Sugerencia: Mantén lo que te hace sentir bien y cuida tu salud mental.");
        }

        System.out.println("\nGracias por realizar el test. 💙");
    }


    private static void ejercicio2(Scanner sc) {
        int[] niveles = new int[7];
        int suma = 0;

        System.out.println("\nIngresa tu nivel de ánimo diario (1–10) durante 7 días:");
        for (int i = 0; i < 7; i++) {
            System.out.printf("Día %d: ", i + 1);
            niveles[i] = sc.nextInt();
            if (niveles[i] < 1) niveles[i] = 1;
            else if (niveles[i] > 10) niveles[i] = 10;
            suma += niveles[i];
        }

        double promedio = suma / 7.0;
        System.out.printf("\nPromedio semanal de ánimo: %.2f\n", promedio);

        if (promedio >= 6) {
            System.out.println("Semana mayoritariamente buena 😊");
        } else if (promedio >= 4) {
            System.out.println("Semana regular 😐");
        } else {
            System.out.println("Semana difícil 😔");
        }
        sc.nextLine();
    }


    private static void ejercicio3(Scanner sc) {
        int negCount = 0;
        System.out.println("¿como te sientes hoy triste, aburrido, ansioso? (escribe 'salir' para terminar):");

        while (true) {
            String msg = sc.nextLine().toLowerCase();
            if (msg.equals("salir")) break;

            if (msg.contains("triste") || msg.contains("aburrido") || msg.contains("ansioso")) {
                negCount++;
            }

            if (negCount >= 3) {
                System.out.println("[ALERTA] Has enviado varios mensajes negativos. ¿Te gustaría contactar a un profesional?");
                negCount = 0;
            }
        }

        System.out.println("Gracias por compartir. ¡Cuídate!");
    }


    public static class EmotionDetector {
        public static Emotion detect(String texto) {
            String t = texto.toLowerCase();
            if (t.contains("triste") || t.contains("lloro")) {
                return Emotion.TRISTEZA;
            } else if (t.contains("enojo") || t.contains("molesto")) {
                return Emotion.ENOJO;
            } else if (t.contains("ansioso") || t.contains("nervioso")) {
                return Emotion.ANSIEDAD;
            } else if (t.contains("feliz") || t.contains("alegre")) {
                return Emotion.ALEGRIA;
            } else {
                return Emotion.NEUTRAL;
            }
        }
    }
}
