-- Countries
INSERT IGNORE INTO country_model (isocode, name) VALUES ('AR', 'Argentina');
INSERT IGNORE INTO country_model (isocode, name) VALUES ('BR', 'Brazil');
INSERT IGNORE INTO country_model (isocode, name) VALUES ('US', 'United States');
INSERT IGNORE INTO country_model (isocode, name) VALUES ('CL', 'Chile');

-- Roles
INSERT IGNORE INTO role_model (name) VALUES ('ADMIN');
INSERT IGNORE INTO role_model (name) VALUES ('USER');

-- Users
INSERT IGNORE INTO user_model (username) VALUES ('anonymousUser')