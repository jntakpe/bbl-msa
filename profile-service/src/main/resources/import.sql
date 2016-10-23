--@formatter:off

-- Table profile
INSERT INTO profile(email, first_name, last_name, login) VALUES ('jocelyn.ntakpe@soprasteria.com', 'Jocelyn', 'N''TAKPE', 'jntakpe');
INSERT INTO profile(email, first_name, last_name, login) VALUES ('bruno.poindron@soprasteria.com', 'Bruno', 'POINDRON', 'bpoindron');
INSERT INTO profile(email, first_name, last_name, login) VALUES ('cyril.barillet@soprasteria.com', 'Cyril', 'Barillet', 'cbarillet');
INSERT INTO profile(email, first_name, last_name, login) VALUES ('rudy.jansem@soprasteria.com', 'Rudy', 'JANSEM', 'rjansem');

-- Table notification
INSERT INTO notification(type) VALUES ('NEW_EVENT');
INSERT INTO notification(type) VALUES ('REGISTRATION');

-- Table profile_notification_settings
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='REGISTRATION'), (SELECT id FROM profile WHERE login='jntakpe'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='REGISTRATION'), (SELECT id FROM profile WHERE login='bpoindron'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='REGISTRATION'), (SELECT id FROM profile WHERE login='rjansem'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='REGISTRATION'), (SELECT id FROM profile WHERE login='cbarillet'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='NEW_EVENT'), (SELECT id FROM profile WHERE login='jntakpe'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='NEW_EVENT'), (SELECT id FROM profile WHERE login='rjansem'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='NEW_EVENT'), (SELECT id FROM profile WHERE login='cbarillet'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='NEW_EVENT'), (SELECT id FROM profile WHERE login='bpoindron'));

--@formatter:on