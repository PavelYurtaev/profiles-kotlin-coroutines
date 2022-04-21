CREATE USER pyurtaev WITH encrypted password 'pyurtaev!';
CREATE DATABASE r2dbc_profiles_db OWNER pyurtaev;
GRANT ALL PRIVILEGES ON DATABASE r2dbc_profiles_db TO pyurtaev;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE profile

(
    id          UUID NOT NULL DEFAULT uuid_generate_v4(),
    title       VARCHAR,
    description VARCHAR,
    PRIMARY KEY (id)
);
