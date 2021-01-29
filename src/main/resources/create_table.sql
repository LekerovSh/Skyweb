CREATE TABLE longs(
    id bigserial primary key,
    value long not null,
    message varchar not null,
    time long not null
);