SET REFERENTIAL_INTEGRITY FALSE;

DROP TABLE IF EXISTS withdrawals;
DROP TABLE IF EXISTS time_deposits;

SET REFERENTIAL_INTEGRITY TRUE;

CREATE TABLE time_deposits (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plan_type VARCHAR(100) NOT NULL,
    days INT NOT NULL,
    balance DECIMAL(15, 2) NOT NULL
);

CREATE TABLE withdrawals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    time_deposit_id INT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    date DATE NOT NULL,
    CONSTRAINT fk_time_deposit
        FOREIGN KEY (time_deposit_id)
        REFERENCES time_deposits(id)
        ON DELETE CASCADE
);
