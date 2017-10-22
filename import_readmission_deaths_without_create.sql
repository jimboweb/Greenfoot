
LOAD DATA LOCAL INFILE '/Users/jimstewart/Downloads/Readmissions_and_Deaths_-_Hospital.csv'
INTO TABLE ReadmissionsDeaths

FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r'
IGNORE 1 ROWS;
