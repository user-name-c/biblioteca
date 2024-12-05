CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(255) NOT NULL,
    birth_date DATE,
    death_date DATE
);