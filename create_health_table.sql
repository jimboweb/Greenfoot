CREATE TABLE ipps (
	DrgDefinition VARCHAR(264),
	ProviderId INT,
	ProviderName VARCHAR(256),
	ProviderAddress VARCHAR(256),
	ProviderCity VARCHAR(64),
	ProviderState CHAR(2),
	ProviderZip CHAR(5),
	HospitalRegion VARCHAR(64),
	TotalDischarges SMALLINT,
	AverageCoveredCharges DECIMAL(10,2),
	AverageTotalPayments DECIMAL(10,2),
	AverageMedicarePayments DECIMAL(10,2)	
);

LOAD DATA LOCAL INFILE '/Users/jimstewart/Downloads/Inpatient_Prospective_Payment_System__IPPS__Provider_Summary_for_the_Top_100_Diagnosis-Related_Groups__DRG__-_FY2011.csv'
INTO TABLE ipps
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;
