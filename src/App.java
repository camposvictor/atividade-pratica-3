import java.io.*;

public class App {

	public static void main(String[] args) throws Exception {
		BST<String, Integer> st = new BST<String, Integer>();
		
		FileReader file = null;
		BufferedReader reader = null;
		
		try {
			file = new FileReader("./example.txt");
			reader = new BufferedReader(file);			
		} catch(Exception e) {
			System.out.println("Não foi possível abrir o arquivo");
		}

		String line = reader.readLine();
		int key = 0;
		
		while (line != null) {
			st.put(line, key++);
			line = reader.readLine();
		 }

		System.out.print("ORDEM - ");
		st.inOrder();
		System.out.print("\nPRÉ-ORDEM - ");
		st.preOrder();
		System.out.print("\nPÓS-ORDEM - ");
		st.postOrder();
	}
}
