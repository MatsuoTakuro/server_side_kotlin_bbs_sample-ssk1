INSERT INTO users(name, email, password, role)
SELECT * FROM (
 SELECT
  'admin',
  'test@example.com',
  '$2a$10$GVtkGlDlhJGgTOMkgCEGC.O9aLXBD8BNvDAhDRRmF.EZ0Vy8rOOEO',
  0
) AS tbl
WHERE NOT EXISTS (SELECT 1 FROM users);