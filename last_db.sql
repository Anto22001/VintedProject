

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
    id integer NOT NULL,
    id_articolo character(4) NOT NULL,
    id_wishlist character(4) NOT NULL
);


ALTER TABLE vinted.articolo_wishlist OWNER TO postgres;

--
-- Name: articolo_wishlist_id_seq; Type: SEQUENCE; Schema: vinted; Owner: postgres
--

CREATE SEQUENCE vinted.articolo_wishlist_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vinted.articolo_wishlist_id_seq OWNER TO postgres;

--
-- Name: articolo_wishlist_id_seq; Type: SEQUENCE OWNED BY; Schema: vinted; Owner: postgres
--

ALTER SEQUENCE vinted.articolo_wishlist_id_seq OWNED BY vinted.articolo_wishlist.id;


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
    id integer NOT NULL,
    id_articolo character(4) NOT NULL,
    id_categoria character(4) NOT NULL
);


ALTER TABLE vinted.categoria_articolo OWNER TO postgres;

--
-- Name: categoria_articolo_id_seq; Type: SEQUENCE; Schema: vinted; Owner: postgres
--

CREATE SEQUENCE vinted.categoria_articolo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vinted.categoria_articolo_id_seq OWNER TO postgres;

--
-- Name: categoria_articolo_id_seq; Type: SEQUENCE OWNED BY; Schema: vinted; Owner: postgres
--

ALTER SEQUENCE vinted.categoria_articolo_id_seq OWNED BY vinted.categoria_articolo.id;


--
-- Name: categoria_preferita; Type: TABLE; Schema: vinted; Owner: postgres
--

CREATE TABLE vinted.categoria_preferita (
    id integer NOT NULL,
    id_utente character(4) NOT NULL,
    id_categoria character(4) NOT NULL
);


ALTER TABLE vinted.categoria_preferita OWNER TO postgres;

--
-- Name: categoria_preferita_id_seq; Type: SEQUENCE; Schema: vinted; Owner: postgres
--

CREATE SEQUENCE vinted.categoria_preferita_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vinted.categoria_preferita_id_seq OWNER TO postgres;

--
-- Name: categoria_preferita_id_seq; Type: SEQUENCE OWNED BY; Schema: vinted; Owner: postgres
--

ALTER SEQUENCE vinted.categoria_preferita_id_seq OWNED BY vinted.categoria_preferita.id;


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
    citta character varying NOT NULL,
    valutazione_media double precision DEFAULT 0.0
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
-- Name: articolo_wishlist id; Type: DEFAULT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.articolo_wishlist ALTER COLUMN id SET DEFAULT nextval('vinted.articolo_wishlist_id_seq'::regclass);


--
-- Name: categoria_articolo id; Type: DEFAULT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_articolo ALTER COLUMN id SET DEFAULT nextval('vinted.categoria_articolo_id_seq'::regclass);


--
-- Name: categoria_preferita id; Type: DEFAULT; Schema: vinted; Owner: postgres
--

ALTER TABLE ONLY vinted.categoria_preferita ALTER COLUMN id SET DEFAULT nextval('vinted.categoria_preferita_id_seq'::regclass);


--
-- Data for Name: acquisto; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

INSERT INTO vinted.acquisto VALUES ('wxyz', '0002', '1001', '2022-06-14', 'a ped', '2022-06-17');


--
-- Data for Name: articolo; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

INSERT INTO vinted.articolo VALUES ('1001', 'Libro', '', '0001', 'gne', '2022-06-14', 'Catanzaro', 30.1, true);


--
-- Data for Name: articolo_wishlist; Type: TABLE DATA; Schema: vinted; Owner: postgres
--



--
-- Data for Name: categoria; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

INSERT INTO vinted.categoria VALUES ('bb00', 'Libri');


--
-- Data for Name: categoria_articolo; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

INSERT INTO vinted.categoria_articolo VALUES (1, '1001', 'bb00');


--
-- Data for Name: categoria_preferita; Type: TABLE DATA; Schema: vinted; Owner: postgres
--



--
-- Data for Name: recensione; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

INSERT INTO vinted.recensione VALUES ('aa00', '0001', '0002', '', 'bdettu', 3, '2022-06-14');
INSERT INTO vinted.recensione VALUES ('aa01', '0001', '0002', '', 'bonu', 2, '2022-06-14');


--
-- Data for Name: utente; Type: TABLE DATA; Schema: vinted; Owner: postgres
--

INSERT INTO vinted.utente VALUES ('0002', 'Paolo', 'Rizzo', '1993-05-03', 'Palermo', 0);
INSERT INTO vinted.utente VALUES ('0001', 'Carlo', 'Ponte', '1998-12-03', 'Catanzaro', 2.5);
INSERT INTO vinted.utente VALUES ('0003', 'Piero', 'Pelusi', '2002-10-03', 'Padova', 0);


--
-- Data for Name: wishlist; Type: TABLE DATA; Schema: vinted; Owner: postgres
--



--
-- Name: articolo_wishlist_id_seq; Type: SEQUENCE SET; Schema: vinted; Owner: postgres
--

SELECT pg_catalog.setval('vinted.articolo_wishlist_id_seq', 1, false);


--
-- Name: categoria_articolo_id_seq; Type: SEQUENCE SET; Schema: vinted; Owner: postgres
--

SELECT pg_catalog.setval('vinted.categoria_articolo_id_seq', 1, true);


--
-- Name: categoria_preferita_id_seq; Type: SEQUENCE SET; Schema: vinted; Owner: postgres
--

SELECT pg_catalog.setval('vinted.categoria_preferita_id_seq', 1, false);


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

