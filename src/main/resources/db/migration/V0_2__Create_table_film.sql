create table if not exists film (
    id int primary key,
    name varchar not null,
    author_id int references author(id)
)