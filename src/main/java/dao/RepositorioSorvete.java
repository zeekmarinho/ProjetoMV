package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Sorvete;
import util.JpaUtil;

public class RepositorioSorvete implements IRepositorioSorvete {

	//Inserir sorvete na lista
	public boolean inserirSorvete(Sorvete sorvete) {
		
		EntityManager ent = JpaUtil.getEntityManager();	
		EntityTransaction ts = ent.getTransaction();
		
    	ts.begin();
    	ent.persist(sorvete);
    	ts.commit();
    	ent.close();		
    	
    	return true;
		
	}

	//Remover sorvete da lista
	public void deletarSorvete(String nome) {
		
		/* METODO PASSANDO O OBJETO COMO REFERENCIA */
	//	EntityManager ent = JpaUtil.getEntityManager();
	//	EntityTransaction tx = ent.getTransaction();		
	//	Sorvete existe = ent.find(Sorvete.class, sorvete.getNome());		
	//	tx.begin();		
	//	if(existe != null) {
	//		ent.remove(existe);
	//		tx.commit();
	//		ent.close();
	//		System.out.println("Sorvete Removido");
	//	}else {
	//		System.out.println("Sorvete Não Cadastrado");
	//	}				
		
		/* METODO PASSANDO CHAVE PRIMÁRIA COMO REFERENCIA */
		EntityManager ent = JpaUtil.getEntityManager();
		Sorvete sorvete = ent.find(Sorvete.class, nome);		
		try {
			ent.getTransaction().begin();
			ent.remove(sorvete);
			ent.getTransaction().commit();
		} finally {
			ent.close();
		}		
	}

	//Listar Sorvetes
	public List<Sorvete> listaSorvetes() {
		
		String sql = "from Sorvete s";
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery(sql);
		List<Sorvete> listaSorvetes = query.getResultList();
		ent.close();
		
		return listaSorvetes;
	}

}
