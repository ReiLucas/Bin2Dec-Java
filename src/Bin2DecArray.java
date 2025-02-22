import java.util.Scanner;

public class Bin2DecArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número binário (até 8 dígitos): ");
        String input = scanner.nextLine().trim();
        
        // Verifica se o número de dígitos excede 8
        if (input.length() > 8) {
            System.out.println("Erro: O número deve ter no máximo 8 dígitos.");
            scanner.close();
            return;
        }
        
        // Converte a string em array
        char[] digitos = input.toCharArray();
        
        // Array para armazenar os dígitos convertidos (0 ou 1)
        int[] binario = new int[digitos.length];
        
        // Validação e conversão dos dígitos
        for (int i = 0; i < digitos.length; i++) {
            if (digitos[i] != '0' && digitos[i] != '1') {
                System.out.println("Erro: Apenas dígitos 0 e 1 são permitidos.");
                scanner.close();
                return;
            }
            binario[i] = digitos[i] - '0';
        }
        
        int decimal = 0;
        // Percorre o array, calculando decimal
        // O dígito mais à direita (índice final) corresponde à potência 0
        for (int i = 0; i < binario.length; i++) {
            // Calcula contando da direita para a esquerda
            int posicao = binario.length - 1 - i;
            // Calcula posicao
            int potencia = (int)Math.round(Math.exp(posicao * Math.log(2)));
            decimal += binario[i] * potencia;
        }
        
        System.out.println("Decimal: " + decimal);
        scanner.close();
    }
}