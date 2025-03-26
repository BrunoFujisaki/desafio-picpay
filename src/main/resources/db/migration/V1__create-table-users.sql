CREATE TABLE users(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    document TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    type VARCHAR(8) NOT NULL
);