-- for h2 database
DROP TABLE IF EXISTS stocks;

CREATE TABLE stocks
(
    id    varchar(255),
    name  varchar(255),
    price double
);