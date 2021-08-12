CREATE TABLE jobs
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE jobs_workers
(
    worker_id UUID REFERENCES workers(id),
    job_id BIGINT REFERENCES jobs(id)
);