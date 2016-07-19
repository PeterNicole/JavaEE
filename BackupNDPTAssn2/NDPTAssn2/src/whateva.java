import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import persistence.*;
import antlr.collections.List;


public class whateva {

	private static Session dbSession;
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("leagueDB");
		EntityManager em = emf.createEntityManager();
		LeagueDAO ldao = new LeagueDAO(em);
		ArrayList<Player> players = ldao.getPlayers("CAN002");
		for(Player p : players){
			System.out.println(p.getFirstName() + " " + p.getLastName());
		}
	}

}
