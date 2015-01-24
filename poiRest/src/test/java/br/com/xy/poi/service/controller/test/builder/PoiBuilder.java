package br.com.xy.poi.service.controller.test.builder;

import br.com.xy.poi.service.entity.*;


/**
 * @author Igor Emmanuel
 *	
 * Classe responsavel por construir um objeto {@link Poi} para ser usado em testes
 */
public class PoiBuilder {

	
	public PoiBuilder(){
		
	}
	
	public static Poi construir(){
		Poi poi = new Poi();
		
		poi.setNome("Nome Padr�o POI");
		poi.setCoodx(20);
		poi.setCoody(10);
		
		return poi;
	}
}
