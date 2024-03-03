# IMDB

Example task - in PGDB

CREATE TABLE Movies (
    MovieID SERIAL PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    ReleaseDate DATE,
    ReleaseCountry VARCHAR(100),
    Language VARCHAR(100),
    Description TEXT
);

CREATE TABLE Actors (
    ActorID SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL
);

CREATE TABLE Directors (
    DirectorID SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL
);

CREATE TABLE MovieCast (
    MovieID INT,
    ActorID INT,
    PRIMARY KEY (MovieID, ActorID),
    FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
    FOREIGN KEY (ActorID) REFERENCES Actors(ActorID)
);

CREATE TABLE MovieDirectors (
    MovieID INT,
    DirectorID INT,
    PRIMARY KEY (MovieID, DirectorID),
    FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
    FOREIGN KEY (DirectorID) REFERENCES Directors(DirectorID)
);

CREATE TABLE Genres (
    GenreID SERIAL PRIMARY KEY,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE MovieGenres (
    MovieID INT,
    GenreID INT,
    PRIMARY KEY (MovieID, GenreID),
    FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
    FOREIGN KEY (GenreID) REFERENCES Genres(GenreID)
);

CREATE TABLE Reviews (
    ReviewID SERIAL PRIMARY KEY,
    MovieID INT,
    ReviewerName VARCHAR(255),
    Rating DECIMAL(3,1),
    Review TEXT,
    FOREIGN KEY (MovieID) REFERENCES Movies(MovieID)
);




INSERT INTO Movies (Title, ReleaseDate, ReleaseCountry, Language, Description)
VALUES ('Kaagaz', '2009-11-01', 'India', 'Hindi', 'Jal Jaega'),
       ('Deewar', '2024-12-02', 'India', 'Hindi', 'Gir Jaegi'),
       ('Mela', '2010-03-31', 'India', 'Hindi', 'Khatm Hojaega'),
	('WalkingDead', '2023-01-01', 'USA', 'Hindi', 'Nikal Jaenge'),
       ('TopGun', '2024-02-02', 'India', 'USA', 'ud Jaega'),
       ('Reacher', '2025-03-03', 'India', 'USA', 'Fight Karega');


INSERT INTO Actors (Name)
VALUES ('Salman Khan'),
	('Pankaj Tripathi'),
	('Shashi Kapoor')
       ('Amitabh Bacchan'),
       ('Amir khan'),
	('Johnny Lever')
	('Andrew Linclon'),
	('Norman Reedus'),
	('TomCruise'),
	('Tim robbins')
       ('Alen Ritchson'),
	('Shaun Sipos');

INSERT INTO Directors (Name)
VALUES ('Satish Kaushik'),
       ('Yash Chopra'),
       ('Dharmesh Darshan'),
	('Frank Darabont'),
       ('Tony Scott'),
       ('Edward Zwick');


INSERT INTO MovieDirectors (MovieID, DirectorID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
	(4, 4),
	(5, 5),
	(6, 6);

INSERT INTO Genres (Name)
VALUES ('Drama'),
	('Action')
       ('Action'),
       ('Horror'),
	('Action'),
	('Adventure');

INSERT INTO MovieGenres (MovieID, GenreID)
VALUES (1, 1),
       (2, 2),
       (3, 3),
	(4, 4),
	(5, 5),
	(6, 6);


INSERT INTO Reviews (MovieID, ReviewerName, Rating, Review)
VALUES (1, 'OmPrakash', 8.5, 'Good movie'),
       (1, 'Rishi', 7.0, 'Average movie'),
       (2, 'Raj', 9.0, 'Excellent movie'),
	(3, 'Jatindar', 9.0, 'Excellent movie'),
	(3, 'Ganesh', 8.5, 'Good movie'),
       (1, 'Rishikesh', 7.0, 'Average movie'),
       (6, 'Anubhav', 9.0, 'Excellent movie'),
	(4, 'Rakesh', 9.0, 'Excellent movie'),
	(1, 'Rakshita', 8.5, 'Good movie'),
       (5, 'Priya', 7.0, 'Average movie'),
       (6, 'akash', 9.0, 'Excellent movie'),
	(4, 'Ankit', 9.0, 'Excellent movie');



Queries:
1>SELECT Title, EXTRACT(YEAR FROM ReleaseDate) AS ReleaseYear
 FROM Movies;
	

2>select Extract(year of releasteDate) as releaseYear where title='Kaagaz';

3>select title from mo movies where extract (year from releaseDate) = 2009;

4>select title from movies where extract(year from releaseDate) = <2010;

5>Select t






5) Select ReviewerName as Name From Reviews UNION Selet select Title As Name From Movies;

6) Select Distinct ReviewName from Reviews where Rating >=7;

2) Select m.title from Movies in Left Join reviews r on m.MovieId = r. MovieId where r. MovieId is NULL;

8) Select Title from Movies where MovieId IN (7, 5,3);


9) Select movieId, Title, Extract (year from ReleaseDate) as Releaseyear from movies where Title like '%a%' order by ReleaseDate ASC;

10) Select MovieId,Title, Extract (year from ReleaseDate) as Releaseyear  From Movies where Title like %a% AND Title Not like %a%a% order by ReleaseDate ASC;

1) Select ActorId From Actors. where Name like 'R%on%';
