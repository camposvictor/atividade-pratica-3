package arvoreBinariaApp;

public class App {
	BST st;
	public static void main() throws Exception {

	}

public void emOrdem(){
System.out.print("ORDEM - ");
st.inOrder();
}
public void preOrdem() {
System.out.print("\nPRÉ-ORDEM - ");
st.preOrder();

}
public void posOrdem() {
System.out.print("\nPÓS-ORDEM - ");
st.postOrder();
}
public void altura() {
System.out.print("\nALTURA - " + st.height());
}
public void tamanhoDoCaminhoInterno() {
System.out.print("\nTAMANHO_DO_CAMINHO_INTERNO - " + st.getInternalPathLenght());
}}