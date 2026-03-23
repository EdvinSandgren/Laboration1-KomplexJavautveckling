CREATE TABLE IF NOT EXISTS cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model TEXT,
    description TEXT,
    price INT NOT NULL,
    mileage INT NOT NULL,
    modelyear INT NOT NULL,
    status TEXT,
    created DATE,
    updated DATE
    );