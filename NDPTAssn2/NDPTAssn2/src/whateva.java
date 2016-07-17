import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import persistence.Team;
import antlr.collections.List;


public class whateva {

	private static Session dbSession;
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeagueService");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Team> teams = (ArrayList<Team>)em.createQuery("SELECT t FROM Team t ", Team.class).getResultList();
		for(Team t : teams){
			System.out.println(t.getTeamName());
		}
	}

}
