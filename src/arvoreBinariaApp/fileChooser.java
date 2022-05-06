package arvoreBinariaApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author BLSoft
 */
public class fileChooser {
    public static BST<String, Integer> run() throws IOException{
    	BST<String, Integer> st = new BST<String, Integer>();
        JFileChooser jFileChooser = new JFileChooser();
        File arquivoSelecionado = null;
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apenas .txt", "txt");
        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.addChoosableFileFilter(filtro);

        int respostDoFileChooser = jFileChooser.showOpenDialog(null);

        if(respostDoFileChooser == JFileChooser.APPROVE_OPTION){
            arquivoSelecionado = jFileChooser.getSelectedFile();
            System.out.println(arquivoSelecionado.getAbsolutePath());
        }else{
            System.out.println("Nenhum arquivo Selecionado");
        }
		FileReader file = null;
		BufferedReader reader = null;
		file = new FileReader(arquivoSelecionado.getPath());
		reader = new BufferedReader(file);			
		String line = reader.readLine();
		int key = 0;
		while (line != null) {
			st.put(line, key++);
			line = reader.readLine();
		 }
		return st;
    }
}
