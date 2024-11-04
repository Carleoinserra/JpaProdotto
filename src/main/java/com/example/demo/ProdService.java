package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
public class ProdService {
	
	private EntityManagerFactory entityManagerFactory;

	
	public ProdService() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
		
		
	}
	
	// Iniezione dell'EntityManager
    @PersistenceContext
    private EntityManager entityManager;
    
 // Metodo per creare un nuovo utente e salvarlo nel database
    @Transactional
    public void createProd(String nome, String marca, int prezzo, String url) {
        // Crea un nuovo oggetto Dip con i parametri forniti
        Prodotto p1 = new Prodotto();
        p1.setNome(nome);
       p1.setMarca(marca);
       p1.setPrezzo(prezzo);
       p1.setUrl(url);
        
        // Salva l'oggetto Dip nel contesto di persistenza (lo rende gestito)
        entityManager.persist(p1);
    }
    
    @Transactional
    public ArrayList<Prodotto> getAllProd() {
        
    	List <Prodotto> lista = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class).getResultList();
    	
    	// cast da lista a arraylist
    	ArrayList <Prodotto> listaP =  (ArrayList<Prodotto>) lista;
    	
    	return listaP;
    }
    
    @Transactional
    public void updatePrezzo(String nome, int prezzo) {
    	
List <Prodotto> lista = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class).getResultList();
    	
    	// cast da lista a arraylist
    	ArrayList <Prodotto> listaP =  (ArrayList<Prodotto>) lista;
    	
    	for (Prodotto p1: listaP) {
    		
    		if (p1.getNome().equalsIgnoreCase(nome)) {
    			
    			p1.setPrezzo(prezzo);
    			entityManager.persist(p1);
    		}
    	}
    }
    	  @Transactional
  	    public void deleteProd(String nome) {
  	    	
  	    	
  	    	
  	    	// Uso del parametro posizionale ?1 per impostare il valore del nome
  	        entityManager.createQuery("DELETE FROM Prodotto p WHERE p.nome = ?1")
  	                     .setParameter(1, nome)  // Setta il parametro posizionale ?1
  	                     .executeUpdate();

  	        
  	    
    	
    	
    }



}
