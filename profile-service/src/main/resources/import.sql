--@formatter:off

-- Table profile
INSERT INTO profile(email, first_name, last_name, login) VALUES ('jocelyn.ntakpe@sopragroup.com', 'Jocelyn', 'N''TAKPE', 'jntakpe');
INSERT INTO profile(email, first_name, last_name, login) VALUES ('bruno.poindron@sopragroup.com', 'Bruno', 'POINDRON', 'bpoindron');
INSERT INTO profile(email, first_name, last_name, login) VALUES ('cyril.barillet@sopragroup.com', 'Cyril', 'Barillet', 'cbarillet');
INSERT INTO profile(email, first_name, last_name, login) VALUES ('rudy.jansem@sopragroup.com', 'Rudy', 'JANSEM', 'rjansem');

-- Table notification
INSERT INTO notification(type) VALUES ('New event');
INSERT INTO notification(type) VALUES ('Registration');

-- Table profile_notification_settings
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='Registration'), (SELECT id FROM profile WHERE login='jntakpe'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='Registration'), (SELECT id FROM profile WHERE login='bpoindron'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='Registration'), (SELECT id FROM profile WHERE login='rjansem'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='Registration'), (SELECT id FROM profile WHERE login='cbarillet'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='New event'), (SELECT id FROM profile WHERE login='jntakpe'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (TRUE, (SELECT id FROM notification WHERE type='New event'), (SELECT id FROM profile WHERE login='rjansem'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='New event'), (SELECT id FROM profile WHERE login='cbarillet'));
INSERT INTO profile_notification_settings(accept, notification_id, profile_id) VALUES (FALSE, (SELECT id FROM notification WHERE type='New event'), (SELECT id FROM profile WHERE login='bpoindron'));



--@formatter:on