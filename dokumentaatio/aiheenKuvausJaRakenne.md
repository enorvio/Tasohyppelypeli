**Aihe:**
Kaksiulotteinen tasohyppelypeli. Toteutetaan yksinkertaisehko peli, jossa pelaaja liikuttaa spriteä näppäinkontrolleilla tavoitteena läpäistä kenttiä, vältellä vihollisia ja kerätä pisteitä.

**Käyttäjät:**
Pelaaja

**Kaikkien käyttäjien toiminnot:**
* uuden pelin aloittaminen
* spriten liikuttaminen näppäimistön avulla
* pelin lopettaminen

**Käyttöohjeet**

Aloitusvalikko: 

Klikkaa hiirellä valikon nappeja. Nappi "New Game" aloittaa uuden pelin. Napista "High Scores" pääset tarkastelemaan top 10 -pistetilastoa. Nappi "Quit" lopettaa pelin. Voit koska tahansa lopettaa pelin (ja koko ohjelman) myös klikkaamalla ruksia aloitusvalikon tai peli-ikkunan oikeassa ylänurkassa.

Peli: 

Ohjaat näppäimistön välityksellä vaaleanpunaista jotain, joka on oikeasti yksisarvinen, mutta 32x32 pikseliä ja piirtotaitoni huomioon ottaen olen tyytyväinen jos se näyttää edes ponilta. Oikealla ja vasemmalla nuolinäppäimellä ohjaat hahmoa oikealle ja vasemmalle. Tämä toimii sekä ilmassa että maassa. Välilyönnistä hyppäät, mikäli olet maassa. Alussa sinulla on yhdeksän elämää. Rotkoon (eli ihan ikkunan alalaitaan) ei kannata pudota, koska silloin kuolet. Kuolet myös jos törmäät viholliseen. Toisaalta jos poimit vaaleansinisen timantin, saat yhden elämän lisää. Jos kuolet, joudut kentän alkuun. Tavoitteena on päästä kentän oikeaan laitaan. Tällöin pääset seuraavaan kenttään. Kannattaa myös kerätä pisteitä, jotka tunnistaa siitä, että ne ovat jotain syötävää. (Toivottavasti tunnistaa. Piirsin ne käsin GIMPillä.) Peli-ikkunan alalaidassa näkyvät elämäsi ja pisteesi.

Kun kuolet lopullisesti (eli elämät menevät nollaan) tai pääset kaikki tasot läpi, ohjelma avaa ikkunan, jossa kysytään nimeäsi. Syötä tekstikenttään nimesi ja paina OK. Jos pisteesi olivat tarpeeksi korkeat, pääset High Scores-taulukkoon. :3 

**Luokkakaavio**

![Alt text][id1]

[id1]: https://github.com/enorvio/Tasohyppelypeli/blob/master/dokumentaatio/luokkakaavio_3.png 

**Rakennekuvaus**

Ohjelma rakentuu pelisilmukan ympärille, jossa otetaan vastaan käyttäjän antama syöte, päivitetään pelilogiikan tilanne sen perusteella, ja lopuksi piirretään pelitilanne uudelleen graafisessa käyttöliittymässä. Kaikista näistä kolmesta vaiheesta vastaa eri luokka, tai useita luokkia. Käyttäjän antaman syötteen (näppäimistö) kuuntelu tapahtuu luokassa NappaimistonKuuntelija. Pelilogiikka (eli pelin "säännöt") sijaitsee luokassa Logiikka, ja pelissä esiintyvät liikkuvat oliot (eli pelaajan sprite ja viholliset) on toteutettu Hahmo-luokan avulla. Tämän luokan perivät Pelaaja ja Vihollinen. Luokan Kentta instanssit vastaavat pelin kenttiä, jotka pelaajalla on tavoitteena läpäistä. 

Kentät on tallennettu tekstitiedostoina. Lukija-luokka sisältää metodit näiden tiedostojen lukemiseen ja Kentta-olioiden luomiseen niiden pohjalta. Lukija-luokassa on toteutettu kaikki tiedostonluku ja -kirjoittaminen, kuten pistetilaston tallennus ja päivitys ja kuvien lataaminen .png-tiedostoista. 

Ohjelmassa on graafinen käyttöliittymä, jossa oman luokkansa muodostavat Kayttoliittyma (aloitusvalikko) ja ValikonKuuntelija (aloitusvalikon kuuntelija, joka aloittaa uuden pelin tai siirtyy tarkastelemaan pistetilastoja käyttäjän klikkaamien JButtonien perusteella), NimenKysyja ja NimenKysyjanKuuntelija (ikkuna jossa käyttäjä syöttää nimensä ja tämän ikkunan kuuntelija) sekä PeliIkkuna. PeliIkkunassa animoidaan reaaliaikaisesti pelin tilanne. Graafisen käyttöliittymän luokka Grafiikka vastaa kuvien hallinnoimisesta siinä vaiheessa kun Lukija on muuntanut ne Image-olioiksi.

**Sekvenssikaavioita**

![Alt text][id2]

[id2]: https://github.com/enorvio/Tasohyppelypeli/blob/master/dokumentaatio/sekvenssikaavio1.png  

![Alt text][id3]

[id3]: https://github.com/enorvio/Tasohyppelypeli/blob/master/dokumentaatio/sekvenssikaavio2.png 

![Alt text][id4]

[id4]: https://github.com/enorvio/Tasohyppelypeli/blob/master/dokumentaatio/sekvenssikaavio3.png 
