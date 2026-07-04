-- Exercise 1: Control Structures

-- Setup: Adding IsVIP column to Customers table for Scenario 2 if it doesn't exist
-- ALTER TABLE Customers ADD (IsVIP VARCHAR2(5) DEFAULT 'FALSE');

-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60 years old
DECLARE
    CURSOR c_customers_above_60 IS
        SELECT c.CustomerID, c.DOB 
        FROM Customers c
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60;
BEGIN
    FOR cust IN c_customers_above_60 LOOP
        UPDATE Loans l
        SET l.InterestRate = l.InterestRate - 1
        WHERE l.CustomerID = cust.CustomerID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Set IsVIP flag to TRUE for customers with balance over $10,000
DECLARE
    CURSOR c_high_balance_customers IS
        SELECT CustomerID, Balance 
        FROM Customers 
        WHERE Balance > 10000;
BEGIN
    FOR cust IN c_high_balance_customers LOOP
        -- Assuming IsVIP column exists in Customers table
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print reminder for loans due in next 30 days
SET SERVEROUTPUT ON;
DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan.Name || ' (Loan ID: ' || loan.LoanID || ') has a loan due on ' || TO_CHAR(loan.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
