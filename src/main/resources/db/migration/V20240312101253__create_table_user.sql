CREATE TABLE public.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,

    create_at TIMESTAMP,
    update_at TIMESTAMP
);

CREATE INDEX users_email_idx ON public.users (email);

---