DELETE from transactions;
DELETE from accounts;
DELETE from categories;
DELETE from users;

INSERT INTO users (id, email, name) VALUES
(1, 'user1@example.com', 'User One'),
(2, 'user2@example.com', 'User Two');

INSERT INTO accounts (id, name, balance, user_id) VALUES
(1, 'Account 1', 1000.00, 1),
(2, 'Account 2', 1500.50, 2);

INSERT INTO categories (id, name, user_id) VALUES
(1, 'Groceries', 1),
(2, 'Salary', 2),
(3, 'Utilities', 1);

INSERT INTO transactions (id, account_id, category_id, date, description, amount, type) VALUES
(1, 1, 1, '2023-04-01', 'Grocery shopping', 150.00, 'EXPENSE'),
(2, 1, 3, '2023-04-02', 'Electricity bill', 90.00, 'EXPENSE'),
(3, 2, 2, '2023-04-03', 'Monthly salary', 3000.00, 'INCOME');

ALTER SEQUENCE users_id_seq RESTART WITH 3;
ALTER SEQUENCE accounts_id_seq RESTART WITH 3;
ALTER SEQUENCE categories_id_seq RESTART WITH 4;
ALTER SEQUENCE transactions_id_seq RESTART WITH 4;