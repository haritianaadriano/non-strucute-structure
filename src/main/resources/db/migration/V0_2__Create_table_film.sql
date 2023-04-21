create table if not exists film (
    id int serial primary key,
    name varchar not null,
    author_id int references author(id)
)