# 
# Meagan Waldo 
# 02/24/2021 
# This SQL code is used to insert 5 records of data into each table. 
# 

#
# These records are being inserted into the table Players. It contains the data Name, PlayerID, Team name, Position, Touchdowns, Total Yards and Salary.
#
insert into Players values ('Drew Lock', '100', 'Denver Broncos', 'QB', '23', '3953', '1752704');
insert into Players values ('Phillip Lindsay', '101', 'Denver Broncos', 'RB', '18', '2550', '575000');
insert into Players values ('Courtland Sutton', '102', 'Denver Broncos', 'WR', '10', '1882', '1710480');
insert into Players values ('Lamar Jackson', '200', 'Baltimore Ravens', 'QB', '68', '7085', '1771588');
insert into Players values ('Dez Bryant', '201', 'Baltimore Ravens', 'WR', '78', '7506', '1050000');

#
# These records are being inserted into the table Games. It contains the data GameID, Date, Stadium, Result, Attendance and Ticket Revenue.
#
insert into Games values ('10000', '2020/05/04', 'Lambeau Field', 'W', '75210', '7001000');
insert into Games values ('10012', '2021/01/02', 'Lambeau Field', 'L', '79310', '7056000');
insert into Games values ('20100', '2021/03/02', 'Lumen Field', 'T', '68740', '7156000');
insert into Games values ('20130', '2020/07/07', 'Lumen Field', 'W', '64440', '7006000');
insert into Games values ('30000', '2021/02/06', 'Empower Field', 'L', '70500', '7067054');

#
# These records are being inserted into the table Play. It contains the data PlayerID and GameID.
#
insert into Play values ('100', '10000');
insert into Play values ('100', '10012');
insert into Play values ('200', '20130');
insert into Play values ('201', '20130');
insert into Play values ('101', '30000');


LOAD DATA INFILE 'test2.txt' INTO TABLE Players FIELDS TERMINATED BY ', ' ENCLOSED BY '\'' LINES TERMINATED BY '\r';

