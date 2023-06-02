--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.4

-- Started on 2022-09-22 14:53:17 MSK

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16419)
-- Name: currency_codes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.currency_codes (
    id integer NOT NULL,
    char_code text NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.currency_codes OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16418)
-- Name: currency_codes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.currency_codes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.currency_codes_id_seq OWNER TO postgres;

--
-- TOC entry 3603 (class 0 OID 0)
-- Dependencies: 213
-- Name: currency_codes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.currency_codes_id_seq OWNED BY public.currency_codes.id;


--
-- TOC entry 212 (class 1259 OID 16410)
-- Name: currency_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.currency_history (
    id integer NOT NULL,
    date text NOT NULL,
    curr1 text NOT NULL,
    curr2 text NOT NULL,
    curr3 text NOT NULL,
    curr4 text NOT NULL,
    curr5 text NOT NULL,
    curr6 text NOT NULL,
    curr7 text NOT NULL,
    curr8 text NOT NULL,
    curr9 text NOT NULL,
    curr10 text NOT NULL,
    curr11 text NOT NULL,
    curr12 text NOT NULL,
    curr13 text NOT NULL,
    curr14 text NOT NULL,
    curr15 text NOT NULL,
    curr16 text NOT NULL,
    curr17 text NOT NULL,
    curr18 text NOT NULL,
    curr19 text NOT NULL,
    curr20 text NOT NULL,
    curr21 text NOT NULL,
    curr22 text NOT NULL,
    curr23 text NOT NULL,
    curr24 text NOT NULL,
    curr25 text NOT NULL,
    curr26 text NOT NULL,
    curr27 text NOT NULL,
    curr28 text NOT NULL,
    curr29 text NOT NULL,
    curr30 text NOT NULL,
    curr31 text NOT NULL,
    curr32 text NOT NULL,
    curr33 text NOT NULL,
    curr34 text DEFAULT 1 NOT NULL,
    curr0 text NOT NULL
);


ALTER TABLE public.currency_history OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16409)
-- Name: currency_history_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.currency_history_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.currency_history_id_seq OWNER TO postgres;

--
-- TOC entry 3604 (class 0 OID 0)
-- Dependencies: 211
-- Name: currency_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.currency_history_id_seq OWNED BY public.currency_history.id;


--
-- TOC entry 216 (class 1259 OID 16429)
-- Name: query_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.query_history (
    id integer NOT NULL,
    curr1 text NOT NULL,
    curr2 text NOT NULL,
    value1 text NOT NULL,
    value2 text NOT NULL,
    date text NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.query_history OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16428)
-- Name: query_history_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.query_history_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.query_history_id_seq OWNER TO postgres;

--
-- TOC entry 3605 (class 0 OID 0)
-- Dependencies: 215
-- Name: query_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.query_history_id_seq OWNED BY public.query_history.id;


--
-- TOC entry 210 (class 1259 OID 16398)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    login text NOT NULL,
    password character(32) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16397)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3606 (class 0 OID 0)
-- Dependencies: 209
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3449 (class 2604 OID 16422)
-- Name: currency_codes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currency_codes ALTER COLUMN id SET DEFAULT nextval('public.currency_codes_id_seq'::regclass);


--
-- TOC entry 3447 (class 2604 OID 16413)
-- Name: currency_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currency_history ALTER COLUMN id SET DEFAULT nextval('public.currency_history_id_seq'::regclass);


--
-- TOC entry 3450 (class 2604 OID 16432)
-- Name: query_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query_history ALTER COLUMN id SET DEFAULT nextval('public.query_history_id_seq'::regclass);


--
-- TOC entry 3446 (class 2604 OID 16401)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3456 (class 2606 OID 16426)
-- Name: currency_codes currency_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currency_codes
    ADD CONSTRAINT currency_codes_pkey PRIMARY KEY (id);


--
-- TOC entry 3454 (class 2606 OID 16417)
-- Name: currency_history currency_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currency_history
    ADD CONSTRAINT currency_history_pkey PRIMARY KEY (id);


--
-- TOC entry 3458 (class 2606 OID 16436)
-- Name: query_history query_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.query_history
    ADD CONSTRAINT query_history_pkey PRIMARY KEY (id);


--
-- TOC entry 3452 (class 2606 OID 16405)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2022-09-22 14:53:17 MSK

--
-- PostgreSQL database dump complete
--

