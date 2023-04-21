create table if not exists film (
    id serial primary key,
    name varchar not null,
    author_id int references author(id)
)