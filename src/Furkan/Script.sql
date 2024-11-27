select 'Hello World' as greetings;

use mondial;

select * from country;

select Name, Capital from country c ;

select Name, Capital as Hauptstadt from country c ;

select *, (Population / Area) as populationDensity from country c ;

select *, round(Population / Area, 3) as populationDensity from country c ;

select Name, Population, round(Population, -3) Population2 from country c ;

select * from country c limit 10; -- MySQL

select top 10 * from country c ; -- Microsoft sql

select * from country c where Population > 10000000;

select * from country c where Population < 10000000;

select * from country c where Population >= 10000000;

select * from country c where Population <= 10000000;

select * from country c where Population = 22664136; -- ist gleich

select * from country c where Population <> 22664136; -- nicht gleich

select * from country c where (Population / Area) < 10;

select * from country c where Population > 10000000 and Area < 100000;
select * from country c where Population > 10000000 or Area < 100000;

select if (name = 'Austria', 'Österreich', name) as name from country c ;

select * from country c where Population > 10000000 and Population < 200000000;
select * from country c where Population between 1000000 and 2000000;

select * from country c where Capital = 'Vienna';

select * from country c order by Capital;
select * from country c order by Area;

select * from country c order by Area asc ;
select * from country c order by Area desc ;

select * from country c order by (Population / Area) desc; 
select name from country c order by (Population / Area) desc limit 5;


select Country, min(Population) Population from city group by Country;
select Country, max(Population) Population from city group by Country;

select Country, count(Population) as AnzahlStaedte from city group by Country;
select Country, sum(Population) as totalPopInCity from city group by Country ;



select Country, count(Name) AnzahlStaedte
from city c 
where Population > 100
group by Country 
order by AnzahlStaedte desc, Country asc;



select * from city c where Name = 'Vienna';

select * from city c where Name like 'VI%';
select * from city c where Name like '%na';
select * from city c where Name like '%enna%';

select * from city c limit 5;
select * from country c limit 5;



select c.Name cityName , Country.Name countryName 
from city c 
join country  ON c.Country = country.Code;
order by countryName, cityName;


select co.Name
from country co 
left join ismember im on co.code = im.Country
where im.Country is null;


select o.Abbreviation, o.Name 
from country co 
join isMember im on co.Code = im.Country 
join organization o on im.Organization = o.Abbreviation 

select Country, count(Name) AnzahlStaedte
from city c 
where Population > 1000000
group by Country 
order by AnzahlStaedte desc, country asc


select country.Name, city.Name, city.Population 
from 
(
select country, max(Population) as Population
from city  
group by Country
) bigCity
join city on city.Country = bigCity.Country
join country  on city.Country = Country.code
where bigCity.Population = city.Population 
order by country.Name asc 


select Population
from country co 
where Name = 'Austria';


-- Wie viele Einwohner hat der Kontinent Europa?
-- Step 1:
select * from country;


-- Step 2:
select * from encompasses e;


-- Step 3:
select * 
from country c 
join encompasses e on c.code = e.Country;

-- Step 4:
select * 
from country c 
join encompasses e on c.code = e.Country
where e.Continent = 'Europe';

-- Step 5:
select * 
from country c 
join encompasses e on c.code = e.Country
where e.Continent = 'Europe' and Percentage >= 50;

-- Step 6:
select SUM(Population) Pop
from country c 
join encompasses e on c.code = e.Country
where e.Continent = 'Europe' and Percentage >= 50;


-- Welche Flüsse fließen durch Österreich?

select gr.River 
from geo_river gr 
join province p on p.Country = gr.Country 
join country c on c.Code = p.Country 
where c.Code= 'A'
group by gr.River ;

-- Welche Flüsse fließen durch Europa (nur den Flussnamen)?
select gr.River 
from geo_river gr 
join country c on c.Code = gr.Country 
join encompasses e on c.code = e.Country
where e.Continent = 'Europe' and Percentage >= 50
group by gr.River ;

-- Wie viel Prozent der Menschen leben im Kontinent Europa?
select 
	100 * (
		select SUM(Population) Pop
		from country c 
		join encompasses e on c.code = e.Country
		where e.Continent = 'Europe' and Percentage >= 50
	) / (select SUM(Population) Pop from country c) as PopAnteilEU;

-- Alle Länder die mit einem A anfangen
select * from country c where Name like 'A%';

-- Alle Länder die mit einem A anfangen und deren Bundesländer mit Einwohnerzahl, sortiert nach Einwohnerzahl
select c.Name, p.Name, c.Population 
from country c
join province p on p.country = c.code
where c.Name like 'A%'
order by c.Population;

-- Alle Flüsse die durch Europa fließen (nur Flüsse und deren Länge), sortiert nach Länge
select r.Name , r.`Length` 
from river r 
join geo_river gr on gr.River = r.Name 
join province p on p.Country = gr.Country 
join country c on c.Code = p.Country 
join encompasses e on c.code = e.Country
where e.Continent = 'Europe' and Percentage >= 50
group by r.Name 
order by r.`Length`;

-- Alle Inseln im Pazifik mit >50% islamischem Bekenntnis
select i.Island 
from islandin i   
join geo_island gi on gi.Island = i.Island 
join religion r on r.Country = gi.Country 
where i.Sea = 'Pacific Ocean' and r.Name = 'Muslim' and r.Percentage >50;

-- Alle 3000er, welche in einem Land sind, welches zu mindestens 60% römisch Katholisch ist
select m.Name 
from mountain m 
join geo_mountain gm on gm.Mountain = m.Name  
join religion r on r.Country = gm.Country 
where m.Height > 3000 
and r.Name = 'Roman Catholic'
and r.Percentage > 60;

-- Alle Länder mit mindestens einem See mit mindestens 100 Meter Tiefe und mindestens einem Berg mit mindestens 1500 Höhenmeter
select distinct c.Name 
from mountain m 
join geo_mountain gm on gm.Mountain = m.Name 
join country c on c.Code = gm.Country  
join geo_lake gl on gl.Country = c.Code 
join lake l on l.Name = gl.Lake 
where m.Height > 1500 and l.`Depth` >100;

-- Einwohnerzahl pro Religion
select r.Name, round(sum(c.Population*r.Percentage/100))  
from religion r 
join country c on c.Code = r.Country 
where r.Name =r.Name and c.Code =r.Country 
group by r.Name; 

-- Alle Länder, nur die Namen und die Meere dazu (keine Null Werte)
select distinct c.Name ,gs.Sea 
from country c 
join geo_sea gs on gs.Country = c.Code;

-- Alle Länder, nur die Namen, und wenn sie haben, das Meer dazu
select distinct c.Name ,gs.Sea 
from country c 
left join geo_sea gs on gs.Country = c.Code;

-- Das Unabhängigkeitsdatum von Ländern die eine Wüste haben und die ethnische Gruppe African
select p.Independence 
from politics p 
join ethnicgroup eg on eg.Country =p.Country 
join geo_desert gd on gd.Country = eg.Country 
where eg.Name = 'African';

-- Welche Länder haben genau 3 Städte? Welche Länder sind dies?
select c2.Name 
from 
(
	select c.Country , count( c.Name) as cnt 
	from city c
	group by c.country
) cnt
join country c2 on c2.Code = cnt.Country
where  cnt = 3;

-- Welches sind die 3 größten Städte von Amerika (Kontinent)?

select c.Name 
from city c 
join encompasses e on e.Country = c.Country 
where e.Continent = 'America'
order by Population desc limit 3;

-- Was ist der größte Berg von Österreich? Wie hoch ist er?

select m.Name, c.Name, m.Height 
from mountain m 
join geo_mountain gm on gm.Mountain = m.Name
join country c on c.Code = gm.Country 
where c.Name = 'Austria' limit 1;


-- Was ist der größte Berg von Europa? Wie hoch ist er?

select m.Name, c.Name, m.Height 
from mountain m 
join geo_mountain gm on gm.Mountain = m.Name
join country c on c.Code = gm.Country 
join encompasses e on c.Code = e.Country 
where e.Continent = 'Europe' and e.Percentage >50
order by m.Height desc limit 1;


-- Was ist der größte Berg pro Kontinent? Wie hoch sind diese?

select e.Continent, max(m.Height) maxH
from mountain m 
join geo_mountain gm on gm.Mountain = m.Name
join country c on c.Code = gm.Country 
join encompasses e on c.Code = e.country
where e.Percentage >= 50
group by e.Continent ;

select distinct tempT.continent, m2.name, m2.Height 
from
(
select e.Continent, max(m.Height) maxH
from mountain m 
join geo_mountain gm on gm.Mountain = m.Name
join country c on c.Code = gm.Country 
join encompasses e on c.Code = e.country
where e.Percentage >= 50
group by e.Continent 
)tempT
join encompasses e2 on tempT.continent = e2.Continent 
join geo_mountain gm2 on e2.Country = gm2.country
join mountain m2 on gm2.Mountain = m2.Name 
where tempT.maxH = m2.Height 




