package com.example.IMDB.dao;

import com.example.IMDB.entity.*;
import com.example.IMDB.filter.Filter;
import com.example.IMDB.model.Pageable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class OrganizationDaoImplementation implements OrganizationDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Movie saveMovie(Movie movie) {
        movie = entityManager.merge(movie);
        return movie;
    }

    @Override
    @Transactional
    public Boolean isExists(String movieTitleToCheck) {
        String queryString =
                "SELECT COUNT(m) FROM Movie m WHERE m.movieTitle = :movieTitle AND m.deleted=false";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("movieTitle", movieTitleToCheck);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    @Transactional
    @Override
    public Actor saveActor(Actor actor) {
        actor = entityManager.merge(actor);
        return actor;
    }

    @Transactional
    @Override
    public Director saveDirector(Director director) {
        director = entityManager.merge(director);
        return director;
    }


    @Transactional
    @Override
    public Genre saveGenre(Genre genre) {
        genre = entityManager.merge(genre);
        return genre;
    }

    @Transactional
    @Override
    public Review saveReview(Review review) {
        review = entityManager.merge(review);
        return review;
    }

    @Override
    @Transactional
    public Pageable getMovieCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Movie> root = criteriaQuery.from(Movie.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue()),
                            criteriaBuilder.equal(root.get("deleted"), 0)));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }

    @Override
    @Transactional
    public Pageable getActorCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Actor> root = criteriaQuery.from(Actor.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue())), criteriaBuilder.equal(root.get("deleted"), 0));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }

    @Override
    public Pageable getDirectorCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Director> root = criteriaQuery.from(Director.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue())),
                            criteriaBuilder.equal(root.get("deleted"), 0));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }

    @Override
    public Pageable getGenreCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Genre> root = criteriaQuery.from(Genre.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue())),
                            criteriaBuilder.equal(root.get("deleted"), 0));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }

    @Override
    public Pageable getReviewCount(int pageNo, int pageSize, Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Review> root = criteriaQuery.from(Review.class);
        if (Objects.nonNull(filter.getAttribute()) && Objects.nonNull(filter.getValue())) {
            criteriaQuery
                    .select(criteriaBuilder.count(root))
                    .where(criteriaBuilder.and(criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue())),
                            criteriaBuilder.equal(root.get("deleted"), 0));
        } else {
            criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("deleted"), 0));
        }
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        long count = query.getSingleResult().intValue();
        return new Pageable(pageNo, pageSize, calculatesPages(pageSize, count), count);
    }

    @Override
    @Transactional
    public List<Movie> getAllMovie(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> root = criteriaQuery.from(Movie.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Actor> getAllActor(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
        Root<Actor> root = criteriaQuery.from(Actor.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Actor> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Director> getAllDirector(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Director> criteriaQuery = criteriaBuilder.createQuery(Director.class);
        Root<Director> root = criteriaQuery.from(Director.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Director> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Genre> getAllGenre(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Genre> criteriaQuery = criteriaBuilder.createQuery(Genre.class);
        Root<Genre> root = criteriaQuery.from(Genre.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Genre> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    @Override
    public List<Review> getAllReview(Filter filter, String sort) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> criteriaQuery = criteriaBuilder.createQuery(Review.class);
        Root<Review> root = criteriaQuery.from(Review.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getAttribute() != null && "Like".equalsIgnoreCase(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.like(root.get(filter.getAttribute()), "%" + filter.getValue() + "%");
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "Equals".equals(filter.getOperator())) {

            Predicate predicate =
                    criteriaBuilder.equal(root.get(filter.getAttribute()), filter.getValue());
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        } else if (filter.getAttribute() != null && "In".equals(filter.getOperator())) {
            Predicate predicate =
                    criteriaBuilder.in(criteriaBuilder.upper(root.get(filter.getAttribute())));
            predicates.add(predicate);
            predicates.add(criteriaBuilder.equal(
                    root.get("deleted"), 0));
        }
        predicates.add(criteriaBuilder.equal(
                root.get("deleted"), 0));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        String[] parts = sort.split(":");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part1 == "desc") {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(part2)));
        } else if (part1 != "desc") {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(part2)));
        }

        TypedQuery<Review> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public static Integer calculatesPages(long pageSize, long count) {
        return count < pageSize ? 1 : (int) Math.ceil((double) count / pageSize);
    }

    @Transactional
    @Override
    public Movie getByMovieId(String id) {
        TypedQuery<Movie> typedQuery =
                entityManager
                        .createQuery("from Movie where movieId=:id", Movie.class)
                        .setParameter("id", id);

        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Actor getByActorId(String id) {
        TypedQuery<Actor> typedQuery =
                entityManager
                        .createQuery("from Actor where actorId=:id", Actor.class)
                        .setParameter("id", id);
        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Director getByDirectorId(String id) {
        TypedQuery<Director> typedQuery =
                entityManager
                        .createQuery("from Director where directorId=:id", Director.class)
                        .setParameter("id", id);
        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Genre getByGenreId(String id) {
        TypedQuery<Genre> typedQuery =
                entityManager
                        .createQuery("from Genre where genreId=:id", Genre.class)
                        .setParameter("id", id);
        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Review getByReviewId(String id) {
        TypedQuery<Review> typedQuery =
                entityManager
                        .createQuery("from Review where reviewId=:id", Review.class)
                        .setParameter("id", id);
        log.warn("TRY AGAIN!");
        log.debug("ReCheck!!");
        return typedQuery.getSingleResult();
    }



    @Transactional
    @Override
    public int softdeleteMovie(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Movie set deleted = true where movieId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }

    @Transactional
    @Override
    public int softdeleteActor(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Actor set deleted = true where actorId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }

    @Transactional
    @Override
    public int softdeleteDirector(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Director set deleted = true where directorId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }

    @Transactional
    @Override
    public int softdeleteGenre(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Genre set deleted = true where genreId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }

    @Transactional
    @Override
    public int softdeleteReview(List<String> idList) {
        Query query =
                entityManager
                        .createQuery("Update Review set deleted = true where reviewId in (:idList)")
                        .setParameter("idList", idList);
        return query.executeUpdate();
    }
}
