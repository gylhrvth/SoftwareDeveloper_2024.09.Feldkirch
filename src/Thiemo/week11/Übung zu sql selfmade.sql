select 'Hello World' AS greetings;

use mondial;

select * from country;

select Name,Capital from country;

select Name,Capital as Hauptstadt from country;

select * , (Population/AREA) as populationDensity from Country;

select * , Round(Population/AREA, 3) as populationDensity from Country;

select Name ,population, Round(Population, -3) population2 from Country;

select * from country limit 10; -- MySQL

-- select Top 10* from country; -- Mircrosoft sql

select * from country where population > 100000000;
select * from country where population < 100000000;
select * from country where population >= 100000000;
select * from country where population <= 100000000;
select * from country where population = 22664136;   -- ist gleich
select * from country where population <> 22664136;  -- nicht gleich 

select * from country where (Population/AREA) <100;


select * from country where population >10000000 and area < 100000;
select * from country where population >10000000 or area < 100000;

-- select if (name = 'Austria',  Österreich', name) as name from country; 


select * from country where population >10000000 and Population < 200000000;
select * from country where Population between 100000 and 200000;

select * from country where capital = 'vienna';

select * from country order by Capital;
select * from country order by Area;

select * from country order by area desc;
select * from country order by area asc;

select * from country order by (Population/area) desc;
select Name from country order by (Population/area) desc limit 5;

-- Pause

select Country, min(Population) Population from city group by country;
select Country, max(Population) Population from city group by country;

select Country, count(Population) as AnzahlStaetde  from city group by country;
select Country, sum(Population) as totalPopInCity from city group by country;


select Country, count(name) AnzahlStaedte
from city 
where Population >100
group by Country
order by AnzahlStaedte desc, country asc;

select * from city where name = 'Vienna';
select * from city where name like 'Vi%';
select * from city where name like '%na';
select * from city where name like '%enna%';

select * from city limit 5;
select * from country limit 5;


select city.name  Cityname, country.Name CountryName, Capital
from city
join country on city.country = country.code
order by countryName, CityName;

select * 
from country co
join ismember im on co.code = im.country;

select * 
from country co
left join ismember im on co.code = im.country;

-- suche nach dem, was nicht da ist
select co.Name
from country co
left join ismember im on co.code = im.country is null;
where im.country 


select o.Abbreviation , o.name
from country co
join isMember im on co.code = im.country
join organization o on im.Organization = o.Abbreviation 
where co.name = 'Austria' and im.`Type` = 'member';


select Country.Name ,maxCity.anzahlStaedte
from (
select Country, count(name) AnzahlStaedte
from city 
where Population >1000000
group by Country
order by AnzahlStaedte desc, country asc
) as maxCity
join country on maxCity.country = country.Code;



select country.Name, city.name, city.Population 
from 
(
select country, max(Population) as Population 
from city
group by country
)bigcity 
join city on city.country = bigcity.country
join country on city.country = country.code
where bigcity.population = city.Population 
order by country.name asc;


select datediff('2027-09-15',now());



-- Übung


-- Wie viele Einwohner hat Österreich?

select Name , Population from country
where country.name = 'Austria';


select * from encompasses
where Percentage <> 100;


-- Wie viele Einwohner hat der Kontinent Europa?

select c.name , sum(population) as Population
from continent c
-- where continent.name = 'europe'
join encompasses e on c.Name = e.Continent 
join country co on co.Code = e.Country
where c.name = 'Europe' and percentage >=50
group by c.name;


-- Welche Flüsse fließen durch Österreich?

select * from river;
select * from country;

select  ri.Name 
from river ri
join geo_river geori on ri.Name = geori.River 
join country co on co.Code = geori.Country 
where co.Name = 'Austria' 
order by co.name desc;


-- Welche Flüsse fließen durch Europa (nur den Flussnamen)?

select distinct geori.River 
from river ri
join geo_river geori on ri.Name = geori.River 
join country co on co.Code = geori.Country 
join encompasses e on co.Code = e.Country 
where e.Percentage >50 and e.Continent = 'europe'
order by geori.River asc;


-- Wie viel Prozent der Menschen leben im Kontinent Europa?
-- part 1

select * 
from encompasses e where e.Continent = 'europe'

-- part 2 WorldPop

select sum(Population ) pop
from encompasses e 
join country c on e.Country = c.Code;

-- part 3  EuropePop

	select SUM(Population) PopEurope
	from encompasses e 
	join country c on e.Country = c.Code 
	where e.Continent = 'Europe' and Percentage >= 50;

-- part 4 percentage of how many people live in Europe from WorldPop

select 
100 * (
	select SUM(Population) PopEurope
	from encompasses e 
	join country c on e.Country = c.Code 
	where e.Continent = 'Europe' and e.percentage >=50
	) / (select sum(Population) popWorld from country) as percentage;

-- part 4.1 percentage of how many people live in Europe from WorldPop

select 100 * sum(Population) / (select sum(Population) from country) as PopPercentage
from country c
join encompasses e on c.Code = e.Country 
where e.Continent  = 'Europe' and e.Percentage >50;



-- Alle Länder die mit einem A anfangen

select c.name
from country c 
where c.Name  like 'A%';


-- Alle Länder die mit einem A anfangen und deren Bundesländer mit Einwohnerzahl, sortiert nach Einwohnerzahl

select * from country c;
select * from province p;

select c.Name, p.Name ,p.Population 
from province p 
join country c on p.Country = c.Code 
where c.Name like 'A%'
order by p.Population desc;

-- Alle Flüsse die durch Europa fließen (nur Flüsse und deren Länge), sortiert nach Länge

select * from river;
select * from geo_river;
select * from encompasses e;

select distinct r.Name , r.`Length` 
from geo_river gr 
join country c on gr.Country = c.Code 
join river r on gr.River = r.name 
join encompasses e on c.Code = e.Country 
where e.Continent = 'Europe' and e.Percentage >99
order by r.`Length` desc;


-- Alle Inseln im Pazifik mit >50% islamischem Bekenntnis

select * from geo_sea gs;
select * from geo_island gi;
select * from religion r;
select * from islandin i;
select * from sea s;

-- part 1

select *
from islandin i 
where i.Sea = 'pacific ocean';

-- part 2
select i.Island 
from religion r 
join geo_island gi on r.Country = gi.Country 
join islandin i on gi.Island = i.Island 
where i.Sea = 'pacific ocean' and r.Name = 'muslim' and r.Percentage >= 50;


-- Alle 3000er, welche in einem Land sind, welches zu mindestens 60% römisch Katholisch ist

select * from country c;
select * from religion r;
select * from geo_mountain gm;
select * from mountain m;

-- part 1

select m.Name 
from geo_mountain gm 
join mountain m on gm.Mountain = m.Name 
join religion r on gm.Country = r.Country 
where m.Height >=3000 and r.name = 'Roman Catholic' and r.Percentage >=60
order by m.Name;


-- Alle Länder mit mindestens einem See mit mindestens 100 Meter Tiefe und mindestens einem Berg mit mindestens 1500 Höhenmeter

select * from country c;
-- select * from geo_lake gl;
select * from lake l;
-- select * from geo_mountain gm;
select * from mountain m;

-- part 1 
select distinct c.Name 
from geo_mountain gm 
join geo_lake gl on gm.Country = gl.Country 
join mountain m on gm.Mountain = m.Name 
join lake l on gl.Lake = l.Name 
join country c on gm.Country = c.Code 
where l.`Depth` >=100 and m.Height >=1500;

-- part 2 
......


-- Einwohnerzahl pro Religion

select * from religion r ;
select * from country c;

-- part 1

select c.Population , r.Name
from religion r 
join country c on r.Country = c.Code 

-- part 2

select r.name, sum(round(c.Population * r.Percentage / 100)) religiousPerson
from religion r 
join country c on r.Country = c.Code
group by r.name
order by religiousPerson desc;


-- Alle Länder, nur die Namen und die Meere dazu (keine Null Werte)

select * from country c;
select * from geo_sea gs;
select * from sea s;

select distinct  c.Name , gs.Sea 
from country c 
join geo_sea gs on c.Code = gs.Country;


-- Alle Länder, nur die Namen, und wenn sie haben, das Meer dazu

select * from country c;
select * from geo_sea gs;
select * from sea s;

select distinct c.Name , gs.Sea 
from country c 
left join geo_sea gs on c.Code = gs.Country;


-- Das Unabhängigkeitsdatum von Ländern die eine Wüste haben und die ethnische Gruppe African

select * from politics p ;
select * from country c;
select * from geo_desert gd;
select * from desert d;
select * from ethnicgroup e;

-- part 1
select distinct p.Independence , c.Name , gd.Desert 
from geo_desert gd 
join country c on gd.Country = c.Code 
join politics p on gd.Country = p.Country 
join ethnicgroup e on gd.Country = e.Country 
where e.Name = 'African';

-- part 2
select *
from geo_desert gd 
join country c on gd.Country = c.Code 
join politics p on gd.Country = p.Country 
join ethnicgroup e on gd.Country = e.Country 
where e.Name = 'African';


-- Welche Länder haben genau 3 Städte? Welche Länder sind dies?

select * from country c;
select * from city ci;

-- part 1  every Country with how many Cities they have
select c2.Name, Count(c.Name) AnzahlStaedte 
from city c 
join country c2 on c.Country = c2.Code 
group by c2.Name 
order by c2.name;

-- part 2  every Country where the City count is 3
select *
from 
(
	select c2.Name, Count(c.Name) AnzahlStaedte 
	from city c 
	join country c2 on c.Country = c2.Code 
	group by c2.Name 
) as countryCityCounts 
where countryCityCounts.AnzahlStaedte = 3;


-- Welches sind die 3 größten Städte von Amerika (Kontinent)?

select * from country c;
select * from city ci;

select ci.Name , ci.Population 
from city ci
join encompasses e on ci.Country = e.Country 
where e.Continent = 'America'
order by ci.Population desc ;

select * 
from city ci
join encompasses e on ci.Country = e.Country 
where e.Continent = 'America'
order by ci.Population desc limit 3;

-- Was ist der größte Berg von Österreich? Wie hoch ist er?

select * from country c;
select * from geo_mountain gm;
select * from mountain m;

select m.Height ,m.Name , c.Name 
from geo_mountain gm 
join country c on gm.Country = c.Code
join mountain m on gm.Mountain = m.Name 
where c.Name = 'Austria'
order by m.Height desc limit 1;


-- Was ist der größte Berg von Europa? Wie hoch ist er?

select * from encompasses e;
select * from geo_mountain gm;

select m.Name , m.Height ,e.Continent , group_concat(c.Name SEPARATOR ',') as Countries
from geo_mountain gm 
join mountain m on gm.Mountain = m.Name 
join country c on gm.Country = c.Code 
join encompasses e on gm.Country = e.Country 
where e.Continent = 'Europe' and e.Percentage >= 50
group by m.Name , m.Height , e.Continent 
order by m.Height desc limit 1;


-- Was ist der größte Berg pro Kontinent? Wie hoch sind diese?

select * from encompasses e;
select * from geo_mountain gm;
select * from mountain m;
select * from country c;

-- part 1 every continent with the highest mountain without name of mountain
select e.Continent , max(m.Height) maxH
from encompasses e 
join country c on e.Country = c.Code 
join geo_mountain gm on e.Country = gm.Country 
join mountain m on gm.Mountain = m.Name 
where e.Percentage >=50
group by e.Continent 

-- part 2 every continent with the highest mountain and the name of the mountain
select tempT.Continent, m2.Name, m2.Height 
from 
	(
		select e.Continent, max(m.Height) maxH
		from mountain m 
		join geo_mountain gm on m.Name = gm.Mountain 
		join encompasses e on gm.Country = e.Country
		where e.Percentage >= 50
		group by e.Continent						-- Das was im 'group by' steht muss oben im select stehen mit * geht's nicht!
	) tempT
join encompasses e2 on tempT.continent = e2.Continent 
join geo_mountain gm2  on e2.Country = gm2.Country 
join mountain m2 on gm2.Mountain = m2.Name
where tempT.maxH = m2.Height;


-- Welches Land hat am meisten anerkannte Religionen? Wie viel sind es?

select * from religion
			-- meine, nicht fertige, Lösung
select c.name, count(c.name) as aor
from religion r
join country c on c.Code = r.Country 
group by c.name
order by aor desc limit 1;
 
			-- Lösung von Chat
SELECT c.name, COUNT(r.name) AS aor
FROM country c
JOIN religion r ON r.Country = c.Code
GROUP BY c.name
HAVING COUNT(r.name) = (
    SELECT MAX(aor)
    FROM (
        SELECT COUNT(r.name) AS aor
        FROM religion r
        GROUP BY r.Country
    ) AS subquery
)
ORDER BY aor DESC;

			-- richtige Lösung
with religion_count as(
	select c.name, count(*) as aor
	from religion r
	join country c on c.Code = r.Country 
	group by c.name
) 
select name, aor
from religion_count
where aor = (select max(aor) from religion_count);


-- Welche Organisationen haben deren Hauptsitz in Österreich? Wie viele Mitglieder haben diese Organisationen?

select o.name, count(im.Organization) as member_count
from organization o
join country c on c.Code = o.Country 
join isMember im on im.Organization = o.Abbreviation 
where c.code = 'A'and im.type = 'member'
group by o.name

-- Was sind die Top 10 Sprachen? Wie viele native Speaker sprechen diese Sprache?

select l.name, round(sum(c.Population * l.Percentage / 100)) as sumPop
from `language` l 
join country c on c.code = l.Country 
group by l.Name 
order by sumPop desc limit 10;



