CREATE TABLE transactions(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    "value" DECIMAL(10, 2) NOT NULL,
    payer_id BIGINT NOT NULL,
    payee_id BIGINT NOT NULL,
    CONSTRAINT payer_fk FOREIGN KEY (payer_id) REFERENCES users(id),
    CONSTRAINT payee_fk FOREIGN KEY (payee_id) REFERENCES users(id)
);