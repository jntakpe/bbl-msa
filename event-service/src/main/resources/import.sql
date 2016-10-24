--@formatter:off

-- Table event
INSERT INTO event(name, type, start, duration, duration_unit) VALUES ('MSA', 'BBL', '2016-10-25', 2, 'HOURS');
INSERT INTO event(name, type, start, duration, duration_unit) VALUES ('Angular 2', 'BBL', '2016-11-10', 2, 'HOURS');
INSERT INTO event(name, type, start, duration, duration_unit) VALUES ('Elastic search', 'CODING_DOJO', '2016-11-24', 2, 'HOURS');

-- Table attendee
INSERT INTO attendee (login) VALUES ('jntakpe');
INSERT INTO attendee (login) VALUES ('rjansem');
INSERT INTO attendee (login) VALUES ('cbarillet');
INSERT INTO attendee (login) VALUES ('bpoindron');

-- Table event_attendees
INSERT INTO event_attendees (events_id, attendees_id) VALUES ((SELECT id FROM event WHERE name='Angular 2'), (SELECT id FROM attendee WHERE login='jntakpe'));
INSERT INTO event_attendees (events_id, attendees_id) VALUES ((SELECT id FROM event WHERE name='Angular 2'), (SELECT id FROM attendee WHERE login='rjansem'));
INSERT INTO event_attendees (events_id, attendees_id) VALUES ((SELECT id FROM event WHERE name='Angular 2'), (SELECT id FROM attendee WHERE login='cbarillet'));
INSERT INTO event_attendees (events_id, attendees_id) VALUES ((SELECT id FROM event WHERE name='MSA'), (SELECT id FROM attendee WHERE login='jntakpe'));
INSERT INTO event_attendees (events_id, attendees_id) VALUES ((SELECT id FROM event WHERE name='MSA'), (SELECT id FROM attendee WHERE login='bpoindron'));

--@formatter:on