-- Ensure the pg_trgm extension is installed
CREATE EXTENSION IF NOT EXISTS pg_trgm;

-- Drop the existing GiST index if it exists
DROP INDEX IF EXISTS idx_location;

-- Alter the column type
ALTER TABLE soil_data ALTER COLUMN location SET DATA TYPE varchar(255);

-- Create the GiST index with the appropriate operator class
CREATE INDEX IF NOT EXISTS idx_location ON soil_data USING GIST (location gist_trgm_ops);

