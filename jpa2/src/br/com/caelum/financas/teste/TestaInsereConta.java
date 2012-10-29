package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {
	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager entityManager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Conta gravada com sucesso!");
		long fim = System.currentTimeMillis();
		System.out.println("Executado em:"+(fim - inicio));
	}
}
