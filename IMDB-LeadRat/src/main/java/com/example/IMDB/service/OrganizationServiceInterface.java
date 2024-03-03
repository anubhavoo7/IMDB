package com.example.IMDB.service;

import com.example.IMDB.entity.*;
import com.example.IMDB.filter.Filter;
import com.example.IMDB.model.*;
import com.example.IMDB.model.SearchResponseRepresentation;
import com.example.IMDB.exception.RequestConflictError;
import java.util.List;

public interface OrganizationServiceInterface {

  ResponseBody<Movie> addMovie(
      Movie movie) throws RequestConflictError;


  ResponseBody<Actor> addActor(
          Actor actor) throws RequestConflictError;

  ResponseBody<Director> addDirector(
          Director director);

  ResponseBody<Genre> addGenre(
          Genre genre);

  ResponseBody<Review> addReview(
          Review review);

//  ResponseBody<MovieView> softdeleteOrganization(String id);

  ResponseBody<Integer> softdeleteMovie(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Integer> softdeleteActor(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Integer> softdeleteDirector(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Integer> softdeleteGenre(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Integer> softdeleteReview(
          List<BatchDelete> batchDeleteList);

  ResponseBody<Movie> updateMovie(
      Movie movie1, String movieId);

  ResponseBody<Actor> updateActor(
      Actor actor, String actorId);

  ResponseBody<Director> updateDirector(
      Director director, String directorId);

  ResponseBody<Genre> updateGenre(
      Genre genre, String genreId);

  ResponseBody<Review> updateReview(
          Review review, String reviewId);

//  ResponseBody<Organization> getOrganization(String id);

  ResponseBody<Movie> getByMovie(String id);

  ResponseBody<Actor> getByActor(String id);

  ResponseBody<Director> getByDirector(String id);

  ResponseBody<Genre> getGenre(String id);
  ResponseBody<Review> getReview(String id);


  ResponseBody<SearchResponseRepresentation<Movie>> searchMovie(
          int pageNo, int pageSize, String sort, Filter filter);

  ResponseBody<SearchResponseRepresentation<Actor>> searchActor(
      int pageNo, int pageSize, String sort, Filter filter);

  ResponseBody<SearchResponseRepresentation<Director>> searchDirector(
      int pageNo, int pageSize, String sort, Filter filter);

  ResponseBody<SearchResponseRepresentation<Genre>> searchGenre(
      int pageNo, int pageSize, String sort, Filter filter);

  ResponseBody<SearchResponseRepresentation<Review>> searchReview(
          int pageNo, int pageSize, String sort, Filter filter);
}
