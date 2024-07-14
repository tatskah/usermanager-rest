Database schema:


CREATE TABLE public.address (
    id bigint NOT NULL,
    city character varying(255),
    street character varying(255),
    suite character varying(255),
    zipcode character varying(255)
);


CREATE TABLE public.company (
    id bigint NOT NULL,
    bs character varying(255),
    catch_phrase character varying(255),
    name character varying(255)
);


CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    phone character varying(255),
    username character varying(255),
    website character varying(255),
    address_id bigint,
    company_id bigint
);
