create table Sales(
id int NOT NULL,
lastName varchar(255) NOT NULL,
firstName varchar(255),
age int,
department varchar(255),
PRIMARY KEY (id)
);

create table Clients (
Id int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Nationality varchar(255),
age int,
salesId int,
PRIMARY KEY (Id),
FOREIGN KEY (salesId) REFERENCES Sales(id)
);

create table Contract(
id int not null,
ClientId int,
SalesId int,
creationDate datetime,
settlementDate date not null,
usedCurrency varchar(255),
boughtCurrency varchar(255),
exchangeRate float,
amount int,
price int,
PRIMARY KEY (id),
FOREIGN KEY (ClientId) REFERENCES Clients(Id),
FOREIGN KEY (SalesId) REFERENCES Sales(id)
);

