-- Insert Time Deposits
INSERT INTO time_deposits (id, plan_type, days, balance)
VALUES (1, 'BASIC', 45, 1000.00);

INSERT INTO time_deposits (id, plan_type, days, balance)
VALUES (2, 'STUDENT', 365, 2000.00);

INSERT INTO time_deposits (id, plan_type, days, balance)
VALUES (3, 'PREMIUM', 90, 5000.00);

-- Insert Withdrawals
INSERT INTO withdrawals (id, time_deposit_id, amount, date)
VALUES (1, 1, 100.00, '2025-01-15');

INSERT INTO withdrawals (id, time_deposit_id, amount, date)
VALUES (2, 2, 250.00, '2025-03-01');

INSERT INTO withdrawals (id, time_deposit_id, amount, date)
VALUES (3, 3, 500.00, '2025-04-10');
