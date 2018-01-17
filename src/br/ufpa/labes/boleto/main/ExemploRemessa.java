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
		header.setValue("NumeroContaCorrente", 101912);
		header.setValue("DigitoVerificadorContaCorrente", 0);
		header.setValue("NomeCedente", "FADESP");
		header.setValue("BB", "001BANCO DO BRASIL");
		header.setValue("DataGravacao", 160118);
		header.setValue("SequencialRemessa", "0000000");
		header.setValue("NumeroConvenioLider", 2866935);
		header.setValue("SequencialRegistro", 1);

		return header;
	}

	private static Record createTransacaoTitulos(FlatFile<Record> ff) {
		Record transacaoTitulos = ff.createRecord("TransacaoTitulo");

		transacaoTitulos.setValue("IdentiFicacaoRegistroDetalhe", 7);
		transacaoTitulos.setValue("TipoInscricaoCedente", 02);
		transacaoTitulos.setValue("NumeroCpfCnpjCedente", "05572870000159");
		transacaoTitulos.setValue("PrefixoAgencia", 1674);
		transacaoTitulos.setValue("DigitoVerificadorAgencia", 8);
		transacaoTitulos.setValue("NumeroContaCorrenteCedente", 101912);
		transacaoTitulos.setValue("DigitoVerificadorConta", 0);
		transacaoTitulos.setValue("NumeroCovenioCobrancaCedente", 2866935);
		//transacaoTitulos.setValue("CodigoControleEmpresa", "");
		transacaoTitulos.setValue("NossoNumero", "28669350000000003");
		transacaoTitulos.setValue("NumeroPrestacao", 00);
		transacaoTitulos.setValue("GrupoValor", 00);
		//transacaoTitulos.setValue("IndicativoMensagemSacador", "");
		//transacaoTitulos.setValue("PrefixoTitulo", "   ");
		transacaoTitulos.setValue("VariacaoCarteira", "019");
		transacaoTitulos.setValue("ContaCaucao", 0);
		transacaoTitulos.setValue("NumeroBordero", 000000);
		//transacaoTitulos.setValue("TipoCobranca", "     ");
		transacaoTitulos.setValue("CarteiraCobranca", 17);
		transacaoTitulos.setValue("Comando", 01);
		//transacaoTitulos.setValue("NumeroTituloAtribuidoCedente", "          ");
		transacaoTitulos.setValue("DataVencimento", "180118");
		transacaoTitulos.setValue("ValorTitulo", 1);
		transacaoTitulos.setValue("NumeroBanco", 001);
		transacaoTitulos.setValue("PrefixoAgenciaCobradora", 0000);
		//transacaoTitulos.setValue("DigitoVerificadorPrefixoAgenciaCobradora", " ");
		transacaoTitulos.setValue("EspecieTitulo", 12);
		transacaoTitulos.setValue("AceiteTitulo", "N");
		transacaoTitulos.setValue("DataEmissao", 160118);
		//transacaoTitulos.setValue("InstrucaoCodificada", "  ");
		//transacaoTitulos.setValue("InstrucaoCodificada", "  ");
		transacaoTitulos.setValue("JurosMoraDiaAtraso", "00000000003");
		//transacaoTitulos.setValue("DataLimite", "      ");
		//transacaoTitulos.setValue("ValorDesconto", "           ");
		//transacaoTitulos.setValue("ValorIof", "           ");
		//transacaoTitulos.setValue("ValorAbatimento", "           ");
		transacaoTitulos.setValue("TipoInscricaoSacado", 01);
		transacaoTitulos.setValue("NumeroCnpjCpfSacado", "00299967247");
		transacaoTitulos.setValue("NomeSacado", "FRANCISCO DEMARIM DE AGUIAR JUNIOR");
		//transacaoTitulos.setValue("ComplementoRegistro", "");
		transacaoTitulos.setValue("EnderecoSacado", "Rua Augusto Corrêa, LABES");
		transacaoTitulos.setValue("BairroSacado", "Guamá");
		transacaoTitulos.setValue("CepEnderecoSacado", "66075110");
		transacaoTitulos.setValue("CidadeSacado", "BELÉM");
		transacaoTitulos.setValue("UfCidadeSacado", "PA");
		//transacaoTitulos.setValue("Observacao", "                                        ");
		//transacaoTitulos.setValue("NumeroDiasProtesto", "  ");
		//transacaoTitulos.setValue("ComplementoRegistro", " ");
		transacaoTitulos.setValue("SequencialRegistro", "3");

		return transacaoTitulos;
	}

	private static Record createTrailer(FlatFile<Record> ff) {
		Record trailer = ff.createRecord("Trailler");
		trailer.setValue("NumeroSequencialRegistro", 3);
		return trailer;
	}
}
