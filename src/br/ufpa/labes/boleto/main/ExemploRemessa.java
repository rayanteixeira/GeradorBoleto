package br.ufpa.labes.boleto.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.jrimum.bopepo.pdf.Files;
import org.jrimum.texgit.FlatFile;
import org.jrimum.texgit.Record;
import org.jrimum.texgit.Texgit;
import org.jrimum.utilix.ClassLoaders;

public class ExemploRemessa {
	public static void main(String[] args) throws IOException {

		File layoutTemporario = new File("LayoutRemessa_BBCNAB400.txg.xml");
		File layout = Files.bytesToFile(layoutTemporario, org.apache.commons.io.IOUtils
				.toByteArray(ClassLoaders.getResourceAsStream("/layoutBanco/LayoutRemessa_BBCNAB400.txg.xml")));

		FlatFile<Record> ff = Texgit.createFlatFile(layout);
		ff.addRecord(createHeader(ff));

		ff.addRecord(createTransacaoTitulos(ff));

		ff.addRecord(createTrailer(ff));

		Date dataGerado = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		
		FileUtils.writeLines(new File("resource/arquivoRemessa/"+"REMESSABB"+dateFormat.format(dataGerado)+".REM"), ff.write(), "\r\n");
		
		System.out.println("Arquivo gerado com sucesso: \nresource/arquivoRemessa/"+"REMESSABB"+dateFormat.format(dataGerado)+".REM");

		if (layoutTemporario != null) {
			layoutTemporario.delete();
		}
	}

	private static Record createHeader(FlatFile<Record> ff) {
		Record header = ff.createRecord("Header");

		header.setValue("IdentificacaoRegistro", 0);
		header.setValue("TipoOperacao", 1);
		header.setValue("IdentificacaoExtensoTipoOperacao", "REMESSA");
		header.setValue("IdentificacaoTipoServico", 1);
		header.setValue("IdentificacaoExtensoTipoServico", "COBRANCA");
		header.setValue("PrefixoAgencia", 1674);
		header.setValue("DigitoVerificadorAgencia", 8);
		header.setValue("NumeroContaCorrente", 333006);
		header.setValue("DigitoVerificadorContaCorrente", 0);
		header.setValue("NomeCedente", "FADESP");
		header.setValue("BB", "001BANCODOBRASIL");
		header.setValue("DataGravacao", 211217);
		header.setValue("SequencialRemessa", 0000000);
		header.setValue("NumeroConvencioLider", 2941653);
		header.setValue("SequencialRegistro", 1);

		return header;
	}

	private static Record createTransacaoTitulos(FlatFile<Record> ff) {
		Record transacaoTitulos = ff.createRecord("TransacaoTitulo");

		transacaoTitulos.setValue("IdentiFicacaoRegistroDetalhe", 7);
		transacaoTitulos.setValue("TipoInscricaoCedente", 01);
		transacaoTitulos.setValue("NumeroCpfCnpjCedente", "05572870000159");
		transacaoTitulos.setValue("PrefixoAgencia", 1674);
		transacaoTitulos.setValue("DigitoVerificadorAgencia", 8);
		transacaoTitulos.setValue("NumeroContaCorrenteCedente", 00333006);
		transacaoTitulos.setValue("DigitoVerificadorConta", 0);
		transacaoTitulos.setValue("NumeroCovenioCobrancaCedente", 2941653);
		transacaoTitulos.setValue("CodigoControleEmpresa", "");
		transacaoTitulos.setValue("NossoNumero", "29416530000036933");
		transacaoTitulos.setValue("NumeroPrestacao", 00);
		transacaoTitulos.setValue("GrupoValor", 00);
		transacaoTitulos.setValue("IndicativoMensagemSacador", "");
		transacaoTitulos.setValue("PrefixoTitulo", "   ");
		transacaoTitulos.setValue("VariacaoCarteira", "019");
		transacaoTitulos.setValue("ContaCaucao", 0);
		transacaoTitulos.setValue("NumeroBordero", 000000);
		transacaoTitulos.setValue("TipoCobranca", "     ");
		transacaoTitulos.setValue("CarteiraCobranca", 17);
		transacaoTitulos.setValue("Comando", 01);
		transacaoTitulos.setValue("NumeroTituloAtribuidoCedente", "          ");
		transacaoTitulos.setValue("DataVencimento", 121206);
		transacaoTitulos.setValue("ValorTitulo", 100);
		transacaoTitulos.setValue("NumeroBanco", 001);
		transacaoTitulos.setValue("PrefixoAgenciaCobradora", 0000);
		transacaoTitulos.setValue("DigitoVerificadorPrefixoAgenciaCobradora", " ");
		transacaoTitulos.setValue("EspecieTitulo", 99);
		transacaoTitulos.setValue("AceiteTitulo", "N");
		transacaoTitulos.setValue("DataEmissao", 121206);
		transacaoTitulos.setValue("InstrucaoCodificada", "  ");
		transacaoTitulos.setValue("InstrucaoCodificada", "  ");
		transacaoTitulos.setValue("JurosMoraDiaAtraso", "00000000003");
		transacaoTitulos.setValue("DataLimite", "      ");
		transacaoTitulos.setValue("ValorDesconto", "           ");
		transacaoTitulos.setValue("ValorIof", "           ");
		transacaoTitulos.setValue("ValorAbatimento", "           ");
		transacaoTitulos.setValue("TipoInscricaoSacado", 01);
		transacaoTitulos.setValue("NumeroCnpjCpfSacado", "05456456465");
		transacaoTitulos.setValue("NomeSacado", "MARCONI CESAR PEREIRA DA SILVA");
		transacaoTitulos.setValue("Complemento", "   ");
		transacaoTitulos.setValue("EnderecoSacado", "ENDERECO TESTE                          ");
		transacaoTitulos.setValue("BairroSacado", "SAO PEDRO   ");
		transacaoTitulos.setValue("CepEnderecoSacado", "12345678");
		transacaoTitulos.setValue("CidadeSacado", "CIDADE         ");
		transacaoTitulos.setValue("UfCidadeSacado", "PA");
		transacaoTitulos.setValue("Observacao", "                                        ");
		transacaoTitulos.setValue("NumeroDiasProtesto", "  ");
		transacaoTitulos.setValue("ComplementoRegistro", " ");
		transacaoTitulos.setValue("SequencialRegistro", "000001");

		return transacaoTitulos;
	}

	private static Record createTrailer(FlatFile<Record> ff) {
		Record trailer = ff.createRecord("Trailler");
		trailer.setValue("NumeroSequencialRegistro", 1212);
		return trailer;
	}
}
