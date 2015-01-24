package br.com.xy.poi.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;

import br.com.caelum.vraptor.ioc.Component;
import br.com.xy.poi.service.controller.PoiController;
import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.repository.interfaces.IPoiRepository;

/**
 * @author Igor Emmanuel
 *
 *	Classe responsavel por responder as requisicoes vindas do {@link PoiController}.
 *
 */
@Component
public class PoiRepository extends Repository<Poi, Long> implements
		IPoiRepository {

	public PoiRepository(EntityManager entityManager) {
		super(entityManager);
	}

	public Poi cadastraPoi(Poi poi) {
		create(poi);
		
		return poi;
	}

	public List<Poi> buscaTodos() {
		return findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Poi> buscaPorCoordenadas(Integer x, Integer y, Integer raio) {
		List<Poi> result = new ArrayList<Poi>();
		
		String consulta = "SELECT * FROM poi.poi p WHERE sqrt(power((:x - p.coodx),2.0) + power((:y - p.coody),2.0)) < :raio ";
		SQLQuery query = session().createSQLQuery(consulta).addEntity(Poi.class);
		
		query.setParameter("x", x);
		query.setParameter("y", y);
		query.setParameter("raio", raio);
		
		result = query.list();
		
		return result;
	}


}
