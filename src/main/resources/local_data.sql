INSERT INTO users(name, email, password, role)
SELECT * FROM (
 SELECT
  'admin',
  'test@example.com',
  '$2a$10$qHwwgwxqm5Od7dSdeIE4wu3lhLbA3xicU3IwPGQWsCxBu13vit7FK',
  0
) AS tbl
WHERE NOT EXISTS (SELECT 1 FROM users);
