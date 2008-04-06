drop type KlientTyp force;
drop type ListaKontTyp force;
drop type AdresTyp force;
drop type KontoTyp force;
drop type ListaTelefonowTyp force;
drop type ListaZamowienTyp force;
drop type ZamowienieTyp force;
drop type PozycjaZamowieniaTyp force;
drop type WypozyczalniaTyp force;
drop type PunktTyp force;
drop type ManagerTyp force;
drop type DyrektorTyp force;
drop type FilmTyp force;
drop type KasetaTyp force;
drop type PracownikTyp force;
drop type OsobaTyp force;
drop type RezyserTyp force;
drop type AktorTyp force;
drop type DystrybutorTyp force;
drop type GatunekTyp force;
drop type ListaAktorowTyp force;
drop type ListaGatunkowTyp force;
drop type ListaPunktowTyp force;
drop type ListaOcenTyp force;
drop type OcenaTyp force;

create or replace type AdresTyp as object
(
ulica varchar(30),
miasto varchar(30),
nrdomu int,
nr_mieszkania int
);
/
create type KontoTyp;
/
create type KasetaTyp;
/
create type WypozyczalniaTyp;
/
create type PunktTyp;
/
create type KlientTyp;
/
create type FilmTyp;
/
create or replace type OcenaTyp as object 
(
ocena int,
film ref FilmTyp,
klient ref KlientTyp
);
/
create or replace type ListaOcenTyp as table of OcenaTyp;
/
create or replace type ListaTelefonowTyp as varray(10) of varchar2(12);
/
create or replace type OsobaTyp as object(
imie varchar(30),
nazwisko varchar(30),
adresMailowy varchar(30),
nazwiskoRodowe varchar(30),
telefony ListaTelefonowTyp
) not final
not instantiable
;

/
create or replace type PracownikTyp under OsobaTyp
(
typUmowy int
) not final;
/
create or replace type ManagerTyp under PracownikTyp
(
punkt ref PunktTyp
) not final;
/
create or replace type DyrektorTyp under ManagerTyp
(
wypozyczalnia ref WypozyczalniaTyp
) final;
/
create or replace type PunktTyp as object
(
manager ref ManagerTyp
);
/
create type ListaPunktowTyp  as table of PunktTyp ;
/
create or replace type WypozyczalniaTyp as object
(
listaOcen ListaOcenTyp,
dyrektor ref DyrektorTyp,
listaPunktow ListaPunktowTyp
);


/

create or replace type PozycjaZamowieniaTyp as object
(
dataZlozenia timestamp
);
/
create or replace type ZamowienieTyp as object
(
dataZlozenia timestamp
);
/
create or replace type ListaZamowienTyp as table of ZamowienieTyp;
/

create or replace type KontoTyp as object
(
stan varchar(10),
wygasloHaslo boolean,
dataOstatniegoLogowania timestamp,
skrotHasla varchar(30),
dataOstatniejZmianyHasla timestamp,
zamowienia ListaZamowienTyp
);
/
create or replace type ListaKontTyp as table of KontoTyp;
/
create or replace type KlientTyp under OsobaTyp
(
nrPesel varchar(30),
adres AdresTyp,
konta ListaKontTyp
);
/
create or replace type GatunekTyp as object(
typ int
);
/
create or replace type DystrybutorTyp as object (
typ int
);
/
create or replace type AktorTyp as object(
typ int
);
/
create or replace type RezyserTyp as object (
typ int
);
/
create or replace type ListaAktorowTyp as table of AktorTyp;
/
create or replace type ListaGatunkowTyp as table of GatunekTyp;
/
create or replace type FilmTyp as object
(
gatunek ref GatunekTyp,
data timestamp
);
/
create or replace type KasetaTyp as object
(
film ref FilmTyp
);
/


