## Viikkoraportti 4

Projekti on muuttunut yhä modulaarisemmaksi; varsinaiselle labyrintin
ratkaisijalle on oma luokkansa ja pääohjelma on lyhyt.

Labyrintti ratkaistaan nyt leveyshaun sijaan A*-algoritmilla, joka perustuu
PriorityQueueen. Heuristiikkaa ei ole toistaiseksi mukana. Ehkä heuristiikkana
voisi käyttää suoraa etäisyyttä maalipisteeseen?

Testit menevät nyt läpi. Luovuin ajatuksesta kovakoodata testikuvat koodiin;
sen sijaan käytän ulkoisia testikuvatiedostoja. Ne ovat varsin pienikokoisia,
vain muutama sata tavua per kuva.

A*:n PriorityQueue on tarkoitus korvata omalla ratkaisulla. Haluaisin myös vertailla
kahta tai useampaa tapaa ratkaista labyrintti, mistä syystä AStar.solve() palauttaakin
jo yleistettävissä olevan tulosolion.