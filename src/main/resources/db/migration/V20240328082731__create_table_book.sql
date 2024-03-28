CREATE TABLE public.books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    pages INT NOT NULL,
    finish BOOLEAN NULL,
    year VARCHAR(4) NULL,
    desire BOOLEAN NULL,
    image_link VARCHAR(200) NULL,
    user_id INT,

    create_at TIMESTAMP,
    update_at TIMESTAMP
);

CREATE INDEX books_name_idx ON public.books (name);

ALTER TABLE public.books
  ADD CONSTRAINT fk_books_to_user FOREIGN KEY (user_id) REFERENCES public.users(id) DEFERRABLE INITIALLY DEFERRED;


---

CREATE TABLE public.book_notes (
    id SERIAL PRIMARY KEY,
    note VARCHAR(250) NULL,
    book_id INT,

    create_at TIMESTAMP,
    update_at TIMESTAMP
);

ALTER TABLE public.book_notes
  ADD CONSTRAINT fk_book_notes_to_book FOREIGN KEY (book_id) REFERENCES public.books(id) DEFERRABLE INITIALLY DEFERRED;


---