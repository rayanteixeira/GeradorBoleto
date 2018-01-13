package br.ufpa.labes.boleto.main;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;

public class TesteGerarBoleto {

	public static void main(String[] args) {
		// Cedente
		Cedente cedente = new Cedente("FADESP - Fundação de Amparo e Desenvolvimento da Pesquisa", "10.687.566/0001-97");
		
		// Sacado
		Sacado sacado = new Sacado("Rayan Teixeira", "00864683243");
		
		// Endereï¿½o do sacado
		Endereco endereco = new Endereco();
		endereco.setUF(UnidadeFederativa.PA);
		endereco.setLocalidade("Ananindeua");
		endereco.setCep(new CEP("66645-000"));
		endereco.setBairro("AGUAS LINDAs");
		endereco.setLogradouro("BR 316 - KM 05");
		endereco.setNumero("1010");
		
		sacado.addEndereco(endereco);
		
		// Criando o tï¿½tulo
		ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_DO_BRASIL.create());
		contaBancaria.setAgencia(new Agencia(1674, "8"));
		contaBancaria.setNumeroDaConta(new NumeroDaConta(2941653));
		//contaBancaria.setNumeroDaConta(new NumeroDaConta(101739, "X"));
		//contaBancaria.setCarteira(new Carteira(17, TipoDeCobranca.COM_REGISTRO));
		contaBancaria.setCarteira(new Carteira(17));
		
		org.jrimum.domkee.financeiro.banco.febraban.Titulo titulo = new org.jrimum.domkee.financeiro.banco.febraban.Titulo(contaBancaria, sacado, cedente);
		titulo.setNumeroDoDocumento("0000000066");
		titulo.setNossoNumero("28588450000000066");
		titulo.setDigitoDoNossoNumero("7");
		
		titulo.setValor(BigDecimal.valueOf(100.00));
		titulo.setDataDoDocumento(new Date());
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 12, 27);
		titulo.setDataDoVencimento(calendar.getTime());
		
		titulo.setTipoDeDocumento(TipoDeTitulo.DS_DUPLICATA_DE_SERVICO);
		
		titulo.setAceite(Aceite.N);
		
		// Dados do boleto
		Boleto boleto = new Boleto(titulo);
		boleto.setLocalPagamento("Pagar preferencialmente no Banco do Brasil");
		boleto.setInstrucaoAoSacado("Evite multas, pague em dias suas contas.");
		
		boleto.setInstrucao1("Após o vencimento, aplicar multa de 2,00% e juros de 1,00% ao mês");
		
		BoletoViewer boletoViewer = new BoletoViewer(boleto);
		
		File arquivoPdf = boletoViewer.getPdfAsFile("resource/boletoBB.pdf");
		 mostreBoletoNaTela(arquivoPdf);
	}
	
	private static void mostreBoletoNaTela(File arquivoBoleto) {

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        
        try {
                desktop.open(arquivoBoleto);
        } catch (IOException e) {
                e.printStackTrace();
        }
}

}
