package br.ufpa.labes.boleto.retorno;

import static org.jrimum.utilix.Collections.checkNotEmpty;
import static org.jrimum.utilix.Collections.hasElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jrimum.texgit.Record;
import br.ufpa.labes.boleto.util.AbstractFlatFile;


public class ArquivoRetorno extends AbstractFlatFile{

	
	private Protocolo protocolo;
	
	private List<TransacaoDeTitulo> transacoes;

	private Sumario sumario;
	
	private static final String LAYOUT = "/layoutBanco/LayoutRetorno_BBCNAB400.txg.xml"; // lê da raiz da pasta resource
	
	private ArquivoRetorno(){
		super(LAYOUT);
	}
	
	private ArquivoRetorno(String cfgFile) {
		super(cfgFile);
	}
	
	public static ArquivoRetorno newInstance(List<String> lines) {
		
		checkNotEmpty(lines, "Linhas ausentes!");

		ArquivoRetorno ff = new ArquivoRetorno();
		
		ff.read(lines);
		
		ff.loadInfo();
		
		return ff;

	}

	public Protocolo getProtocolo() {
		return protocolo;
	}

	public Sumario getSumario() {

		return sumario;
	}

	public List<TransacaoDeTitulo> getTransacoes() {

		return transacoes;
	}

	private void loadInfo() {

		this.protocolo = new Protocolo(getFlatFile().getRecord("Header"));
		
		this.sumario = new Sumario(getFlatFile().getRecord("Trailler"));
		
		Collection<Record> registrosDeTransacoes = getFlatFile().getRecords("TransacaoTitulo");

		if (hasElement(registrosDeTransacoes)) {
			ArrayList<TransacaoDeTitulo> transacoes = new ArrayList<TransacaoDeTitulo>(registrosDeTransacoes.size());
			for (Record registro : registrosDeTransacoes) {
				try {
					transacoes.add(new TransacaoDeTitulo(registro));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.transacoes = transacoes;
		}
	}

}
