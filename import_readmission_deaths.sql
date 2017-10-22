CREATE TABLE ReadmissionsDeaths (
	ProviderId INT,
	HospitalName VARCHAR(256),
	Address VARCHAR(256),
	City VARCHAR(64),
	State CHAR(2),
	ZipCode CHAR(5),
	CountyName VARCHAR(256),
	PhoneNumber CHAR (10),
	MeasureName VARCHAR(256),
	MeasureId VARCHAR (64),
	ComparedToNational VARCHAR (256),
	Score DECIMAL (3,1),
	LowerEstimate DECIMAL (3,1),
	HigherEstimate DECIMAL (3, 1)
	
);

LOAD DATA LOCAL INFILE '/Users/jimstewart/Downloads/Readmissions_and_Deaths_-_Hospital.csv'
INTO TABLE ReadmissionsDeaths
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;
