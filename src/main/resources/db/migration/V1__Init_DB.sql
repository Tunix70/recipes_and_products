CREATE TABLE "azure".user_parameters
(
    user_id VARCHAR(36),
    gender  VARCHAR(5)       not null,
    age     INTEGER          not null,
    weight  DOUBLE PRECISION not null,
    height  INTEGER          not null,
    bmi     DOUBLE PRECISION not null,
    PRIMARY KEY (user_id)
);