package br.com.xy.poi.service.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.xy.poi.service.controller.PoiController;
import br.com.xy.poi.service.controller.test.builder.PoiBuilder;
import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.exception.CampoObrigatorioNaoInformadoException;
import br.com.xy.poi.service.exception.InformacaoInvalidaException;

/**
 * @author Igor Emmanuel
 *
 *	Classe que implementa os testes unitarios dos metodos do {@link PoiController}
 *
 */
public class PoiControllerTest {
	
	private Poi poi;
	private Logger log = LoggerFactory.getLogger(getClass());
	
    public PoiController poiController = new PoiController(null);
    
    
    @Before
    public void init(){
    	poi = PoiBuilder.construir();
        poi.setId(System.currentTimeMillis());
    	
    }
    
    @Test(expected = CampoObrigatorioNaoInformadoException.class)
    public void testarSalvarCampoObrigatorioException() throws CampoObrigatorioNaoInformadoException, InformacaoInvalidaException, Exception{
    	
    	log.info("Rodando - testarSalvarCampoObrigatorioException()");
    	
    	poi.setCoodx(null);
    	
    	poiController.salvar(poi);
    }
    
    @Test(expected = InformacaoInvalidaException.class)
    public void testarSalvarInformacaoInvalidaException() throws CampoObrigatorioNaoInformadoException, InformacaoInvalidaException, Exception{
    	
    	log.info("Rodando - testarSalvarInformacaoInvalidaException()");
    	
    	poi.setCoodx(-8);
    	
    	poiController.salvar(poi);
    }
    
    @Test(expected = InformacaoInvalidaException.class)
    public void testarBuscarPOIInformacaoInvalidaException() throws InformacaoInvalidaException, Exception {
    	
    	log.info("Rodando - testarBuscarPOIInformacaoInvalidaException()");
    	
    	poiController.buscaPorCoordenadas(poi, -10);
    }
    
    
}
