select 'Hello World!' as greeting;
use mondial;

select * from country;

select name, capital from country;

select name, capital as Hauptstadt from country;

select *, (population / area) as populationDensity from country;

select *, Round(population / area, 2) as populationDensity from country;

select name, population, round(population, -3)population2 from country; 

select * from country limit 10; -- MySQL
-- select TOP 10 * from country; -- Microsoft SQL

select * from country where population > 10000000;
select * from country where population < 10000000;
select * from country where population >= 10000000;
select * from country where population <= 10000000;
select * from country where population = 10000000; -- ist gleich
select * from country where population <> 10000000; -- nicht gleich

select * from country where (population / area) < 100;

select * from country where population > 10000000 and area < 100000;
select * from country where population > 10000000 or area < 100000;

select if(name = 'Zaire', 'Democratic Republic of Congo', name) as name, code, Capital from country;

select * from country where population > 10000000 and population < 20000000;
select * from country where population between 10000000 and 20000000;

select * from country where capital = 'vienna';

select * from country order by capital;
select * from country order by capital Desc;
select * from country order by area;

select * from country order by (population / area) desc;
select name from country order by (population / area) desc limit 5;

-- PAUSE

select country, min(population) population from city group by country;
select country, max(population) population from city group by country;

select country, count(population) as anzahlStaedte from city group by country;
select country, sum(population) as totalPopInCity from city group by country;

select country, count(name) AnzahlStaedte
from city
where population > 100
group by country
order by AnzahlStaedte desc, country asc;

select * from city where name = 'Vienna';
select * from city where name like 'Vi%';
select * from city where name like '%na';
select * from city where name like '%enna%';

select * from city limit 5;
select * from country limit 5;

select country.name countryName, city.name cityName
from city 
join country on city.country = country.Code
order by countryName, cityName;

-- Suche nach dem, was nicht da ist...
select co.Name
from country co
left join isMember im on co.code = im.country;

select * 
from country co
left join isMember im on co.code = im.country
where im.country is null;

select o.Abbreviation, o.name
from country co
join isMember im on co.code = im.country
join organization o on im.Organization = o.Abbreviation
where co.name = 'Turkey' and im.`Type` = 'Member';

select country.name, maxCity.AnzahlStaedte
from (
	select country, count(name) AnzahlStaedte
	from city 
	where Population > 1000000
	group by Country
	order by AnzahlStaedte desc, country asc
) as maxCity
join country on maxCity.country = country.code;

select country.name, city.name, city.Population 
from
(
	select country, max(Population) as Population 
	from city
	group by country
) bigCity
join city on city.country = bigCity.Country
join country on city.country = country.code
where bigCity.population = city.Population
order by country.name asc;

-- Wie viele Einwohner hat Österreich?
select co.name, co.Population 
from country co
where co.name = 'Austria';

-- Wie viele Einwohner hat der Kontinent Europa? Vol1
select c.name, sum(population) as Population
from continent c
join encompasses e on c.Name = e.Continent
join country co on co.Code = e.Country
where c.name = 'Europe' and percentage >= 50
group by c.name;

-- Wie viele Einwohner hat der Kontinent Europa? Vol2
select sum(population) Population
from country c
join encompasses e on c.Code = e.Country
where e.Continent = 'Europe' and percentage >= 50 

-- Welche Flüsse fließen durch Österreich?
select gr.River
from geo_river gr
join province p on p.Country = gr.Country
join country c on c.code = p.Country 
where c.code = 'A'
group by gr.River;

-- Welche Flüsse fließen durch Europa?
select gr.River
from geo_river gr 
join country c on c.Code = gr.Country 
join encompasses e on c.code = e.Country 
where e.Continent = 'Europe' and Percentage >= 50
group by gr.River;

-- Wie viel Prozent der Menschen leben im Kontinent Europa?
select 
	100 * (
		select sum(population) Population
		from country c
		join encompasses e on c.Code = e.Country
		where e.Continent = 'Europe' and percentage >= 50 
	) / (select Sum(Population) Pop from country c) as PopAnteilEU;

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

-- Alle 3000er, welche in einem Land sind, welches zu mindestens 60% römisch katholisch ist
select m.Name
from mountain m
join geo_mountain gm on gm.Mountain = m.Name
join religion r on r.Country = gm.Country
where m.Height > 3000
and r.Name = 'Roman Catholic'
and r.Percentage > 60;

-- Alle Länder mit mindestens einem See, mit mindestens 100 Meter Tiefe und mindestens einem Berg, mit mindestens 1500 Höhenmeter
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

-- Alle Länder, nur die Namen und die Meere dazu (keine Null werte)
select distinct c.Name ,gs.Sea
from country c
join geo_sea gs on gs.Country = c.Code;

-- Alle Länder, nur die Namen, und wenn sie haben, das Meer dazu
select distinct c.Name ,gs.Sea
from country c
left join geo_sea gs on gs.Country = c.Code;

-- Die Unabhängigkeitsdatum von Ländern die eine Wüste haben und die ethnische Gruppe African
select p.Independence
from politics p
join ethnicgroup eg on eg.Country =p.Country
join geo_desert gd on gd.Country = eg.Country
where eg.Name = 'African';

-- Welche Länder haben genau 3 Städte? Welche Länder sind die?
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
select c.name
from city c
join encompasses e on e.Country = c.Country
where e.Continent = 'America'
order by c.Population desc limit 3;

-- Was ist der größte Berg von Österreich? Wie hoch ist er?
select m.name , m.Height 
from mountain m
join geo_mountain gm on gm.Mountain = m.Name
join country c on c.Code = gm.Country
where c.name = 'Austria' limit 1;

-- Was ist der größte Berg von Europa? Wie hoch ist er?
select * from mountain m;
select * from encompasses e;

select m.Name, m.Height 
from mountain m 
join geo_mountain gm on m.Name = gm.Mountain 
join encompasses e on gm.Country = e.Country 
where e.Continent = 'Europe' and e.Percentage >= 50
order by m.Height desc
limit 1;

-- Was ist der größte Berg pro Kontinent? Wie hoch sind diese?
select distinct tempT.Continent, m2.Name, m2.Height 
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
where tempT.maxH = m2.Height 

-- Welches Land hat am meisten anerkannte Religionen? Wie viel sind es?
select * from religion
			-- meine, nicht fertige, Lösung
select c.name, count(c.name) as aor
from religion r
join country c on c.Code = r.Country 
group by c.name
order by aor desc limit 1
 
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


