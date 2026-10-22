-- Fornece números para gerar os códigos internos dos equipamentos.
CREATE SEQUENCE equipamento_codigo_seq
    AS BIGINT
    START WITH 1
    INCREMENT BY 1
    NO CYCLE;