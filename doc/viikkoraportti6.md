## Viikkoraportti 6

Ohjelman valikoissa toimii nyt myös algoritmien vertailu. Vertailtavien
algoritmien joukossa on myös leveyshaku.

Aikavertailujen tulokset ovat melko erikoisia; ajat vaihtelevat
moninkertaisesti ajosta toiseen eikä eri algoritmien välillä ole
aina havaittavissa odotetunkaltaisia eroja. Kyse voi olla siitä, että
A*-toteutukseni vaatii suotta verkon rakentamista syötekuvasta, vaikka
algoritmin voisi ajaa suoraan bittikartallekin.

Tarkoituksena on ollut toteuttaa vielä neljänneksi algoritmiksi
JPS-optimoitu A*, mutta se vaatisi vielä parempaa hahmottamista ja ehkä
olemassaolevan toteutukseni refaktorointa edellämainitulla tavalla.