CREATE TABLE public.article
(
    id integer NOT NULL DEFAULT nextval('article_id_seq'::regclass),
    name character varying(300) COLLATE pg_catalog."default",
    content character varying(300) COLLATE pg_catalog."default",
    created timestamp without time zone,
    product_id integer,
    CONSTRAINT article_pkey PRIMARY KEY (id)
)