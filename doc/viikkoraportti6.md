## Viikkoraportti 6

Ohjelman valikoissa toimii nyt myös algoritmien vertailu. Vertailtavien
algoritmien joukossa on myös leveyshaku.

Aikavertailujen tulokset ovat melko erikoisia; ajat vaihtelevat
moninkertaisesti ajosta toiseen eikä eri algoritmien välillä ole
aina havaittavissa odotetunkaltaisia eroja. Kyse voi olla siitä, että
A*-toteutukseni vaatii suotta verkon rakentamista syötekuvasta, vaikka
algoritmin voisi ajaa suoraan bittikartallekin.

Tarkoituksena on ollut toteuttaa vielä neljänneksi algoritmiksi
jokin sofistikoituneempi labyrinttialgoritmi, vaikkapa siis JPS-optimoitu
A*, mutta se vaatisi minulta vielä algoritmin parempaa hahmottamista ja
ehkä olemassaolevan A*-toteutukseni refaktorointa edellämainitulla tavalla.

BreadthFirstSearch ei tunnu tällä hetkellä toimivan suurella labyrinttikuvalla;
se ei löydä siihen lainkaan ratkaisua, vaikka pienemmillä testikuvilla
testit menevät läpi.

Työmääräarvio noin 10h.