# 
# Meagan Waldo 
# 02/24/2021 
# This SQL code is used to create a MySQL database with information about Offensive NFL players (Quarterbacks, Running Backs, and Wide Receivers). 
# 

#
# This table is called Players. This table is used to store data such as Name, PlayerID, Team name, Position, Touchdowns, Total Yards and Salary.
# I want the PlayerID to be unique so that the player can be easily identified and not confused with others. I want to check if Position is one of
# the three available position choices so that incorrect data cannot be added. All the data in this table must not be null because each are valuable
# pieces of information. I chose to make the PlayerID the primary key since it can be used to easily identify the player that all the other data in the 
# table is connected to.
#
create table Players
	(Name   varchar(20) not null,
	 PlayerID   integer not null,
		unique (PlayerID),
     Team_name   varchar(20) not null,
     Position   varchar(2) not null
		check (position in ('QB', 'RB', 'WR')),
	 Touchdowns   integer not null,
     Total_Yards   integer not null,
     Salary   integer not null,
	 primary key (PlayerID)
	);

#
# This table is called Games. This table is used to store data such as GameID, Date, Stadium, Result, Attendance and Ticket Revenue.
# I want the GameID to be unique so that the games can be easily identified among each other. I want to check if Result is one of
# the three available result choices so that incorrect data cannot be added. All the data in this table must not be null because each are valuable
# pieces of information. I chose to make the GameID the primary key since it can be used to easily identify the game that all the other data in the table
# is connected to.
#
create table Games
	(GameID   integer not null,
		unique (GameID),
     Date   date not null,
     Stadium   varchar(20) not null,
     Result   varchar(1) not null
		check (result in ('W', 'L', 'T')),
	 Attendance   integer not null,
     Ticket_Revenue   integer not null,
     primary key (GameID)
	);
    
#
# This table is called Play. This table is used to store data such as PlayerID and GameID.
# All the data in this table must not be null because each are valuable pieces of information. I chose to make the GameID and PlayerID the primary keys 
# since it can be used to help easily identify the game and player which has data in the two other tables. I chose to create two foreign keys to grab the data
# of PlayerID and GameID from the tables Players and Games. When deleted the data is deleted using a cascade delete for both foreign keys. I chose to use cascade
# delete due to this table mainly holding the child information of two parent tables called Players and Games.
#
create table Play
	(PlayerID   integer not null,
	 GameID   integer not null,
     primary key (PlayerID, GameID),
     foreign key (PlayerID) references Players(PlayerID)
        on delete cascade,
     foreign key (GameID) references Games(GameID)
		on delete cascade
	);