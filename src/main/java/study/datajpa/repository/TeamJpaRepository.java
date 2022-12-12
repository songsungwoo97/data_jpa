package study.datajpa.repository;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamJpaRepository {

    private final EntityManager em;

    @Transactional
    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    @Transactional
    public void delete(Team team) {em.remove(team);}

    public long count() {
        return em.createQuery("select count(t) from Team t", Long.class).getSingleResult();
    }

    public List<Team> findAll() {
        return em.createQuery("select t from Team t", Team.class).getResultList();
    }

    public Optional<Team> findById(Long id) {
        Team team = em.find(Team.class, id);

        return Optional.ofNullable(team);
    }


}
