CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS workers
(
    id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name     varchar(100) not null,
    password varchar(50)  not null
);