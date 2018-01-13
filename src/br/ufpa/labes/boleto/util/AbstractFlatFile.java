package br.ufpa.labes.boleto.util;

import static org.apache.commons.lang.StringUtils.EMPTY;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jrimum.texgit.FlatFile;
import org.jrimum.texgit.Record;
import org.jrimum.texgit.Texgit;
import org.jrimum.utilix.ClassLoaders;
import org.jrimum.utilix.Collections;
import org.jrimum.utilix.Objects;
import org.jrimum.utilix.text.Strings;


public abstract class AbstractFlatFile{
	
	private String cfgFile;

	private FlatFile<Record> flatFile;

	protected AbstractFlatFile(String cfgFile) {

		init(cfgFile);
	}

	protected final void init(String cfgFile) {

		Strings.checkNotBlank(cfgFile, "Arquivo invalido!");
		
		this.cfgFile = cfgFile;

		configure();
	}

	protected final FlatFile<Record> getFlatFile() {
		
		return flatFile;
	}

	private void configure() {

		InputStream in = null;
		
		try {
			
			in = ClassLoaders.getResourceAsStream(cfgFile, this.getClass());
			
			File config = File.createTempFile(cfgFile, EMPTY);
			
			FileUtils.copyInputStreamToFile(in, config);
			
			flatFile = Texgit.createFlatFile(config);
			
		} catch (Exception e) {

			throw new IllegalStateException(e);
			
		}finally {

			if (in != null) {

				try {

					in.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		Objects.checkNotNull(flatFile, "NAO FOI POSSIVEL INICIALIZAR A LIB TEXGIT!");
	}
	
	@SuppressWarnings("unchecked")
	public <FF extends AbstractFlatFile> FF read(final List<String> lines) {

		Collections.checkNotEmpty(lines, "Linhas ausentes!");

		try {
			
			getFlatFile().read(lines);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (FF) this;
	}
	
	@SuppressWarnings("unchecked")
	public <FF extends AbstractFlatFile> FF read(final File file) {

		Objects.checkNotNull(file, "Arquivo TXT a ser importado nulo!");

		try {
			
			getFlatFile().read(FileUtils.readLines(file, "UTF-8"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (FF) this;
	}
	
	@SuppressWarnings("unchecked")
	public <FF extends AbstractFlatFile> FF read(final File file, String encoding) {

		Objects.checkNotNull(file, "Arquivo TXT a ser importado nulo!");
		Strings.checkNotBlank(encoding, "Encoding inválido!");

		try {
			
			getFlatFile().read(FileUtils.readLines(file, encoding));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return (FF) this;
	}

	public File write() throws IOException {
		
		Objects.checkNotNull(getFlatFile(), "Arquivo TXT a ser importado nulo!");

		File f = File.createTempFile(this.getClass().getName() + ""
				+ new Date().getTime(), "_jnfmtmp.txt");

		FileUtils.writeLines(f, getFlatFile().write());
		
		return f;
	}
	
	public File write(String encoding) throws IOException {
		
		if (getFlatFile() != null) {

			File f = File.createTempFile(this.getClass().getName() + ""
					+ new Date().getTime(), "_jnfmtmp.txt");

			FileUtils.writeLines(f, getFlatFile().write(), encoding);
			
			return f;

		} else{
			
			throw new IllegalArgumentException(new NullPointerException(
					"Arquivo TXT a ser importado nulo!"));
		}
	}
}
