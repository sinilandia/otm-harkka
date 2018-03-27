# Alustava määrittelydokumentti

## Sovelluksen tarkoitus
Sovelluksen avulla voi harjoitella erilaisia sanaleikkejä, joissa pitää keksiä keskimmäinen sana, joka muodostaa yhdyssanan sekä edessä että takana olevan sanan kanssa. 

Esim.
viini_____puuro (vastaus: marja // viinimarja - marjapuuro)
viisauden______valas (vastaus:hammas // viisaudenhammas - hammasvalas)

## Käyttäjäroolit
- tavallinen käyttäjä

## Käyttöliittymäluonnos
Sovellus koostuu viidestä eri näkymästä: kirjautuminen, luo uusi käyttäjä, vastaa tehtävään ja vastaukset (oikein/väärin).

<img src="https://raw.githubusercontent.com/sinilandia/otm-harkka/master/dokumentaatio/kuvat/kayttoliittymaluonnos_v1.JPG" width="750">

Sovellus aukeaa kirjautumisnäkymään, missä voi kirjautua tai luoda uuden käyttäjän.
Tehtävänäkymässä sovellus arpoo kysymyksiä, joihin käyttäjän tulee vastata.
Vastaus-näkymässä näkyy vastasiko käyttäjä oikein vai väärin, ja jälkimmäisessä tapauksessa oikeat vastaukset.

## Toiminnallisuudet
Tavallinen käyttäjä:
- voi luoda itselleen tunnukset järjestelmään 
	- käyttäjätunnus uniikki ja vähintään 3 merkkiä
	- voi kirjautua järjestelmään salasanan avulla
	- jos käyttäjää ei olemassa, järjestelmä ilmoittaa virheestä
- kirjautuneena sisään: voi vastata kysymyksiin
- näkee vastasiko oikein vai väärin kysymykseen ja oikeat vastaukset 
- voi kirjautua ulos järjestelmästä

## Toimintaympäristön rajoitteet
- tämän tehtävän tehtävänannossa vaadittu, että tieto paikallisesti käyttäjän koneella
- toimii Linux- ja OS-järjestelmillä



## Jatkokehitysideoita
- jos jää aikaa, voi tehdä Telegram-botin > voi kilpailla kavereita vastaan
- voi pelata aikaa vastaan, esim. vastausaikaa 30sek
- käyttäjä voi tarkastella omaa edistymistään numeerisesti ja graafisesti
- käyttäjä voi asettaa itselleen opiskelutavoitteita (esim. Telegram-botissa voi asettaa kuinka usein kysymyksiä tulee päivässä tai kuinka monta minuuttia harjoitellut)
- admin-käyttäjä
	- voi lisätä ja poistaa tehtäviä
	- voi poistaa käyttäjiä
	- näkee tilastoja sovelluksen käytöstä (esim. aika)
- sanaleikit voi jaotella eri luokkiin, esim. eläimet, ruuat, luonto 

