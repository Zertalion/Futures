create table Sales(
Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
lastName varchar(255) NOT NULL,
firstName varchar(255),
dateOFBirth date,
department varchar(255)
);

create table Clients (
Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Nationality varchar(255),
dateOFBirth date
);

create table Contract(
Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
ClientId int,
SalesId int,
creationDate datetime,
settlementDate date not null,
usedCurrency varchar(255),
boughtCurrency varchar(255),
exchangeRate float,
amount int,
price int,
FOREIGN KEY (ClientId) REFERENCES Clients(Id),
FOREIGN KEY (SalesId) REFERENCES Sales(id)
);