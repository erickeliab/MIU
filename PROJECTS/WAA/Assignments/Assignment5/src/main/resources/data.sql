INSERT INTO users (id, email, name, password)
VALUES (1, 'erick@gmail.com', 'erick','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, name, password)
VALUES (2, 'emma@gmail.com', 'emma','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123



INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);



INSERT INTO post (id, title, content, author, user_id)
VALUES (1, 'The Great Gatsby', 'A novel written by American author F. Scott Fitzgerald.', 1, 1);
INSERT INTO post (id, title, content, author, user_id)
VALUES (2, 'Mediterranean Diet', 'A heart-healthy eating plan based on typical foods and recipes of Mediterranean-style cooking.', 1, 1);
INSERT INTO post (id, title, content, author, user_id)
VALUES (3, 'Yoga for Beginners', 'An introductory guide to starting your yoga journey.', 1, 1);


INSERT INTO comment (id, name, post_id)
VALUES (1, 'An amazing portrayal of the Jazz Age.', 1);
INSERT INTO comment (id, name, post_id)
VALUES (2, 'A timeless classic that everyone should read.', 1);
INSERT INTO comment (id, name, post_id)
VALUES (3, 'The characters are so well developed.', 1);
INSERT INTO comment (id, name, post_id)
VALUES (4, 'This diet has really improved my health.', 2);
INSERT INTO comment (id, name, post_id)
VALUES (5, 'Delicious recipes that are easy to follow.', 2);
INSERT INTO comment (id, name, post_id)
VALUES (6, 'I love the variety of foods included.', 2);
INSERT INTO comment (id, name, post_id)
VALUES (7, 'Perfect guide for yoga newbies.', 3);
INSERT INTO comment (id, name, post_id)
VALUES (8, 'Clear instructions and easy to follow.', 3);
INSERT INTO comment (id, name, post_id)
VALUES (9, 'Helped me get started with a daily routine.', 3);
