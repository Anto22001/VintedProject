--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: vinted_db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE vinted_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';


ALTER DATABASE vinted_db OWNER TO postgres;

\connect vinted_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: vinted; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA vinted;


ALTER SCHEMA vinted OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: acquisto; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.acquisto (
    id character(4) NOT NULL,
    id_acquirente character(4) NOT NULL,
    id_articolo character(4) NOT NULL,
    data_acquisto date NOT NULL,
    modalita_spedizione character varying NOT NULL,
    data_spedizione date NOT NULL
);


ALTER TABLE vinted.acquisto OWNER TO postgres;

--
-- Name: articolo; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.articolo (
    id character(4) NOT NULL,
    nome character varying NOT NULL,
    descrizione character varying,
    id_venditore character(4) NOT NULL,
    condizioni character varying,
    data_pubblicazione date NOT NULL,
    luogo character varying NOT NULL,
    prezzo double precision NOT NULL,
    in_vendita boolean DEFAULT true NOT NULL
);


ALTER TABLE vinted.articolo OWNER TO postgres;

--
-- Name: articolo_wishlist; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.articolo_wishlist (
    id character(4) NOT NULL,
    id_articolo character(4) NOT NULL,
    id_wishlist character(4) NOT NULL
);


ALTER TABLE vinted.articolo_wishlist OWNER TO postgres;

--
-- Name: categoria; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.categoria (
    id character(4) NOT NULL,
    nome character varying NOT NULL
);


ALTER TABLE vinted.categoria OWNER TO postgres;

--
-- Name: categoria_articolo; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.categoria_articolo (
    id character(4) NOT NULL,
    id_articolo character(4) NOT NULL,
    id_categoria character(4) NOT NULL
);


ALTER TABLE vinted.categoria_articolo OWNER TO postgres;

--
-- Name: categoria_preferita; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.categoria_preferita (
    id character(4) NOT NULL,
    id_utente character(4) NOT NULL,
    id_categoria character(4) NOT NULL
);


ALTER TABLE vinted.categoria_preferita OWNER TO postgres;

--
-- Name: recensione; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.recensione (
    id character(4) NOT NULL,
    id_recensito character(4) NOT NULL,
    id_recensore character(4) NOT NULL,
    titolo character varying,
    testo character varying,
    valutazione integer NOT NULL,
    data_pubblicazione date NOT NULL
);


ALTER TABLE vinted.recensione OWNER TO postgres;

--
-- Name: utente; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.utente (
    id character(4) NOT NULL,
    nome character varying NOT NULL,
    cognome character varying NOT NULL,
    data_nascita date NOT NULL,
    citta character varying NOT NULL
);


ALTER TABLE vinted.utente OWNER TO postgres;

--
-- Name: wishlist; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.wishlist (
    id character(4) NOT NULL,
    nome character varying NOT NULL,
    id_utente character(4) NOT NULL
);


ALTER TABLE vinted.wishlist OWNER TO postgres;

--
-- Data for Name: acquisto; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.acquisto (id, id_acquirente, id_articolo, data_acquisto, modalita_spedizione, data_spedizione) FROM stdin;
AAAA	0001	0002	2022-05-13	a mano	2022-05-12
BBBB	0004	0003	2022-06-15	poste italiane 	2022-05-16
\.


--
-- Data for Name: articolo; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.articolo (id, nome, descrizione, id_venditore, condizioni, data_pubblicazione, luogo, prezzo, in_vendita) FROM stdin;
0001	Maglietta	magliettina	0002	nuove	2022-06-13	Catania	22.5	t
0002	Pantaloni		0003	pessime	2022-05-13	Palermo	10.5	t
0003	PlayStation		0003	come nuovo	2022-06-14	Palermo	300	t
0004	PC	Pc usato pochissimo vendo causa inutilizzo	0002	nuove	2022-06-12	Messina	0	t
\.


--
-- Data for Name: articolo_wishlist; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.articolo_wishlist (id, id_articolo, id_wishlist) FROM stdin;
\.


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.categoria (id, nome) FROM stdin;
\.


--
-- Data for Name: categoria_articolo; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.categoria_articolo (id, id_articolo, id_categoria) FROM stdin;
\.


--
-- Data for Name: categoria_preferita; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.categoria_preferita (id, id_utente, id_categoria) FROM stdin;
\.


--
-- Data for Name: recensione; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.recensione (id, id_recensito, id_recensore, titolo, testo, valutazione, data_pubblicazione) FROM stdin;
\.


--
-- Data for Name: utente; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.utente (id, nome, cognome, data_nascita, citta) FROM stdin;
0001	Antonino	Palumeri	1996-04-12	Piazza Armerina
0002	Simone	Conti	1997-06-24	Catania
0003	Emmanuele	Surdi	1992-05-24	Palermo
0004	Lorenzo	Pavano	1990-06-24	Siracusa
\.


--
-- Data for Name: wishlist; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

COPY vinted.wishlist (id, nome, id_utente) FROM stdin;
\.


--
-- Name: acquisto acquisto_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.acquisto
    ADD CONSTRAINT acquisto_pk PRIMARY KEY (id);


--
-- Name: articolo articolo_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.articolo
    ADD CONSTRAINT articolo_pk PRIMARY KEY (id);


--
-- Name: articolo_wishlist articolo_wishlist_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.articolo_wishlist
    ADD CONSTRAINT articolo_wishlist_pk PRIMARY KEY (id);


--
-- Name: categoria_articolo categoria_articolo_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_articolo
    ADD CONSTRAINT categoria_articolo_pk PRIMARY KEY (id);


--
-- Name: categoria categoria_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (id);


--
-- Name: categoria_preferita categoria_preferita_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_preferita
    ADD CONSTRAINT categoria_preferita_pk PRIMARY KEY (id);


--
-- Name: recensione recensione_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.recensione
    ADD CONSTRAINT recensione_pk PRIMARY KEY (id);


--
-- Name: utente utente_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.utente
    ADD CONSTRAINT utente_pk PRIMARY KEY (id);


--
-- Name: wishlist wishlist_pk; Type: CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.wishlist
    ADD CONSTRAINT wishlist_pk PRIMARY KEY (id);


--
-- Name: acquisto_id_articolo_uindex; Type: INDEX; Schema: vinted; Owner: postgres
--

CREATE UNIQUE INDEX acquisto_id_articolo_uindex ON vinted.acquisto USING btree (id_articolo);


--
-- Name: acquisto acquisto_articolo_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.acquisto
    ADD CONSTRAINT acquisto_articolo_id_fk FOREIGN KEY (id_articolo) REFERENCES vinted.articolo(id);


--
-- Name: acquisto acquisto_utente_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.acquisto
    ADD CONSTRAINT acquisto_utente_id_fk FOREIGN KEY (id_acquirente) REFERENCES vinted.utente(id);


--
-- Name: articolo articolo_utente_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.articolo
    ADD CONSTRAINT articolo_utente_id_fk FOREIGN KEY (id_venditore) REFERENCES vinted.utente(id);


--
-- Name: articolo_wishlist articolo_wishlist_articolo_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.articolo_wishlist
    ADD CONSTRAINT articolo_wishlist_articolo_id_fk FOREIGN KEY (id_articolo) REFERENCES vinted.articolo(id);


--
-- Name: articolo_wishlist articolo_wishlist_wishlist_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.articolo_wishlist
    ADD CONSTRAINT articolo_wishlist_wishlist_id_fk FOREIGN KEY (id_wishlist) REFERENCES vinted.wishlist(id);


--
-- Name: categoria_articolo categoria_articolo_articolo_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_articolo
    ADD CONSTRAINT categoria_articolo_articolo_id_fk FOREIGN KEY (id_articolo) REFERENCES vinted.articolo(id);


--
-- Name: categoria_articolo categoria_articolo_categoria_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_articolo
    ADD CONSTRAINT categoria_articolo_categoria_id_fk FOREIGN KEY (id_categoria) REFERENCES vinted.categoria(id);


--
-- Name: categoria_preferita categoria_preferita_categoria_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_preferita
    ADD CONSTRAINT categoria_preferita_categoria_id_fk FOREIGN KEY (id_categoria) REFERENCES vinted.categoria(id);


--
-- Name: categoria_preferita categoria_preferita_utente_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_preferita
    ADD CONSTRAINT categoria_preferita_utente_id_fk FOREIGN KEY (id_utente) REFERENCES vinted.utente(id);


--
-- Name: recensione recensione_utente_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.recensione
    ADD CONSTRAINT recensione_utente_id_fk FOREIGN KEY (id_recensito) REFERENCES vinted.utente(id);


--
-- Name: recensione recensione_utente_id_fk_2; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.recensione
    ADD CONSTRAINT recensione_utente_id_fk_2 FOREIGN KEY (id_recensore) REFERENCES vinted.utente(id);


--
-- Name: wishlist wishlist_utente_id_fk; Type: FK CONSTRAINT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.wishlist
    ADD CONSTRAINT wishlist_utente_id_fk FOREIGN KEY (id_utente) REFERENCES vinted.utente(id);


--
-- PostgreSQL database dump complete
--

