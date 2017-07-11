DROP TABLE IF EXISTS contracts;
DROP TABLE IF EXISTS suppliers;

CREATE TABLE suppliers (
  ID INTEGER primary key AUTOINCREMENT,
  name VARCHAR(50),
  registration VARCHAR(50),
  financialScore INTEGER,
  valueScore INTEGER,
  deliveryScore INTEGER,
  exclude INTEGER,
  insurance INTEGER,
  courtJudgement INTEGER
);

CREATE TABLE contracts (
  ID INTEGER PRIMARY KEY AUTOINCREMENT,
  title VARCHAR(50),
  manager VARCHAR(50),
  supplier_id INTEGER references suppliers(id) ON DELETE CASCADE,
  status VARCHAR(50),
  category VARCHAR(50),
  strategicImportanceRating INTEGER,
  startDate VARCHAR(50),
  endDate VARCHAR(50),
  contractedValue INTEGER,
  actualValue INTEGER,
  description VARCHAR(50)
);

