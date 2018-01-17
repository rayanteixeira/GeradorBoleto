package br.ufpa.labes.boleto.retorno;

import java.util.Date;

import org.jrimum.texgit.Record;

public class Protocolo {

	private Record header;

	public Protocolo(Record header) {
		if (header != null) {
			this.header = header;
		} else {
			throw new IllegalArgumentException("Header nulo!");
		}
	}

	public Integer getTipoOperacao() {
		return header.getValue("TipoOperacao");
	}

	public String getIdentificacaoTipoOperacao() {
		return header.getValue("IdentificacaoTipoOperacao");
	}

	public Integer getIdentificacaoTipoServico() {
		return header.getValue("IdentificacaoTipoServico");
	}

	public String getIdentificacaoExtensoTipoServico() {
		return header.getValue("IdentificacaoExtensoTipoServico");
	}

	public String getComplementoRegistro() {
		return header.getValue("ComplementoRegistro");
	}

	public Integer getPrefixoAgencia() {
		return header.getValue("PrefixoAgencia");
	}

	public String getDigitoVerificadorAgencia() {
		return header.getValue("DigitoVerificadorAgencia");
	}

	public Integer getNumeroContaCorrente() {
		return header.getValue("NumeroContaCorrente");
	}

	public String getDigitoVerificadorContaCorrenteo() {
		return header.getValue("DigitoVerificadorContaCorrente");
	}

	public String getNomeCedente() {
		return header.getValue("NomeCedente");
	}
	
	
	public String getBB() {
		return header.getValue("BB");
	}
	
	
	public Date getDataGravacao() {
		return header.getValue("DataGravacao");
	}
	
	
	public Integer getSequencialRetorno() {
		return header.getValue("SequencialRetorno");
	}
	
	
	public Integer getNumeroConvencio() {
		return header.getValue("NumeroConvencio");
	}
	
	public Integer getSequencialRegistro() {
		return header.getValue("NumeroSequencialRegistro");
	}
	


}