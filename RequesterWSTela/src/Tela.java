import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.EstoqueBOStub;
import br.com.fiap.bo.EstoqueBOStub.Camiseta;
import br.com.fiap.bo.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.bo.EstoqueBOStub.ConsultaProdutoResponse;

public class Tela {

	protected Shell shell;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(71, 25, 76, 21);

		Label text = new Label(shell, SWT.NONE);
		text.setBounds(10, 28, 55, 15);
		text.setText("Codigo:");

		Label lblCodigo = new Label(shell, SWT.NONE);
		lblCodigo.setBounds(40, 152, 107, 15);
		lblCodigo.setText("Codigo");

		Label lblDescricao = new Label(shell, SWT.NONE);
		lblDescricao.setBounds(40, 181, 100, 15);
		lblDescricao.setText("Descricao");

		Label lblPreco = new Label(shell, SWT.NONE);
		lblPreco.setBounds(227, 181, 76, 15);
		lblPreco.setText("Preco");

		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(227, 152, 89, 15);
		lblQuantidade.setText("Quantidade");
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Code

				int codigo = Integer.parseInt(txtCodigo.getText());

				Camiseta camiseta = new Camiseta();

				try {

					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultaProduto consulta = new ConsultaProduto();

					consulta.setCodigo(codigo);

					ConsultaProdutoResponse response = stub.consultaProduto(consulta);


					camiseta = response.get_return();

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				lblCodigo.setText(Integer.toString(camiseta.getCodigo()));
				lblDescricao.setText(camiseta.getDesc());
				lblPreco.setText(Double.toString(camiseta.getPreco()));
				lblQuantidade.setText(Integer.toString(camiseta.getQtde()));
			}
		});
		btnPesquisar.setBounds(72, 66, 75, 25);
		btnPesquisar.setText("Pesquisar");


	}

}
