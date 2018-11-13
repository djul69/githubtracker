package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@InJpa
@Dependent

public class JPAGithuberDAO implements GithuberDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Githuber> getGithubers() {
        TypedQuery<Githuber> query = em.createQuery("select c from Githuber c", Githuber.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveGithuber(Githuber githuber) {
        try {
            em.persist(githuber);
        } catch (Exception e) {
            throw new RuntimeException("Erreur : ce login Github n'existe pas ou le site ne répond pas", e);
        }
    }

    @Override
    @Transactional
    public void deleteGithuber(int id_githuber) {
        try {
            em.createQuery("delete from Githuber c where c.id=" + id_githuber).executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erreur : cet Id github n'est pas dans la base de donnée!", e);
        }
    }
}



