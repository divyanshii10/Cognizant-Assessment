-- Exercise 3: Stored Procedures

-- Scenario 1: ProcessMonthlyInterest for savings accounts (1% interest)
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all Savings accounts.');
END ProcessMonthlyInterest;
/

-- Scenario 2: UpdateEmployeeBonus based on department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percentage / 100))
    WHERE Department = p_department;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to department: ' || p_department);
END UpdateEmployeeBonus;
/

-- Scenario 3: TransferFunds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_from_balance NUMBER;
BEGIN
    -- Check balance of the source account
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE; -- Lock row for update to prevent race conditions

    IF v_from_balance >= p_amount THEN
        -- Deduct from source account
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account_id;

        -- Add to destination account
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' from Account ' || p_from_account_id || ' to Account ' || p_to_account_id || ' completed successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient funds in Account ' || p_from_account_id || ' for transfer.');
        ROLLBACK;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('One of the accounts does not exist.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred during transfer: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/
