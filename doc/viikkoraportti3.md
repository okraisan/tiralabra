## Viikkoraportti 3

Projekti on muuttunut sen verran, että verkon luonti kuvasta tehdään
nyt ConnectedGraph-luokan konstruktorissa suoraan kuvasta. Luokka on
myös testattavissa syöttämällä sille yksinkertainen, lähdekoodiin kätevästi
binäärinä mahtuva testikuva.

Testikattavuus on seurannassa Eclipsessä ja yksikkötestejä jo jonkin verran
onkin.

Olen miettinyt, kuinka verkkoja oikeastaan kannattaisi käsitellä Javassa.
Tällä hetkellä pidän kaarista kirjaa kaksiulotteisella taulukolla, sillä
solmulla voi olla korkeintaan 8 naapuria. Jokaiselle mahdolliselle
naapuruudelle luodaan jo verkon konstruktorissa Edge-olio, mutta sen
osoittamat indeksit ovat -1 ellei niitä ole erityisesti asetettu. Pohdin
aiemmin jonkinlaisen Setin käyttämistä naapuruuksien tallentamiseen, mutta
se voisi olla asian turhaa mutkistamista.

Image-luokan testejä ajaessani saan erikoisen NullPointerExceptionin rivillä,
jossa bufferedImagen leveyttä yritetään kysyä. Kyseinen jäsenmuuttuja on
kuitenkin alustettu Image-luokan konstruktorissa, joka ajetaan testin setUpissa,
joten tämä on hieman mystistä.

Sain Eclipsen viimein ilmoittamaan checkstyle-ongelmista, kun vaihdoin
sen käyttämään Sunin tyyliä Googlen tyylin sijasta - todennäköisesti
Googlen tyyli koskee vain C:tä ja C++:aa. Valitsin IDEksi Eclipsen alunperin
siksi, että olin kuullut NetBeansin toimivan huonosti macOSilla. Eclipsessä
tuntuu kuitenkin olevan myös pieniä käyttöliittymäongelmia, jotka eivät
parantuneet vaikka siirryin nyt käyttämään Windowsia. Workspace-tiedoston
poistaminen ja uuden luonti auttaa.

Seuraavaksi on tarkoitus saada edes leveyshaku menemään loppuun asti uudella
ConnectedGraph-luokan konstruktorilla tehdyllä verkolla; tällä hetkellä se jää
jostain syystä ikuiseen silmukkaan.

Arvioisin käytetyksi työmääräksi reilut 10 tuntia.