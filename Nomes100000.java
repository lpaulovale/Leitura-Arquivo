/* O programa a seguir guarda todos os nomes dentro do arquivo nome.txt em uma matriz
, e após isso o programa procura pelo nome digitado nessa matriz
, se o nome digitado for encontrado o programa termina. */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Nomes100000 {
	public static void main(String[] input) {
		String fname, nome;// Variaveis para guarda strings digitadas
		int x = 0; // contagem de nomes já lidos
		List<String> list1 = new ArrayList<>(); // lista de strings

		Scanner scan = new Scanner(System.in);

		System.out.print("Escreva o nome do local (com o nome do arquivo) : ");
		fname = scan.nextLine();
		System.out.print("Digite o nome a encontrar no arquivo : ");
		nome = scan.next();

		String line = null;
		try {
			/* FileReader lê caracteres de arquivos para caracteres */
			FileReader fileReader = new FileReader(fname);

			/* cria um buffer para receber caracteres de tamanho padrão */
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				x++;
				list1.add(line);
				if (x == 100000) {
					break;
				}
			}
//Escreve na tela todas as vezes que o nome digitado aparece na matriz e o tempo de processamento
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).equals(nome) == true) {
					System.out.println(nome + "\nTempo de execução em milisegundos : " + System.currentTimeMillis());
				}
			}
			/* fechar arquivo após uso */
			bufferedReader.close();
		} catch (IOException ex) {
			System.out.println("Erro lendo arquivo nomeado de '" + fname + "'");
		}
	}

}