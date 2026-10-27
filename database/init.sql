CREATE TABLE vehicle (
    id       SERIAL PRIMARY KEY,
    model    VARCHAR(100) NOT NULL,
    category VARCHAR(50)  NOT NULL,
    location VARCHAR(100) NOT NULL
);

INSERT INTO vehicle (model, category, location) VALUES
    ('Toyota Yaris',  'Small',    'Horsens'),
    ('VW Passat',     'Family',   'Aarhus'),
    ('Tesla Model 3', 'Electric', 'Horsens');