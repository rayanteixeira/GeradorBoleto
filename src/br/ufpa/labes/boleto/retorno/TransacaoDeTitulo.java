package br.ufpa.labes.boleto.retorno;

import java.math.BigDecimal;
import java.util.Date;
import org.jrimum.texgit.Record;

public class TransacaoDeTitulo{
		
	
	private Record registro;
	
	
	public TransacaoDeTitulo(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de transação não foi informado.");
		}
	}

	
	public Integer getPrefixoAgencia() {

		return registro.getValue("PrefixoAgencia");
	}

	public String getDigitoVerificadorAgencia() {

		return registro.getValue("DigitoVerificadorAgencia");
	}

	public Integer getNumeroContaCorrenteCedente() {

		return registro.getValue("NumeroContaCorrenteCedente");
	}

	public String getDigitoVerificadorContaCorrente() {

		return registro.getValue("DigitoVerificadorContaCorrente");
	}

	public Integer getNumeroConvenioCobrancaCedente() {

		return registro.getValue("NumeroConvenioCobrancaCedente");
	}
	
	public String getNumeroControleParticipante() {

		return registro.getValue("NumeroControleParticipante");
	}

	public String getNossoNumero() {

		return registro.getValue("NossoNumero");
	}

	public Integer getTipoCobranca() {

		return registro.getValue("TipoCobranca");
	}

	public Integer getTipoCobrancaEspecifico() {

		return registro.getValue("TipoCobrancaEspecifico");
	}

	public Integer getDiasParaCalculo() {

		return registro.getValue("DiasParaCalculo");
	}

	public Integer getNaturezaRecebimento() {

		return registro.getValue("NaturezaRecebimento");
	}

	public String getPrefixoTitulo() {

		return registro.getValue("PrefixoTitulo");
	}

	public Integer getVariacaoCarteira() {

		return registro.getValue("VariacaoCarteira");
	}

	public Integer getContaCaucao() {

		return registro.getValue("ContaCaucao");
	}

	public BigDecimal getTaxaParaDesconto() {

		return registro.getValue("TaxaParaDesconto");
	}

	public BigDecimal getTaxaIOF() {

		return registro.getValue("TaxaIOF");
	}

	public Integer getCarteiraCobranca() {

		return registro.getValue("CarteiraCobranca");
	}

	public Integer getComando() {

		return registro.getValue("Comando");
	}

	public Date getDataLiquidacao() {

		return registro.getValue("DataLiquidacao");
	}

	public String getNumeroTituloDadoPeloCedente() {

		return registro.getValue("NumeroTituloDadoPeloCedente");
	}

	public Date getDataVencimento() {

		return registro.getValue("DataVencimento");
	}

	public BigDecimal getValorTitulo() {

		return registro.getValue("ValorTitulo");
	}

	public Integer getCodigoDoBancoRecebedor() {

		return registro.getValue("CodigoDoBancoRecebedor");
	}

	public Integer getPrefixoAgenciaRecebedora() {

		return registro.getValue("PrefixoAgenciaRecebedora");
	}

	public String getDigitoVerificadorPrefixoAgenciaRecebedora() {

		return registro.getValue("DigitoVerificadorPrefixoAgenciaRecebedora");
	}

	public Integer getEspecieTitulo() {

		return registro.getValue("EspecieTitulo");
	}

	public Date getDataCredito() {

		return registro.getValue("DataCredito");
	}

	public BigDecimal getValorTarifa() {

		return registro.getValue("ValorTarifa");
	}

	public BigDecimal getOutrasDespesas() {

		return registro.getValue("OutrasDespesas");
	}

	public BigDecimal getJurosDesconto() {

		return registro.getValue("JurosDesconto");
	}

	public BigDecimal getIOFDesconto() {

		return registro.getValue("IOFDesconto");
	}

	public BigDecimal getValorAbatimento() {

		return registro.getValue("ValorAbatimento");
	}

	public BigDecimal getDescontoConcedido() {

		return registro.getValue("DescontoConcedido");
	}

	public BigDecimal getValorRecebido() {

		return registro.getValue("ValorRecebido");
	}

	public BigDecimal getJurosDeMora() {

		return registro.getValue("JurosDeMora");
	}
	
	
	public BigDecimal getOutrosRecebimentos() {

		return registro.getValue("OutrosRecebimentos");
	}

	public BigDecimal getAbatimentoNaoAproveitadoPeloSacado() {

		return registro.getValue("AbatimentoNaoAproveitadoPeloSacado");
	}

	public BigDecimal getValorLancamento() {

		return registro.getValue("ValorLancamento");
	}

	public Integer getIndicativoDeDebitoCredito() {

		return registro.getValue("IndicativoDeDebitoCredito");
	}

	public Integer getIndicadorDeValor() {

		return registro.getValue("IndicadorDeValor");
	}

	public BigDecimal getValorDoAjuste() {

		return registro.getValue("ValorDoAjuste");
	}

	public Integer getIndicativoDeAutorizacaoLiquidacaoParcial() {

		return registro.getValue("IndicativoDeAutorizacaoLiquidacaoParcial");
	}
	
	public Integer getCanalDePagementoDoTituloUtilizadoPeloSacado() {

		return registro.getValue("CanalDePagementoDoTituloUtilizadoPeloSacado");
	}

	public Integer getSequencialRegistro() {

		return registro.getValue("SequencialRegistro");
	}

}
