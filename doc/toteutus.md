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

A* on toteutettu prioriteettijonolla.

### Kuvan luku ja kirjoitus

Toteutettu Javan ImageIO:lla.