## Tiralabyra: Toteutus

Tiralabyra ratkaisee labyrinttejä PNG-kuvista. Mustat pikselit (000000)
tulkitaan seiniksi, punainen pikseli (FF0000) lähtöpaikaksi ja vihreä
(00FF00) pikseli maalipisteeksi. Muunvärisillä pikseleillä ei ole
merkitystä.

Kuvasta luodaan ensin ConnectedGraph-olio, joka sisältää tiedon
pikselien vierekkäisyyksistä, lähtö- ja maalipisteistä sekä siitä,
mihin naapuripikseleistä voi vapaasti siirtyä. Tämä olio voidaan syöttää
ratkaisijalle, vaikkapa AStarille. Ratkaisijan solve()-metodi palauttaa
mahdollisen ratkaistun reitin pituuksineen ja tiedon siitä, oliko
labyrintti ylipäätään ratkaistavissa.

Lopuksi reitti piirretään alkuperäisen kuvan kopioon ja kirjoitetaan
uuteen kuvatiedostoon.

### A*

A*:n prioriteettijono on toteutettu minimikekona, jossa vertailtavana
suureena on kullekin reitille arvioitu lopullinen pituus. Tässä käytetään
heuristiikkaa, joka on yksinkertaisesti diagonaalinen eli euklidinen
etäisyys reitin viimeisimmästä pisteestä maalipisteeseen.

Minimikeon sisältö on taulukossa. Taulukon täyttyessä varataan
uusi muistialue, jonka koko on edelliseen nähden kaksinkertainen,
ja sisältö kopioidaan siihen.

Uuden solmun syöttäminen kekoon on aikavaativuudeltaan luokkaa O(log n).
Pienimmän solmun palauttaminen on luokkaa O(log n), sillä solmu samalla
poistetaan ja ajetaan Heapify-metodi.

### Dijsktra

A*:n saa toimimaan Dijkstran algoritmina, kun solve()-metodin toiseksi
parametriksi asettaa false. Tällöin algoritmi ei käytä lainkaan
heuristiikkaa jäljellä olevan matkan arviointiin, vaan minimikeko on
järjestetty ainoastaan kuljetun matkan mukaan.

### BFS

Leveyshaku ei sisällä minkäänlaista arviointia järkevimmän hakusuunnan
suhteen, vaan solmuja lisätään käsittelyjonoon sitä mukaa kun ne löytyvät
kuvalta. Jono on FIFO, joka on sisäisesti toteutettu ympyrätaulukon avulla.
Ympyrätaulukon alkupäästä poistaminen ja loppupäähän lisääminen tapahtuvat nopeasti
kahta pointteria siirtämällä (luokkaa O(1)). Jonon täyttyessä varataan
uusi, kaksi kertaa suurempi muistialue.

### Kuvan luku ja kirjoitus

Kuvatiedostojen luku ja kirjoitus on toteutettu Javan ImageIO:ta hyödyntäen.
Omassa Image-luokassa on helpottavia metodeita, joiden avulla voi iteroida
kuvan pikselien läpi ja tarkistaa, onko jokin niistä lähtö- tai maalipikseli.

Kuvaa ei syötetä hakualgoritmeille bittikarttana vaan siitä muodostetaan ensin
verkko, johon pikselien naapuruudet on abstrahoitu. Tämä selkeyttää koodia itse
hakualgoritmeissa mutta vaatii laskenta-aikaa ja tekee joistain mahdollisista
optimoinneista hankalampia toteuttaa, esim. JPS:stä.