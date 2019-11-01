## Määrittely: tiralabyra

Ohjelmani ratkaisee lyhimmän reitin sokkelossa, jonka se saa kuvatiedostona.
Käyttäjä huolehtii ensin kuvan sellaiseen bittikarttaformaattiin, että
labyrintin seinät ovat mustia, tausta valkoinen ja kuvasta käy eri väreillä
ilmi haluttu alku- ja loppupiste. Ohjelma antaa tuloksena ensinnäkin tiedon,
onko sokkeloon löydettävissä ratkaisua. Jos on, se myös piirtää ratkaisun
kuvalle ja kirjoittaa tiedoston levylle.

### Mitä tarkoittaa lyhin reitti?

Verkossa lyhin reitti kahden solmun välillä on sellainen, jonka yhteenlaskettu
paino on pienin. Bittikarttakuvalla paino voisi olla esimerkiksi kuljettujen
pikselien lukumäärä tai mieluummin geometrinen etäisyys, jossa neliömäisten
pikselien diagonaalinen naapuruus saa arvon √2 ja vaaka- tai pystysuora
naapuruus arvon 1.

Ohjelman käyttötapaus voisi olla ihmisten ratkottaviksi tehtyjen sokkelokuvien
ratkaiseminen, jopa paperilta skannattuina. Tällaisessa käytössä ei
välttämättä ole merkitystä sillä, kumpaa etäisyysmetriikkaa täsmälleen käytetään;
ihmisen tuottamissa sokkeloratkaisuissahan voidaan kulkea vaikkapa
epäoptimaalisesti käytävän keskellä, ja ratkaisun voi silti sanoa olevan aivan
oikein:

![Ihmisen ja koneen ratkaisema sokkelo](https://i.imgur.com/RD9Ga5C.png)

Viimeistään väriarvojen mielivaltainen kynnystys mustaksi ja valkoiseksi
tuottaa koneratkaisuun epävarmuutta. Väite "lyhin reitti" pätee siis vain tähän
pikseliesitykseen.

### Flood fill -algoritmi

Aion käyttää toteutuksessani ns. flood fill -algoritmia. Se täyttää kuvaa
värillä 4- tai 8-naapurusto kerrallaan alkupikselistä lähtien ja seiniin
pysähtyen kuten kuvankäsittelyohjelman täyttötyökalu. Jokainen väritetty pikseli sisältää tiedon reitin edellisistä
pikseleistä.

![Pikselin 4-naapurusto](https://i.imgur.com/uYwkbKF.png)

Kun värjäys pääsee loppupisteeseen, saadaan reitti selville
seuraamalla naapuruuksia taaksepäin. Tällainen reitinhaku toimii lähes kuten
Dijkstra tai leveyssuuntainen haku.

### Verkkomainen tietorakenne

Algoritmin voisi toteuttaa rekursiivisena niin, että ratkaisun löytyessä
seurattaisiin muodostunutta rekursioketjua takaisinpäin. Arvelen kuitenkin, että
pinon maksimikoko asettaisi tällöin suotta arvaamattoman rajoituksen sokkelon koolle.
Suunnitelmanani onkin toteuttaa verkko, jonka solmuihin tallennetaan tieto
vierailluista pikseleistä, naapuruuksista ja siten kuljetusta reitistä. Verkon
koko on tiedossa heti kun syötekuvan koko tiedetään.

### Kompleksisuus

Tavoitteenani on aikavaativuus O(n), kun n on syötekuvan pikselien määrä. Flood
fill -algoritmin aikavaativuus nimittäin vastaa leveyshakua. 4- tai 8-naapuruuden
takia solmun kaarien määrällä on vakiomuotoinen yläraja, ja algoritmi käy pahimmassa
tapauksessa kaikki solmut läpi.

Laskennan vaatima muistin määrä on myös pahimmassa tapauksessa suoraan
verrannollinen pikselien määrään kuvalla; jokainen pikseli ja sen naapuruustieto
tallennetaan solmuksi ja solmun koko on vakio. Tilavaativuuskin on siten luokkaa O(n).

