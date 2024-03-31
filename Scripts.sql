CREATE TABLE flat(
	id 			INTEGER PRIMARY KEY AUTOINCREMENT,
	flat_number TEXT NOT NULL,
	name        TEXT NOT NULL,
	area 		REAL NOT NULL,
	email_id 	TEXT,
	phone_no	TEXT
)

CREATE TABLE charge_type(
	id		  INTEGER PRIMARY KEY AUTOINCREMENT,
	type_name TEXT NOT NULL,
	type_desc TEXT,
	amount    REAL NOT NULL
)

CREATE TABLE manual_bills(
	id          INTEGER PRIMARY KEY AUTOINCREMENT,
	month       INTEGER NOT NULL,
	year        INTEGER NOT NULL,
	monthyear   INTEGER NOT NULL,
	flat_number INTEGER NOT NULL,
	amount      REAL NOT NULL
)

select * from charge_type

select * from flat

select * from manual_bills

-- delete from flat

INSERT INTO flat (flat_number, name, area, email_id, phone_no) VALUES
('101', 'John Doe', 1200.50, 'john.doe@example.com', '1234567890'),
('102', 'Jane Smith', 1150.25, 'jane.smith@example.com', '0987654321'),
('103', 'Mike Johnson', 1300.75, 'mike.johnson@example.com', '1122334455'),
('104', 'Emily Davis', 1100.00, NULL, '2233445566'),
('105', 'David Wilson', 1250.50, 'david.wilson@example.com', NULL),
('106', 'Jim Beam', 1100.0, 'jimbeam@example.com', '555-555-5555'),
('107', 'Jack Daniels', 1250.0, 'jackdaniels@example.com', '666-666-6666'),
('108', 'Johnny Walker', 1300.0, 'johnnywalker@example.com', '777-777-7777');


-- delete from manual_bills

INSERT INTO manual_bills (month, year, monthyear, flat_number, amount) VALUES
(1, 2023, 202301, 101, 12000.00),
(2, 2023, 202302, 101, 12000.00),
(3, 2023, 202303, 101, 12000.00),
(4, 2023, 202304, 101, 12000.00),
(5, 2023, 202305, 101, 12000.00),
(6, 2023, 202306, 101, 12000.00),
(7, 2023, 202307, 101, 12000.00),
(8, 2023, 202308, 101, 12000.00),
(9, 2023, 202309, 101, 12000.00),
(10, 2023, 202310, 101, 12000.00),
(11, 2023, 202311, 101, 12000.00),
(12, 2023, 202312, 101, 12000.00),
(13, 2024, 202401, 101, 12005.00),
(14, 2024, 202402, 101, 12005.00),
(15, 2024, 202403, 101, 12005.00);




select * from manual_bills
where flat_number = 101
and monthyear >= 202306 and monthyear <= 202402