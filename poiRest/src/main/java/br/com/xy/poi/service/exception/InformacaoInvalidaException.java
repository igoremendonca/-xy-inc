package br.com.xy.poi.service.exception;

import java.util.List;

import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.util.CampoUtil;

/**
 * @author Igor Emmanuel
 *
 * Classe que implementa excecoes que sao lancadas quando metodos de validacao identificam informacoes invalidas em objetos {@link Poi}.
 */
public class InformacaoInvalidaException extends PoiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 201501212130L;
	
private String mensagem;
	
	public InformacaoInvalidaException(String mensagem,
			List<CampoUtil> campos) {
		super(campos);
		this.mensagem = mensagem;
	}

	public String retornaMensagemErroFormatada(){
		StringBuilder mensagem = new StringBuilder();
		
		mensagem.append(this.mensagem);
		
		for (CampoUtil campoUtil : super.getCampos()) {
			mensagem.append(campoUtil.getNome());
			mensagem.append(",");
		}
		
		mensagem.setLength(mensagem.length() - 1);
		
		return mensagem.toString();
	}



}
