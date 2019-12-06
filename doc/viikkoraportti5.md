## Viikkoraportti 5

A*-algoritmi on nyt mahdollista asettaa käyttämään heuristiikkaa
(suora euklidinen etäisyys maaliin) tai olemaan käyttämättä sitä,
jolloin kyseessä on käytännössä Dijkstra. Näin päästään jo
rakentamaan erilaisten ratkaisijoiden vertailua.

Kaikki ohjelmassa ja testeissä käytettävät input-kuvat ovat nyt
repositoriossa. Pääohjelman voi siis ajaa muillakin kuin omalla
koneellani. Tosin vertaispalautteen perusteella näin ei
käytännössä ole; tätä on debugattava.

Main-luokassa voi compareAlgorithmsissa mitata suoritusaikoja
eri metodeille. Näistä on seuraavaksi tarkoitus tehdä
järjestelmällisempiä. Myös muita kuin nämä kaksi reitinhakua
on tarkoitus ottaa käyttöön, esimerkiksi JPS-modifikaatio A*:sta
tai syvyyshaku.

Muutin Checkstyle-säännöstön Sun-standardista Google-standardiin,
joka tuntuu monin tavoin järkevämmältä. Lisäsin nyt Checkstylen myös
build.gradleen, olen aiemmin ajanut sitä vain Eclipsestä.