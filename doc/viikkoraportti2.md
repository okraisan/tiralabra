## Viikkoraportti 2

Olen toteuttanut MVP-tyyppisen labyrinttihaun, jotta voin sitä
myöhemmin alkaa parannella. Se osaa lukea määrittelydokumentissa mainitun
kaltaisen kuvan, kulkea sokkelon alusta loppuun, piirtää reitin punaisella
viivalla ja kirjoittaa kuvan uuteen tiedostoon. Lyhintä reittiä ei tässä
vaiheessa varsinaisesti löydetä, vaan tulos on vielä jonkinlaista siksakkia.
Myös luokkarakenne on alkeellinen; suuri osa logiikasta on Mainissa.

Myös Eclipsen konfigurointi tyylitarkistuksineen ja kattavuusseurantoineen
alkaa olla kohdillaan. Point-luokalle, joka lienee lähellä lopullista muotoaan,
on kattavat yksikkötestit. Käytännössä se tarkoittaa getterien ja staattisen
yhteenlaskufunktion testausta.

Olen huomannut viikon aikana, että arveluni pikselietäisyyksien mittaustavan
merkityksettömyydestä meni hieman mönkään. Jos nimittäin reitin pituutta
mitataan pelkästään kuljettujen pikselien määrällä, niin reitti tuntuu kiertävän
erikoisten suorien kulmien kautta.

Seuraavaksi siirryn tekemään ConnectedGraph-luokasta sellaista, joka osaa
konstruktorissa lukea kuvan ja rakentaa siitä oikeanlaisen verkon naapuruuksineen
ja kaaripainoineen.

En ole vielä saanut viritettyä varsinaista työaikakelloa, mutta arvioisin
käyttäneeni kurssiin tällä viikolla 10-15 tuntia.
