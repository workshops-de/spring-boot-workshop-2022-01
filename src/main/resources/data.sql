DELETE FROM tag;
DELETE FROM book_tag;
DELETE FROM book;
DELETE FROM author;


INSERT INTO author (id, firstname, lastname) VALUES (1, 'Erich', 'Gamma');
INSERT INTO author (id, firstname, lastname) VALUES (2, 'Robert C.', 'Martin');
INSERT INTO author (id, firstname, lastname) VALUES (3, 'Gottfried', 'Wolmeringer');

INSERT INTO book (id, isbn, title, author_id, info) VALUES (1, '978-0201633610', 'Design Patterns', 1, 'Mit Design Patterns lassen sich wiederkehrende Aufgaben in der objektorientierten Softwareentwicklung effektiv lösen.');
INSERT INTO book (id, isbn, title, author_id, info) VALUES (2, '978-3826655487', 'Clean Code', 2, 'Das einzige praxisnahe Buch, mit dem Sie lernen, guten Code zu schreiben!');
INSERT INTO book (id, isbn, title, author_id, info) VALUES (3, '978-3836211161', 'Coding for Fun', 3,  'Dieses unterhaltsam geschriebene Buch führt Sie spielerisch durch die spektakuläre Geschichte unserer Blechkollegen.');

INSERT INTO tag (id, name) VALUES (1, 'DEV');
INSERT INTO tag (id, name) VALUES (2, 'FUN');

INSERT INTO book_tag (book_id, tag_id) VALUES (1, 1);
INSERT INTO book_tag (book_id, tag_id) VALUES (2, 1);
INSERT INTO book_tag (book_id, tag_id) VALUES (3, 1);
INSERT INTO book_tag (book_id, tag_id) VALUES (3, 2);