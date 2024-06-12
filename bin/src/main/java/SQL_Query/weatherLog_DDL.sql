CREATE TABLE public."WeatherLog"
(
    "Id" integer NOT NULL,
    "responseId" character varying,
    location character varying,
    "actualWeather" character varying,
    temperature character varying,
    "dtimeInserted" timestamp without time zone,
    PRIMARY KEY ("Id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."WeatherLog"
    OWNER to postgres;