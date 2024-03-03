package com.example.IMDB.service;

import com.example.IMDB.dao.OrganizationDao;
import com.example.IMDB.entity.*;
import com.example.IMDB.exception.ApplicationErrorCode;
import com.example.IMDB.exception.RequestConflictError;
import com.example.IMDB.exception.ResourceNotFoundException;
import com.example.IMDB.filter.Filter;
import com.example.IMDB.model.BatchDelete;
import com.example.IMDB.model.SearchResponseRepresentation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Setter
@Getter
public class OrganizationServiceImplementation implements OrganizationServiceInterface {
  @Autowired private OrganizationDao dao;

  @Override
  public ResponseBody<Movie> addMovie(
      Movie movie) throws RequestConflictError {

    if (Boolean.TRUE.equals((dao.isExists(movie.getMovieTitle())))) {
      log.error("Account Name Already Exist");
      throw new RequestConflictError(
          "Already Exist.", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    } else {
      movie.setMovieId("movie-" + UUID.randomUUID());
      movie.setCreatedDttm(ZonedDateTime.now());
      return new ResponseBody<>(
          HttpStatus.OK,
              dao.saveMovie(movie));
    }
  }

  @Override
  public ResponseBody<Actor> addActor(
          Actor actor) throws RequestConflictError {
    try {
      actor.setActorId("actor-" + UUID.randomUUID());
      actor.setActorName(actor.getActorName());
      actor.setCreatedDttm(ZonedDateTime.now());


      return new ResponseBody<>(HttpStatus.OK, dao.saveActor(actor));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Recheck request!", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    }
  }

  @Override
  public ResponseBody<Director> addDirector(
          Director director) {
    try {
      director.setDirectorId("director-" + UUID.randomUUID());
      director.setCreatedDttm(ZonedDateTime.now());
      return new ResponseBody<>(HttpStatus.OK, dao.saveDirector(director));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Recheck request!", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    }
  }

  @Override
  public ResponseBody<Genre> addGenre(
          Genre genre) {
    try {

      genre.setGenreId("genre-" + UUID.randomUUID());
      genre.setCreatedDttm(ZonedDateTime.now());
      return new ResponseBody<>(
              HttpStatus.OK,dao.saveGenre(genre));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Recheck request!", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    }
  }
  @Override
  public ResponseBody<Review> addReview(
          Review review) {
    try {

      review.setReviewId("review-" + UUID.randomUUID());
      review.setCreatedDttm(ZonedDateTime.now());
      return new ResponseBody<>(
              HttpStatus.OK,dao.saveReview(review));
    } catch (Exception e) {
      throw new RequestConflictError(
              "Recheck request!", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    }
  }

  @Override
  public ResponseBody<Integer> softdeleteMovie(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete list1 : batchDeleteList) {
        list.add(list1.getId());
      }
      int count = dao.softdeleteMovie(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      e.printStackTrace();
      throw new ResourceNotFoundException(
          "Failed to Delete Account",
          ApplicationErrorCode.RESOURCE_NOT_FOUND,
          HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Integer> softdeleteActor(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete contactIds1 : batchDeleteList) {
        list.add(contactIds1.getId());
      }
      int count = dao.softdeleteActor(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      throw new ResourceNotFoundException(
          "Failed to Delete Actor",
          ApplicationErrorCode.RESOURCE_NOT_FOUND,
          HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Integer> softdeleteDirector(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete list1 : batchDeleteList) {
        list.add(list1.getId());
      }
      int count = dao.softdeleteDirector(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Delete Subscription",
          ApplicationErrorCode.RESOURCE_CONFLICT,
          HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseBody<Integer> softdeleteGenre(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete list1 : batchDeleteList) {
        list.add(list1.getId());
      }
      int count = dao.softdeleteGenre(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      throw new ResourceNotFoundException(
          "Failed to Delete Install",
          ApplicationErrorCode.RESOURCE_NOT_FOUND,
          HttpStatus.NOT_FOUND);
    }
  }


  @Override
  public ResponseBody<Integer> softdeleteReview(
          List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete list1 : batchDeleteList) {
        list.add(list1.getId());
      }
      int count = dao.softdeleteReview(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      throw new ResourceNotFoundException(
              "Failed to Delete Install",
              ApplicationErrorCode.RESOURCE_NOT_FOUND,
              HttpStatus.NOT_FOUND);
    }
  }


  @Override
  public ResponseBody<Movie> updateMovie(
      Movie movie1, String movieId) {
    try {
      Movie movie = dao.getByMovieId(movieId);
      movie.setMovieId(movie1.getMovieId());
      movie.setMovieTitle(movie1.getMovieTitle());
      movie.setReleaseDate(movie1.getReleaseDate());
      movie.setReleaseCountry(movie1.getReleaseCountry());
      movie.setIsActive(movie1.getIsActive());
      movie.setDeleted(movie1.getDeleted());
      return new ResponseBody<>(
              HttpStatus.OK, (dao.saveMovie(movie)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseBody<Actor> updateActor(
      Actor actor, String actorId) {
    try {
      Actor actor1 = dao.getByActorId(actorId);
      actor1.setActorId(actor.getActorId());
      actor.setMovieId(actor.getMovieId());
      actor1.setActorName(actor.getActorName());
      return new ResponseBody<>(
              HttpStatus.OK,(dao.saveActor(actor1)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseBody<Director> updateDirector(
      Director director, String directorId) {
    try {
      Director director1 = dao.getByDirectorId(directorId);
      director1.setDirectorId(director.getDirectorId());

      director1.setDirectorName(director.getDirectorName());
      return new ResponseBody<>(
              HttpStatus.OK,(dao.saveDirector(director1)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseBody<Genre> updateGenre(
      Genre genre, String genreId) {
    try {
      Genre genre1 = dao.getByGenreId(genreId);
      genre1.setGenreId(genre.getGenreId());
      genre1.setGenreName(genre.getGenreName());
      return new ResponseBody<>(
              HttpStatus.OK, (dao.saveGenre(genre1)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseBody<Review> updateReview(
          Review review, String reviewId) {
    try {
      Review review1 = dao.getByReviewId(reviewId);
      review1.setReviewId(review.getReviewId());
      review1.setMovieId(review.getMovieId());
      review1.setReviewerName(review.getReviewerName());
      review1.setReviewerRating(review.getReviewerRating());
      review1.setReview(review.getReview());

      return new ResponseBody<>(
              HttpStatus.OK, (dao.saveReview(review1)));
    } catch (Exception e) {
      throw new RequestConflictError(
              "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }


  @Override
  public ResponseBody<Movie> getByMovie(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByMovieId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Actor> getByActor(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByActorId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Director> getByDirector(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByDirectorId(id)));

    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Genre> getGenre(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByGenreId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }
  @Override
  public ResponseBody<Review> getReview(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByReviewId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
              "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }


  @Override
public ResponseBody<SearchResponseRepresentation<Movie>> searchMovie(
        int pageNo, int pageSize, String sort, Filter filter) {
  try {
    return new ResponseBody<>(
            HttpStatus.OK,
            new SearchResponseRepresentation<>(
                    dao.getMovieCount(pageNo, pageSize, filter),
                    dao.getAllMovie(filter, sort)));

  } catch (Exception e) {
    e.printStackTrace();
    log.info("Unable to locate Attribute with the the given name!");
    throw new ResourceNotFoundException(
            "Not found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
  }
}

  @Override
  public ResponseBody<SearchResponseRepresentation<Actor>> searchActor(
      int pageNo, int pageSize, String sort, Filter filter) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,
          new SearchResponseRepresentation<>(
              dao.getActorCount(pageNo, pageSize, filter),
              dao.getAllActor(filter, sort)));

    } catch (Exception e) {
      e.printStackTrace();
      log.info("Unable to locate Attribute  with the the given name!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<SearchResponseRepresentation<Director>> searchDirector(
      int pageNo, int pageSize, String sort, Filter filter) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,
          new SearchResponseRepresentation<>(
              dao.getDirectorCount(pageNo, pageSize, filter),
              dao.getAllDirector(filter, sort)));

    } catch (Exception e) {
      e.printStackTrace();
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<SearchResponseRepresentation<Genre>> searchGenre(
      int pageNo, int pageSize, String sort, Filter filter) {

    try {
      return new ResponseBody<>(
              HttpStatus.OK,
          new SearchResponseRepresentation<>(
              dao.getGenreCount(pageNo, pageSize, filter),
              dao.getAllGenre(filter, sort)));

    } catch (Exception e) {
      e.printStackTrace();
      log.info("Unable to locate Attribute  with the the given name!");
      throw new ResourceNotFoundException(
          "Not found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<SearchResponseRepresentation<Review>> searchReview(
          int pageNo, int pageSize, String sort, Filter filter) {

    try {
      return new ResponseBody<>(
              HttpStatus.OK,
              new SearchResponseRepresentation<>(
                      dao.getReviewCount(pageNo, pageSize, filter),
                      dao.getAllReview(filter, sort)));

    } catch (Exception e) {
      e.printStackTrace();
      log.info("Unable to locate Attribute  with the the given name!");
      throw new ResourceNotFoundException(
              "Not found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }
}
