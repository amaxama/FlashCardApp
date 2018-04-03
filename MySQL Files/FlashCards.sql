DROP DATABASE IF EXISTS FlashCards;

CREATE DATABASE FlashCards;

USE FlashCards;

CREATE TABLE IF NOT EXISTS Category
(CategoryID SMALLINT UNSIGNED AUTO_INCREMENT,
CategoryName VARCHAR(30) NOT NULL,
CategoryDesc VARCHAR(100),
PRIMARY KEY(CategoryID)
);

CREATE TABLE IF NOT EXISTS Card
(CardID MEDIUMINT UNSIGNED AUTO_INCREMENT,
CardName VARCHAR(30) NOT NULL,
CardChallenge VARCHAR(300) NOT NULL,
CardAnswer VARCHAR(1000) NOT NULL,
PRIMARY KEY(CardID)
);

CREATE TABLE IF NOT EXISTS CardCategory
(CardID MEDIUMINT UNSIGNED,
CategoryID SMALLINT UNSIGNED,
PRIMARY KEY(CardID, CategoryID),
CONSTRAINT fk_CardCategoryCardID FOREIGN KEY (CardID) REFERENCES Card(CardID),
CONSTRAINT fk_CategoryID FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

CREATE TABLE IF NOT EXISTS QueuedCard
(QueuedCardID MEDIUMINT UNSIGNED AUTO_INCREMENT,
CardID MEDIUMINT UNSIGNED,
CardName VARCHAR(30) NOT NULL,
CardChallenge VARCHAR(300) NOT NULL,
CardAnswer VARCHAR(1000) NOT NULL,
PRIMARY KEY(QueuedCardID),
UNIQUE KEY(CardID)
);

CREATE TABLE IF NOT EXISTS QueuedCardCategory
(QueuedCardID MEDIUMINT UNSIGNED,
CategoryID SMALLINT UNSIGNED,
PRIMARY KEY(QueuedCardID, CategoryID),
CONSTRAINT fk_QCardCategoryQueuedCardID FOREIGN KEY (QueuedCardID) REFERENCES QueuedCard(QueuedCardID),
CONSTRAINT fk_QCardCategoryCategoryID FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

CREATE TABLE IF NOT EXISTS `User`
(UserID INT UNSIGNED AUTO_INCREMENT,
UserName VARCHAR(25) NOT NULL, -- IF WE'RE GOING TO USE EMAIL IT NEEDS TO BE MORE LIKE 50
`Password` VARCHAR(100) NOT NULL,
Active BOOLEAN NOT NULL DEFAULT 1,
PRIMARY KEY(UserID),
INDEX (UserName)
);

CREATE TABLE IF NOT EXISTS UserCard
(UserID INT UNSIGNED NOT NULL,
CardID MEDIUMINT UNSIGNED NOT NULL,
PRIMARY KEY(UserID, CardID),
CONSTRAINT fk_UserCardUserID FOREIGN KEY (UserID) REFERENCES `User`(UserID),
CONSTRAINT fk_UserCardCardID FOREIGN KEY (CardID) REFERENCES Card(CardID)
);

CREATE TABLE IF NOT EXISTS Role
(RoleID TINYINT UNSIGNED AUTO_INCREMENT,
RoleName VARCHAR(30) NOT NULL,
RoleDesc VARCHAR(50) NOT NULL,
PRIMARY KEY(RoleID)
);

CREATE TABLE IF NOT EXISTS UserRole
(UserID INT UNSIGNED NOT NULL,
RoleID TINYINT UNSIGNED NOT NULL,
PRIMARY KEY(UserID, RoleID),
CONSTRAINT fk_UserRoleUserID FOREIGN KEY (UserID) REFERENCES `User` (UserID),
CONSTRAINT fk_RoleID FOREIGN KEY (RoleID) REFERENCES Role (RoleID)
);

CREATE TABLE IF NOT EXISTS Deck
(DeckID SMALLINT UNSIGNED AUTO_INCREMENT,
DeckName VARCHAR(30) NOT NULL,
DeckDesc VARCHAR(100),
PRIMARY KEY(DeckID)
);

CREATE TABLE IF NOT EXISTS UserDeck
(UserID INT UNSIGNED NOT NULL,
DeckID SMALLINT UNSIGNED NOT NULL,
PRIMARY KEY(UserID, DeckID),
CONSTRAINT fk_UserDeckUserID FOREIGN KEY (UserID) REFERENCES `User` (UserID),
CONSTRAINT fk_UserDeckDeckID FOREIGN KEY (DeckID) REFERENCES Deck (DeckID)
);

CREATE TABLE IF NOT EXISTS DeckCard
(DeckID SMALLINT UNSIGNED NOT NULL,
CardID MEDIUMINT UNSIGNED NOT NULL,
PRIMARY KEY(DeckID, CardID),
CONSTRAINT fk_DeckCardDeckID FOREIGN KEY (DeckID) REFERENCES Deck (DeckID),
CONSTRAINT fk_DeckCardCardID FOREIGN KEY (CardID) REFERENCES Card (CardID)
);

CREATE TABLE IF NOT EXISTS Folder
(FolderID SMALLINT UNSIGNED AUTO_INCREMENT,
UserID INT UNSIGNED NOT NULL,
FolderName VARCHAR(30) NOT NULL,
PRIMARY KEY(FolderID),
CONSTRAINT fk_FolderUserID FOREIGN KEY (UserID) REFERENCES `User` (UserID)
);

CREATE TABLE IF NOT EXISTS DeckFolder
(DeckID SMALLINT UNSIGNED NOT NULL,
FolderID SMALLINT UNSIGNED NOT NULL,
PRIMARY KEY(DeckID, FolderID),
CONSTRAINT fk_DeckFolderDeckID FOREIGN KEY (DeckID) REFERENCES Deck (DeckID),
CONSTRAINT fk_FolderID FOREIGN KEY (FolderID) REFERENCES Folder (FolderID)
);

CREATE TABLE IF NOT EXISTS Review
(ReviewID MEDIUMINT UNSIGNED AUTO_INCREMENT,
DeckID SMALLINT UNSIGNED NOT NULL,
UserID INT UNSIGNED NOT NULL,
ReviewName VARCHAR(30) NOT NULL,
ReviewContent VARCHAR(500) NOT NULL,
PRIMARY KEY(ReviewID),
CONSTRAINT fk_ReviewDeckID FOREIGN KEY (DeckID) REFERENCES Deck(DeckID),
CONSTRAINT fk_ReviewUserID FOREIGN KEY (UserID) REFERENCES `User`(UserID)
);

-- CREATE TABLE IF NOT EXISTS CardRating
-- (UserID INT UNSIGNED NOT NULL,
-- CardID MEDIUMINT UNSIGNED NOT NULL,
-- Rating TINYINT UNSIGNED NOT NULL,
-- PRIMARY KEY(UserID, CardID),
-- CONSTRAINT fk_CardRatingUserID FOREIGN KEY (UserID) REFERENCES `User`(UserID),
-- CONSTRAINT fk_CardRatingCardID FOREIGN KEY (CardID) REFERENCES Card(CardID)
-- );

-- CREATE TABLE IF NOT EXISTS CardRating
-- (CardRatingID INT UNSIGNED NOT NULL AUTO_INCREMENT,
-- UserID MEDIUMINT UNSIGNED NOT NULL,
-- CardID MEDIUMINT UNSIGNED NOT NULL,
-- Rating TINYINT UNSIGNED NOT NULL,
-- PRIMARY KEY(CardRatingID),
-- CONSTRAINT fk_CardRatingUserID FOREIGN KEY (UserID) REFERENCES `User`(UserID),
-- CONSTRAINT fk_CardRatingCardID FOREIGN KEY (CardID) REFERENCES Card(CardID)
-- );

CREATE TABLE IF NOT EXISTS CardRating (
CardRatingID INT PRIMARY KEY auto_increment,
UserID INT(10) UNSIGNED NOT NULL,
CardID MEDIUMINT UNSIGNED NOT NULL,
Rating TINYINT UNSIGNED NOT NULL,
FOREIGN KEY(UserID) REFERENCES `User`(UserID),
FOREIGN KEY(CardID) REFERENCES Card(CardID)
);


INSERT INTO `User`
(UserID, UserName, `Password`)
VALUES
(1,'admin','password'),
(2,'user','password');

INSERT INTO Role
(RoleID, RoleName, RoleDesc)
VALUES
(1, 'ROLE_ADMIN',''),
(2, 'ROLE_USER','');

INSERT INTO UserRole
(UserID, RoleID)
VALUES
(1,1),
(1, 2),
(2, 2);

UPDATE `User`
SET
`password` = '$2a$10$DH/hmF4yOLIR9cxnEzO5yus75EPOkCezs0O7g8ybPl211/0VcwcRS'
WHERE `userId` = 2;

UPDATE `User`
SET
`password` = '$2a$10$DH/hmF4yOLIR9cxnEzO5yus75EPOkCezs0O7g8ybPl211/0VcwcRS'
WHERE `userId` = 1;

insert into card (cardName, cardChallenge, cardAnswer)
values ('Variables', 'What is a variable?', 'A variable is the name given to a memory location. It is the basic unit of storage in a program. 
The value stored in a variable can be changed during program execution.'),
('String', 'How many bytes in a String?', 'The number of bytes a string takes up is equal to the number of characters in the string plus 1 (the terminator), 
times the number of bytes per character. The number of bytes per character can vary. It is 1 byte for a regular char type.'),
('Gizzard', 'What is a gizzard?', 'a part of a bird''s stomach that contains tiny stones. It helps them grind up food for digestion.'),
('Dos Equis', 'What is the brewing process for the beer maker Dos Equis? (TEST SPACE) Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s.', '(TEST SPACE) First, barley grains are germinated by immersing them in water. 
This encourages the barley to sprout. The barley is then dried to halt the process of sprouting completely in order to release the enzymes necessary for brewing.
Next, starch made from the malted barley is converted into fermentable sugars and hops are added. The mixture is set to boil and at this point in the process, it becomes what is known as wort.
Brewer’s yeast is added, and instantly, the yeast begins converting the sugars into alcohol and carbon dioxide. This is what makes beer carbonated. 
Different strains of yeast have different flavor compounds, so this is also where beers get their different and distinct flavor profiles. 
The beer is kept at a low temperature for a set period of time. Once the beer is saturated with carbon dioxide, the yeast settles to the bottom of the tank.
The remaining yeast cells are filtered out, leaving clear beer that’s ready to be filled into bottles, cans and kegs.'),
('Constructor', 'What is a constructor?', 'A constructor is a special method of a class or structure in object-oriented programming that initializes an object of that type. 
A constructor is an instance method that usually has the same name as the class, and can be used to set the values of the members of an object, either to default or to user-defined values.'),
('List and Tuples', 'What is the difference between list and tuples?', 'The main difference between mutable and immutable is memory usage when you are trying to append an item. When you create a variable, 
some fixed memory is assigned to the variable. If it is a list, more memory is assigned than actually used.');

INSERT INTO deck(deckName, deckDesc) VALUES('deck 4', 'deck 4 desc');
insert into deck (deckName, deckDesc)
values ('Java Questions', 'Interview Questions to help study. (TEST SPACE) Lorem Ipsum is simply dummy text of the printing.'),
('Turkey Questions', 'Questions about turkeys.'),
('Beer Questions', 'Questions about beer.'),
('Python Questions', 'Questions to help study');

insert into category (categoryName, categoryDesc)
values ('Programming', 'Writing computer programs.'),
('Turkey', 'Delicious bird. (TEST SPACE) Lorem Ipsum is simply dummy text of the printing and.'),
('Beer', 'Is Awesome!');

insert into CardCategory (cardID, categoryID)
values (1,1),
(2,1),
(3,2),
(4,3),
(5,1),
(6,1);



insert into userCard (userID, cardID)
values (1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6);

insert into UserDeck (userID, deckID)
values (1,1),
(1,2),
(1,3),
(1,4);

INSERT INTO deckCard(deckId, cardId) VALUES (1,3);
INSERT INTO deckCard(deckId, cardId) VALUES (2,2);  
insert into DeckCard (deckID, cardID)
values (1,1),
(1,2),
(2,3),
(3,4),
(1,5),
(4,6);

insert into folder (userID, folderName)
values (1, 'Java and Python'),
(1, 'Turkey'),
(1, 'Beer');

insert into DeckFolder (deckID, FolderID)
values (1,1),
(2,2),
(3,3),
(4,1);

insert into review (deckID, userID, reviewName, reviewContent)
values (1,1, 'Java Deck Review', 'This deck is amazing!'),
(2,1, 'Turkey Deck Review', 'This deck is terrible! (TEST SPACE) Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset.'),
(3,1, 'Beer Deck Review', 'This is the greatest of all time!'),
(4,1, 'Python Deck Review', 'Awesome deck!'); 

insert into cardRating (userID, cardID, rating)
values (1,1,4),
(1,2,5),
(1,3,1),
(1,4,3),
(1,5,4),
(1,6,5);
