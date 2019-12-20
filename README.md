# tiralabyra

Labyrinttiratkaisija tiralabraan.

* [Määrittelydokumentti](doc/maarittely.md)
* [Toteutusdokumentti](doc/toteutus.md)
* [Testausdokumentti](doc/testaus.md)
* [Viikkoraportti 1](doc/viikkoraportti1.md)
* [Viikkoraportti 2](doc/viikkoraportti2.md)
* [Viikkoraportti 3](doc/viikkoraportti3.md)
* [Viikkoraportti 4](doc/viikkoraportti4.md)
* [Viikkoraportti 5](doc/viikkoraportti5.md)
* [Viikkoraportti 6](doc/viikkoraportti6.md)
* [javadoc](javadoc/)

## Käyttöohje

Ohjelma käännetään ja ajetaan gradlen avulla: `gradle run`

Terminaaliin tulostuu ohjelman päävalikko.

### 1 Labyrintin ratkaiseminen

Tällä toiminnolla ohjelma ratkaisee kuvatiedostossa olevan labyrintin
A*-algoritmilla. Kuvan tulee olla sellaisessa bittikarttamuodossa, jota
`javax.imageio.ImageIO`-luokka osaa lukea. Kuvaan merkitään labyrintin
alkupiste punaisella värillä (255, 0, 0) ja loppupiste vihreällä
(0, 255, 0). Seinät, joiden läpi ei saa siirtyä, merkitään mustalla
värillä (0, 0, 0). Muiden pikselien väriarvot voivat olla mitä vain. Kuvan
tulee olla häviöttömästi koodattu (esim. PNG), jotta näiden merkkipikselien arvot eivät
muutu.

Tulostetiedostoon kirjoitetaan kopio alkuperäisestä labyrintistä, johon on
piirretty ratkaistu reitti.

### 2 Algoritmien vertailu

Tällä valinnalla ohjelma ratkaisee useita erilaisia labyrinttejä muutamaa eri
algoritmia käyttäen (tällä hetkellä BFS, Dijkstra, A*). Algoritmien ajankäyttö
erilaisilla syötekuvilla tulostetaan terminaaliin.