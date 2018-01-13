package br.ufpa.labes.boleto.retorno;

import java.math.BigDecimal;

import org.jrimum.texgit.Record;

public class Sumario {

	
	private Record trailler;

	public Sumario(Record trailler) {
		if (trailler != null) {
			this.trailler = trailler;
		} else {
			throw new IllegalArgumentException("Trailler nulo!");
		}
	}

	public Integer getValorFixoTrailer1() {
		return trailler.getValue("ValorFixoTrailer1");
	}
	public Integer getValorFixoTrailer2() {
		return trailler.getValue("ValorFixoTrailer2");
	}
	public Integer getValorFixoTrailer3() {
		return trailler.getValue("ValorFixoTrailer3");
	}
	public Integer getCobrancaSimplesQuantidadeTitulos() {
		return trailler.getValue("CobrancaSimplesQuantidadeTitulos");
	}

	public BigDecimal getCobrancaSimplesValorTotal() {
		return trailler.getValue("CobrancaSimplesValorTotal");
	}

	public Integer geNumeroContaCorrenteCedente() {
		return trailler.getValue("CobrancaSimplesNumeroDoAviso");
	}

	public Integer getDigitoVerificadorConta() {
		return trailler.getValue("CobrancaVinculadaQuantidadeTitulos");
	}

	public BigDecimal getNumeroCovenioCobrancaCedente() {
		return trailler.getValue("CobrancaVinculadaValorTotal");
	}

	public Integer getNumeroControleParticipante() {
		return trailler.getValue("CobrancaVinculadaNumeroDoAviso");
	}

	public Integer getNossoNumero() {
		return trailler.getValue("CobrancaCaucionadaQuantidadeTitulos");
	}

	public BigDecimal getTipoCobranca() {
		return trailler.getValue("CobrancaCaucionadaValorTotal");
	}

	public Integer getTipoCobrancaEspecifico() {
		return trailler.getValue("CobrancaCaucionadaNumeroDoAviso");
	}

	public Integer getDiasParaCalculo() {
		return trailler.getValue("CobrancaDescontadaQuantidadeTitulos");
	}

	public Integer getNaturezaRecebimento() {
		return trailler.getValue("NaturezaRecebimento");
	}

	public BigDecimal getPrefixoTitulo() {
		return trailler.getValue("CobrancaDescontadaValorTotal");
	}

	public Integer getVariacaoCarteira() {
		return trailler.getValue("CobrancaDescontadaNumeroDoAviso");
	}

	public Integer getContaCaucao() {
		return trailler.getValue("CobrancaVendorQuantidadeTitulos");
	}

	public BigDecimal getTaxaParaDesconto() {
		return trailler.getValue("CobrancaVendorValorTotal");
	}

	public Integer getTaxaIOF() {
		return trailler.getValue("CobrancaVendorNumeroDoAviso");
	}

	public Integer getCarteiraCobranca() {
		return trailler.getValue("SequencialDoRegistro");
	}
	
		
	
}