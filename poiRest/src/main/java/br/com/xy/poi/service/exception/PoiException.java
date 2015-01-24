package br.com.xy.poi.service.exception;

import java.util.List;

import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.util.CampoUtil;

/**
 * @author Igor Emmanuel
 *
 *	Classe que implementa excecoes referentes a objetos {@link Poi}.
 */
public class PoiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 201501221513L;

	private List<CampoUtil> campos;
	
	public PoiException(String mensagem, List<CampoUtil> campos) {
		super();
		this.campos = campos;
	}
	
	public PoiException(List<CampoUtil> campos){
		this.campos = campos;
	}

	public List<CampoUtil> getCampos() {
		return campos;
	}

	public void setCampos(List<CampoUtil> campos) {
		this.campos = campos;
	}
	
	
	
}
