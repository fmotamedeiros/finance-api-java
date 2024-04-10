CREATE TABLE IF NOT EXISTS USERS (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    username VARCHAR(255) UNIQUE,
    PASSWORD NVARCHAR2(128) NOT NULL,
    ENABLED CHAR(1) CHECK (ENABLED IN ('Y','N') ) NOT NULL
);

CREATE TABLE IF NOT EXISTS ACCOUNTS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    balance DECIMAL(19,2),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS CATEGORIES (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS TRANSACTIONS (
    id SERIAL PRIMARY KEY,
    account_id BIGINT,
    category_id BIGINT,
    date DATE,
    description VARCHAR(255),
    amount DECIMAL(19,2),
    type VARCHAR(255),
    FOREIGN KEY (account_id) REFERENCES accounts(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE IF NOT EXISTS AUTHORITIES (
    user_id SERIAL NOT NULL,
    authority VARCHAR(128) NOT NULL
);

ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_UNIQUE UNIQUE (user_id, authority);
ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY (user_id) REFERENCES USERS (id);
