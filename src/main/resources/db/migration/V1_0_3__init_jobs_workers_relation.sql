CREATE TABLE IF NOT EXISTS jobs
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS jobs_workers
(
    worker_id UUID REFERENCES workers(id),
    job_id BIGINT REFERENCES jobs(id)
);

INSERT INTO jobs (name)
VALUES ('job1');

INSERT INTO jobs_workers (worker_id, job_id)
VALUES ('9609710a-f2c9-47ea-990a-c22b6458c344', 1);