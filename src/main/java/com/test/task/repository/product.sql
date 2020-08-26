CREATE TABLE public.product
(
    id integer NOT NULL DEFAULT nextval('product_id_seq'::regclass),
    name character varying(300) COLLATE pg_catalog."default",
    description character varying(300) COLLATE pg_catalog."default",
    price character varying(300) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (id)
)