--users
INSERT INTO users (user_id, first_name, last_name, email)
VALUES (1, 'name', 'lastname', 'aaa@bbb'),
       (2, 'name1', 'lastname2', 'testEmail'),
       (3, 'name2', 'lastname2', 'emailAddress');

--pack
INSERT INTO pack (pack_id, unit_id, pack_name, pack_quant, pack_type)
VALUES (1, 1, 'Орехи', 500, '1'),
       (2, 2, 'Мороженное', 10, '0'),
       (3, 3, 'Фанта', 15, '0');

--exbarc
INSERT INTO exbarc (exbarc_id, exbar_body, pack_id)
VALUES (1, 167867868, '1'),
       (2, 267867676, '2'),
       (3, 367867869, '3');

--pack_prc
INSERT INTO pack_prc (pack_id, pack_bonus, pack_price)
VALUES (1, 200, 500),
       (2, 300, 600),
       (3, 100, 200);

--unit_id
INSERT INTO unit_id (unit_id, unit_name)
VALUES (1, 'грамм'),
       (2, 'шт.'),
       (3, 'бут.');