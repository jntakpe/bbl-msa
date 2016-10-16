--@formatter:off

-- Table Account
INSERT INTO account (login, password) VALUES ('jntakpe', 'bblmsapwd');
INSERT INTO account (login, password) VALUES ('bpoindron', 'bblmsapwd');
INSERT INTO account (login, password) VALUES ('cbarillet', 'bblmsapwd');
INSERT INTO account (login, password) VALUES ('rjansem', 'bblmsapwd');

-- Table Authority
INSERT INTO authority (name) VALUES ('USER');
INSERT INTO authority (name) VALUES ('ADMIN');

-- Table de jointure Account_Authorities
INSERT INTO account_authorities (account_id, authorities_id) VALUES ((SELECT id FROM account WHERE login='jntakpe'), (SELECT id FROM authority WHERE name='USER'));
INSERT INTO account_authorities (account_id, authorities_id) VALUES ((SELECT id FROM account WHERE login='bpoindron'), (SELECT id FROM authority WHERE name='USER'));
INSERT INTO account_authorities (account_id, authorities_id) VALUES ((SELECT id FROM account WHERE login='cbarillet'), (SELECT id FROM authority WHERE name='USER'));
INSERT INTO account_authorities (account_id, authorities_id) VALUES ((SELECT id FROM account WHERE login='rjansem'), (SELECT id FROM authority WHERE name='USER'));
INSERT INTO account_authorities (account_id, authorities_id) VALUES ((SELECT id FROM account WHERE login='jntakpe'), (SELECT id FROM authority WHERE name='ADMIN'));

--@formatter:on