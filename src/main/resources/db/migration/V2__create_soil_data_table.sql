-- Create soil_data table
CREATE TABLE IF NOT EXISTS soil_data (
 id SERIAL PRIMARY KEY,
location GEOMETRY(Point, 4326),
    bulk_density DOUBLE PRECISION,
    clay_content DOUBLE PRECISION,
    carbon_organic DOUBLE PRECISION,
    ph_level DOUBLE PRECISION
    );

