DROP database NEWBOOKSTORE;
Create database IF NOT EXISTS NEWBOOKSTORE;
Use NEWBOOKSTORE;


CREATE TABLE IF NOT EXISTS users (
   uid int NOT NULL AUTO_INCREMENT,
   lastname VARCHAR(30),
   firstname VARCHAR(30),
   username VARCHAR(30),
   pass VARCHAR(30),
   PRIMARY KEY (uid)
   );

INSERT INTO users (uid, lastname,firstname,username,pass) 
VALUES(1, 'AdminFirst','AdminLast','Admin','pass1');
 
  CREATE TABLE IF NOT EXISTS book_category (
  cid int,
  categorytitle varchar(100) NOT NULL,
  PRIMARY KEY (cid)
  );
INSERT INTO book_category (cid, categorytitle) VALUES
  (1, 'Fantasy'),
  (2, 'Adventure'),
  (3, 'Romance'),
  (4, 'Academic'),
  (5, 'Contemporary'),
  (6, 'Dystopian'),
  (7, 'Mystery'),
  (8, 'Horror');
  

 
CREATE TABLE IF NOT EXISTS books (
  bid int auto_increment,
  cid int NOT NULL,
  booktitle varchar(100) NOT NULL,
  description varchar(250) NOT NULL,
  author varchar(100) NOT NULL,
  publisheddate varchar(250) NOT NULL,
  isbn char(12) unique,
  price decimal,
  noofpages int,
  FOREIGN KEY (cid) REFERENCES book_category(cid),
  PRIMARY KEY (bid));



INSERT INTO books (bid, booktitle,description, author, publisheddate, isbn,price,noofpages,cid) VALUES
  (1, 'Star Wars','My First  Book Description', 'Alexander Freed', '2020-07-02 12:08:17.320053-03', '987152912461',26.25,368,1),
  (2, 'My SQL Book','My  SQL Book Description' ,'John Mayer', '2016-07-03 09:22:45.050088-07', '85730092371',4.99,600,4),
  (3, 'My Third SQL Book','My SecondSQL Book', 'Cary Flint', '2000-03-20 13:05:44.547516-07', '52312096781',10.95,780,4),
   (4, 'My Adventure Book','Adventure Book', 'Flint Cars', '2020-08-06 16:07:23.547515-07', '56456546546',10.33,680,2),
    (5, 'My Second Horror Book','Horror Book', 'Joel Yol Fin', '2014-10-13 19:05:34.547416-07', '878786756',11.95,745,8),
     (6, 'My Second Foot Book','Foot Book', 'Cassy Massy', '2016-10-15 14:09:14.547576-07', '454546564564',19.95,73,5),
      (7, 'My Second Murder mystery Book','My mystery Book', 'Blue Gene Green', '2005-01-16 14:05:44.543516-07', '232454',1.95,380,7);

INSERT INTO books (bid, booktitle,description, author, publisheddate, isbn,price,noofpages,cid) VALUES
  (8, 'Poo','My F', 'Al', '2020-07-02 12:08:17.320053-03', '98711',26.25,368,3);


CREATE TABLE IF NOT EXISTS comments (
  id int,
  bid integer NOT NULL,
  reviewername varchar(255),
  commentcontent varchar(255),
  commentdate timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (bid) REFERENCES books(bid) ON DELETE CASCADE
);

INSERT INTO comments (id, bid, reviewername, commentcontent, commentdate) VALUES
  (1, 1, 'John Smith', 'First review', '2020-08-10 05:50:11.127281-02'),
  (2, 1, 'Anonymous', 'Second review', '2020-08-13 15:05:12.673382-05'),
  (3, 2, 'Alice', 'Another review', '2017-10-22 23:47:10.407569-07');