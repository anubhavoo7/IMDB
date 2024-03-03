package com.example.IMDB.dao;

import com.example.IMDB.entity.*;
import com.example.IMDB.filter.Filter;
import com.example.IMDB.model.Pageable;
import java.util.List;

public interface OrganizationDao {

  Movie saveMovie (Movie movie);

  Boolean isExists(String movieTitleToCheck);

  Actor saveActor(Actor actor);

  Director saveDirector(Director director);


  Genre saveGenre(Genre genre);

  Review saveReview(Review review);

  Pageable getMovieCount(int pageNo, int pageSize, Filter filter);

  Pageable getActorCount(int pageNo, int pageSize, Filter filter);

  Pageable getDirectorCount(int pageNo, int pageSize, Filter filter);

  Pageable getGenreCount(int pageNo, int pageSize, Filter filter);

  Pageable getReviewCount(int pageNo, int pageSize, Filter filter);

  List<Movie> getAllMovie(Filter filter, String sort);


  List<Actor> getAllActor(Filter filter, String sort);

  List<Director> getAllDirector(Filter filter, String sort);

  List<Genre> getAllGenre(Filter filter, String sort);
  List<Review> getAllReview(Filter filter, String sort);

  Movie getByMovieId(String id);


  Actor getByActorId(String id);

  Director getByDirectorId(String id);

  Genre getByGenreId(String id);
  Review getByReviewId(String id);

  int softdeleteMovie(List<String> idList);

  int softdeleteActor(List<String> batchDeleteList);

  int softdeleteDirector(List<String> batchDeleteList);

  int softdeleteGenre(List<String> batchDeleteList);

  int softdeleteReview(List<String> batchDeleteList);
}
