import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
    public static File run() throws IOException {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(".txt", "txt");

        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.addChoosableFileFilter(extensionFilter);

        int isOptionApproved = jFileChooser.showOpenDialog(null);

        if (isOptionApproved == JFileChooser.APPROVE_OPTION)
            return jFileChooser.getSelectedFile();

        throw new IOException("Não foi possível abrir o arquivo.");

    }
}
