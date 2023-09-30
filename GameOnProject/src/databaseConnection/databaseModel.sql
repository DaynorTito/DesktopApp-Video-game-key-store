
-- CREATE DATABASE GameStore;

CREATE TABLE Audience(
	IDAudience INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    field VARCHAR(20)
);
CREATE TABLE Developments(
	IDDevelopment INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NameDevelopment VARCHAR(50)
);
CREATE TABLE Categories(
	IDCategorie INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20)
);
CREATE TABLE Plataforms(
	IDPlataform INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20)
);
CREATE TABLE Games(
	IDGame INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    CategoryID INT,
    PlataformID INT,
    AudienceID INT,
    DevelopmentID INT,
    Descripcion VARCHAR(500),
    RequisitosMin VARCHAR(1000),
    RequisitosRec VARCHAR(1000),
    Quantity INT,
    Price FLOAT,
	ImagePath VARCHAR(200),
	Available BOOLEAN,
    CONSTRAINT FK_Category_ID FOREIGN KEY (CategoryID) REFERENCES Categories(IDCategorie),
    CONSTRAINT FK_Plataform_ID FOREIGN KEY (PlataformID) REFERENCES Plataforms(IDPlataform),
    CONSTRAINT FK_Audience_ID FOREIGN KEY (AudienceID) REFERENCES Audience(IDAudience),
    CONSTRAINT FK_Development_ID FOREIGN KEY (DevelopmentID) REFERENCES Developments(IDDevelopment)
);

CREATE TABLE Offers (
  IDOffers INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  PercentageDiscount FLOAT,
  GameID INT,
  CONSTRAINT FK_Game_ID FOREIGN KEY (GameID) REFERENCES Games(IDGame)
);

CREATE TABLE TopGames(
	IDTopGame INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    GameID INT,
	CONSTRAINT FK_Games_ID FOREIGN KEY (GameID) REFERENCES Games(IDGame)
); 

CREATE TABLE Users(
	IDUser INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    UserLevel VARCHAR(20)
);
CREATE TABLE UserData(
	IDUserDate INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(14) NOT NULL,
    FirstName VARCHAR(20) NOT NULL,
    SecondName VARCHAR(20),
    FirstSurname VARCHAR(20) NOT NULL,
    SecondLastName VARCHAR(20),
    DateOfBirth DATE,
    NIT VARCHAR(15),
    UserID INT,
    CONSTRAINT FK_User_ID FOREIGN KEY (UserID) REFERENCES Users(IDUser)
);
CREATE TABLE PurchaseStatus(
	IDStatus  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    State VARCHAR(50)
);
CREATE TABLE VideoGameKeys(
	VideoGameKeysID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDGame INT,
    GameKey VARCHAR(16),
    Activate BOOLEAN,
    CONSTRAINT FK_Games_VideoGameKeys_ID FOREIGN KEY (IDGame) REFERENCES Games(IDGame)
);

-- AUN FALTAN INSERTS
CREATE TABLE ShoppingCarts(
	CartID  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDGames INT,
    Bought BOOLEAN,
    Quantity INT,
    IDDataUser INT,
    CONSTRAINT FK_UserData_ShoppingCarts_ID FOREIGN KEY (IDDataUser) REFERENCES UserData(IDUserDate),
    CONSTRAINT FK_Games_ShoppingCarts_ID FOREIGN KEY (IDGames) REFERENCES Games(IDGame),
	NumberOfVideoGames INT,
    TotalCost float
     
);
select * from ShoppingCarts;

CREATE TABLE PurchaseHistory(
	PurchaseHistoryID  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    DateAndTime TIMESTAMP,
    IDStatus INT,
    BillID VARCHAR(20),
    IDCart INT,
    IDKey INT,
    CONSTRAINT FK_Status_PurchaseHistory_ID FOREIGN KEY (IDStatus) REFERENCES PurchaseStatus(IDStatus),
    CONSTRAINT FK_Cart_PurchaseHistory_ID FOREIGN KEY (IDCart) REFERENCES ShoppingCarts(CartID),
    CONSTRAINT FK_Key_PurchaseHistory_ID FOREIGN KEY (IDKey) REFERENCES VideoGameKeys(VideoGameKeysID)
);
CREATE TABLE CardPayments(
	CardID  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDDataUser INT,
    Debit FLOAT,
    CardNumber VARCHAR(16),
    CONSTRAINT FK_IDDataUser_CardPayments_ID FOREIGN KEY (IDDataUser) REFERENCES UserData(IDUserDate)
);

-- Agregar datos a la tabla Audience
INSERT INTO Audience (Field)
VALUES ('3+'), ('7+'), ('12+'), ('16+'), ('18+');

-- Agregar datos a la tabla Developments
INSERT INTO Developments (NameDevelopment)
VALUES ('Electronic Arts'), ('Ubisoft'), ('Activision'), ('Nintendo'), ('Sony Interactive Entertainment');

-- Agregar datos a la tabla Categories
INSERT INTO Categories (Name)
VALUES ('Action'), ('Adventure'), ('RPG'), ('Sports'), ('Strategy');

-- Agregar datos a la tabla Platforms
INSERT INTO Plataforms (Name)
VALUES ('PC'), ('PS4'), ('PS5'), ('XBOX'), ('Switch');

-- Agregar datos a la tabla Games 
INSERT INTO Games (Name, CategoryID, PlataformID, AudienceID, DevelopmentID, Descripcion, RequisitosMin, RequisitosRec, Quantity, Price,ImagePath, Available) 
VALUES
	('Grand Theft Auto V', 1, 1, 3, 1, 'Open-world action-adventure game', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1050\nEspacio en disco: 50GB\nSistema Operativo: Windows 10', 'Procesador: Intel Core i7\nRAM: 16GB\nTarjeta gráfica: NVIDIA GeForce GTX 1080\nEspacio en disco: 50GB\nSistema Operativo: Windows 10',10, 299.99,"src/imgGameStoreCaratule/GTAV_image.jpg",1),
    ('The Witcher 3: Wild Hunt', 3, 1, 3, 2, 'Action role-playing game', 'Procesador: AMD Ryzen 3\nRAM: 4GB\nTarjeta gráfica: AMD Radeon RX 560\nEspacio en disco: 30GB\nSistema Operativo: Windows 8.1', 'Procesador: AMD Ryzen 5\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 570\nEspacio en disco: 50GB\nSistema Operativo: Windows 10',10, 199.99,"src/imgGameStoreCaratule/TheWitcher3_image.jpg",1),
    ('God of War', 1, 2, 3, 5, 'Action-adventure game based on Greek mythology','Procesador: Intel Core i3\nRAM: 6GB\nTarjeta gráfica: NVIDIA GeForce GTX 750\nEspacio en disco: 20GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/GodOfWar_image.jpeg",1),
    ('FIFA 22', 4, 2, 3, 3, 'Football sports game','Procesador: Intel Core 2 Duo\nRAM: 2GB\nTarjeta gráfica: NVIDIA GeForce 8800 GT\nEspacio en disco: 10GB\nSistema Operativo: Windows Vista', 'Procesador: Intel Core i5\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 660\nEspacio en disco: 20GB\nSistema Operativo: Windows 10', 10, 249.99,"src/imgGameStoreCaratule/Fifa_image.jpeg",1),
    ('Super Mario Odyssey', 2, 5, 1, 4, 'Platformer game featuring Mario','Procesador: AMD FX-6300\nRAM: 8GB\nTarjeta gráfica: AMD Radeon R9 270X\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 12GB\nTarjeta gráfica: AMD Radeon RX 580\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 399.99,"src/imgGameStoreCaratule/SuperMarioOdyssey.jpg",1),
    ('Halo Infinite', 1, 4, 3, 3, 'First-person shooter game','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 660\nEspacio en disco: 15GB\nSistema Operativo: Windows 8', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 449.99,"src/imgGameStoreCaratule/HaloInfinite_image.jpeg",1),
    ('Assassin''s Creed Valhalla', 1, 2, 3, 2, 'Action-adventure game set in the Viking Age','Procesador: Intel Core i5\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750 Ti\nEspacio en disco: 20GB\nSistema Operativo: Windows 10', 'Procesador: Intel Core i7\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1060\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 399.99,"src/imgGameStoreCaratule/AssassinsCreedValhalla_image.jpg",1),
    ('Minecraft', 2, 1, 3, 2, 'Sandbox game where you can build and explore','Procesador: Intel Core 2 Duo\nRAM: 2GB\nTarjeta gráfica: Intel HD Graphics 3000\nEspacio en disco: 5GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: Intel HD Graphics 4000\nEspacio en disco: 10GB\nSistema Operativo: Windows 8', 10, 199.99,"src/imgGameStoreCaratule/Minecraft_image.png",1),
    ('The Legend of Zelda: Breath of the Wild', 2, 5, 1, 4, 'Action-adventure game in an open world','Procesador: AMD FX-4300\nRAM: 6GB\nTarjeta gráfica: AMD Radeon RX 460\nEspacio en disco: 25GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 570\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/Zelda_image.jpg",1),
    ('Call of Duty: Warzone', 1, 1, 3, 3, 'Battle royale first-person shooter game','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750\nEspacio en disco: 15GB\nSistema Operativo: Windows 8.1', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 299.99,"src/imgGameStoreCaratule/CODWarzone_image.jpg",1),
    ('Red Dead Redemption 2', 1, 1, 3, 1, 'Open-world action-adventure game set in the Wild West','Procesador: AMD Ryzen 3\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 560\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 12GB\nTarjeta gráfica: AMD Radeon RX 580\nEspacio en disco: 50GB\nSistema Operativo: Windows 10', 10, 449.99,"src/imgGameStoreCaratule/RedDeadRedemption_image.jpg",1),
    ('Fortnite', 1, 1, 3, 2, 'Battle royale game with building mechanics', 'Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750\nEspacio en disco: 20GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 150.00,"src/imgGameStoreCaratule/Fortnite_image.jpg",1),
    ('Animal Crossing: New Horizons', 2, 5, 3, 4, 'Life simulation game where you create your own island','Procesador: AMD Ryzen 5\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 560\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 7\nRAM: 16GB\nTarjeta gráfica: AMD Radeon RX 570\nEspacio en disco: 60GB\nSistema Operativo: Windows 10', 10, 399.99,"src/imgGameStoreCaratule/AnimalCrossingNewHorizons_image.jpg",1),
    ('Battlefield V', 1, 1, 3, 1, 'First-person shooter game set in World War II','Procesador: Intel Core i5\nRAM: 6GB\nTarjeta gráfica: NVIDIA GeForce GTX 1050\nEspacio en disco: 25GB\nSistema Operativo: Windows 8.1', 'Procesador: Intel Core i7\nRAM: 12GB\nTarjeta gráfica: NVIDIA GeForce GTX 1070\nEspacio en disco: 50GB\nSistema Operativo: Windows 10', 10, 249.99,"src/imgGameStoreCaratule/BattlefieldV_image.jpg",1),
    ('Cyberpunk 2077', 1, 1, 3, 2, 'Open-world action-adventure game set in a dystopian future','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 760\nEspacio en disco: 20GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1060\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/CyberPunk2077_image.jpg",1),
    ('Overwatch', 1, 1, 3, 3, 'Team-based first-person shooter game','Procesador: AMD FX-6300\nRAM: 6GB\nTarjeta gráfica: AMD Radeon R9 270\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 12GB\nTarjeta gráfica: AMD Radeon RX 580\nEspacio en disco: 60GB\nSistema Operativo: Windows 10', 10, 199.99,"src/imgGameStoreCaratule/Overwatch_image.jpg",1),
    ('Super Smash Bros. Ultimate', 1, 5, 1, 4, 'Fighting game featuring various Nintendo characters','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 660\nEspacio en disco: 15GB\nSistema Operativo: Windows 8', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 399.99,"src/imgGameStoreCaratule/SuperSmashBrosUltimate_image.jpg",1),
    ('Resident Evil Village', 1, 1, 3, 5, 'Survival horror game','Procesador: Intel Core i5\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750 Ti\nEspacio en disco: 20GB\nSistema Operativo: Windows 10', 'Procesador: Intel Core i7\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1060\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/ResidentEvilVillage_image.png",1),
    ('NBA 2K22', 4, 3, 3, 3, 'Basketball sports game','Procesador: Intel Core 2 Duo\nRAM: 2GB\nTarjeta gráfica: Intel HD Graphics 3000\nEspacio en disco: 5GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: Intel HD Graphics 4000\nEspacio en disco: 10GB\nSistema Operativo: Windows 8', 10, 299.99,"src/imgGameStoreCaratule/NBA2K22_image.jpg",1),
    ('World of Warcraft', 3, 1, 3, 1, 'Massively multiplayer online role-playing game','Procesador: AMD FX-4300\nRAM: 6GB\nTarjeta gráfica: AMD Radeon RX 460\nEspacio en disco: 25GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 570\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 449.99,"src/imgGameStoreCaratule/WorldofWarcraft_image.jpg",1),
    ('Madden NFL 22', 4, 2, 3, 3, 'American football sports game','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750\nEspacio en disco: 15GB\nSistema Operativo: Windows 8.1', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 249.99,"src/imgGameStoreCaratule/MaddenNFL22_image.png",1),
    ('Pokémon Sword and Shield', 2, 5, 3, 4, 'Role-playing game with Pokémon battles','Procesador: Intel Core i5\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 960\nEspacio en disco: 20GB\nSistema Operativo: Windows 10', 'Procesador: Intel Core i7\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1070\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/PokémonSwordandShield_image.jpg",1),
    ('The Last of Us Part II', 1, 2, 3, 5, 'Action-adventure game in a post-apocalyptic world','Procesador: AMD Ryzen 3\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 560\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 12GB\nTarjeta gráfica: AMD Radeon RX 580\nEspacio en disco: 50GB\nSistema Operativo: Windows 10', 10, 399.99,"src/imgGameStoreCaratule/TheLastofUsII_image.png",1),
    ('Star Wars Jedi: Fallen Order', 1, 1, 3, 2, 'Action-adventure game set in the Star Wars universe','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 660\nEspacio en disco: 15GB\nSistema Operativo: Windows 8', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 299.99,"src/imgGameStoreCaratule/StarWarsJedi_image.jpg",1),
    ('Tom Clancy''s Rainbow Six Siege', 1, 1, 3, 2, 'Tactical first-person shooter game','Procesador: Intel Core i5\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750 Ti\nEspacio en disco: 20GB\nSistema Operativo: Windows 10', 'Procesador: Intel Core i7\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1060\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 249.99,"src/imgGameStoreCaratule/TomClancyRainbowSixS_image.jpg",1),
    ('F1 2021', 4, 1, 3, 3, 'Formula 1 racing game','Procesador: Intel Core 2 Duo\nRAM: 2GB\nTarjeta gráfica: Intel HD Graphics 3000\nEspacio en disco: 5GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: Intel HD Graphics 4000\nEspacio en disco: 10GB\nSistema Operativo: Windows 8', 10, 449.99,"src/imgGameStoreCaratule/F12021_image.png",1),
    ('Ghost of Tsushima', 1, 2, 3, 5, 'Action-adventure game set in feudal Japan','Procesador: AMD FX-4300\nRAM: 6GB\nTarjeta gráfica: AMD Radeon RX 460\nEspacio en disco: 25GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 8GB\nTarjeta gráfica: AMD Radeon RX 570\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/GhostofTsushima_image.png",1),
    ('Apex Legends', 1, 1, 3, 2, 'Battle royale first-person shooter game','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 750\nEspacio en disco: 15GB\nSistema Operativo: Windows 8.1', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 140.00,"src/imgGameStoreCaratule/ApexLegends_image.jpg",1),
    ('Super Mario Party', 2, 5, 3, 4, 'Party game with various minigames','Procesador: Intel Core i5\nRAM: 6GB\nTarjeta gráfica: NVIDIA GeForce GTX 1050\nEspacio en disco: 25GB\nSistema Operativo: Windows 8.1', 'Procesador: Intel Core i7\nRAM: 12GB\nTarjeta gráfica: NVIDIA GeForce GTX 1070\nEspacio en disco: 50GB\nSistema Operativo: Windows 10', 10, 399.99,"src/imgGameStoreCaratule/SuperMarioParty_image.png",1),
    ('Assassin''s Creed Odyssey', 1, 2, 3, 2, 'Action role-playing game set in ancient Greece','Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 760\nEspacio en disco: 20GB\nSistema Operativo: Windows 7', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 1060\nEspacio en disco: 40GB\nSistema Operativo: Windows 10', 10, 299.99,"src/imgGameStoreCaratule/ACreedOdyssey_image.jpg",1),
    ('Mortal Kombat 11', 1, 4, 3, 3, 'Fighting game with iconic characters','Procesador: AMD FX-6300\nRAM: 6GB\nTarjeta gráfica: AMD Radeon R9 270\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 'Procesador: AMD Ryzen 5\nRAM: 12GB\nTarjeta gráfica: AMD Radeon RX 580\nEspacio en disco: 60GB\nSistema Operativo: Windows 10', 10, 249.99,"src/imgGameStoreCaratule/MortalKombat11_image.jpeg",1),
    ('Marvel''s Spider-Man: Miles Morales', 1, 2, 3, 5, 'Action-adventure game featuring Spider-Man', 'Procesador: Intel Core i3\nRAM: 4GB\nTarjeta gráfica: NVIDIA GeForce GTX 660\nEspacio en disco: 15GB\nSistema Operativo: Windows 8', 'Procesador: Intel Core i5\nRAM: 8GB\nTarjeta gráfica: NVIDIA GeForce GTX 970\nEspacio en disco: 30GB\nSistema Operativo: Windows 10', 10, 349.99,"src/imgGameStoreCaratule/MarvelSpiderManMilesM_image.jpg",1);

-- Agregar datos a la tabla Offers
INSERT INTO Offers( PercentageDiscount, GameID ) 
VALUES ( '15', 24 ), ( '30', 6 ), ( '25', 10 ), ( '32', 1 ), ( '10', 12 );
 
-- Agregar datos a la tabla TopGames
INSERT INTO TopGames(GameID) VALUES(4),(8),(11),(32),(31);

-- Agregar datos a la tabla Users
INSERT INTO Users (Email, Password, UserLevel)
VALUES ('super@user.com', 'Admin123', 'Nivel 5'),
       ('janejohnson@example.com', 'contrasena2', 'Nivel 2'),
       ('bobbrown@example.com', 'contrasena3', 'Nivel 3'),
       ('alicesmith@example.com', 'contrasena4', 'Nivel 2'),
       ('mikemiller@example.com', 'contrasena5', 'Nivel 1'),
       ('emilytaylor@example.com', 'contrasena6', 'Nivel 3'),
       ('daviddavis@example.com', 'contrasena7', 'Nivel 1'),
       ('sarahharris@example.com', 'contrasena8', 'Nivel 2'),
       ('alexsmith@example.com', 'contrasena9', 'Nivel 3'),
       ('jala@jala.com', 'jala', 'Nivel 1');

-- Agregar datos a la tabla UserData
INSERT INTO UserData (UserName, FirstName, SecondName, FirstSurname, SecondLastName, DateOfBirth, NIT,UserID)
VALUES ('user1', 'John', 'Alan', 'Doe', 'Smith', '1990-01-01','1234567890', 1),
       ('user2', 'Jane', 'Beth', 'Johnson', 'Brown', '1995-05-10', '9876543210',2),
       ('user3', 'Bob', 'Clark', 'Brown', 'Jones', '1985-12-15', '2468135790',3),
       ('user4', 'Alice', 'Deborah', 'Smith', 'White', '1988-07-20', '1357924680',4),
       ('user5', 'Mike', 'Edward', 'Miller', 'Green', '1992-03-05', '8642097531',5),
       ('user6', 'Emily', 'Francis', 'Taylor', 'Gray', '1994-09-18', '9753108642',6),
       ('user7', 'David', 'George', 'Davis', 'Black', '1991-06-30', '9876540123',7),
       ('user8', 'Sarah', 'Helen', 'Harris', 'Wilson', '1993-11-25', '3210987654',8),
       ('user9', 'Alex', 'Ian', 'Smith', 'Jones', '1987-04-15', '7890123456',9),
       ('user10', 'Olivia', 'Jane', 'Johnson', 'Moore', '1996-02-12', '6123456789',10);

-- Agregar datos a la tabla PurchaseStatus
INSERT INTO PurchaseStatus(State)
VALUES ('Successfully purchased'), ('Key failures'), ('Lack of balance');

-- Agregar datos a la tabla VideoGameKeys
INSERT INTO VideoGameKeys (IDGame,GameKey, Activate)
VALUES
    -- Grand Theft Auto V
    (1, 'qHfG9j7K6L5m3N2P', 1),
    (1, 'eR4tY5uI8oO7pL1K', 1),
    (1, 'wS3eD6rF7tG2yH9J', 1),
    (1, 'uI2oP3aS5dF6gH4J', 1),
    (1, 'yN3bV7cX1mZ4lK8J', 1),
    (1, 'tR5eW4qA2sD3fG6H', 1),
    (1, 'iU8oP2lK5jM4nC7B', 1),
    (1, 'oP7iU6yH3tG4rF5D', 1),
    (1, 'pL2kM3nB7vC4xZ6Q', 1),
    (1, 'mN4bV8cX2zL7kP3', 1),
    -- The Witcher 3: Wild Hunt
    (2, 'qW3eR4tY5uI8oO7', 1),
    (2, 'wS2dF3gH4jK5lP6', 1),
    (2, 'eR6tY7uI8oO9pL1', 1),
    (2, 'rT5yU6iO7pA8sD9', 1),
    (2, 'tG7hJ8kL9zX1cV2', 1),
    (2, 'yN3bV7cX1mZ4lK8', 1),
    (2, 'uI8oP2lK5jM4nC7', 1),
    (2, 'iU6yH4tG2rF5dS3', 1),
    (2, 'oP1aS2dF3gH4jK5', 1),
    (2, 'pL6kM7nB8vC9xZ1', 1),
    -- God of War
    (3, 'qW2eR4tY5uI7oO9', 1),
    (3, 'wS1dF3gH5jK6lP7', 1),
    (3, 'eR8tY7uI9oP1aS2', 1),
    (3, 'rT4yU6iO3pA5sD7', 1),
    (3, 'tG9hJ2kL5zX8cV1', 1),
    (3, 'yN7bV4cX1mZ6lK9', 1),
    (3, 'uI3oP5aS8dF2gH4', 1),
    (3, 'oP7iU9yH2tG4rF6', 1),
    (3, 'pL5kM3nB7vC9xZ1', 1),
    -- The Legend of Zelda: Breath of the Wild
    (4, 'qW2eR4tY6uI8oO1', 1),
    (4, 'wS3dF5gH7jK9lP2', 1),
    (4, 'eR1tY3uI5oO7pL9', 1),
    (4, 'rT2yU4iO6pA8sD1', 1),
    (4, 'tG3hJ5kL7zX9cV2', 1),
    (4, 'yN1bV3cX5mZ7lK9', 1),
    (4, 'uI2oP4aS6dF8gH1', 1),
    (4, 'iU3yH5tG7rF9dS2', 1),
    (4, 'oP1iU3yH5tG7rF9', 1),
    (4, 'pL2kM4nB6vC8xZ1', 1),
    -- Minecraft
    (5, 'qW3eR5tY7uI9oO1', 1),
    (5, 'wS4dF6gH8jK1lP3', 1),
    (5, 'eR2tY4uI6oO8pL1', 1),
    (5, 'rT5yU7iO9pA1sD3', 1),
    (5, 'tG6hJ8kL1zX3cV5', 1),
    (5, 'yN4bV6cX8mZ1lK3', 1),
    (5, 'uI7oP9aS1dF3gH5', 1),
    (5, 'iU8yH1tG3rF5dS7', 1),
    (5, 'oP9iU1yH3tG5rF7', 1),
    (5, 'pL6kM8nB1vC3xZ5', 1),
    -- Super Mario Odyssey
    (6, 'qW1eR3tY5uI7oO9', 1),
    (6, 'wS2dF4gH6jK8lP0', 1),
    (6, 'eR3tY5uI7oO9pL1', 1),
    (6, 'rT4yU6iO8pA0sD2', 1),
    (6, 'tG5hJ7kL9zX1cV3', 1),
    (6, 'yN6bV8cX0mZ2lK4', 1),
    (6, 'uI7oP9aS1dF3gH5', 1),
    (6, 'iU8yH0tG2rF4dS6', 1),
    (6, 'oP9iU1yH3tG5rF7', 1),
    (6, 'pL0kM2nB4vC6xZ8', 1),
    -- Grand Theft Auto V
    (7, 'qW3eR5tY7uI9oO1', 1),
    (7, 'wS4dF6gH8jK1lP3', 1),
    (7, 'eR2tY4uI6oO8pL1', 1),
    (7, 'rT5yU7iO9pA1sD3', 1),
    (7, 'tG6hJ8kL1zX3cV5', 1),
    (7, 'yN4bV6cX8mZ1lK3', 1),
    (7, 'uI7oP9aS1dF3gH5', 1),
    (7, 'iU8yH1tG3rF5dS7', 1),
    (7, 'oP9iU1yH3tG5rF7', 1),
    (7, 'pL6kM8nB1vC3xZ5', 1),
    -- Overwatch
    (8, 'qW9eR8tY7uI6oO5', 1),
    (8, 'wS4dF3gH2jK1lP0', 1),
    (8, 'eR5tY6uI7oO8pL9', 1),
    (8, 'rT0yU1iO2pA3sD4', 1),
    (8, 'tG5hJ6kL7zX8cV9', 1),
    (8, 'yN4bV3cX2mZ1lK0', 1),
    (8, 'uI5oP6aS7dF8gH9', 1),
    (8, 'iU0yH1tG2rF3dS4', 1),
    (8, 'oP5iU6yH7tG8rF9', 1),
    -- The Legend of Zelda: Breath of the Wild
    (9, 'qW3eR5tY7uI9oO1', 1),
    (9, 'wS4dF6gH8jK1lP3', 1),
    (9, 'eR2tY4uI6oO8pL1', 1),
    (9, 'rT5yU7iO9pA1sD3', 1),
    (9, 'tG6hJ8kL1zX3cV5', 1),
    (9, 'yN4bV6cX8mZ1lK3', 1),
    (9, 'uI7oP9aS1dF3gH5', 1),
    (9, 'iU8yH1tG3rF5dS7', 1),
    (9, 'oP9iU1yH3tG5rF7', 1),
    (9, 'pL6kM8nB1vC3xZ5', 1),
    -- Minecraft
    (10, 'qW9eR8tY7uI6oO5', 1),
    (10, 'wS4dF3gH2jK1lP0', 1),
    (10, 'eR5tY6uI7oO8pL9', 1),
    (10, 'rT0yU1iO2pA3sD4', 1),
    (10, 'tG5hJ6kL7zX8cV9', 1),
    (10, 'yN4bV3cX2mZ1lK0', 1),
    (10, 'uI5oP6aS7dF8gH9', 1),
    (10, 'iU0yH1tG2rF3dS4', 1),
    (10, 'oP5iU6yH7tG8rF9', 1),
    (10, 'pL4kM3nB2vC1xZ0', 1),
    -- Fallout 4
    (11, 'qW3eR5tY7uI9oO1', 1),
    (11, 'wS4dF6gH8jK1lP3', 1),
    (11, 'eR2tY4uI6oO8pL1', 1),
    (11, 'rT5yU7iO9pA1sD3', 1),
    (11, 'tG6hJ8kL1zX3cV5', 1),
    (11, 'yN4bV6cX8mZ1lK3', 1),
    (11, 'uI7oP9aS1dF3gH5', 1),
    (11, 'iU8yH1tG3rF5dS7', 1),
    (11, 'oP9iU1yH3tG5rF7', 1),
    (11, 'pL6kM8nB1vC3xZ5', 1),
    -- Red Dead Redemption 2
    (12, 'qW3eR5tY7uI9oO1', 1),
    (12, 'wS4dF6gH8jK1lP3', 1),
    (12, 'eR2tY4uI6oO8pL1', 1),
    (12, 'rT5yU7iO9pA1sD3', 1),
    (12, 'tG6hJ8kL1zX3cV5', 1),
    (12, 'yN4bV6cX8mZ1lK3', 1),
    (12, 'uI7oP9aS1dF3gH5', 1),
    (12, 'iU8yH1tG3rF5dS7', 1),
    (12, 'oP9iU1yH3tG5rF7', 1),
    (12, 'pL6kM8nB1vC3xZ5', 1),
    -- The Witcher 3: Wild Hunt
    (13, 'qW9eR8tY7uI6oO5', 1),
    (13, 'wS4dF3gH2jK1lP0', 1),
    (13, 'eR5tY6uI7oO8pL9', 1),
    (13, 'rT0yU1iO2pA3sD4', 1),
    (13, 'tG5hJ6kL7zX8cV9', 1),
    (13, 'yN4bV3cX2mZ1lK0', 1),
    (13, 'uI5oP6aS7dF8gH9', 1),
    (13, 'iU0yH1tG2rF3dS4', 1),
    (13, 'oP5iU6yH7tG8rF9', 1),
    (13, 'pL4kM3nB2vC1xZ0', 1),
    -- Dark Souls III
    (14, 'qW3eR5tY7uI9oO1', 1),
    (14, 'wS4dF6gH8jK1lP3', 1),
    (14, 'eR2tY4uI6oO8pL1', 1),
    (14, 'rT5yU7iO9pA1sD3', 1),
    (14, 'tG6hJ8kL1zX3cV5', 1),
    (14, 'yN4bV6cX8mZ1lK3', 1),
    (14, 'uI7oP9aS1dF3gH5', 1),
    (14, 'iU8yH1tG3rF5dS7', 1),
    (14, 'oP9iU1yH3tG5rF7', 1),
    -- God of War (2018)
    (15, 'qW9eR8tY7uI6oO5', 1),
    (15, 'wS4dF3gH2jK1lP0', 1),
    (15, 'eR5tY6uI7oO8pL9', 1),
    (15, 'rT0yU1iO2pA3sD4', 1),
    (15, 'tG5hJ6kL7zX8cV9', 1),
    (15, 'yN4bV3cX2mZ1lK0', 1),
    (15, 'uI5oP6aS7dF8gH9', 1),
    (15, 'iU0yH1tG2rF3dS4', 1),
    (15, 'oP5iU6yH7tG8rF9', 1),
    (15, 'pL4kM3nB2vC1xZ0', 1),
    -- Uncharted 4: A Thief's End
    (16, 'qW3eR5tY7uI9oO1', 1),
    (16, 'wS4dF6gH8jK1lP3', 1),
    (16, 'eR2tY4uI6oO8pL1', 1),
    (16, 'rT5yU7iO9pA1sD3', 1),
    (16, 'tG6hJ8kL1zX3cV5', 1),
    (16, 'yN4bV6cX8mZ1lK3', 1),
    (16, 'uI7oP9aS1dF3gH5', 1),
    (16, 'iU8yH1tG3rF5dS7', 1),
    (16, 'oP9iU1yH3tG5rF7', 1),
    (16, 'pL6kM8nB1vC3xZ5', 1),
    -- Horizon Zero Dawn
    (17, 'qW9eR8tY7uI6oO5', 1),
    (17, 'wS4dF3gH2jK1lP0', 1),
    (17, 'eR5tY6uI7oO8pL9', 1),
    (17, 'rT0yU1iO2pA3sD4', 1),
    (17, 'tG5hJ6kL7zX8cV9', 1),
    (17, 'yN4bV3cX2mZ1lK0', 1),
    (17, 'uI5oP6aS7dF8gH9', 1),
    (17, 'iU0yH1tG2rF3dS4', 1),
    (17, 'oP5iU6yH7tG8rF9', 1),
    -- Assassin's Creed Odyssey
    (18, 'qW3eR5tY7uI9oO1', 1),
    (18, 'wS4dF6gH8jK1lP3', 1),
    (18, 'eR2tY4uI6oO8pL1', 1),
    (18, 'rT5yU7iO9pA1sD3', 1),
    (18, 'tG6hJ8kL1zX3cV5', 1),
    (18, 'yN4bV6cX8mZ1lK3', 1),
    (18, 'uI7oP9aS1dF3gH5', 1),
    (18, 'iU8yH1tG3rF5dS7', 1),
    (18, 'oP9iU1yH3tG5rF7', 1),
    (18, 'pL6kM8nB1vC3xZ5', 1),
    -- Bloodborne
    (19, 'qW9eR8tY7uI6oO5', 1),
    (19, 'wS4dF3gH2jK1lP0', 1),
    (19, 'eR5tY6uI7oO8pL9', 1),
    (19, 'rT0yU1iO2pA3sD4', 1),
    (19, 'tG5hJ6kL7zX8cV9', 1),
    (19, 'yN4bV3cX2mZ1lK0', 1),
    (19, 'uI5oP6aS7dF8gH9', 1),
    (19, 'iU0yH1tG2rF3dS4', 1),
    (19, 'oP5iU6yH7tG8rF9', 1),
    (19, 'pL4kM3nB2vC1xZ0', 1),
    -- The Last of Us Part II
    (20, 'qW3eR5tY7uI9oO1', 1),
    (20, 'wS4dF6gH8jK1lP3', 1),
    (20, 'eR2tY4uI6oO8pL1', 1),
    (20, 'rT5yU7iO9pA1sD3', 1),
    (20, 'tG6hJ8kL1zX3cV5', 1),
    (20, 'yN4bV6cX8mZ1lK3', 1),
    (20, 'uI7oP9aS1dF3gH5', 1),
    (20, 'iU8yH1tG3rF5dS7', 1),
    (20, 'oP9iU1yH3tG5rF7', 1),
    -- Grand Theft Auto V
    (21, 'qW9eR8tY7uI6oO5', 1),
    (21, 'wS4dF3gH2jK1lP0', 1),
    (21, 'eR5tY6uI7oO8pL9', 1),
    (21, 'rT0yU1iO2pA3sD4', 1),
    (21, 'tG5hJ6kL7zX8cV9', 1),
    (21, 'yN4bV3cX2mZ1lK0', 1),
    (21, 'uI5oP6aS7dF8gH9', 1),
    (21, 'iU0yH1tG2rF3dS4', 1),
    (21, 'oP5iU6yH7tG8rF9', 1),
    (21, 'pL4kM3nB2vC1xZ0', 1),
    -- Overwatch
    (22, 'qW3eR5tY7uI9oO1', 1),
    (22, 'wS4dF6gH8jK1lP3', 1),
    (22, 'eR2tY4uI6oO8pL1', 1),
    (22, 'rT5yU7iO9pA1sD3', 1),
    (22, 'tG6hJ8kL1zX3cV5', 1),
    (22, 'yN4bV6cX8mZ1lK3', 1),
    (22, 'uI7oP9aS1dF3gH5', 1),
    (22, 'iU8yH1tG3rF5dS7', 1),
    (22, 'oP9iU1yH3tG5rF7', 1),
    (22, 'pL6kM8nB1vC3xZ5', 1),
    -- Super Mario Odyssey
    (23, 'qW9eR8tY7uI6oO5', 1),
    (23, 'wS4dF3gH2jK1lP0', 1),
    (23, 'eR5tY6uI7oO8pL9', 1),
    (23, 'rT0yU1iO2pA3sD4', 1),
    (23, 'tG5hJ6kL7zX8cV9', 1),
    (23, 'yN4bV3cX2mZ1lK0', 1),
    (23, 'uI5oP6aS7dF8gH9', 1),
    (23, 'iU0yH1tG2rF3dS4', 1),
    (23, 'oP5iU6yH7tG8rF9', 1),
    -- Minecraft
    (24, 'qW3eR5tY7uI9oO1', 1),
    (24, 'wS4dF6gH8jK1lP3', 1),
    (24, 'eR2tY4uI6oO8pL1', 1),
    (24, 'rT5yU7iO9pA1sD3', 1),
    (24, 'tG6hJ8kL1zX3cV5', 1),
    (24, 'yN4bV6cX8mZ1lK3', 1),
    (24, 'uI7oP9aS1dF3gH5', 1),
    (24, 'iU8yH1tG3rF5dS7', 1),
    (24, 'oP9iU1yH3tG5rF7', 1),
    (24, 'pL6kM8nB1vC3xZ5', 1),
    -- League of Legends
    (25, 'qW9eR8tY7uI6oO5', 1),
    (25, 'wS4dF3gH2jK1lP0', 1),
    (25, 'eR5tY6uI7oO8pL9', 1),
    (25, 'rT0yU1iO2pA3sD4', 1),
    (25, 'tG5hJ6kL7zX8cV9', 1),
    (25, 'yN4bV3cX2mZ1lK0', 1),
    (25, 'uI5oP6aS7dF8gH9', 1),
    (25, 'iU0yH1tG2rF3dS4', 1),
    (25, 'oP5iU6yH7tG8rF9', 1),
    (25, 'pL4kM3nB2vC1xZ0', 1),
    -- Stardew Valley
    (26, 'qW3eR5tY7uI9oO1', 1),
    (26, 'wS4dF6gH8jK1lP3', 1),
    (26, 'eR2tY4uI6oO8pL1', 1),
    (26, 'rT5yU7iO9pA1sD3', 1),
    (26, 'tG6hJ8kL1zX3cV5', 1),
    (26, 'yN4bV6cX8mZ1lK3', 1),
    (26, 'uI7oP9aS1dF3gH5', 1),
    (26, 'iU8yH1tG3rF5dS7', 1),
    (26, 'oP9iU1yH3tG5rF7', 1),
    -- Fortnite
    (27, 'qW9eR8tY7uI6oO5', 1),
    (27, 'wS4dF3gH2jK1lP0', 1),
    (27, 'eR5tY6uI7oO8pL9', 1),
    (27, 'rT0yU1iO2pA3sD4', 1),
    (27, 'tG5hJ6kL7zX8cV9', 1),
    (27, 'yN4bV3cX2mZ1lK0', 1),
    (27, 'uI5oP6aS7dF8gH9', 1),
    (27, 'iU0yH1tG2rF3dS4', 1),
    (27, 'oP5iU6yH7tG8rF9', 1),
    (27, 'pL4kM3nB2vC1xZ0', 1),
    -- World of Warcraft
    (28, 'qW3eR5tY7uI9oO1', 1),
    (28, 'wS4dF6gH8jK1lP3', 1),
    (28, 'eR2tY4uI6oO8pL1', 1),
    (28, 'rT5yU7iO9pA1sD3', 1),
    (28, 'tG6hJ8kL1zX3cV5', 1),
    (28, 'yN4bV6cX8mZ1lK3', 1),
    (28, 'uI7oP9aS1dF3gH5', 1),
    (28, 'iU8yH1tG3rF5dS7', 1),
    (28, 'oP9iU1yH3tG5rF7', 1),
    (28, 'pL6kM8nB1vC3xZ5', 1),
    -- The Legend of Zelda: Breath of the Wild
    (29, 'qW9eR8tY7uI6oO5', 1),
    (29, 'wS4dF3gH2jK1lP0', 1),
    (29, 'eR5tY6uI7oO8pL9', 1),
    (29, 'rT0yU1iO2pA3sD4', 1),
    (29, 'tG5hJ6kL7zX8cV9', 1),
    (29, 'yN4bV3cX2mZ1lK0', 1),
    (29, 'uI5oP6aS7dF8gH9', 1),
    (29, 'iU0yH1tG2rF3dS4', 1),
    (29, 'oP5iU6yH7tG8rF9', 1),
    -- Dark Souls III
    (30, 'qW3eR5tY7uI9oO1', 1),
    (30, 'wS4dF6gH8jK1lP3', 1),
    (30, 'eR2tY4uI6oO8pL1', 1),
    (30, 'rT5yU7iO9pA1sD3', 1),
    (30, 'tG6hJ8kL1zX3cV5', 1),
    (30, 'yN4bV6cX8mZ1lK3', 1),
    (30, 'uI7oP9aS1dF3gH5', 1),
    (30, 'iU8yH1tG3rF5dS7', 1),
    (30, 'oP9iU1yH3tG5rF7', 1),
    (30, 'pL6kM8nB1vC3xZ5', 1),
    -- Animal Crossing: New Horizons
    (31, 'qW9eR8tY7uI6oO5', 1),
    (31, 'wS4dF3gH2jK1lP0', 1),
    (31, 'eR5tY6uI7oO8pL9', 1),
    (31, 'rT0yU1iO2pA3sD4', 1),
    (31, 'tG5hJ6kL7zX8cV9', 1),
    (31, 'yN4bV3cX2mZ1lK0', 1),
    (31, 'uI5oP6aS7dF8gH9', 1),
    (31, 'iU0yH1tG2rF3dS4', 1),
    (31, 'oP5iU6yH7tG8rF9', 1),
    (31, 'pL4kM3nB2vC1xZ0', 1),
    -- Doom Eternal
    (32, 'qW3eR5tY7uI9oO1', 1),
    (32, 'wS4dF6gH8jK1lP3', 1),
    (32, 'eR2tY4uI6oO8pL1', 1),
    (32, 'rT5yU7iO9pA1sD3', 1),
    (32, 'tG6hJ8kL1zX3cV5', 1),
    (32, 'yN4bV6cX8mZ1lK3', 1),
    (32, 'uI7oP9aS1dF3gH5', 1),
    (32, 'iU8yH1tG3rF5dS7', 1),
    (32, 'oP9iU1yH3tG5rF7', 1);
    
    
-- Agregar datos a la tabla ShoppingCarts
INSERT INTO ShoppingCarts (IDGames, Bought, Quantity, IDDataUser)
VALUES
(1, 0, 2, 2),
(3, 0, 1, 3),
(5, 0, 3, 4),
(7, 0, 1, 5),
(9, 0, 2, 6),
(11, 0, 1, 7),
(13, 0, 2, 8),
(15, 0, 1, 9),
(17, 0, 3, 2),
(19, 0, 1, 3);

-- Agregar datos a la tabla PurchaseHistory
INSERT INTO PurchaseHistory (DateAndTime, IDStatus, BillID, IDCart, IDKey)
VALUES
('2023-06-01 10:30:00', 1, 'BILL001', 1, 1),
('2023-06-02 14:45:00', 1, 'BILL002', 2, 2),
('2023-06-03 09:15:00', 1, 'BILL003', 3, 3),
('2023-06-04 16:20:00', 1, 'BILL004', 4, 4),
('2023-06-05 11:10:00', 1, 'BILL005', 5, 5),
('2023-06-06 13:55:00', 1, 'BILL006', 6, 6),
('2023-06-07 08:45:00', 1, 'BILL007', 7, 7),
('2023-06-08 12:30:00', 1, 'BILL008', 8, 8),
('2023-06-09 15:00:00', 1, 'BILL009', 9, 9),
('2023-06-10 09:30:00', 1, 'BILL010', 10, 10);
-- Agregar tarjetas
INSERT INTO CardPayments (IDDataUser, Debit, CardNumber)
VALUES (10,0,'1234567890123456'),(10,100000,'1234567890123457');