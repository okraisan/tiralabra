## Määrittelydokumentti

Ohjelmani ratkaisee sokkelon, jonka se saa kuvana. Käyttäjä huolehtii ensin
kuvan sellaiseen formaattiin, että seinät ovat mustia, tausta valkoinen ja
kuvasta käy eri väreillä ilmi haluttu alku- ja loppupiste. Ohjelma antaa
tuloksena ensinnäkin tiedon, onko sokkeloon löydettävissä ratkaisua, ja jos on,
se kirjoittaa myös kuvatiedoston, johon ratkaisu on piirretty.

Aion käyttää toteutuksessani ns. flood fill -algoritmia. Se täyttää kuvaa
värillä nelinaapurusto kerrallaan alkupikselistä lähtien ja seiniin pysähtyen.
Jokainen väritetty pikseli sisältää tiedon reitin edellisistä pikseleistä. Kun
värjäys pääsee loppupisteeseen, saadaan reitti selville seuraamalla
naapuruuksia taaksepäin.

Algoritmin voisi toteuttaa rekursiivisena niin, että ratkaisun löytyessä
seurattaisiin muodostunutta rekursioketjua takaisinpäin. Arvelen kuitenkin, että
pinon maksimikoko asettaisi tällöin suotta arvaamattoman rajoituksen sokkelon koolle.
Suunnitelmanani onkin toteuttaa verkko, johon vieraillut pikselit ja siten kuljettu
reitti tallennetaan.

Tavoitteenani on aikavaativuus O(n), kun n on pikselien määrä kuvalla.
