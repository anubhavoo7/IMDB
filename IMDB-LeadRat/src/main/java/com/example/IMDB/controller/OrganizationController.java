package com.example.IMDB.controller;

import com.example.IMDB.entity.*;
import com.example.IMDB.filter.Filter;
import com.example.IMDB.model.BatchDelete;
import com.example.IMDB.model.SearchResponseRepresentation;
import com.example.IMDB.service.OrganizationServiceInterface;
import com.example.IMDB.service.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrganizationController {

  @Autowired private OrganizationServiceInterface organizationServiceInterface;

  @PostMapping("/addMovie")

  public ResponseEntity<Movie> addMovie(
      @RequestBody Movie movie){
    ResponseBody<Movie> movie1 =
            organizationServiceInterface.addMovie(movie);
    return new ResponseEntity<>(
            movie1.getPayload(), movie1.getStatus());
  }


  @PostMapping("/addActor")
  public ResponseEntity<Actor> addActor(
      @RequestBody Actor actor) {
    ResponseBody<Actor> actor1 =
        organizationServiceInterface.addActor(actor);
    return new ResponseEntity<>(
            actor1.getPayload(),actor1.getStatus());
  }

  @PostMapping("/addDirector")
  public ResponseEntity<Director> addDirector(
      @RequestBody Director director) {
    ResponseBody<Director> director1 =
        organizationServiceInterface.addDirector(director);
    return new ResponseEntity<>(
        director1.getPayload(), director1.getStatus());
  }

  @PostMapping("/addGenre")
  public ResponseEntity<Genre> addGenre(
      @RequestBody Genre genre) {
    ResponseBody<Genre> addGenre1 =
        organizationServiceInterface.addGenre(genre);
    return new ResponseEntity<>(
            addGenre1.getPayload(), addGenre1.getStatus());
  }

  @PostMapping("/addReview")
  public ResponseEntity<Review> addReview(
          @RequestBody Review review) {
    ResponseBody<Review> addReview1 =
            organizationServiceInterface.addReview(review);
    return new ResponseEntity<>(
            addReview1.getPayload(), addReview1.getStatus());
  }

  @PostMapping("/deleteMovie")
  public ResponseEntity<Integer> softdeleteMovie(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> movie =
        organizationServiceInterface.softdeleteMovie(batchDeleteList);
    return new ResponseEntity<>(
        movie.getPayload(), movie.getStatus());
  }

  @PostMapping("/deleteActor")
  public ResponseEntity<Integer> softdeleteActor(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> actor =
        organizationServiceInterface.softdeleteActor(batchDeleteList);
    return new ResponseEntity<>(
        actor.getPayload(), actor.getStatus());
  }

  @PostMapping("/deleteDirector")
  public ResponseEntity<Integer> softdeleteDirector(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> director =
        organizationServiceInterface.softdeleteDirector(batchDeleteList);
    return new ResponseEntity<>(
        director.getPayload(), director.getStatus());
  }

  @PostMapping("/deleteGenre")
  public ResponseEntity<Integer> softdeleteGenre(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> genre =
        organizationServiceInterface.softdeleteGenre(batchDeleteList);
    return new ResponseEntity<>(
        genre.getPayload(), genre.getStatus());
  }

  @PostMapping("/deleteReview")
  public ResponseEntity<Integer> softdeleteReview(
          @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> review =
            organizationServiceInterface.softdeleteGenre(batchDeleteList);
    return new ResponseEntity<>(
            review.getPayload(), review.getStatus());
  }

  @PutMapping("/movieUpdate/{id}")
  public ResponseEntity<Movie> updateMovie(
      @RequestBody Movie movie,
      @PathVariable(value = "id") String id) {
    ResponseBody<Movie> movie1 =
        organizationServiceInterface.updateMovie(movie, id);
    return new ResponseEntity<>(
            movie1.getPayload(), movie1.getStatus());
  }

  @PutMapping("/actorUpdate/{id}")
  public ResponseEntity<Actor> updateActor(
      @RequestBody Actor actor,
      @PathVariable(value = "id") String id) {
    ResponseBody<Actor> actor1 =
        organizationServiceInterface.updateActor(actor, id);
    return new ResponseEntity<>(
            actor1.getPayload(), actor1.getStatus());
  }

  @PutMapping("/directorUpdate/{id}")
  public ResponseEntity<Director> updateDirector(
      @RequestBody Director director,
      @PathVariable(value = "id") String id) {
    ResponseBody<Director> director1 =
        organizationServiceInterface.updateDirector(director, id);
    return new ResponseEntity<>(
            director1.getPayload(), director1.getStatus());
  }

  @PutMapping("/genreUpdate/{id}")
  public ResponseEntity<Genre> updateGenre(
      @RequestBody Genre genre,
      @PathVariable(value = "id") String id) {
    ResponseBody<Genre> genre1 =
        organizationServiceInterface.updateGenre(genre, id);
    return new ResponseEntity<>(
            genre1.getPayload(), genre1.getStatus());
  }

  @PutMapping("/reviewUpdate/{id}")
  public ResponseEntity<Review> updateReview(
          @RequestBody Review review,
          @PathVariable(value = "id") String id) {
    ResponseBody<Review> review1 =
            organizationServiceInterface.updateReview(review, id);
    return new ResponseEntity<>(
            review1.getPayload(), review1.getStatus());
  }

  @GetMapping("movie/{id}")
  public ResponseEntity<Movie> getMovie(@PathVariable String id) {
    ResponseBody<Movie> byMovie =
        organizationServiceInterface.getByMovie(id);
    return new ResponseEntity<>(
            byMovie.getPayload(), byMovie.getStatus());
  }

  @GetMapping("/actor/{id}")
  public ResponseEntity<Actor> getActor(
      @PathVariable String id) {
    return new ResponseEntity<>(
        organizationServiceInterface.getByActor(id).getPayload(),
        organizationServiceInterface.getByActor(id).getStatus());
  }

  @GetMapping("/director/{id}")
  public ResponseEntity<Director> getDirector(
      @PathVariable String id){
    return new ResponseEntity<>(
        organizationServiceInterface.getByDirector(id).getPayload(),
        organizationServiceInterface.getByDirector(id).getStatus());
  }

  @GetMapping("/genre/{id}")
  public ResponseEntity<Genre> getGenre(
      @PathVariable String id){
    return new ResponseEntity<>(
        organizationServiceInterface.getGenre(id).getPayload(),
        organizationServiceInterface.getGenre(id).getStatus());
  }

  @GetMapping("/review/{id}")
  public ResponseEntity<Review> getReview(
          @PathVariable String id){
    return new ResponseEntity<>(
            organizationServiceInterface.getReview(id).getPayload(),
            organizationServiceInterface.getReview(id).getStatus());
  }

@PostMapping("/Movies")
public ResponseEntity<SearchResponseRepresentation<Movie>> searchAccounts(
        @RequestBody(required = false) Filter filter,
        @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
        @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
        @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

  ResponseBody<SearchResponseRepresentation<Movie>> searchedMovies =
          organizationServiceInterface.searchMovie(pageNo, pageSize, sort, filter);

  return new ResponseEntity<>(searchedMovies.getPayload(), searchedMovies.getStatus());
}

  @PostMapping("/Actors")
  public ResponseEntity<SearchResponseRepresentation<Actor>> searchActor(
      @RequestBody(required = false) Filter filter,
      @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
      @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
      @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

    ResponseBody<SearchResponseRepresentation<Actor>> searchedActors =
        organizationServiceInterface.searchActor(pageNo, pageSize, sort, filter);

    return new ResponseEntity<>(searchedActors.getPayload(), searchedActors.getStatus());
  }

  @PostMapping("/Directors")
  public ResponseEntity<SearchResponseRepresentation<Director>>
      searchDirector(
          @RequestBody(required = false) Filter filter,
          @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
          @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
          @RequestParam(name = "sort", defaultValue = "createdDttm", required = false)
              String sort) {

    ResponseBody<SearchResponseRepresentation<Director>> searchedDirectors =
        organizationServiceInterface.searchDirector(pageNo, pageSize, sort, filter);

    return new ResponseEntity<>(
        searchedDirectors.getPayload(), searchedDirectors.getStatus());
  }

  @PostMapping("/Genres")
  public ResponseEntity<SearchResponseRepresentation<Genre>> searchGenre(
      @RequestBody(required = false) Filter filter,
      @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
      @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
      @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

    ResponseBody<SearchResponseRepresentation<Genre>> searchedGenres =
        organizationServiceInterface.searchGenre(pageNo, pageSize, sort, filter);

    return new ResponseEntity<>(searchedGenres.getPayload(), searchedGenres.getStatus());
  }

  @PostMapping("/Reviews")
  public ResponseEntity<SearchResponseRepresentation<Review>> searchReview(
          @RequestBody(required = false) Filter filter,
          @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
          @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
          @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

    ResponseBody<SearchResponseRepresentation<Review>> searchedReviews =
            organizationServiceInterface.searchReview(pageNo, pageSize, sort, filter);

    return new ResponseEntity<>(searchedReviews.getPayload(), searchedReviews.getStatus());
  }
}
