# OTM kevät 2018: yhdyssana-arvauspeli


## Dokumentaatio

[vaatismusmaarittelu.md](https://github.com/sinilandia/otm-harkka/blob/master/dokumentaatio/vaatimusmaarittely.md)

[tuntikirjanpito](https://github.com/sinilandia/otm-harkka/blob/master/dokumentaatio/tuntikirjanpito.md)

[arkkitehtuuri.md](https://github.com/sinilandia/otm-harkka/blob/master/dokumentaatio/arkkitehtuuri.md)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
