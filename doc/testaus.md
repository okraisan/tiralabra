## Tiralabyra: Testaus

### Toteutus

Yksikkötestaus tapahtuu JUnit-testeillä. Myös kokonaisen
labyrintin ratkaisemista testataan testikuvien avulla. Testikattavuutta
seurataan Jacocon avulla sekä Eclipse IDE:n omalla kattavuusraportoinnilla.

Testausta on myös yksikkötestien ulkopuolella, sillä pääohjelma voi kutsua
eri algoritmien suoritusaikoja vertailevaa funktiota. Tulevaisuudessa tässä
funktiossa on automatiikkaa aikamittauksien ja tilastojen tekemiseen.

### Tuloksia

Tällä hetkellä manuaalisesti saatuja tuloksia on A*-algoritmin ajamisesta samalle
labyrintille heuristiikoilla ja ilman; sekä algoritmin ajamisesta helpolle ja
vaikealle labyrintille.

* Helppo labyrintti heuristiikalla: 20..23 ms
* Helppo labyrintti ilman heuristiikkaa: 32..33 ms
* Vaikea labyrintti heuristiikalla: 111..112 ms
* Vaikea labyrintti ilman heuristiikkaa: 70..71 ms

Mistä johtuu yllättävä tulos, että "vaikealla" kuvalla heuristiikan käyttö
hidastaakin algoritmia? Vastaus piilee siinä, että runsaasti mutkittelevassa
labyrintissä euklidinen etäisyys uloskäyntiin ei välttämättä kerro mitään
siitä, kuinka pitkä matka todella on vielä kuljettavana. Päin vastoin,
mielivaltainen arvio saattaa johtaa hakua harhaan, jolloin suoritus hidastuu.