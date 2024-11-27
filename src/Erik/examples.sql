select 'Hello World!' as greeting;
use mondial;

-- Examples

select * from country;

select Name, Capital from country;

select Name, Capital as Hauptstadt from country;

select *, (Population / Area) as populationDestiny from country;

select *, round(Population / Area, 3) as populationDestiny from country;

select Name, Population, round(Population, -3) Population2 from country; 

select * from country limit 10; -- MySQL
-- select Top 10 * from country; -- Microsoft SQL

select * from country where Population > 10000000;
select * from country where Population < 10000000;
select * from country where Population >= 10000000;
select * from country where Population <= 10000000;	
select * from country where Population = 22664136;	-- ist gleich
select * from country where Population <> 22664136; -- nicht gleich

select * from country where (Population/Area) < 10;

select * from country where Population > 100000 and Area < 10000;
select * from country where Population > 100000 or Area < 10000;

select if (name = 'Austria', 'Österreich', name) as name from country; -- nicht üblich 

select * from country where Population > 100000000 and Population < 200000000;
select * from country where Population between 10000000 and 20000000;

select * from country where Capital = 'vienna'; -- groß kleinschreibung ist uninteressant

select * from country order by Capital;
select * from country order by Area;

select * from country order by Area asc;	-- aufsteigen sortieren
select * from country order by Area desc;	-- absteigend sortieren

select * from country order by (Population/Area) desc; 
select name from country order by (Population/Area) desc limit 5; 

-- Pause

-- select * from city order by country;
select country, min(Population) Population from city group by country;
select country, max(Population) Population from city group by country;

select country, count(Population) as AnzahlStaedte from  city group by Country;
select country, sum(Population) as totalPopInCity from  city group by Country;

select Country, count(name) AnzahlStaedte 
from city
where Population  > 100
group by Country
order by AnzahlStaedte desc, country asc;

select * from city where name = 'vienna';

select * from city where name like 'vi%';		-- filtert nach vi am anfang
select * from city where name like '%na';		-- filtert nach na am schluss
select * from city where name like '%enna%';	-- filtert nach enna im namen

select * from country limit 5;
select * from city limit 5;

select country.Name countryName, city.Name cityName
from city
join country on city.Country = Country.Code
order by countryName, cityName;

select *
from country co
join ismember im on co.Code = im.Country;

select *
from country co
left join ismember im on co.Code = im.Country;

-- Suche nach dem, was nicht da ist...
select co.Name 
from country co
left join ismember im on co.Code = im.Country
where im.Country is null;



select o.Abbreviation, o.Name 
from country co
join ismember im on co.Code = im.Country 
join organization o on im.Organization = o.Abbreviation
where co.Name = 'Austria' and im.`Type` = 'Member';



select country.Name, maxCity.AnzahlStaedte 
from 
(
	select Country, count(name) AnzahlStaedte 
	from city
	where Population  > 1000000
	group by Country
	order by AnzahlStaedte desc, country asc
) as maxCity
join country on maxCity.Country = country.code;



select Country.Name, city.Name, city.Population 
from 
(
	select Country, max(Population) as Population 
	from city ci
	group by Country
) bigCity
join city on city.Country = bigCity.Country
join country on city.Country = Country.Code
where bigCity.Population = city.Population
order by country.Name asc;
-- -------------------------------------------------------------

-- SQL Querie Aufgaben

-- Population(Einwohner) in Austria
select * from country c;

select name, Population 
from country 
where Capital = 'vienna';

-- -------------------------------------------------------------

-- Population from Europe
select SUM(Population) Population 
from encompasses
join country on country.Code = encompasses.Country 
where continent = 'Europe' and encompasses.Percentage >= 50;


-- Population from Europe Step by Step:
-- Step 1:
select * from encompasses e;

-- Step 2:
select * from country c;

-- Step 3:
select *
from encompasses e
join country c on e.Country = c.Code;

-- Step 4:
select *
from encompasses e 
join country c on e.Country = c.Code 
where e.Continent = 'Europe';

-- Step 5:
select *
from encompasses e 
join country c on e.Country = c.Code 
where e.Continent = 'Europe' and Percentage >= 50

-- Step 6:
select SUM(Population) Pop
from encompasses e 
join country c on e.Country = c.Code 
where e.Continent = 'Europe' and Percentage >= 50

-- -------------------------------------------------------------

-- Which rivers in Austria
select * from geo_river gr;
select * from country c;

select distinct geo_river.River 
from geo_river  
join country on country.code = geo_river.Country 
 where country.name = 'Austria';

-- -------------------------------------------------------------

-- Which Rivers in Europe
select * from geo_river gr;		-- Verbindungs Check
select * from encompasses e; 	-- Verbindungs Check

select distinct gr.River 
from geo_river gr 
join encompasses e on gr.Country = e.Country 
where e.Continent = 'Europe' and e.Percentage  >= 50
order by gr.river asc;

-- -------------------------------------------------------------

-- How many Percent of People live in Europa
select * from encompasses e;

select sum(Population) pop
from encompasses e 
join country c on e.Country = c.Code;

select 
100 * (
	select SUM(Population) PopEurope
	from encompasses e 
	join country c on e.Country = c.Code 
	where e.Continent = 'Europe' and Percentage >= 50
	) / (select sum(Population) popWorld from country) as anteil

-- -------------------------------------------------------------

-- All Countries with the beginning Letter 'A'	
select * from country c;
	
select name  
from country c 
where name like 'A%';

-- -------------------------------------------------------------

-- All Countries with the beginning Letter 'A' with State and Populition sorted by Population
select * from country;
select * from province;

select c.Name, p.Name, p.Population 
from province p 
join country c on p.Country = c.Code 
where c.name like 'A%'
order by p.Population desc;

-- -------------------------------------------------------------

-- All rivers only through Europe with name and length sorted by length
select * from river;
select * from geo_river;

select distinct r.name, r.`Length` 
from geo_river gr
join river r on gr.River = r.name
join encompasses e on gr.Country = e.Country 
where e.Continent = 'Europe' and e.Percentage >= 99
order by r.`Length` asc;

-- -------------------------------------------------------------

-- All Island's in the Paficic Ocean with > 50% Muslim confession(Bekenntnis)
select * from geo_sea;
select * from geo_island;
select * from religion;
select * from islandin i;

select *
from islandin i 
where i.Sea = 'pacific ocean';
 
select i.Island 
from religion r 
join geo_island gi on r.Country = gi.Country 
join islandin i on gi.Island = i.Island 
where i.Sea = 'pacific ocean' and r.Name = 'muslim' and r.Percentage >= 50;

-- -------------------------------------------------------------

-- All 3000m height Mountains in a Land with min 60% Roman Catholic Confession
select * from geo_mountain gm;
select * from mountain m;
select * from country c;
select * from religion r;

select distinct m.Name 
from religion r 
join geo_mountain gm on r.Country = gm.Country 
join mountain m on gm.Mountain = m.Name
where m.Height >= 3000 and r.name = 'Roman Catholic' and r.Percentage >= 60
order by m.Name;

-- -------------------------------------------------------------

-- All Countries with a See depth from 100m and a Mountain height from 1500m
select * from country;
select * from lake;
select * from mountain;

select distinct gm.Country 
from geo_mountain gm 
join geo_lake gl on gm.Country = gl.Country 
join mountain m on gm.Mountain = m.Name 
join lake l on gl.Lake = l.Name 
where l.`Depth` >= 100 and m.Height >= 1500;

-- -------------------------------------------------------------

-- Population per Religion
select * from religion r;
select * from country;

select c.Population, r.Name 
from religion r 
join country c on r.Country = c.Code;

select r.name, sum(round(c.Population * r.Percentage / 100)) religiousPerson
from religion r 
join country c on r.Country = c.Code
group by r.name
order by religiousPerson desc;

-- -------------------------------------------------------------

-- Alle Länder, nur die Namen und Meere dazu (Ohne Null)
select * from country;
select * from geo_sea;

select distinct c.name, s.Name 
from geo_sea gs
join country c on gs.Country = c.code
join sea s on gs.Sea = s.Name;

-- -------------------------------------------------------------

-- Alle länder nur die Namen und wenn sie haben das Meer dazu (Mit Null)
select * from geo_sea gs;
select * from country c;

select distinct c.name, gs.Sea 
from geo_sea gs
right join country c on gs.Country = c.code;

-- -------------------------------------------------------------

-- Unabhängigskeitsdatum von Ländern die eine Wüste haben mit ethnische Gruppe African
select * from geo_desert;
select * from country;
select * from politics p;
select * from ethnicgroup e;

select p.Independence, c.Name, gd.Desert 
from geo_desert gd 
join country c on gd.Country = c.Code
join politics p on p.Country = c.Code
join ethnicgroup e on e.Country = c.Code
where e.Name = 'African';

-- -------------------------------------------------------------

-- Which Countries have 3 Cities and how they called
select * from country c; 
select * from city c;

select c2.Name, Count(c.Name) AnzahlStaedte 
from city c 
join country c2 on c.Country = c2.Code 
group by c2.Name 
order by c2.Name;

select t.name 
from 
(
	select c2.Name, Count(c.Name) AnzahlStaedte 
	from city c 
	join country c2 on c.Country = c2.Code 
	group by c2.Name 
) as t
where t.AnzahlStaedte = 3;

-- -------------------------------------------------------------

-- Welches sind die 3 größten Städte von Amerika (Kontinent)?
select * from country c;
select * from city c;



-- -------------------------------------------------------------