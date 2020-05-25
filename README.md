Treść zadań:

## LAB02 - JSP ##
### zad 1 ###

* Napisz servlet, który będzie przyjmował 5 liczb całkowitych metodą GET, wyliczy ich średnią i zwróci
wynik.
* Napisz servlet, który będzie przyjmował dowolną ilość parametrów metodą POST i sprawdzał, czy
parametry te są liczbami. Jeśli są, niech je wyświetli w kolejności od najmniejszej do największej.
Jeśli parametry nie są liczbami, niech servlet zwróci informacje o błędnych danych.

### zad 2 ###
<p> Celem zadania jest napisanie prostej aplikacji internetowej o nazwie Doradca Piwny. Aplikacja
powinna zostać zbudowana zgodnie z prostą architekturą MVC ( z wyróżnionym widokiem/ami
kontrolerem oraz modelem).</p>
<p> Aplikacja będzie posiadać dwie strony będące widokiem: form.html z formularzem wyboru koloru
piwa, oraz stronę wynik.jsp, która wyświetla sugerowaną markę piwa na podstawie wyboru koloru.
Kontroler aplikacji jest skonstruowany w postaci serwletu WyborPiwa. Modelem będzie komponent
będącym klasą EkspertPiwny.</p>
<p> Dodatkowo aplikacja powinna wykorzystując koncepcje filtra na samym początku sprawdzić czy
osoba zainteresowana wyborem marki piwa jest pełnoletnia. Jeśli nie to wyświetlamy jej odpowiedni
komunikat. Tylko osoby pełnoletnie mogą przejść do ekranu wyboru koloru piwa. </p>

### zad 3 ###
Przygotuj stronę logowania. Założenia:
* Formularz wyświetla 2 pola (login i hasło) oraz przycisk "Zaloguj".
* Wewnątrz skryptu w sposób jawny jest zadeklarowany wektor przechowujący elementy
typu DaneOsobowe (składowe: login, hasło, imie, nazwisko). Wektor ten powinien zostać
wypełniony przykładowymi danymi.
* Scenariusze użycia:
  * nie podano loginu - komunikat "Podaj login" i ponowne wyświetlenie formularza,
  * nie podano hasła - komunikat "Podaj hasło" i ponowne wyświetlenie formularza,
  * błędne dane logowania - komunikat o błędzie (tekst dowolny) i ponowne wyświetlenie
formularza,
  * poprawne dane logowania – przejście do strony obsługującej księgę gości. ( patrz
poniżej).
Przygotuj sevlet obsługujący prostą księgę gości.

Założenia:
* Dane podane przez użytkownika powinny być utrwalane w pamięci serwera - zalecana
struktura to Vector.
* Dane nie muszą być utrwalane na stałe. Po restarcie serwera mogą być zerowane.
* Dane wpisane w formularzu powinny być widoczne również z innej sesji przeglądarki
(proszę przeprowadzić testy w przeglądarce trybie "Prywatnym").

## LAB03 - JSF ##
### zad 4 ###
<p>
Stwórz aplikacje ułatwiającą zarządzanie posiadanymi książkami. Książki są wysiedlane w postaci
tabelarycznej z następującymi polami do wyświetlenie: tytuł, autor, typ książki (typu wojenna,
romans, kryminał itp.), cena zakupu, waluta, ilość stron. Aplikacja powinna umożliwiać dynamiczne
filtrowanie wyświetlanych danych po dowolnej ilości kryteriów: np. zakres cenowy i typ waluty.
Dodatkowo powinna być możliwość ukrywania wybranych kategorii. Cena zakupu książki powinna
umożliwiać wyświetlanie ceny w walucie polskiej lub oryginalnej, jeśli książka była kupiona np. w Euro
lub USD Oczywiście przeliczanie odbywało by się globalnie dla całej listy książek.</br>
Użytkownik powinien mieć możliwość wyboru/zaznaczenia interesujących go pozycji i po akceptacji
wyboru wyświetlić mu podsumowanie zamówienia – ilość pozycji + suma zamówionych książek.</p>
<p>Ze względu na fakt, że nie przerabialiśmy jeszcze współpracy z bazą danych dane niech będą zaszyte
w dowolnej kolekcji zaczytywanej przez beany.</p>

### zad 5 ###
Jesteś już specjalistą w zakresie ankiet, więc otrzymujesz coraz więcej zleceń. Twój kolejny klient
poprosił Cię o przygotowanie ankiety dla internetowego sklepu z odzieżą. Ma ona być skierowana
zarówno do nowych klientów użytkowników, badając ich preferencje zakupowe, jak również do
obecnych klientów, sprawdzając ich poziom zadowolenia z towarów i obsługi. Twoim zadaniem jest
zaproponowanie i wykonanie ankiety z uwzględnieniem części wspólnej, która zawiera:
* imię (wymagane)
* adres e-mail (wymagane, poprawny adres)
* wiek (wartość między 10 a 100)
* płeć
* wykształcenie
* wzrost ( dla kobiet w zakresie 150 -185 dla mężczyzn 165-200)

Na podstawie płci należy wyświetlić dodatkowe informacje:

w przypadku kobiet:
* obwód biustu
* wielkość miseczki
* talia
* biodra

w przypadku mężczyzn:
* klatka
* pas

Dodatkowo po zaakceptowaniu powyższej części formularza wyświetla się dodatkowa sekcja pytań:
Pytania wspólne dla nowych klientów:
* Ile jesteś w stanie przeznaczyc miesięcznie na zakup ubrania? (Lista wyboru, odpowiedzi: „do
100 zł”, „100-500 zł”, „500-1000 zł”, „powyżej 1000 zł”.)
* Jak często dokonujesz zakupu ubrania? (Lista wyboru, odpowiedzi: „Codziennie”, „Raz w
tygodniu”, „Raz w miesiącu”, „Kilka razy w roku”.)
* W jakich kolorach preferujesz ubrania? (Lista wielokrotnego wyboru, odpowiedzi: „Kolorowojaskrawych”,
„Stonowanych w szarościach”, „W czerni i bieli”, „W samej czerni”.)
* Jakiego rodzaju ubrania najchętniej kupujesz?

W przypadku, gdy klient jest kobietą, pobierz odpowiedź z listy (Lista wielokrotnego wyboru,
odpowiedzi: „garsonki”, „bluzki”, „spódniczki”, „spodnie”.)

Gdy mężczyzną: (Lista wielokrotnego wyboru, odpowiedzi: „spodnie”, „spodenki”, „garnitury”,
„koszule”, „krawaty”.)

Koniecznie sprawdź poprawność wpisywanych danych, a w podsumowaniu ankiety wyświetl
informacje wypełnione przez użytkownika. Klient zażyczył sobie również, by na stronie była
możliwość losowego wyświetlania reklam wraz z rejestracją ilości kliknięć banera.

## LAB04 - EJB ##
<p>Napisać aplikacje do zakupu biletów do teatru w oparciu o różnego rodzaju komponenty
EJB. </p>
<p>Singletonowy komponent EJB ma zawierać metody obsługujące zarządzanie miejscami w teatrze.
Dodajmy do projektu kilka ziaren sesyjnych związanych z logiką biznesową, takich jak bezstanowe
ziarno sesyjne odpowiedzialne za informacje o dostępności poszczególnych miejsc w teatrze i stanowe
ziarno sesyjne działające jako pośrednik systemu płatności – pozwalające na zakup biletu na określone
miejsce. Zakup wiąze się z zmniejszeniem stanu konta poszczególnego użytkownika.</p>
<p>Ziarno singletonowe udostępnia trzy metody publiczne. Metoda getSeatList zwraca listę obiektów
Seat, które zostaną wykorzystane do wskazania użytkownikowi, czy podane miejsce zostało
zarezerwowane.</p>
<p>Metoda getSeatPrice to metoda pomocnicza, która zwraca cenę za miejsce jako typ int, co umożliwia
szybkie sprawdzenie, czy użytkownika stać na zakup wskazanego miejsca.</p>
<p>Ostatnia z metod, buyTicket, odpowiada za zakup biletu i oznaczenie miejsca jako zarezerwowanego.</p>
<p>Oprócz tego Singleton ma stworzyć liste miejsc z przypisanymi im cenami w momencie stworzenia
komponentu.</p>
<p>Ziarno nad metodami dotyczącymi obsługi obiektów Seat powinno zawiera adnotację @Lock. Służy
ona do sterowania współbieżnością singletonu. Współbieżny dostęp do singletonowego EJB jest
domyślnie kontrolowany przez kontener.</p>
<p>Aby kontrolować zawartość portfela klienta, potrzebny będzie komponent przechowujący dane sesji
z klientem. Głównym celem klasy sesyjnej jest wywołanie metody buyTicket singletonu po
przeprowadzeniu kilku prostych testów związanych z logiką biznesową. Jeśli w trakcie sprawdzeń
pojawi się sytuacja niedozwolona, aplikacja zgłosi wyjątek. Dotyczy to między innymi sytuacji, w
których miejsce zostało już zarezerwowane lub gdy klient nie posiada wystarczających środków na
zakup biletu</p>
<p>Klientem aplikacji niech będzie aplikacja webowa stworzona w JSF. Zakres i projekt pozostawiam do
Państwa uznania.</p>



## LAB05 - JPA ##

Stwórz aplikacje webowa pozwalającą na zarządzanie książkami. Aplikacja
umożliwia podgląd, dodawanie, usuwanie i modyfikacje pozycji katalogu.
Katalog zawiera następujące pozycje: nazwisko autora, imię, tytuł, numer ISBN,
rok wydania, cena.

Można wykorzystać warstwę prezentacyjna wykonaną w ramach lab 3.

## LAB06 - Hibernate ##

W oparciu o Hibernate samodzielnie zbudować aplikacje
typu Biblioteka. Model danych powinien składać się z obiektów:
Czytelnik, Książka, Autor, Kategorie, Katalog oraz Wypożyczenia.
Czytelnik składa się z imienia, nazwiska. Książka to tytuł, id autora,
numer ISBN, kategoria. Wypożyczenia przechowuje informacje o
wypożyczonych książkach przez czytelnika. Składa się z id książki, id
czytelnika oraz daty wypożyczenia i daty zwrotu. Katalog zawiera
informacje o wszystkich instancjach książek dostępnych w naszej
bibliotece – np. możemy mieć 10 egzemplarzy jakieś pozycji oraz
zawiera informacje o jej aktualnym stanie
Aplikacja umożliwia podgląd, dodawanie, usuwanie i modyfikacje
poszczególnych pozycji katalogu bibliotecznego.
Dodatkowo należy dorobić opcje pozwalające na wyszukiwanie
bardziej zaawansowanych kryteriów wyszukiwania np.
1. podaj wszystkich czytelników, którzy pożyczyli książki danego
autora ( np. Sienkiewicza) w okresie od 1.01.2018 do 1.05.2018
2. Kto przeczytał książkę „kapitan nemo” w podanym okresie czasu
3. Wszystkich autorów, których książki pożyczył pan Jan Kowalski
(ewentualnie w jakim okresie czasu)
4. Jakiego autora czyta się najwięcej?

## LAB08 - REST ##
### REST ###
W oparciu o wiedze z wykładu dotyczącą sposobu adresacji zasobów w REST API (poziom 2)
zaimplementuj prostą aplikacje umożliwiającą dostęp do kolekcji osób oraz ich ulubionych filmów.
Kolekcja może być przechowywana w bazie danych lub w pliku XML.
Na potrzeby lab przyjmij następujące API RESTowe:
o User opisany jest za pomocą: Id, imienia, wiek, awataru (w postaci grafiki) oraz jest
właścicielem kolekcji filmów.
o Pojedynczy film zawiera następujące pola: ‘id’: identyfikator, ‘title’: tytul ‘uri’: link
do siebie

Zaimplementuj komplet CRUD dla obu typów zasobów

Filtrowanie po tytule

Dopisz parametr ‘title’ do zasobu movies pozwalający wyszukać film po tytule. Upewnij się że
parametr jest dodany do opisu usługi.

Zaimplementuj metodę pozwalającą na modyfikacje tylko jednej wartości np. zmianę linku dla
wybranego filmu.

Utwórz zasób o URI ‘/osoby’, który spowoduje przekierowanie do /users. 

Spróbuj zwrócić poprzez API REST dane binarne np. plik PNG (avatar usera).

### Klient ###
Napisz jako niezależną aplikację, aplikacje kliencką pozwalającą na zarządzanie kolekcją
users i ich filmów. Wykorzystaj funkcjonalność klienta w RESTEasy.
