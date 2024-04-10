INSERT INTO USERS (id, email, username, password, enabled) VALUES
(1, 'user1@example.com', 'user', '$2a$12$i6Zp2MR/6zZ/KqOshnwcU.H/ltfUzXLM5pC1J1dHS2lNN8t6C9J66', 'Y'),
(2, 'user2@example.com', 'admin', '$2a$12$i6Zp2MR/6zZ/KqOshnwcU.H/ltfUzXLM5pC1J1dHS2lNN8t6C9J66', 'Y');

INSERT INTO AUTHORITIES (user_id, authority) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

INSERT INTO ACCOUNTS (id, name, balance, user_id) VALUES
(1, 'Account 1', 1000.00, 1),
(2, 'Account 2', 1500.50, 2);

INSERT INTO CATEGORIES (id, name, user_id) VALUES
(1, 'Groceries', 1),
(2, 'Salary', 2),
(3, 'Utilities', 1);

INSERT INTO TRANSACTIONS (id, account_id, category_id, date, description, amount, type) VALUES
(1, 1, 1, '2023-04-01', 'Grocery shopping', 150.00, 'EXPENSE'),
(2, 1, 3, '2023-04-02', 'Electricity bill', 90.00, 'EXPENSE'),
(3, 2, 2, '2023-04-03', 'Monthly salary', 3000.00, 'INCOME');

ALTER SEQUENCE USERS_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE ACCOUNTS_ID_SEQ RESTART WITH 3;
ALTER SEQUENCE CATEGORIES_ID_SEQ RESTART WITH 4;
ALTER SEQUENCE TRANSACTIONS_ID_SEQ RESTART WITH 4;