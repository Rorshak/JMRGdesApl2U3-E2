-- Table: public.automovil

-- DROP TABLE public.automovil;

CREATE TABLE public.automovil
(
  id integer NOT NULL DEFAULT nextval('automovil_id_seq'::regclass),
  marca character varying(20),
  modelo character varying(20),
  year integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.automovil
  OWNER TO utng;
