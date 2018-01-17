package br.ufpa.labes.boleto.util;

import java.math.BigDecimal;
import java.util.Date;

import org.jrimum.texgit.Record;

public abstract class AbstractTransacaoDeTitulo {

	private Record transacao;
	
	public AbstractTransacaoDeTitulo(Record transacao) {

		if (transacao != null) {

			this.transacao = transacao;
	
		} else {
			throw new IllegalArgumentException("Transacao nula!");
		}
	}

	public final Record getTransacao() {

		return transacao;
	}

	public abstract String getNumeroControleDoParticipante();

	public abstract String getNossoNumeroComDigito();

	public abstract Integer getCarteira();

	public abstract Integer getCodigoDeOcorrencia();

	public abstract Date getDataDaOcorrencia();

	public abstract String getNumeroDoDocumento();

	public abstract BigDecimal getValor();
}
