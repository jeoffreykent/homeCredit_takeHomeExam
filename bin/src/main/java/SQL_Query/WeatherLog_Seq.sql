CREATE SEQUENCE public."weatherlog_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public."weatherlog_seq"
    OWNER TO postgres;
    
ALTER TABLE public."WeatherLog"
    ALTER COLUMN "Id" SET DEFAULT nextval('weatherlog_seq'::regclass);