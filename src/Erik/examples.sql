select 'Hello World!' as greeting;
use mondial;

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




-- Population von Austria
select name, Population 
from country 
where Capital = 'vienna';



-- Population from Europe
select SUM(Population) Population 
from encompasses
join country on country.Code = encompasses.Country 
where continent = 'Europe' and encompasses.Percentage >= 50;

-- Population from Europe Step by Step:
-- Step 1:
select * from encompasses e ;

-- Step 2:
select * from country c ;

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
-- -----------------------------------------------------------


-- Which rivers in Austria
select distinct geo_river.River 
from geo_river  
join country on country.code = geo_river.Country 
 where country.name = 'Austria';



-- Which Rivers in Europe
select * from geo_river gr; -- Verbindung?
select * from encompasses e; -- Verbindung?

select distinct gr.River 
from geo_river gr 
join encompasses e on gr.Country = e.Country 
where e.Continent = 'Europe' and e.Percentage  >= 50
order by gr.river asc;



select *
from encompasses e 

select sum(Population) pop
from encompasses e 
join country c on e.Country = c.Code 



select 
100 * (
	select SUM(Population) PopEurope
	from encompasses e 
	join country c on e.Country = c.Code 
	where e.Continent = 'Europe' and Percentage >= 50
	) / (select sum(Population) popWorld from country) as anteil


select name  from country c where name like 'A%';


select * from country;
select * from province;
select * from river;
select * from geo_river;


select c.Name ,p.Name, p.Population 
from province p 
join country c on p.Country = c.Code 
where c.name like 'A%'
order by p.Population desc;


select distinct r.name, r.`Length` 
from geo_river gr
join river r on gr.River = r.name
join encompasses e on gr.Country = e.Country 
where e.Continent = 'Europe' and e.Percentage >=99
order by r.`Length` asc;







select * from river


select * from borders limit 20;
select * from city limit 20;
select * from country limit 20;
select * from economy e limit 20;
select * from encompasses e limit 20;
select * from continent c limit 20;


select * from desert d limit 20;

